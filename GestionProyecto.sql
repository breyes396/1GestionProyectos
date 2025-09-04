drop database if exists  SistemaGestion_db;
create database SistemaGestion_db;
use SistemaGestion_db;



-- ------------------------------------------------------------------------------------------------------------proyecto -------------------------------------------------------------------------------------------------------------------
create table Proyectos(
	id_proyecto int auto_increment,
	nombre_proyecto varchar (128) not null,
	fecha_inicio date not null,
	constraint pk_proyectos primary key (id_proyecto)
);
 -- ----------------------------------------------CRUD ----------------------------------------------------------
-- LISTAR
DELIMITER $$
	create procedure sp_ListarProyectos()
		begin
			select 
			id_proyecto as ID,
			nombre_Proyecto  as PROYECTO,
			fecha_inicio as FECHA
			from Proyectos;
		end$$
	
DELIMITER ;

-- AGREGAR
DELIMITER $$
	create procedure sp_AgregarProyectos(
			in p_id_proyecto int,
			in p_nombre_Proyecto varchar(128),
			in p_fecha_inicio date)
		begin
			insert into Proyectos(nombre_Proyecto, fecha_inicio)
				values(p_nombre_Proyecto,p_fecha_inicio);
		end$$
DELIMITER ;

- ACTUALIZAR
DELIMITER $$
	create procedure sp_ActualizarProyectos(
			in p_id_proyecto int,
			in p_nombre_Proyecto varchar(128),
			in p_fecha_inicio date)
		begin
			update Proyectos
				set
					nombre_Proyecto = p_nombre_Proyecto,
					fecha_inicio = p_fecha_inicio 
				where 
					id_proyecto = p_id_proyecto ;
			
		end$$
DELIMITER ;

-- ELIMINAR
DELIMITER $$
	create procedure sp_EliminarProyectos(in p_id_proyecto int)
		begin
			delete 
			from Proyectos
				where id_proyecto  = p_id_proyecto ;
		end$$
DELIMITER ;


-- -------------------------------------------------------------call-----------------------------------

call  sp_AgregarProyectos(1,'wilson',current_date());
call  sp_AgregarProyectos(2,'marco',current_date());
call  sp_AgregarProyectos(3,'wily',current_date());
call sp_ActualizarProyectos(2,'miguel',current_date());
 call sp_EliminarProyectos(3);
 call  sp_ListarProyectos();
-- -----------------------------------------------------------------------------------------------------------------------------------------------------usuarios ---------------------------------------------------------------
 
create table Usuarios(
	id_usuario int auto_increment,
	nombre varchar (64) not null,
    email varchar (32) not null,
    contraseña varchar (64) not null,
	rol enum ('usuario','administrador') not null,
	constraint pk_usuarios primary key (id_usuario)
);
 -- -----------------------------------------------------------CRUD -----------------------------------------------------------------


-- LISTAR
DELIMITER $$
	create procedure sp_ListarUsuarios()
		begin  
			select 
			id_usuario as ID,
			nombre as USUARIO,
            email as CORREO,
            contraseña as CONTRASEÑA,
			rol as ROL
			from Usuarios;
		end$$
	
DELIMITER ;

-- AGREGAR
DELIMITER $$
	create procedure sp_AgregarUsuarios(
			in p_id_usuario int,
			in p_nombre varchar(64),
            in  p_email varchar (32)  ,
			in  p_contraseña varchar (64)  ,
			in p_rol enum ('usuario','administrador'))
		begin
			insert into Usuarios(nombre,email ,contraseña,rol)
				values(p_nombre,p_email,p_contraseña,p_rol);
		end$$
DELIMITER ;

- ACTUALIZAR
DELIMITER $$
	create procedure sp_ActualizarUsuarios(
			in p_id_usuario int,
			in  p_nombre varchar(64),
            in  p_email varchar (32)  ,
			in  p_contraseña varchar (64)  ,
			in  p_rol enum ('usuario','administrador'))
		begin
			update Usuarios
				set
					nombre = p_nombre,
                    email	= p_email,
                    contraseña	=p_contraseña,
					rol = p_rol 
				where 
					id_usuario = p_id_usuario ;
			
		end$$
DELIMITER ;

