-- Tabla 'pais'
INSERT INTO pais (id_pais, nombre_pais) VALUES (1, 'Argentina');
INSERT INTO pais (id_pais, nombre_pais) VALUES (2, 'Colombia');
INSERT INTO pais (id_pais, nombre_pais) VALUES (3, 'Chile');
INSERT INTO pais (id_pais, nombre_pais) VALUES (4, 'Peru');
INSERT INTO pais (id_pais, nombre_pais) VALUES (5, 'Brasil');
INSERT INTO pais (id_pais, nombre_pais) VALUES (6, 'Mexico');

-- Tabla 'ciudad'
INSERT INTO ciudad (id_ciudad, nombre_ciudad, codigo_postal, id_pais) VALUES (1, 'Buenos Aires', '1000', 1);
INSERT INTO ciudad (id_ciudad, nombre_ciudad, codigo_postal, id_pais) VALUES (2, 'Bucaramanga', '01000-000', 2);
INSERT INTO ciudad (id_ciudad, nombre_ciudad, codigo_postal, id_pais) VALUES (3, 'Santiago', '2000', 3);
INSERT INTO ciudad (id_ciudad, nombre_ciudad, codigo_postal, id_pais) VALUES (4, 'Lima', '15000', 4);
INSERT INTO ciudad (id_ciudad, nombre_ciudad, codigo_postal, id_pais) VALUES (5, 'Rio de Janeiro', '21000', 5);
INSERT INTO ciudad (id_ciudad, nombre_ciudad, codigo_postal, id_pais) VALUES (6, 'Ciudad de Mexico', '01020', 6);

-- Tabla 'oficina'
INSERT INTO oficina (id_oficina, id_ciudad, telefono, linea_direccion1, linea_direccion2) VALUES (1, 1, '0115678565', 'Calle Falsa 123', 'Apto 4B');
INSERT INTO oficina (id_oficina, id_ciudad, telefono, linea_direccion1, linea_direccion2) VALUES (2, 2, '1195432677', 'Avenida Paulista 1000', 'Sala 12');
INSERT INTO oficina (id_oficina, id_ciudad, telefono, linea_direccion1, linea_direccion2) VALUES (3, 3, '0322221111', 'Calle Real 456', 'Piso 1');
INSERT INTO oficina (id_oficina, id_ciudad, telefono, linea_direccion1, linea_direccion2) VALUES (4, 4, '0144345678', 'Avenida Principal 789', 'Oficina 3A');
INSERT INTO oficina (id_oficina, id_ciudad, telefono, linea_direccion1, linea_direccion2) VALUES (5, 5, '0219876543', 'Rua Verde 987', 'Bloco B');
INSERT INTO oficina (id_oficina, id_ciudad, telefono, linea_direccion1, linea_direccion2) VALUES (6, 6, '0523456789', 'Calle Central 1234', 'Edificio 8');

-- Tabla 'puesto'
INSERT INTO puesto (id_puesto, nombre_puesto) VALUES (1, 'Gerente');
INSERT INTO puesto (id_puesto, nombre_puesto) VALUES (2, 'Asistente');
INSERT INTO puesto (id_puesto, nombre_puesto) VALUES (3, 'Desarrollador');
INSERT INTO puesto (id_puesto, nombre_puesto) VALUES (4, 'Analista');
INSERT INTO puesto (id_puesto, nombre_puesto) VALUES (5, 'Consultor');

-- Tabla 'empleado'
INSERT INTO empleado (id_empleado, nombre, apellido1, apellido2, extension, email, id_oficina, id_jefe, id_puesto) VALUES (1, 'Juan', 'Perez', 'Gomez', '123', 'juan.perez@example.com', 1, NULL, 1);
INSERT INTO empleado (id_empleado, nombre, apellido1, apellido2, extension, email, id_oficina, id_jefe, id_puesto) VALUES (2, 'Ana', 'Garcia', 'Martinez', '124', 'ana.garcia@example.com', 1, 1, 2);
INSERT INTO empleado (id_empleado, nombre, apellido1, apellido2, extension, email, id_oficina, id_jefe, id_puesto) VALUES (3, 'Carlos', 'Lopez', 'Fernandez', '125', 'carlos.lopez@example.com', 2, 1, 3);
INSERT INTO empleado (id_empleado, nombre, apellido1, apellido2, extension, email, id_oficina, id_jefe, id_puesto) VALUES (4, 'Maria', 'Rodriguez', 'Sanchez', '126', 'maria.rodriguez@example.com', 3, 2, 4);
INSERT INTO empleado (id_empleado, nombre, apellido1, apellido2, extension, email, id_oficina, id_jefe, id_puesto) VALUES (5, 'Jose', 'Gonzalez', 'Diaz', '127', 'jose.gonzalez@example.com', 4, 3, 5);

