/*DATOS */

/*1. DATOS CIUDAD */
INSERT INTO ciudad (nombre) VALUES 
('Bucaramanga'),
('Bogotá'),
('Medellín'),
('Cali'),
('Cartagena');

/*2. DATOS DIRECCIÓN */
INSERT INTO direcciones (direccion_valor) VALUES 
('Calle 123 #45-67'),
('Carrera 54A #10-11'),
('Avenida El Dorado, Edificio Almira 402'), 
('Carrera 84 #32-42'),
('Calle 15A #30-18');

/*3. DATOS PERSONAS - ESTUDIANTES*/
INSERT INTO personas (nombre_persona, apellido_persona, telefono, fecha_nacimiento, genero, clase_documento, numero_documento, id_ciudad, id_direccion) VALUES
('Juan', 'Pérez', 123456789, '1990-01-01', 'M', 'Cédula', 123456789, 1, 1),
('María', 'Gómez', 987654321, '1991-02-02', 'F', 'Cédula de Extranjería', 987654321, 2, 2),
('Pedro', 'López', 321654987, '1992-03-03', 'M', 'Número de Pasaporte', 321654987, 3, 3),
('Ana', 'Martínez', 456789012, '1993-04-04', 'F', 'Tarjeta de Identidad', 456789012, 4, 4),
('Luis', 'Rodríguez', 567890123, '1994-05-05', 'M', 'Cédula', 567890123, 5, 5);

/*3. DATOS PERSONAS - PROFESORES*/
INSERT INTO personas (nombre_persona, apellido_persona, telefono, fecha_nacimiento, genero, clase_documento, numero_documento, id_ciudad, id_direccion) VALUES
('Camila', 'Rojas', 654789321, '1995-06-06', 'F', 'Tarjeta de Identidad', 654789321, 2, 3),
('Santiago', 'Fernández', 789012345, '1996-07-07', 'M', 'Cédula', 789012345, 3, 4),
('Valentina', 'Gutiérrez', 987456123, '1997-08-08', 'F', 'Cédula de Extranjería', 987456123, 4, 5);

/*4. DATOS CARRERAS*/
INSERT INTO carreras (nombre_programa, categoria) VALUES
('Ingeniería Informática', 'pregrado'),
('Derecho', 'pregrado'),
('Medicina', 'pregrado'),
('Administración de Empresas', 'pregrado'),
('Maestría en Ingeniería Informática', 'posgrado');

/*5. DATOS ESTUDIANTE_CARRERA*/
INSERT INTO estudiante_carrera (id_persona, id_programa) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);

/*6. DATOS FACULTADES*/
INSERT INTO facultades (nombre_facultad) VALUES
('Ingeniería'),
('Medicina'),
('Derecho'),
('Administración de Empresas'),
('Humanidades');

/*7. DATOS PROFESORES*/
INSERT INTO profesores (id_persona, id_facultad) VALUES
(6, 1),
(7, 2),
(8, 3);

/*8. DATOS EDIFICIOS*/
INSERT INTO edificios (nombre_edificio, pisos_edificio) VALUES
('Edificio A', 5),
('Edificio B', 10),
('Edificio C', 15);

/*9. DATOS CURSO_MATERIA*/
INSERT INTO curso_materia (nombre_curso, guia_curso) VALUES
('43B', 'Introducción a la Programación'),
('12M', 'Cálculo Diferencial e Integral'),
('89C', 'Física General');

/*10. DATOS PERIODO*/
INSERT INTO periodo (anio, semestre) VALUES
(2023, 1),
(2023, 2),
(2024, 1);

/*11. DATOS SALÓN*/
INSERT INTO salon (valor_salon, capacidad_salon, piso_edificio) VALUES
('A101', 30, 1),
('B202', 40, 2),
('C303', 50, 3);

/*12. DATOS VALOR MATRICULAS*/
INSERT INTO valor_matricula (valor_credito, id_programa, id_periodo) VALUES
(120000, 1, 1),
(150000, 2, 2),
(180000, 3, 3);

/*13. DATOS DE MATERIAS*/
INSERT INTO materias (nombre_materia, creditos, cantidad_estudiantes) VALUES
('Introducción a la Programación', 4, 50),
('Cálculo Diferencial e Integral', 3, 40),
('Física General', 4, 30);

/*14. DATOS DE REGISTRO*/
INSERT INTO registro (id_estudiante, id_periodo, id_materia) VALUES
(1, 1, 1),
(1, 2, 2),
(2, 1, 3);

/*15. DATOS DE MATERIA*/
INSERT INTO horario (dia_clase, hora_inicio, hora_final) VALUES
('Lunes', '08:00:00', '10:00:00'),
('Martes', '10:00:00', '12:00:00'),
('Miércoles', '14:00:00', '16:00:00');