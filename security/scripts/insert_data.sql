
-- Insertar roles de profesor
INSERT INTO "ROL" ("IdRol", "Nombre", "Descripcion")
VALUES (1, 'Profesor', 'Rol para profesores'),
       (2, 'Alumno', 'Rol para alumnos'),
       (3, 'Admin', 'Rol para admin');
-- Asignar roles de profesor a los usuario
INSERT INTO "USUARIO_ROL" ("IdUsuario", "IdRol")
VALUES (1, 1);






