delete from AnimacionEntity;
delete from ArtistaEntity;
delete from MediodepagoEntity;

delete from RondaEntity;

delete from RondaEntity;
delete from JuradoEntity;
delete from VotacionEntity;
delete from CalificacionEntity;
delete from ClienteEntity;

delete from facturaEntity;
delete from ConcursoEntity;



insert into ArtistaEntity (id, privado, nombre, tecnina, tema, usuario, contrasenia) values (1, 0, 'David Firth', 'Candice', 'Erin', 'DavidFirth', 'fZR73XIKI');
insert into ArtistaEntity (id, privado, nombre, tecnina, tema, usuario, contrasenia) values (2, 0, 'Becky and Joe', 'Normy', 'Trevar', 'beckyandjoe', 'p77HvSdgaO');

insert into AnimacionEntity (id, nombre, descripcion, precio, tecnica, tags, calificacion, link, fecha, artista_id, typeofanimation) values (1, 'Salad Fingers 1: Spoons', 'The very first episode of Salad Fingers', 867, 'Striped hyena', 'Hyaena hyaena', 5, 'OWBFKL6H7rI', '9/3/2013', 1, 'A');
insert into AnimacionEntity (id, nombre, descripcion, precio, tecnica, tags, calificacion, link, fecha, artista_id, typeofanimation) values (2, 'Salad Fingers 2: Friends', 'Salad Fingers has a few friends over for a fish supper', 385, 'Long-necked turtle', 'Chelodina longicollis', 1, 'cuCw5k-Lph0', '7/4/2008', 1, 'A');
insert into AnimacionEntity (id, nombre, descripcion, precio, tecnica, tags, calificacion, link, fecha, artista_id, typeofanimation) values (3, 'Salad Fingers 3: Nettles', 'Salad Fingers finds great pleasure in a magical plant.', 148, 'Trumpeter, green-winged', 'Psophia viridis', 1, 'ojoICRzSCOo', '7/13/2008', 1, 'A');
insert into AnimacionEntity (id, nombre, descripcion, precio, tecnica, tags, calificacion, link, fecha, artista_id, typeofanimation) values (4, 'Salad Fingers 4: Cage', 'Salad Fingers has a secret admirer.', 148, 'Trumpeter, green-winged', 'Psophia viridis', 1, 'tBNrtrntkJ4', '7/26/2008', 1, 'A');
insert into AnimacionEntity (id, nombre, descripcion, precio, tecnica, tags, calificacion, link, fecha, artista_id, typeofanimation) values (5, 'Salad Fingers 5: Picnic', 'Salad Fingers holds a grand picnic and invites all his friends.', 148, 'Trumpeter, green-winged', 'Psophia viridis', 1, 'P_zbGGNI7lo', '10/5/2008', 1, 'A');
insert into AnimacionEntity (id, nombre, descripcion, precio, tecnica, tags, calificacion, link, fecha, artista_id, typeofanimation) values (6, 'Salad Fingers 6: Present', 'Salad Fingers receives a gift from an old friend.', 148, 'Trumpeter, green-winged', 'Psophia viridis', 1, 'rU2D0ncBFm0', '4/17/2009', 1, 'A');
insert into AnimacionEntity (id, nombre, descripcion, precio, tecnica, tags, calificacion, link, fecha, artista_id, typeofanimation) values (7, 'Salad Fingers 7: Shore Leave', 'Salad FIngers brother returns from The Great War.', 148, 'Trumpeter, green-winged', 'Psophia viridis', 1, 'kQNRkdHeK1A', '3/20/2018', 1, 'A');
insert into AnimacionEntity (id, nombre, descripcion, precio, tecnica, tags, calificacion, link, fecha, artista_id, typeofanimation) values (8, 'Salad Fingers 8: Cupboard', 'Salad Fingers receives some unpleasant frequencies from his radio', 148, 'Trumpeter, green-winged', 'Psophia viridis', 1, 'oykmawhKWhc', '10/18/2009', 1, 'A');
insert into AnimacionEntity (id, nombre, descripcion, precio, tecnica, tags, calificacion, link, fecha, artista_id, typeofanimation) values (9, 'Salad Fingers 9: Letter', 'Salad Fingers receives a letter from the great war', 148, 'Trumpeter, green-winged', 'Psophia viridis', 1, 'MSOnIS84x1k', '8/4/2013', 1, 'A');
insert into AnimacionEntity (id, nombre, descripcion, precio, tecnica, tags, calificacion, link, fecha, artista_id, typeofanimation) values (10, 'Salad Fingers 10: Birthday', 'Its Hubert Cumberdales birthday', 148, 'Trumpeter, green-winged', 'Psophia viridis', 1, 'vsZrLSM61W0', '3/12/2014', 1, 'A');
insert into AnimacionEntity (id, nombre, descripcion, precio, tecnica, tags, calificacion, link, fecha, artista_id, typeofanimation) values (11, 'Salad Fingers 11: Glass Brother', 'Salad Fingers decides it’s time for Hubert Cumberdale to become a real boy', 148, 'Trumpeter, green-winged', 'Psophia viridis', 1, 'qeE-J-GjAyQ', '1/30/2019', 1, 'A');

