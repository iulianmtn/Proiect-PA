


create or replace function insert_camera (p_id_fac facultati.nume%type, p_capacitate int, p_nume camere.nume%type) return int as
    v_id facultati.id%type;
begin
    insert into camere (id_facultate, capacitate, nume) values (p_id_fac, p_capacitate, p_nume);
    select id into v_id from camere where nume = p_nume and id_facultate = p_id_fac;
    return v_id;
end insert_camera;



create or replace function get_camere_facultate (p_id_fac camere.id_facultate%type) return varchar2 is
    v_lista varchar2(2000);
    cursor lista_camere is select nume, capacitate from camere where id_facultate = p_id_fac;
begin
    v_lista := '[';
    for v_cam in lista_camere loop
        v_lista := v_lista || '{"nume":"' || v_cam.nume || '", "capacitate":"' || v_cam.capacitate || '"},';
    end loop;
    v_lista := substr(v_lista, 0, length(v_lista) -1);
    v_lista := v_lista || ']';
    
    return v_lista;
end;
    
    
    
create or replace function find_cam_by_id(p_id_camera camere.id%type) return VARCHAR2 is
    v_nume varchar2(20);
begin
    select nume into v_nume from camere where id = p_id_camera;
    return v_nume;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            return 'n/a';
end find_cam_by_id;

