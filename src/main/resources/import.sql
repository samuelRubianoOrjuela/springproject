INSERT INTO pais (id_pais, nombre_pais) VALUES (1, 'Argentina');
INSERT INTO pais (id_pais, nombre_pais) VALUES (2, 'Brasil');
INSERT INTO pais (id_pais, nombre_pais) VALUES (3, 'Chile');

INSERT INTO ciudad (id_ciudad, nombre_ciudad, codigo_postal, id_pais) VALUES (1, 'Buenos Aires', '1000', 1);
INSERT INTO ciudad (id_ciudad, nombre_ciudad, codigo_postal, id_pais) VALUES (2, 'São Paulo', '01000-000', 2);

INSERT INTO oficina (id_oficina, id_ciudad, telefono, linea_direccion1, linea_direccion2) VALUES (1, 1, '0115678565', 'Calle Falsa 123', 'Apto 4B');
INSERT INTO oficina (id_oficina, id_ciudad, telefono, linea_direccion1, linea_direccion2) VALUES (2, 2, '1195432677', 'Avenida Paulista 1000', 'Sala 12');

INSERT INTO puesto (id_puesto, nombre_puesto) VALUES (1, 'Gerente');
INSERT INTO puesto (id_puesto, nombre_puesto) VALUES (2, 'Asistente');

INSERT INTO empleado (id_empleado, nombre, apellido1, apellido2, extension, email, id_oficina, id_jefe, id_puesto) VALUES (1, 'Juan', 'Pérez', 'Gómez', '123', 'juan.perez@example.com', 1, 2, 1);
INSERT INTO empleado (id_empleado, nombre, apellido1, apellido2, extension, email, id_oficina, id_jefe, id_puesto) VALUES (2, 'Ana', 'García', 'Martínez', '124', 'ana.garcia@example.com', 1, 1, 2);

INSERT INTO direccion (id_direccion, tipo_direccion, direccion, descripcion, linea_direccion1, linea_direccion2, id_ciudad) VALUES(1, 'Oficina', 'Calle Falsa 123', 'Oficina principal', 'Calle Falsa 123', 'Apto 4B', 1);
INSERT INTO direccion (id_direccion, tipo_direccion, direccion, descripcion, linea_direccion1, linea_direccion2, id_ciudad) VALUES(2, 'Sucursal', 'Avenida Paulista 1000', 'Sucursal principal', 'Avenida Paulista 1000', NULL, 2);

INSERT INTO cliente (id_cliente, nombre_contacto, nombre_cliente, apellido_cliente, email, fax, telefono, id_ciudad, id_direccion, id_empleado_rep_ventas, limite_credito) VALUES (1, 'Cliente Atra', 'Luis', 'Fernández', 'luisfernandez@ejemplo.com', '1234', '5678', 1, 1, 1, 10000.00);
INSERT INTO cliente (id_cliente, nombre_contacto, nombre_cliente, apellido_cliente, email, fax, telefono, id_ciudad, id_direccion, id_empleado_rep_ventas, limite_credito) VALUES (2, 'Cliente Travelo', 'Marta', 'López', 'Martalopez@ejemplo.com', '5678', '1234', 2, 2, 2, 20000.00);

INSERT INTO forma_pago (id_forma_pago, nombre_forma_pago) VALUES (1, 'Tarjeta de Crédito');
INSERT INTO forma_pago (id_forma_pago, nombre_forma_pago) VALUES (2, 'Transferencia Bancaria');

INSERT INTO estado_pedido (id_estado, nombre_estado) VALUES (1, 'Pendiente');
INSERT INTO estado_pedido (id_estado, nombre_estado) VALUES (2, 'Completado');

INSERT INTO proveedor (id_proveedor, nombre, id_ciudad) VALUES (1, 'Proveedor A', 1);
INSERT INTO proveedor (id_proveedor, nombre, id_ciudad) VALUES (2, 'Proveedor B', 2);

INSERT INTO gama_producto (gama, descripcion_texto, descripcion_html, imagen) VALUES ('Electrónica', 'Productos electrónicos', '<p>Productos electrónicos</p>', 'image-electronics.jpg');
INSERT INTO gama_producto (gama, descripcion_texto, descripcion_html, imagen) VALUES ('Muebles', 'Muebles para oficina y hogar', '<p>Muebles para oficina y hogar</p>', 'image-furniture.jpg');

INSERT INTO dimensiones (id_dimensiones, ancho, alto, largo) VALUES (1, 30.00, 20.00, 10.00);
INSERT INTO dimensiones (id_dimensiones, ancho, alto, largo) VALUES (2, 60.00, 40.00, 20.00);

INSERT INTO producto (id_producto, nombre, gama, id_dimensiones, id_proveedor, descripcion, cantidad_en_stock, precio_venta, precio_proveedor) VALUES (1, 'Laptop', 'Electrónica', 1, 1, 'Laptop de última generación', 10, 1200.00, 1000.00);
INSERT INTO producto (id_producto, nombre, gama, id_dimensiones, id_proveedor, descripcion, cantidad_en_stock, precio_venta, precio_proveedor) VALUES (2, 'Silla Oficina', 'Muebles', 2, 2, 'Silla ergonómica', 20, 150.00, 120.00);

INSERT INTO stock (id_stock, id_producto, cantidad_en_stock) VALUES (1, 1, 10);
INSERT INTO stock (id_stock, id_producto, cantidad_en_stock) VALUES (2, 2, 20);

INSERT INTO pago (id_pago, id_cliente, id_forma_pago, fecha_pago, total) VALUES (1, 1, 1, '2024-08-01', 5000.00);
INSERT INTO pago (id_pago, id_cliente, id_forma_pago, fecha_pago, total) VALUES (2, 2, 2, '2024-08-02', 15000.00);

INSERT INTO pedido (id_pedido, fecha_pedido, fecha_esperada, fecha_entrega, comentarios, id_cliente, metodo_pago, id_pago, id_estado) VALUES (1, '2024-08-01', '2024-08-05', '2024-08-04', 'Pedido urgente', 1, 'Tarjeta de Crédito', 1, 1);
INSERT INTO pedido (id_pedido, fecha_pedido, fecha_esperada, fecha_entrega, comentarios, id_cliente, metodo_pago, id_pago, id_estado) VALUES (2, '2024-08-02', '2024-08-10', NULL, 'Pedido estándar', 2, 'Transferencia Bancaria', 2, 2);

INSERT INTO detalle_pedido (id_detalle_pedido, id_pedido, id_producto, cantidad, precio_unidad, numero_linea) VALUES (1, 1, 1, 1, 1200.00, 1);
INSERT INTO detalle_pedido (id_detalle_pedido, id_pedido, id_producto, cantidad, precio_unidad, numero_linea) VALUES (2, 2, 2, 2, 150.00, 1);
