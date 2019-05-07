delete from AnimacionEntity;
delete from ArtistaEntity;
delete from RondaEntity;
delete from VotacionEntity;
delete from CalificacionEntity;

insert into ArtistaEntity (id, privado, nombre, tecnina, tema, usuario, contrasenia) values (1, 0, 'David Firth', 'Candice', 'Erin', 'DavidFirth', 'fZR73XIKI');
insert into ArtistaEntity (id, privado, nombre, tecnina, tema, usuario, contrasenia) values (2, 0, 'Becky and Joe', 'Normy', 'Trevar', 'beckyandjoe', 'p77HvSdgaO');
insert into ArtistaEntity (id, privado, nombre, tecnina, tema, usuario, contrasenia) values (3, 0, 'Alissa', 'Elena', 'Thaxter', 'tmclagan2', 'nqhjex6D');
insert into ArtistaEntity (id, privado, nombre, tecnina, tema, usuario, contrasenia) values (4, 0, 'Sherlocke', 'Tildie', 'Tanhya', 'tcammacke3', 'UINQxq0kw1i');
insert into ArtistaEntity (id, privado, nombre, tecnina, tema, usuario, contrasenia) values (5, 0, 'Ebba', 'Nollie', 'Kali', 'kquinnell4', 'eILC4Qe3tapk');

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

insert into ClienteEntity (id, nombre, informacion, usuario, contrasenia) values (1, 'Juan', 'yo soy juan', 'JJ', 'popo');

insert into CalificacionEntity (id, animacion_id, cliente_id, comentario) values (1, 1, 1, 'Muy buena me gusto mucho');

--select * from AnimacionEntity;
--select * from ArtistaEntity;