insert into AnimacionEntity (id, nombre, descripcion, precio, tecnica, tags, calificacion, link, fecha, artista_id, typeofanimation) values (12, 'Dont Hug me Im Scared', 'DHIM', 867, 'Striped hyena', 'Hyaena hyaena', 5, '9C_HReR_McQ', '7/29/2011', 2, 'A');
insert into AnimacionEntity (id, nombre, descripcion, precio, tecnica, tags, calificacion, link, fecha, artista_id, typeofanimation) values (13, 'Dont Hug me Im Scared 2 - TIME', 'Some things change over Time.', 867, 'Striped hyena', 'Hyaena hyaena', 5, 'vtkGtXtDlQA', '1/8/2014', 2, 'A');
insert into AnimacionEntity (id, nombre, descripcion, precio, tecnica, tags, calificacion, link, fecha, artista_id, typeofanimation) values (14, 'Dont Hug me Im Scared 3', 'Maybe I could hold your hand? And together we can understand...', 867, 'Striped hyena', 'Hyaena hyaena', 5, 'sXOdn6vLCuU', '10/13/2014', 2, 'A');
insert into AnimacionEntity (id, nombre, descripcion, precio, tecnica, tags, calificacion, link, fecha, artista_id, typeofanimation) values (15, 'Dont Hug me Im Scared 4', 'Its easy to be a clever smart boy like me...', 867, 'Striped hyena', 'Hyaena hyaena', 5, 'G9FGgwCQ22w', '3/30/2015', 2, 'A');
insert into AnimacionEntity (id, nombre, descripcion, precio, tecnica, tags, calificacion, link, fecha, artista_id, typeofanimation) values (16, 'Dont Hug me Im Scared 5', 'You look to be a bit hungry?', 867, 'Striped hyena', 'Hyaena hyaena', 5, 'tS_Xq7gSCBM', '10/14/2015', 2, 'A');
insert into AnimacionEntity (id, nombre, descripcion, precio, tecnica, tags, calificacion, link, fecha, artista_id, typeofanimation) values (17, 'Dont Hug me Im Scared 6', 'Looks like someones having a bad dream?', 867, 'Striped hyena', 'Hyaena hyaena', 5, 'dbL-NSkXnl8', '6/19/2016', 2, 'A');

insert into RondaEntity (id, numero, fechaInicio, fechaFin) values (1, 2, '4/14/2018', '5/6/2018');
insert into RondaEntity (id, numero, fechaInicio, fechaFin) values (2, 1, '4/30/2018', '5/8/2018');
insert into RondaEntity (id, numero, fechaInicio, fechaFin) values (3, 2, '5/8/2018', '5/19/2018');
insert into RondaEntity (id, numero, fechaInicio, fechaFin) values (4, 2, '4/28/2018', '5/1/2018');
insert into RondaEntity (id, numero, fechaInicio, fechaFin) values (5, 1, '4/11/2018', '5/2/2018');

