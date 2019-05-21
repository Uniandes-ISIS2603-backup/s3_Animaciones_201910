
delete from CalificacionEntity;
delete from AnimacionEntity;
delete from ArtistaEntity;
delete from MediodepagoEntity;
delete from VotacionEntity;
delete from RondaEntity;
delete from RondaEntity;
delete from JuradoEntity;
delete from ClienteEntity;

delete from facturaEntity;
delete from ConcursoEntity;



insert into ArtistaEntity (id, privado, nombre, tecnina, tema, usuario, contrasenia) values (1, 0, 'David Firth', 'Candice', 'Erin', 'DavidFirth', 'fZR73XIKI');
insert into ArtistaEntity (id, privado, nombre, tecnina, tema, usuario, contrasenia) values (2, 0, 'Becky and Joe', 'Normy', 'Trevar', 'beckyandjoe', 'p77HvSdgaO');

insert into AnimacionEntity (id, nombre, descripcion, precio, tecnica, tags, calificacion, link, fecha, artista_id, typeofanimation) values (89, 'Salad Fingers 1: Spoons', 'The very first episode of Salad Fingers', 867, 'Striped hyena', 'Hyaena hyaena', 5, 'OWBFKL6H7rI', '9/3/2013', 1, 'A');
insert into AnimacionEntity (id, nombre, descripcion, precio, tecnica, tags, calificacion, link, fecha, artista_id, typeofanimation) values (90, 'Salad Fingers 2: Friends', 'Salad Fingers has a few friends over for a fish supper', 385, 'Long-necked turtle', 'Chelodina longicollis', 1, 'cuCw5k-Lph0', '7/4/2008', 1, 'A');
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

insert into RondaEntity (id, numero, fechaInicio, fechaFin) values (18, 2, '4/14/2018', '5/6/2018');
insert into RondaEntity (id, numero, fechaInicio, fechaFin) values (19, 1, '4/30/2018', '5/8/2018');
insert into RondaEntity (id, numero, fechaInicio, fechaFin) values (20, 2, '5/8/2018', '5/19/2018');
insert into RondaEntity (id, numero, fechaInicio, fechaFin) values (21, 2, '4/28/2018', '5/1/2018');
insert into RondaEntity (id, numero, fechaInicio, fechaFin) values (22, 1, '4/11/2018', '5/2/2018');

insert into JuradoEntity (id, credencial, usuario, contrasena) values (23, 'Jurado1', 'J1', 'J1');
insert into JuradoEntity (id, credencial, usuario, contrasena) values (24, 'Jurado2', 'J2', 'J2');
insert into JuradoEntity (id, credencial, usuario, contrasena) values (25, 'Jurado3', 'J3', 'J3');
insert into JuradoEntity (id, credencial, usuario, contrasena) values (26, 'Jurado4', 'J4', 'J4');
insert into JuradoEntity (id, credencial, usuario, contrasena) values (27, 'Jurado5', 'J5', 'J5');

insert into VotacionEntity (id, idAnimacion, puntos, numRonda, ronda_id, jurado_id) values (28, 1, 4, 2, 22, 27);
insert into VotacionEntity (id, idAnimacion, puntos, numRonda, ronda_id, jurado_id) values (29, 1, 1, 1, 20, 23);
insert into VotacionEntity (id, idAnimacion, puntos, numRonda, ronda_id, jurado_id) values (30, 2, 2, 2, 21, 23);
insert into VotacionEntity (id, idAnimacion, puntos, numRonda, ronda_id, jurado_id) values (31, 2, 2, 1, 18, 24);
insert into VotacionEntity (id, idAnimacion, puntos, numRonda, ronda_id, jurado_id) values (32, 1, 4, 1, 20, 23);
insert into VotacionEntity (id, idAnimacion, puntos, numRonda, ronda_id, jurado_id) values (91, 2, 2, 1, 20, 23);
insert into VotacionEntity (id, idAnimacion, puntos, numRonda, ronda_id, jurado_id) values (34, 2, 4, 2, 18, 24);
insert into VotacionEntity (id, idAnimacion, puntos, numRonda, ronda_id, jurado_id) values (35, 1, 3, 1, 20, 25);
insert into VotacionEntity (id, idAnimacion, puntos, numRonda, ronda_id, jurado_id) values (36, 2, 5, 2, 22, 25);
insert into VotacionEntity (id, idAnimacion, puntos, numRonda, ronda_id, jurado_id) values (37, 1, 4, 2, 19, 23);
insert into VotacionEntity (id, idAnimacion, puntos, numRonda, ronda_id, jurado_id) values (38, 2, 1, 1, 22, 23);
insert into VotacionEntity (id, idAnimacion, puntos, numRonda, ronda_id, jurado_id) values (39, 2, 5, 2, 22, 24);