-- Tabla 'direccion'
INSERT INTO direccion (id_direccion, tipo_direccion, direccion, descripcion, linea_direccion1, linea_direccion2, id_ciudad) VALUES(1, 'Oficina', 'Calle Falsa 123', 'Oficina principal', 'Calle Falsa 123', 'Apto 4B', 1);
INSERT INTO direccion (id_direccion, tipo_direccion, direccion, descripcion, linea_direccion1, linea_direccion2, id_ciudad) VALUES(2, 'Sucursal', 'Avenida Paulista 1000', 'Sucursal principal', 'Avenida Paulista 1000', NULL, 2);
INSERT INTO direccion (id_direccion, tipo_direccion, direccion, descripcion, linea_direccion1, linea_direccion2, id_ciudad) VALUES(3, 'Oficina', 'Calle Real 456', 'Oficina secundaria', 'Calle Real 456', 'Piso 1', 3);
INSERT INTO direccion (id_direccion, tipo_direccion, direccion, descripcion, linea_direccion1, linea_direccion2, id_ciudad) VALUES(4, 'Sucursal', 'Avenida Principal 789', 'Sucursal Lima', 'Avenida Principal 789', 'Oficina 3A', 4);
INSERT INTO direccion (id_direccion, tipo_direccion, direccion, descripcion, linea_direccion1, linea_direccion2, id_ciudad) VALUES(5, 'Oficina', 'Rua Verde 987', 'Oficina Rio de Janeiro', 'Rua Verde 987', 'Bloco B', 5);

-- Tabla 'cliente'
INSERT INTO cliente (id_cliente, nombre_contacto, nombre_cliente, apellido_cliente, email, fax, telefono, id_ciudad, id_direccion, id_empleado_rep_ventas, limite_credito) VALUES (1, 'Cliente Atra', 'Luis', 'Fernandez', 'luisfernandez@ejemplo.com', '1234', '5678', 1, 1, 1, 10000.00);
INSERT INTO cliente (id_cliente, nombre_contacto, nombre_cliente, apellido_cliente, email, fax, telefono, id_ciudad, id_direccion, id_empleado_rep_ventas, limite_credito) VALUES (2, 'Cliente Tribilin', 'Marta', 'Lopez', 'Martalopez@ejemplo.com', '5678', '1234', 2, 2, 2, 20000.00);
INSERT INTO cliente (id_cliente, nombre_contacto, nombre_cliente, apellido_cliente, email, fax, telefono, id_ciudad, id_direccion, id_empleado_rep_ventas, limite_credito) VALUES (3, 'Cliente Uno', 'Pedro', 'Perez', 'pedroperez@ejemplo.com', '6789', '7890', 3, 3, 3, 15000.00);
INSERT INTO cliente (id_cliente, nombre_contacto, nombre_cliente, apellido_cliente, email, fax, telefono, id_ciudad, id_direccion, id_empleado_rep_ventas, limite_credito) VALUES (4, 'Cliente Dos', 'Sofia', 'Garcia', 'sofiagarcia@ejemplo.com', '3456', '4567', 4, 4, 4, 25000.00);
INSERT INTO cliente (id_cliente, nombre_contacto, nombre_cliente, apellido_cliente, email, fax, telefono, id_ciudad, id_direccion, id_empleado_rep_ventas, limite_credito) VALUES (5, 'Cliente Tres', 'Diego', 'Morales', 'diegomorales@ejemplo.com', '4321', '8765', 5, 5, 5, 30000.00);

-- Tabla 'forma_pago'
INSERT INTO forma_pago (id_forma_pago, nombre_forma_pago) VALUES (1, 'Tarjeta de Credito');
INSERT INTO forma_pago (id_forma_pago, nombre_forma_pago) VALUES (2, 'Transferencia Bancaria');
INSERT INTO forma_pago (id_forma_pago, nombre_forma_pago) VALUES (3, 'Cheque');
INSERT INTO forma_pago (id_forma_pago, nombre_forma_pago) VALUES (4, 'Efectivo');
INSERT INTO forma_pago (id_forma_pago, nombre_forma_pago) VALUES (5, 'Pago Movil');