insert into JuradoEntity (id, credencial, usuario, contrasena) values (1, 'Jurado1', 'J1', 'J1');
insert into JuradoEntity (id, credencial, usuario, contrasena) values (2, 'Jurado2', 'J2', 'J2');
insert into JuradoEntity (id, credencial, usuario, contrasena) values (3, 'Jurado3', 'J3', 'J3');
insert into JuradoEntity (id, credencial, usuario, contrasena) values (4, 'Jurado4', 'J4', 'J4');
insert into JuradoEntity (id, credencial, usuario, contrasena) values (5, 'Jurado5', 'J5', 'J5');

insert into VotacionEntity (id, idAnimacion, puntos, numRonda, ronda_id, jurado_id) values (1, 1, 4, 2, 5, 5);
insert into VotacionEntity (id, idAnimacion, puntos, numRonda, ronda_id, jurado_id) values (2, 1, 1, 1, 3, 1);
insert into VotacionEntity (id, idAnimacion, puntos, numRonda, ronda_id, jurado_id) values (3, 2, 2, 2, 4, 1);
insert into VotacionEntity (id, idAnimacion, puntos, numRonda, ronda_id, jurado_id) values (4, 2, 2, 1, 1, 2);
insert into VotacionEntity (id, idAnimacion, puntos, numRonda, ronda_id, jurado_id) values (5, 1, 4, 1, 3, 1);
insert into VotacionEntity (id, idAnimacion, puntos, numRonda, ronda_id, jurado_id) values (6, 2, 2, 1, 3, 1);
insert into VotacionEntity (id, idAnimacion, puntos, numRonda, ronda_id, jurado_id) values (7, 2, 4, 2, 1, 4);
insert into VotacionEntity (id, idAnimacion, puntos, numRonda, ronda_id, jurado_id) values (8, 1, 3, 1, 3, 3);
insert into VotacionEntity (id, idAnimacion, puntos, numRonda, ronda_id, jurado_id) values (9, 2, 5, 2, 5, 3);
insert into VotacionEntity (id, idAnimacion, puntos, numRonda, ronda_id, jurado_id) values (10, 1, 4, 2, 2, 1);
insert into VotacionEntity (id, idAnimacion, puntos, numRonda, ronda_id, jurado_id) values (11, 2, 1, 1, 5, 1);
insert into VotacionEntity (id, idAnimacion, puntos, numRonda, ronda_id, jurado_id) values (12, 2, 5, 2, 3, 2);

insert into ClienteEntity (id, nombre, informacion, usuario, contrasenia) values (1, 'Juan', 'yo soy juan', 'JJ', 'jajaja123');
insert into ClienteEntity (id, nombre, informacion, usuario, contrasenia) values (2, 'Daniel', 'yo soy Dany', 'dany', 'jeje123');
insert into ClienteEntity (id, nombre, informacion, usuario, contrasenia) values (3, 'Camila', 'yo soy tu padre', 'camilauno', 'darcy123');
insert into ClienteEntity (id, nombre, informacion, usuario, contrasenia) values (4, 'Light', 'El dios del nuevo mundo', 'Kira', 'daslkjfNÑ');
insert into ClienteEntity (id, nombre, informacion, usuario, contrasenia) values (6, 'Kakaroto', 'Hola, soy Goku', 'Goku', 'vamosapelear345');
insert into ClienteEntity (id, nombre, informacion, usuario, contrasenia) values (7, 'Shin', 'No soy raro', 'Wolford', 'fisica123');
insert into ClienteEntity (id, nombre, informacion, usuario, contrasenia) values (8, 'Anakin Skywaler', 'yo soy tu padre', 'Darth Vader', 'darthvadersito123');
insert into ClienteEntity (id, nombre, informacion, usuario, contrasenia) values (9, 'Naruto', 'Algún día seré Hokage', 'El Séptimo', 'elseptimo');