insert into ClienteEntity (id, nombre, informacion, usuario, contrasenia) values (40, 'Juan', 'yo soy juan', 'JJ', 'jajaja123');
insert into ClienteEntity (id, nombre, informacion, usuario, contrasenia) values (41, 'Daniel', 'yo soy Dany', 'dany', 'jeje123');
insert into ClienteEntity (id, nombre, informacion, usuario, contrasenia) values (42, 'Camila', 'yo soy tu padre', 'camilauno', 'darcy123');
insert into ClienteEntity (id, nombre, informacion, usuario, contrasenia) values (43, 'Light', 'El dios del nuevo mundo', 'Kira', 'daslkjfNÑ');
insert into ClienteEntity (id, nombre, informacion, usuario, contrasenia) values (44, 'Kakaroto', 'Hola, soy Goku', 'Goku', 'vamosapelear345');
insert into ClienteEntity (id, nombre, informacion, usuario, contrasenia) values (45, 'Shin', 'No soy raro', 'Wolford', 'fisica123');
insert into ClienteEntity (id, nombre, informacion, usuario, contrasenia) values (46, 'Anakin Skywaler', 'yo soy tu padre', 'Darth Vader', 'darthvadersito123');
insert into ClienteEntity (id, nombre, informacion, usuario, contrasenia) values (47, 'Naruto', 'Algún día seré Hokage', 'El Séptimo', 'elseptimo');



insert into CalificacionEntity (id, animacion_id, cliente_id, comentario, calificacion) values (49, 89, 40, 'Muy buena, me gustó mucho', 8);
insert into CalificacionEntity (id, animacion_id, cliente_id, comentario, calificacion) values (50, 89, 45, 'Buena, me gustó ', 7);
insert into CalificacionEntity (id, animacion_id, cliente_id, comentario, calificacion) values (51, 89, 46, 'Bastante buena pero no es perfecta', 9);
insert into CalificacionEntity (id, animacion_id, cliente_id, comentario, calificacion) values (52, 90, 41, 'Regular, ni buena, ni mala', 5);
insert into CalificacionEntity (id, animacion_id, cliente_id, comentario, calificacion) values (53, 90, 47, 'No me gustó pero no estuvo tan mal', 4);
insert into CalificacionEntity (id, animacion_id, cliente_id, comentario, calificacion) values (54, 3, 42, 'Me gustó ', 8);
insert into CalificacionEntity (id, animacion_id, cliente_id, comentario, calificacion) values (55, 4, 47, 'Hagan más como esta', 8);
insert into CalificacionEntity (id, animacion_id, cliente_id, comentario, calificacion) values (56, 5, 40, 'Excelente', 10);
insert into CalificacionEntity (id, animacion_id, cliente_id, comentario, calificacion) values (57, 6, 41, 'Aceptable, no es la mejor', 7);
insert into CalificacionEntity (id, animacion_id, cliente_id, comentario, calificacion) values (58, 7, 43, 'Puedo vivir con eso', 6);
insert into CalificacionEntity (id, animacion_id, cliente_id, comentario, calificacion) values (59, 8, 45, 'Toma tu like, ah cierto, no puedo dar like', 8);
insert into CalificacionEntity (id, animacion_id, cliente_id, comentario, calificacion) values (60, 9, 42, 'De lo peor', 3);
insert into CalificacionEntity (id, animacion_id, cliente_id, comentario, calificacion) values (61, 10, 41, 'Meh, aguanta', 7);
insert into CalificacionEntity (id, animacion_id, cliente_id, comentario, calificacion) values (62, 10, 40, 'Le daría me encorazona si pudiera xd :v', 8);


