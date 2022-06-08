
create or replace function insert_facultate (p_nume facultati.nume%type) return int as
    v_id facultati.id%type;
begin
    insert into facultati (nume) values (p_nume);
    select id into v_id from facultati where nume = p_nume;
    return v_id;
end insert_facultate;





create or replace function get_facultati return varchar2 as
    v_lista varchar2(2000);
    cursor lista_facultati is select nume, id from facultati;
begin
    v_lista :='[';
    
    for v_fac in lista_facultati loop
        v_lista := v_lista || '{"nume":"' || v_fac.nume || '", "id":"' || v_fac.id || '"},';
    end loop;
    
    --la final vom avea o virgula care nu ar trebui sa fie acolo asa ca o eliminam
    v_lista := substr(v_lista, 0, length(v_lista) -1);
    
    v_lista := v_lista || ']';
    return v_lista;
end get_facultati;
    
    
    
    

