
create or replace function get_fac_ev (p_id_fac events.id_facultate%type) return varchar2 is
    v_lista varchar2(18000);
    cursor lista_events is select nume, inceput, sfarsit, dimensiune, zi, an||semian||(case tip when 0 then '' else to_char(grupa) end) as grupa_fac, find_cam_by_id(id_camera) as camera, decode(tip, 0, 'curs', 1, 'lab') as tip_ev from events
                        where id_facultate = p_id_fac
                        order by decode(lower(zi), 'monday', 1, 'tuesday', 2, 'wednesday', 3, 'thursday', 4, 'friday', 5, 'saturday', 6, 7);
    v_zi varchar2(15);
    v_events_zi varchar2(1000);
    
begin
    v_zi := ' ';
    v_events_zi := '';
    v_lista := '[';
    for v_event in lista_events loop
        if v_event.zi != v_zi then -- am ajuns la o zi noua => punem obiectul contstruit pana atunci in lista si, construim un obiect nou
            v_zi := v_event.zi;
            if(v_events_zi is not null) then
                v_events_zi := substr(v_events_zi, 0, length(v_events_zi) -1); --stergem virgula de la final
                v_events_zi := v_events_zi || ']}';
                v_lista := v_lista || v_events_zi || ', ';
            end if;
            v_events_zi := '{"zi":"' || v_event.zi || '", "events": ['; 
            
        end if;
        
        v_events_zi := v_events_zi || '{"nume":"' || v_event.nume || '", "inceput":"' || v_event.inceput || '", "sfarsit":"' || v_event.sfarsit || '", "dimensiune":"' || v_event.dimensiune || '", "grupa":"' || v_event.grupa_fac || '", "camera":"' || v_event.camera || '", "tip":"' || v_event.tip_ev || '"},' ;
    end loop;                    
    v_events_zi := substr(v_events_zi, 0, length(v_events_zi) -1); --stergem virgula de la final
    v_lista := v_lista || v_events_zi || ']}';
    v_lista := v_lista || ']';
    
    dbms_output.put_line(v_lista);
    return v_lista;
    
end;








create or replace function get_gr_ev (p_id_fac events.id_facultate%type, p_an int, p_sem varchar2, p_gr int) return varchar2 is
    v_lista varchar2(18000);
    cursor lista_events is select nume, inceput, sfarsit, dimensiune, zi, an||semian||(case tip when 0 then '' else to_char(grupa) end) as grupa_fac, find_cam_by_id(id_camera) as camera, decode(tip, 0, 'curs', 1, 'lab') as tip_ev from events
                        where id_facultate = p_id_fac and an=p_an and  semian = p_sem and (grupa = p_gr or tip = 0) -- afisam la grupele din b si cursurile de la b
                        order by decode(lower(zi), 'monday', 1, 'tuesday', 2, 'wednesday', 3, 'thursday', 4, 'friday', 5, 'saturday', 6, 7);
    v_zi varchar2(15);
    v_events_zi varchar2(1000);
    
begin
    v_zi := ' ';
    v_events_zi := '';
    v_lista := '[';
    for v_event in lista_events loop
        if v_event.zi != v_zi then -- am ajuns la o zi noua => punem obiectul contstrui pana atunci in lista si, construim un obiect nou
            v_zi := v_event.zi;
            if(v_events_zi is not null) then
                v_events_zi := substr(v_events_zi, 0, length(v_events_zi) -1); --stergem virgula de la final
                v_events_zi := v_events_zi || ']}';
                v_lista := v_lista || v_events_zi || ', ';
            end if;
            v_events_zi := '{"zi":"' || v_event.zi || '", "events": ['; 
            
        end if;
        
        v_events_zi := v_events_zi || '{"nume":"' || v_event.nume || '", "inceput":"' || v_event.inceput || '", "sfarsit":"' || v_event.sfarsit || '", "dimensiune":"' || v_event.dimensiune || '", "grupa":"' || v_event.grupa_fac || '", "camera":"' || v_event.camera || '", "tip":"' || v_event.tip_ev || '"},' ;
    end loop;                    
    v_events_zi := substr(v_events_zi, 0, length(v_events_zi) -1); --stergem virgula de la final
    v_lista := v_lista || v_events_zi || ']}';
    v_lista := v_lista || ']';
    
    return v_lista;
    
end;





create or replace function get_grupe(p_id_facultate facultati.id%type) return varchar2 is
    cursor lista_grupe is select distinct an, semian, grupa from events where id_facultate = p_id_facultate order by an, semian, grupa;
    
    v_lista varchar2(2000);
begin
    v_lista := '[';
    for v_gr in lista_grupe loop
        v_lista := v_lista || '{"grupa":"' || v_gr.an || v_gr.semian || v_gr.grupa || '"},';
    end loop;
    v_lista := substr(v_lista, 0, length(v_lista) -1);
    v_lista := v_lista || ']';
    
    return v_lista;
end;

    


set serveroutput on;

begin
 dbms_output.put_line(get_gr_ev(27,1, 'B', 1));
 --dbms_output.put_line(get_fac_ev(27));

end;



select nume from events order by decode(zi, 'luni', 1, 'marti', 2, 3) desc;

insert into events (id_facultate, nume, zi, inceput, sfarsit, an, grupa, semian, tip, dimensiune) values ('22', 'ww1', 'joi', 8, 10, 2, 2, 'A', 0, 30);


select * from events;


desc events;
delete from facultati;