-- Tabla 'estado_pedido'
INSERT INTO estado_pedido (id_estado, nombre_estado) VALUES (1, 'Pendiente');
INSERT INTO estado_pedido (id_estado, nombre_estado) VALUES (2, 'Completado');
INSERT INTO estado_pedido (id_estado, nombre_estado) VALUES (3, 'Cancelado');
INSERT INTO estado_pedido (id_estado, nombre_estado) VALUES (4, 'En proceso');
INSERT INTO estado_pedido (id_estado, nombre_estado) VALUES (5, 'Devuelto');

-- Tabla 'proveedor'
INSERT INTO proveedor (id_proveedor, nombre, id_ciudad) VALUES (1, 'Proveedor A', 1);
INSERT INTO proveedor (id_proveedor, nombre, id_ciudad) VALUES (2, 'Proveedor B', 2);
INSERT INTO proveedor (id_proveedor, nombre, id_ciudad) VALUES (3, 'Proveedor C', 3);
INSERT INTO proveedor (id_proveedor, nombre, id_ciudad) VALUES (4, 'Proveedor D', 4);
INSERT INTO proveedor (id_proveedor, nombre, id_ciudad) VALUES (5, 'Proveedor E', 5);

-- Tabla 'gama_producto'
INSERT INTO gama_producto (gama, descripcion_texto, descripcion_html, imagen) VALUES ('Electronica', 'Productos electronicos', '<p>Productos electronicos</p>', 'image-electronics.jpg');
INSERT INTO gama_producto (gama, descripcion_texto, descripcion_html, imagen) VALUES ('Muebles', 'Muebles para oficina y hogar', '<p>Muebles para oficina y hogar</p>', 'image-furniture.jpg');
INSERT INTO gama_producto (gama, descripcion_texto, descripcion_html, imagen) VALUES ('Ropa', 'Ropa para todas las edades', '<p>Ropa para todas las edades</p>', 'image-clothing.jpg');
INSERT INTO gama_producto (gama, descripcion_texto, descripcion_html, imagen) VALUES ('Alimentos', 'Productos alimenticios frescos y enlatados', '<p>Productos alimenticios frescos y enlatados</p>', 'image-food.jpg');
INSERT INTO gama_producto (gama, descripcion_texto, descripcion_html, imagen) VALUES ('Deportes', 'Articulos deportivos', '<p>Articulos deportivos</p>', 'image-sports.jpg');

-- Tabla 'dimensiones'
INSERT INTO dimensiones (id_dimensiones, ancho, alto, largo) VALUES (1, 30.00, 20.00, 10.00);
INSERT INTO dimensiones (id_dimensiones, ancho, alto, largo) VALUES (2, 60.00, 40.00, 20.00);
INSERT INTO dimensiones (id_dimensiones, ancho, alto, largo) VALUES (3, 50.00, 30.00, 15.00);
INSERT INTO dimensiones (id_dimensiones, ancho, alto, largo) VALUES (4, 100.00, 60.00, 30.00);
INSERT INTO dimensiones (id_dimensiones, ancho, alto, largo) VALUES (5, 200.00, 120.00, 60.00);

-- Tabla 'producto'
INSERT INTO producto (id_producto, nombre, gama, id_dimensiones, id_proveedor, descripcion, cantidad_en_stock, precio_venta, precio_proveedor) VALUES (1, 'Laptop', 'Electronica', 1, 1, 'Laptop de ultima generacion', 10, 1200.00, 1000.00);
INSERT INTO producto (id_producto, nombre, gama, id_dimensiones, id_proveedor, descripcion, cantidad_en_stock, precio_venta, precio_proveedor) VALUES (2, 'Silla Oficina', 'Muebles', 2, 2, 'Silla ergonomica', 20, 150.00, 120.00);
INSERT INTO producto (id_producto, nombre, gama, id_dimensiones, id_proveedor, descripcion, cantidad_en_stock, precio_venta, precio_proveedor) VALUES (3, 'Camiseta', 'Ropa', 3, 3, 'Camiseta de algodon', 50, 20.00, 15.00);
INSERT INTO producto (id_producto, nombre, gama, id_dimensiones, id_proveedor, descripcion, cantidad_en_stock, precio_venta, precio_proveedor) VALUES (4, 'Manzanas', 'Alimentos', 4, 4, 'Manzanas frescas', 100, 1.00, 0.80);
INSERT INTO producto (id_producto, nombre, gama, id_dimensiones, id_proveedor, descripcion, cantidad_en_stock, precio_venta, precio_proveedor) VALUES (5, 'Balon', 'Deportes', 5, 5, 'Balon de futbol', 30, 25.00, 18.00);

