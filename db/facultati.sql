create or replace package fac_pack is
    function insert_facultate (p_nume facultati.nume%type) return int; --returneaza id
    function get_facultati return varchar2;
end;
    
    
create or replace package body fac_pack is

    function insert_facultate (p_nume facultati.nume%type) return int as
        v_id facultati.id%type;
    begin
        insert into facultati (nume) values (p_nume);
        select id into v_id from facultati where nume = p_nume;
        return v_id;
    end insert_facultate;
    
    function get_facultati return varchar2 as
        v_lista varchar2(2000);
        cursor lista_facultati is select nume from facultati;
    begin
        v_lista :='[';
        
        for v_nume in lista_facultati loop
            v_lista := v_lista || '{"nume":"' || v_nume.nume || '"},';
        end loop;
        
        --la final vom avea o virgula care nu ar trebui sa fie acolo asa ca o eliminam
        v_lista := substr(v_lista, 0, length(v_lista) -1);
        
        v_lista := v_lista || ']';
        return v_lista;
    end get_facultati;
    
    
end fac_pack;






set SERVEROUT on;

declare
    v_id int;
begin
--    v_id := fac_pack.insert_facultate('info');
    dbms_output.put_line(get_facultati());
end;


















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
    
    
    
    