-- ELIMINAR
DELIMITER $$
	create procedure sp_EliminarUsuarios(in p_id_usuario  int)
		begin
			delete 
			from Usuarios
				where id_usuario  = p_id_usuario ;
		end$$
DELIMITER ;
 
 -- -------------------------------------------------------------call-----------------------------------
call  sp_AgregarUsuarios(1,'wilson','@sdfsdf','ahahah','usuario');
call  sp_AgregarUsuarios(2,'marco','sdfsd33333333333','qqqqqqqqq','administrador');
call  sp_AgregarUsuarios(3,'wily','sdfsdfsssssssssssss','zzzzzzzzz','usuario');
call sp_ActualizarUsuarios(2,'miguel','333333','88888888888888','usuario');
 call sp_EliminarUsuarios(3);
 call  sp_ListarUsuarios();
 
 

 
create table ProyectosUsuarios(
	id_proyecto int not null,
	id_usuario int not null,
	constraint pk_proyectos_usuarios primary key  (id_proyecto, id_usuario),
	constraint fk_proyectos_usuarios_proyecto foreign key (id_proyecto)
		references Proyectos (id_proyecto) on delete cascade,
	constraint fk_proyectos_usuarios_usuarios foreign key (id_usuario)
		references Usuarios (id_usuario) on delete cascade 
);
 
 
-- ----------------------------------------------------------------------------------tareas ---------------------------------------------------------------
 
create table Tareas(
	id_tarea int auto_increment,
	nombre_tarea varchar (128) not null,
	descripcion varchar (128) not null,
	estado enum ('pendiente','en proceso','completada') not null,
    fecha_inicio date,
    fecha_fin date,
	id_proyecto int not null,
	id_usuario int not null,
	constraint id_tarea primary key (id_tarea),
	constraint fk_tareas_proyectos foreign key (id_proyecto)
		references Proyectos (id_proyecto) on delete cascade,
    constraint fk_tareas_usuarios foreign key (id_usuario)
		references Usuarios (id_usuario) on delete cascade    
);

-- -----------------------------------------------------------------------------------CRUD---------------------------------------------------
 
-- LISTAR
DELIMITER $$
	create procedure sp_ListarTareas()
		begin
			select 
			id_Tarea as ID,
			nombre_tarea  as USUARIO,
            descripcion as DESCRIPCION,
			estado as ESTADO,
            fecha_inicio as FECHA_INICIO,
            fecha_fin as FECHA_FIN,
            id_proyecto as ID_PROYECTO,
            id_usuario AS ID_USUARIO
			from Tareas;
		end$$
DELIMITER ;
 
-- Agregar
delimiter $$
	create procedure sp_AgregarTareas(
    in p_nombre_tarea varchar(128),
    in p_descripcion varchar(128),
    in p_estado varchar(128),
    in p_fecha_inicio date,
    in p_fecha_fin date,
    in p_id_proyecto int,
    in p_id_usuario int
    )
		begin
			insert into Tareas(nombre_tarea, descripcion, estado, fecha_inicio, fecha_fin, id_proyecto, id_usuario)
				values(p_nombre_tarea, p_descripcion, p_estado, p_fecha_inicio, p_fecha_fin, p_id_proyecto, p_id_usuario);
		end$$
delimiter ;
 
-- Eliminar
delimiter $$
	create procedure sp_EliminarTareas(in p_id_tarea int)
		begin
			delete
				from Tareas 
            where id_tarea = p_id_tarea;
		end$$
delimiter ;
 
-- Actualizar
delimiter $$
	create procedure sp_ActualizarTareas(
    in p_id_tarea int,
    in p_nombre_tarea varchar(128),
    in p_descripcion varchar(128),
    in p_estado varchar(128),
    in p_fecha_inicio date,
    in p_fecha_fin date,
    in p_id_proyecto int,
    in p_id_usuario int
    )
		begin
			update Tareas
				set
					nombre_tarea = p_nombre_tarea,
                    descripcion = p_descripcion, 
                    estado = p_estado,
                    fecha_inicio = p_fecha_inicio,
                    fecha_fin = p_fecha_fin,
                    id_proyecto = p_id_proyecto,
                    id_usuario = p_id_usuario
				where
					id_tarea = p_id_tarea;
		end$$
delimiter ;
 

