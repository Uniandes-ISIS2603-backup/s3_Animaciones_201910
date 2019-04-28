delete from AnimacionEntity;
delete from ArtistaEntity;
delete from RondaEntity;
delete from VotacionEntity;
delete from CalificacionEntity;

insert into ArtistaEntity (id, privado, nombre, tecnina, tema, usuario, contrasenia) values (1, 1, 'Dayle', 'Candice', 'Erin', 'eibbitt0', 'fZR73XIKI');
insert into ArtistaEntity (id, privado, nombre, tecnina, tema, usuario, contrasenia) values (2, 0, 'Caitlin', 'Normy', 'Trevar', 'tgiacubo1', 'p77HvSdgaO');
insert into ArtistaEntity (id, privado, nombre, tecnina, tema, usuario, contrasenia) values (3, 0, 'Alissa', 'Elena', 'Thaxter', 'tmclagan2', 'nqhjex6D');
insert into ArtistaEntity (id, privado, nombre, tecnina, tema, usuario, contrasenia) values (4, 1, 'Sherlocke', 'Tildie', 'Tanhya', 'tcammacke3', 'UINQxq0kw1i');
insert into ArtistaEntity (id, privado, nombre, tecnina, tema, usuario, contrasenia) values (5, 0, 'Ebba', 'Nollie', 'Kali', 'kquinnell4', 'eILC4Qe3tapk');

insert into AnimacionEntity (id, nombre, descripcion, precio, tecnica, tags, calificacion, link, fecha, artista_id, typeofanimation) values (1, 'Xunlei Limited', 'Mock Goldenweed', 867, 'Striped hyena', 'Hyaena hyaena', 5, 'Eget.jpeg', '10/20/2018', 1, 'A');
insert into AnimacionEntity (id, nombre, descripcion, precio, tecnica, tags, calificacion, link, fecha, artista_id, typeofanimation) values (2, 'Public Storage', 'British Felt Lichen', 385, 'Long-necked turtle', 'Chelodina longicollis', 1, 'SedInterdumVenenatis.pdf', '3/15/2018', 2, 'A');
insert into AnimacionEntity (id, nombre, descripcion, precio, tecnica, tags, calificacion, link, fecha, artista_id, typeofanimation) values (3, 'Ares Capital Corporation', 'Blessed Thistle', 148, 'Trumpeter, green-winged', 'Psophia viridis', 1, 'DonecSemper.jpeg', '8/2/2018', 2, 'A');

insert into RondaEntity (id, numero, fechaInicio, fechaFin) values (1, 2, '4/14/2018', '5/6/2018');
insert into RondaEntity (id, numero, fechaInicio, fechaFin) values (2, 1, '4/30/2018', '5/8/2018');
insert into RondaEntity (id, numero, fechaInicio, fechaFin) values (3, 2, '5/8/2018', '5/19/2018');
insert into RondaEntity (id, numero, fechaInicio, fechaFin) values (4, 2, '4/28/2018', '5/1/2018');
insert into RondaEntity (id, numero, fechaInicio, fechaFin) values (5, 1, '4/11/2018', '5/2/2018');

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