-- Tabla 'pago'
INSERT INTO pago (id_pago, id_cliente, id_forma_pago, fecha_pago, total) VALUES (1, 1, 1, '2024-08-01', 5000.00);
INSERT INTO pago (id_pago, id_cliente, id_forma_pago, fecha_pago, total) VALUES (2, 2, 2, '2024-08-02', 15000.00);
INSERT INTO pago (id_pago, id_cliente, id_forma_pago, fecha_pago, total) VALUES (3, 3, 3, '2024-08-03', 2000.00);
INSERT INTO pago (id_pago, id_cliente, id_forma_pago, fecha_pago, total) VALUES (4, 4, 4, '2024-08-04', 3000.00);
INSERT INTO pago (id_pago, id_cliente, id_forma_pago, fecha_pago, total) VALUES (5, 5, 5, '2024-08-05', 10000.00);

-- Tabla 'pedido'
INSERT INTO pedido (id_pedido, fecha_pedido, fecha_esperada, fecha_entrega, comentarios, id_cliente, metodo_pago, id_pago, id_estado) VALUES (1, '2024-08-01', '2024-08-05', '2024-08-04', 'Pedido urgente', 1, 'Tarjeta de Credito', 1, 1);
INSERT INTO pedido (id_pedido, fecha_pedido, fecha_esperada, fecha_entrega, comentarios, id_cliente, metodo_pago, id_pago, id_estado) VALUES (2, '2024-08-02', '2024-08-10', '2024-08-11', 'Pedido estandar', 2, 'Transferencia Bancaria', 2, 2);
INSERT INTO pedido (id_pedido, fecha_pedido, fecha_esperada, fecha_entrega, comentarios, id_cliente, metodo_pago, id_pago, id_estado) VALUES (3, '2024-08-03', '2024-08-07', '2024-08-06', 'Pedido rapido', 3, 'Cheque', 3, 3);
INSERT INTO pedido (id_pedido, fecha_pedido, fecha_esperada, fecha_entrega, comentarios, id_cliente, metodo_pago, id_pago, id_estado) VALUES (4, '2024-08-04', '2024-08-12', '2024-08-11', 'Pedido para oficina', 4, 'Efectivo', 4, 4);
INSERT INTO pedido (id_pedido, fecha_pedido, fecha_esperada, fecha_entrega, comentarios, id_cliente, metodo_pago, id_pago, id_estado) VALUES (5, '2024-08-05', '2024-08-09', '2024-08-08', 'Pedido especial', 5, 'Pago Movil', 5, 5);

-- Tabla 'detalle_pedido'
INSERT INTO detalle_pedido (id_detalle_pedido, id_pedido, id_producto, cantidad, precio_unidad, numero_linea) VALUES (1, 1, 1, 1, 1200.00, 1);
INSERT INTO detalle_pedido (id_detalle_pedido, id_pedido, id_producto, cantidad, precio_unidad, numero_linea) VALUES (2, 2, 2, 2, 150.00, 1);
INSERT INTO detalle_pedido (id_detalle_pedido, id_pedido, id_producto, cantidad, precio_unidad, numero_linea) VALUES (3, 3, 3, 5, 20.00, 1);
INSERT INTO detalle_pedido (id_detalle_pedido, id_pedido, id_producto, cantidad, precio_unidad, numero_linea) VALUES (4, 4, 4, 50, 1.00, 1);
INSERT INTO detalle_pedido (id_detalle_pedido, id_pedido, id_producto, cantidad, precio_unidad, numero_linea) VALUES (5, 5, 5, 3, 25.00, 1);

INSERT INTO roles (name) VALUES ("ROLE_USER");
INSERT INTO roles (name) VALUES ("ROLE_ADMIN");
