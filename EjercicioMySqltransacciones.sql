/*SENTENCIAS INSERT*/
insert into persona(nombre, apellido) values ('Luciana', 'Murcia');

insert into persona(nombre, apellido) values ('Karen', 'Martinez');

insert into persona(nombre, apellido) values ('Fernando', 'Murcia');

/*SENTENCIAS SELECT*/
select * from persona;

/*SENTENCIAS UPDATE*/
update persona set nombre = 'Lucianita' where idpersona = 1;

/*SENTENCIAS DELETE*/
delete from persona where id_persona = 13;