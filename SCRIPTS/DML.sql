CREATE TABLE db_empresa.cliente (
	id_cliente INT auto_increment primary key NOT NULL,
	nit varchar(9) NULL,
	nombre varchar(60) NULL,
	apellido varchar(60) NULL,
	direccion varchar(100) NULL,
	telefono varchar(8) NULL,
	fecha_nacimiento DATE NULL
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE db_empresa.puesto (
	id_puesto smallint(6) auto_increment primary key NOT NULL,
	puesto varchar(40) NULL
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE db_empresa.puesto (
	id_puesto smallint(6) auto_increment primary key NOT NULL,
	puesto varchar(40) NULL
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE db_empresa.empleado (
	id_empleado INT auto_increment primary key NOT NULL,
	codigo varchar(20) null,
	nombre varchar(60) NULL,
	apellido varchar(60) NULL,
	direccion varchar(100) NULL,
	telefono varchar(8) NULL,
	fecha_nacimiento DATE null,
	id_puesto smallint(6),
	CONSTRAINT empleado_to_puesto FOREIGN KEY (id_puesto) REFERENCES puesto(id_puesto) on update cascade
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

CREATE USER 'apempresa'@'%' IDENTIFIED BY 'Temp0ral1,';
GRANT SELECT, INSERT, UPDATE, delete, show view, execute ON db_empresa.* TO 'apempresa'@'%';
FLUSH PRIVILEGES;