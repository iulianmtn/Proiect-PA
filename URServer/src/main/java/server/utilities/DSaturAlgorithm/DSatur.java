package server.utilities.DSaturAlgorithm;

import server.model.Event;
import server.model.Room;

import java.util.*;
import java.util.stream.Collectors;

public class DSatur {
    private static final Integer INFINITY = Integer.MAX_VALUE;

    private DSatur() {
    }

    /**
     * @param inputRooms  represents the rooms that we have to insert in database
     * @param inputEvents represents the events that we have to make a schedule on
     * @param idRooms     represents a Map used to keep track of the real ids in the database of the inputRooms
     * @return will return a Map that associates for each event its id of Room from database
     */
    public static Map<Event, Integer> makeSchedule(List<Room> inputRooms, List<Event> inputEvents, Map<Room, Integer> idRooms) {
        /**
         * 1. Let's create the graph as Map<Event,List<Event>>, for each Event we say that we have an adjacent
         *  node if and only if the two Events are between the same hours and the same Day*
         */

        Map<Event, List<Event>> graph = new HashMap<>();
        Map<Event, Integer> colorGrade = new HashMap<>();
        Map<Event, Room> distribution = new HashMap<>();

        inputEvents.stream().forEach(element -> findNeighbors(element, inputEvents, graph));
        inputEvents.stream().forEach(element -> colorGrade.put(element, 0));
        inputEvents.stream().forEach(node -> distribution.put(node, null));

        int numberSteps = inputEvents.size();

        while (numberSteps-- > 0) {
            Event nextEvent = chooseEvent(graph, colorGrade, distribution);

            distribution.replace(nextEvent, findValidRoom(nextEvent, graph, distribution, inputRooms));

            updateColorGrade(graph, distribution, colorGrade);

        }


        List<Event> maybeFictiveSchedule = distribution.keySet().stream().toList();
        Map<Event, Integer> foreignKeyDistribution = new HashMap<>();

        for (Event event : maybeFictiveSchedule) {
            if (distribution.get(event).getCapacity() == INFINITY) {
                distribution.replace(event, null);////we did not find a room for this event
                foreignKeyDistribution.put(event, null);
            } else    //we try to map It like Event,idRoom
            {
                Room takenRoom = distribution.get(event);
                foreignKeyDistribution.put(event, idRooms.get(takenRoom));
            }
        }


        return foreignKeyDistribution;

    }

    private static void updateColorGrade(Map<Event, List<Event>> graph, Map<Event, Room> distribution, Map<Event, Integer> colorGrade) {
        Integer nbEvents = graph.keySet().size();
        List<Event> events = graph.keySet().stream().toList();

        for (int node = 0; node < nbEvents; ++node) {
            List<Event> neighbors = graph.get(events.get(node));
            Long numberColoredNeighbors = neighbors.stream().map(event -> distribution.get(event)).distinct().filter(room -> room != null).count();
            if (distribution.get(events.get(node)) == null) //for the events that were not scheduled yet
                colorGrade.replace(events.get(node), numberColoredNeighbors.intValue());
            else
                colorGrade.replace(events.get(node), -1);
        }
    }

    private static Room findValidRoom(Event node, Map<Event, List<Event>> graph, Map<Event, Room> distribution, List<Room> colors) {
        List<Event> neighbors = graph.get(node);
        Integer numberColors = colors.size();

        Room bestFit = new Room("test", INFINITY);

        for (int nbColor = 0; nbColor < numberColors; ++nbColor) {
            boolean enoughSpace = node.getSize() <= colors.get(nbColor).getCapacity();
            boolean available = !neighbors.stream().map(nod -> distribution.get(nod)).distinct().collect(Collectors.toList()).contains(colors.get(nbColor));
            Room candidate = colors.get(nbColor);
            if (enoughSpace && available && candidate.getCapacity() < bestFit.getCapacity())
                bestFit = candidate;
        } //assign an existing room

        if (bestFit.getCapacity() != INFINITY)
            return bestFit;
        if (distribution.get(node) == null) {
            Room fictiveRoom = new Room("fictive", INFINITY);
            colors.add(fictiveRoom);
            return fictiveRoom;
        } //we create a new fictive room to be used so the algorithm can run

        return null;
    }


