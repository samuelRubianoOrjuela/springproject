

CREATE TABLE pais (
    id_pais INT(5) PRIMARY KEY,
    nombre_pais VARCHAR(50)
);


CREATE TABLE ciudad (
    id_ciudad INT(5) PRIMARY KEY,
    nombre_ciudad VARCHAR(20),
    codigo_postal VARCHAR(10),
    id_pais INT(5),
    CONSTRAINT FK_id_pais_ciudad FOREIGN KEY(id_pais) REFERENCES pais(id_pais)
);

CREATE TABLE oficina (
    id_oficina VARCHAR(10) PRIMARY KEY,
    id_ciudad INT(5),
    telefono VARCHAR(20),
    linea_direccion1 VARCHAR(50),
    linea_direccion2 VARCHAR(50),
    CONSTRAINT FK_id_ciudad_oficina FOREIGN KEY (id_ciudad) REFERENCES ciudad(id_ciudad)
);


CREATE TABLE proveedor (
    id_proveedor VARCHAR(50) PRIMARY KEY,
    nombre VARCHAR(70),
    id_ciudad INT(5),
    CONSTRAINT FK_id_ciudad_proveedor FOREIGN KEY (id_ciudad) REFERENCES ciudad(id_ciudad)
);

CREATE TABLE puesto (
    id_puesto INT(11) PRIMARY KEY,
    nombre_puesto VARCHAR(50)
);

CREATE TABLE empleado (
    id_empleado INT(11) PRIMARY KEY,
    nombre VARCHAR(50),
    apellido1 VARCHAR(50),
    apellido2 VARCHAR(50),
    extension VARCHAR(10),
    email VARCHAR(100),
    id_oficina VARCHAR(10),
    id_jefe INT(11),
    id_puesto INT(11),
    CONSTRAINT FK_id_oficina_empleado FOREIGN KEY (id_oficina) REFERENCES oficina(id_oficina),
    CONSTRAINT FK_id_jefe_empleado FOREIGN KEY (id_jefe) REFERENCES empleado(id_empleado),
    CONSTRAINT FK_id_puesto_empleado FOREIGN KEY (id_puesto) REFERENCES puesto(id_puesto)
);

CREATE TABLE cliente (
    id_cliente INT(11) PRIMARY KEY,
    nombre_cliente VARCHAR(50),
    apellido_contacto VARCHAR(30),
    email VARCHAR(100),
    fax VARCHAR(15),
    telefono VARCHAR(15),
    id_ciudad INT(5),
    id_direccion INT(5),
    id_empleado_rep_ventas INT(11),
    limite_credito DECIMAL(15,2),
    CONSTRAINT FK_id_ciudad FOREIGN KEY (id_ciudad) REFERENCES ciudad(id_ciudad),
    CONSTRAINT FK_id_direccion FOREIGN KEY (id_direccion) REFERENCES direccion(id_direccion),
    CONSTRAINT FK_id_rep_ventas FOREIGN KEY (id_empleado_rep_ventas) REFERENCES empleado(id_empleado)
);

CREATE TABLE forma_pago (
    id_forma_pago INT (10) PRIMARY KEY,
    nombre_forma_pago VARCHAR (40) 
);

CREATE TABLE direccion (
    id_direccion INT(5) PRIMARY KEY,
    id_cliente INT(11),
    tipo_direccion VARCHAR(50),
    direccion VARCHAR(50),
    descripcion VARCHAR(70),
    linea_direccion1 VARCHAR(50),
    linea_direccion2 VARCHAR(50), 
    id_ciudad INT(5),
    CONSTRAINT FK_id_ciudad_direccion_cliente FOREIGN KEY (id_ciudad) REFERENCES ciudad(id_ciudad),
    CONSTRAINT FK_id_cliente_direccion_cliente FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)
);

CREATE TABLE pago (
    id_pago INT(11) PRIMARY KEY,
    id_cliente INT(11),
    id_forma_pago INT (10),
    fecha_pago DATE(230),
    total DECIMAL(15,2),
    CONSTRAINT FK_id_cliente_pago FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente),
    CONSTRAINT FK_id_forma_pago FOREIGN KEY (id_forma_pago) REFERENCES forma_pago(id_forma_pago)
);

CREATE TABLE gama_producto (
    gama VARCHAR(50) PRIMARY KEY,
    descripcion_texto TEXT,
    descripcion_html TEXT,
    imagen VARCHAR(256)
);

CREATE TABLE dimensiones (
    id_dimensiones INT(10) PRIMARY KEY,
    ancho DECIMAL(18,5) NOT NULL,
    alto DECIMAL(18,5) NOT NULL,
    largo DECIMAL(18,5) NOT NULL
);

CREATE TABLE producto (
    id_producto VARCHAR(15) PRIMARY KEY,
    nombre VARCHAR(70),
    gama VARCHAR(50),
    id_dimensiones INT(10),
    id_proveedor VARCHAR(50),
    descripcion TEXT,
    cantidad_en_stock SMALLINT(6),
    precio_venta DECIMAL(15,2),
    precio_proveedor DECIMAL(15,2),
    CONSTRAINT FK_id_dimensiones_producto FOREIGN KEY (id_dimensiones) REFERENCES dimensiones(id_dimensiones),
    CONSTRAINT FK_gama_producto FOREIGN KEY (gama) REFERENCES gama_producto(gama),
    CONSTRAINT FK_id_proveedor_producto FOREIGN KEY (id_proveedor) REFERENCES proveedor(id_proveedor)
);

-- CREATE TABLE stock (
--     id_stock INT(11) PRIMARY KEY,
--     id_producto VARCHAR(15),
--     cantidad_en_stock SMALLINT(6),
--     CONSTRAINT FK_id_producto_stock FOREIGN KEY (id_producto) REFERENCES producto(id_producto)
-- );

CREATE TABLE estado_pedido (
    id_estado INT(11) PRIMARY KEY,
    nombre_estado VARCHAR(20)
);

CREATE TABLE pedido (
    id_pedido INT(11) PRIMARY KEY,
    fecha_pedido DATE,
    fecha_esperada DATE,
    fecha_entrega DATE,
    comentarios TEXT,
    id_cliente INT(11),
    metodo_pago VARCHAR(40),
    id_pago INT(10),
    id_estado INT (11),
    CONSTRAINT FK_id_estado_pedido FOREIGN KEY (id_estado) REFERENCES estado_pedido(id_estado),
    CONSTRAINT FK_id_cliente_pedido FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente),
    CONSTRAINT FK_id_pago_pedido FOREIGN KEY (id_pago) REFERENCES pago(id_pago)
);

CREATE TABLE detalle_pedido (
    id_detalle_pedido INT(11) PRIMARY KEY,
    id_pedido INT(11),
    id_producto VARCHAR(15),
    cantidad INT(11),
    precio_unidad DECIMAL(15,2),
    numero_linea INT(6),
    CONSTRAINT FK_id_pedido_detalle FOREIGN KEY (id_pedido) REFERENCES pedido(id_pedido),
    CONSTRAINT FK_id_producto_detalle FOREIGN KEY (id_producto) REFERENCES producto(id_producto)
);