insert into CalificacionEntity (id, animacion_id, cliente_id, comentario, calificacion) values (1, 1, 1, 'Muy buena, me gustó mucho', 8);
insert into CalificacionEntity (id, animacion_id, cliente_id, comentario, calificacion) values (2, 1, 6, 'Buena, me gustó ', 7);
insert into CalificacionEntity (id, animacion_id, cliente_id, comentario, calificacion) values (3, 1, 7, 'Bastante buena pero no es perfecta', 9);
insert into CalificacionEntity (id, animacion_id, cliente_id, comentario, calificacion) values (4, 2, 2, 'Regular, ni buena, ni mala', 5);
insert into CalificacionEntity (id, animacion_id, cliente_id, comentario, calificacion) values (5, 2, 8, 'No me gustó pero no estuvo tan mal', 4);
insert into CalificacionEntity (id, animacion_id, cliente_id, comentario, calificacion) values (6, 3, 3, 'Me gustó ', 8);
insert into CalificacionEntity (id, animacion_id, cliente_id, comentario, calificacion) values (7, 4, 9, 'Hagan más como esta', 8);
insert into CalificacionEntity (id, animacion_id, cliente_id, comentario, calificacion) values (8, 5, 1, 'Excelente', 10);
insert into CalificacionEntity (id, animacion_id, cliente_id, comentario, calificacion) values (9, 6, 2, 'Aceptable, no es la mejor', 7);
insert into CalificacionEntity (id, animacion_id, cliente_id, comentario, calificacion) values (10, 7, 4, 'Puedo vivir con eso', 6);
insert into CalificacionEntity (id, animacion_id, cliente_id, comentario, calificacion) values (11, 8, 6, 'Toma tu like, ah cierto, no puedo dar like', 8);
insert into CalificacionEntity (id, animacion_id, cliente_id, comentario, calificacion) values (12, 9, 3, 'De lo peor', 3);
insert into CalificacionEntity (id, animacion_id, cliente_id, comentario, calificacion) values (13, 10, 2, 'Meh, aguanta', 7);
insert into CalificacionEntity (id, animacion_id, cliente_id, comentario, calificacion) values (14, 10, 1, 'Le daría me encorazona si pudiera xd :v', 8);


insert into CalificacionEntity (id, animacion_id, cliente_id, comentario, calificacion) values (15, 10, 1, 'Muy buena, me gustó mucho', 8);
insert into CalificacionEntity (id, animacion_id, cliente_id, comentario, calificacion) values (16, 11, 7, 'Buena, me gustó ', 7);
insert into CalificacionEntity (id, animacion_id, cliente_id, comentario, calificacion) values (17, 12, 8, 'Bastante buena pero no es perfecta', 9);
insert into CalificacionEntity (id, animacion_id, cliente_id, comentario, calificacion) values (18, 12, 8, 'Regular, ni buena, ni mala', 5);
insert into CalificacionEntity (id, animacion_id, cliente_id, comentario, calificacion) values (19, 12, 2, 'No me gustó pero no estuvo tan mal', 4);
insert into CalificacionEntity (id, animacion_id, cliente_id, comentario, calificacion) values (20, 13, 9, 'Me gustó ', 8);
insert into CalificacionEntity (id, animacion_id, cliente_id, comentario, calificacion) values (21, 14, 3, 'Hagan más como esta', 8);
insert into CalificacionEntity (id, animacion_id, cliente_id, comentario, calificacion) values (22, 15, 1, 'Excelente', 10);
insert into CalificacionEntity (id, animacion_id, cliente_id, comentario, calificacion) values (23, 16, 2, 'Aceptable, no es la mejor', 7);
insert into CalificacionEntity (id, animacion_id, cliente_id, comentario, calificacion) values (24, 17, 9, 'Puedo vivir con eso', 6);
insert into CalificacionEntity (id, animacion_id, cliente_id, comentario, calificacion) values (25, 15, 4, 'Toma tu like, ah cierto, no puedo dar like', 8);
insert into CalificacionEntity (id, animacion_id, cliente_id, comentario, calificacion) values (26, 17, 8, 'De lo peor', 3);
insert into CalificacionEntity (id, animacion_id, cliente_id, comentario, calificacion) values (27, 11, 7, 'Meh, aguanta', 7);
insert into CalificacionEntity (id, animacion_id, cliente_id, comentario, calificacion) values (28, 8, 1, 'Le daría me encorazona si pudiera xd :v', 8);

--select * from AnimacionEntity;
--select * from ArtistaEntity;
--select * from CalificacionEntity;