    private static Event chooseEvent(Map<Event, List<Event>> graph, Map<Event, Integer> colorGrade, Map<Event, Room> distribution) {
        Integer maxColoration = colorGrade.keySet().stream().map(node -> colorGrade.get(node)).max(Integer::compare).orElse(INFINITY);
        long countColoredMaxim = colorGrade.keySet().stream().map(node -> colorGrade.get(node)).filter(node -> (node == maxColoration)).count();
        if (countColoredMaxim < 1)
            return null;
        else if (countColoredMaxim == 1) {
            Event chosenEvent = colorGrade.keySet().stream().max((firstNode, secondNode) -> Integer.compare(colorGrade.get(firstNode), colorGrade.get(secondNode))).orElse(null);
            return chosenEvent;
        } else {
            Map<Event, List<Event>> cleanGraph = graphWithoutColor(graph, distribution);
            List<Event> candidates = colorGrade.keySet().stream().filter(node -> colorGrade.get(node) == maxColoration).collect(Collectors.toList());
            Event bestCandidate = maxInduceSubgraph(candidates, cleanGraph);
            return bestCandidate;
        }
    }

    private static Event maxInduceSubgraph(List<Event> candidates, Map<Event, List<Event>> cleanGraph) {
        Map<Event, Integer> nodeSubgraphValue = new HashMap<>();
        for (Event candidate : candidates)
            nodeSubgraphValue.put(candidate, induceSubgraph(candidate, cleanGraph));

        Event bestCandidate = nodeSubgraphValue.keySet().stream().max((firstNode, secondNode) -> Integer.compare(nodeSubgraphValue.get(firstNode), nodeSubgraphValue.get(secondNode))).orElse(null);

        return bestCandidate;
    }

    private static Integer induceSubgraph(Event node, Map<Event, List<Event>> cleanGraph) {
        Queue<Event> orderBfs = new ArrayDeque<>();
        orderBfs.add(node);
        List<Event> visitedNodes = new ArrayList<>();
        visitedNodes.add(node);

        while (!orderBfs.isEmpty()) {
            Event currentNode = orderBfs.poll();
            List<Event> neighbors = cleanGraph.get(currentNode);

            for (Event neighbor : neighbors) {
                if (!visitedNodes.contains(neighbor)) {
                    orderBfs.add(neighbor); ///I will need to explore you as well
                    visitedNodes.add(neighbor); //we visited it
                }
            }
        }

        return visitedNodes.size(); ///the size of the subgraph
    }

    private static Map<Event, List<Event>> graphWithoutColor(Map<Event, List<Event>> graph, Map<Event, Room> distribution) {
        List<Event> allNodes = graph.keySet().stream().toList();
        Map<Event, List<Event>> cleanGraph = new HashMap<>(graph);
        for (Event node : allNodes) {
            if (distribution.get(node) != null)
                cleanGraph.remove(node);
            else {
                List<Event> neighbors = cleanGraph.get(node);
                neighbors = neighbors.stream().filter(event -> distribution.get(event) == null).collect(Collectors.toList());
                cleanGraph.replace(node, neighbors); ///but I think is redundant
                ///we have now a clean part of the graph
            }
        }
        return cleanGraph;
    }


    private static List<Event> cleanAdjacentList(List<Event> adjacentList, Map<Event, Integer> colorGrade) {
        return adjacentList.stream().filter(node -> colorGrade.get(node) == -1).collect(Collectors.toList());
    }

    private static void findNeighbors(Event event, List<Event> eventList, Map<Event, List<Event>> graph) {
        List<Event> neighbors = eventList.stream().filter(node -> adjacentNodes(event, node)).collect(Collectors.toList());
        graph.put(event, neighbors);
    }

    private static boolean adjacentNodes(Event firstEvent, Event secondEvent) {
        return firstEvent.getDay().equals(secondEvent.getDay())
                && (
                ((firstEvent.getStart() >= secondEvent.getStart() && firstEvent.getStart() < secondEvent.getEnd())
                        ||
                        (firstEvent.getEnd() > secondEvent.getStart() && firstEvent.getEnd() <= secondEvent.getEnd())
                ))
                &&
                firstEvent != secondEvent;
    }
}