insert into CalificacionEntity (id, animacion_id, cliente_id, comentario, calificacion) values (63, 10, 40, 'Muy buena, me gustó mucho', 8);
insert into CalificacionEntity (id, animacion_id, cliente_id, comentario, calificacion) values (64, 11, 46, 'Buena, me gustó ', 7);
insert into CalificacionEntity (id, animacion_id, cliente_id, comentario, calificacion) values (65, 12, 47, 'Bastante buena pero no es perfecta', 9);
insert into CalificacionEntity (id, animacion_id, cliente_id, comentario, calificacion) values (66, 12, 47, 'Regular, ni buena, ni mala', 5);
insert into CalificacionEntity (id, animacion_id, cliente_id, comentario, calificacion) values (67, 12, 41, 'No me gustó pero no estuvo tan mal', 4);
insert into CalificacionEntity (id, animacion_id, cliente_id, comentario, calificacion) values (68, 13, 47, 'Me gustó ', 8);
insert into CalificacionEntity (id, animacion_id, cliente_id, comentario, calificacion) values (69, 14, 42, 'Hagan más como esta', 8);
insert into CalificacionEntity (id, animacion_id, cliente_id, comentario, calificacion) values (70, 15, 40, 'Excelente', 10);
insert into CalificacionEntity (id, animacion_id, cliente_id, comentario, calificacion) values (72, 16, 41, 'Aceptable, no es la mejor', 7);
insert into CalificacionEntity (id, animacion_id, cliente_id, comentario, calificacion) values (73, 17, 47, 'Puedo vivir con eso', 6);
insert into CalificacionEntity (id, animacion_id, cliente_id, comentario, calificacion) values (74, 15, 43, 'Toma tu like, ah cierto, no puedo dar like', 8);
insert into CalificacionEntity (id, animacion_id, cliente_id, comentario, calificacion) values (75, 17, 47, 'De lo peor', 3);
insert into CalificacionEntity (id, animacion_id, cliente_id, comentario, calificacion) values (76, 11, 46, 'Meh, aguanta', 7);
insert into CalificacionEntity (id, animacion_id, cliente_id, comentario, calificacion) values (77, 8, 40, 'Le daría me encorazona si pudiera xd :v', 8);


insert into ConcursoEntity (id, tema, tecnica, organizador, reglas) values (78, 'Animaciones de Naturaleza', 'Rotoscopía', 0, 'No maltratar animales' );
insert into ConcursoEntity (id, tema, tecnica, organizador, reglas) values (79, 'Animaciones en la ciudad', 'Animacion de punto', 3, 'No grabar en espacios no permitidos' );
insert into ConcursoEntity (id, tema, tecnica, organizador, reglas) values (80, 'Animacion fantástica', 'Stopmotion', 3, 'usar más de 80 frames' );
insert into ConcursoEntity (id, tema, tecnica, organizador, reglas) values (81, 'El Cronos', 'Pixelation', 3, 'No maltratar animales' );
insert into ConcursoEntity (id, tema, tecnica, organizador, reglas) values (82, 'Tributo a Les Claypool', 'Claymotion', 3, 'Usar plastilina psicodélica' );

insert into AnimacionEntity ( id, typeofanimation, ronda_id, puntaje, puesto, finalista, dinero, nombre, fecha, descripcion, precio, tecnica, tags, calificacion, link ) values (83, 'P', 18, 5, 0, 0, 0,'buho','9/3/2013', 'las creaciones de Hagrid', 0, 'rotoscópia', 'Hedwig volando', 5, 'cococo.png');
insert into AnimacionEntity ( id, typeofanimation, ronda_id, puntaje, puesto, finalista, dinero, nombre, fecha, descripcion, precio, tecnica, tags, calificacion, link ) values (84, 'P', 19, 5, 0, 0, 0,'matik matik','9/3/2013', 'punkeritas y el ron de sabores', 0, 'Animacion de punto', 'nuncaOldJhon', 5, 'hip.png');
insert into AnimacionEntity ( id, typeofanimation, ronda_id, puntaje, puesto, finalista, dinero, nombre, fecha, descripcion, precio, tecnica, tags, calificacion, link ) values (85, 'P', 20, 5, 0, 0, 0,'superHot','9/3/2013', 'mind is software', 0, 'stopMotion', 'gente volando', 5, 'katanaOnly.png');
insert into AnimacionEntity ( id, typeofanimation, ronda_id, puntaje, puesto, finalista, dinero, nombre, fecha, descripcion, precio, tecnica, tags, calificacion, link ) values (86, 'P', 21, 5, 0, 0, 0,'KatanaZero','9/3/2013', 'NO LE HABLES A ELECTROHEAD', 0, 'pixelation', 'cabezas volando', 5, 'splash.png');
insert into AnimacionEntity ( id, typeofanimation, ronda_id, puntaje, puesto, finalista, dinero, nombre, fecha, descripcion, precio, tecnica, tags, calificacion, link ) values (87, 'P', 22, 5, 0, 0, 0,'nynph()maniac','9/3/2013', 'Ramsteim gratuito y en la cara', 0, 'Live-action', 'Lars Von trier', 5, 'laCajaDePandora.png');
insert into AnimacionEntity ( id, typeofanimation, ronda_id, puntaje, puesto, finalista, dinero, nombre, fecha, descripcion, precio, tecnica, tags, calificacion, link ) values (88, 'P', 18, 5, 0, 0, 0,'Brisa','9/3/2013', 'un vive100 en Melgar (el paraiso)', 0, 'Con recortes', 'kim Gordon', 5, 'laDeSonicYouth.png');

--select * from AnimacionEntity;
--select * from ArtistaEntity;
select * from CalificacionEntity;