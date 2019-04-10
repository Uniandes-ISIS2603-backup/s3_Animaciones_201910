delete from AnimacionEntity;
delete from ArtistaEntity;
delete from RondaEntity;
delete from VotacionEntity;

insert into ArtistaEntity (id, privado, nombre, tecnina, tema, usuario, contrasenia) values (1, 1, 'Dayle', 'Candice', 'Erin', 'eibbitt0', 'fZR73XIKI');
insert into ArtistaEntity (id, privado, nombre, tecnina, tema, usuario, contrasenia) values (2, 0, 'Caitlin', 'Normy', 'Trevar', 'tgiacubo1', 'p77HvSdgaO');
insert into ArtistaEntity (id, privado, nombre, tecnina, tema, usuario, contrasenia) values (3, 0, 'Alissa', 'Elena', 'Thaxter', 'tmclagan2', 'nqhjex6D');
insert into ArtistaEntity (id, privado, nombre, tecnina, tema, usuario, contrasenia) values (4, 1, 'Sherlocke', 'Tildie', 'Tanhya', 'tcammacke3', 'UINQxq0kw1i');
insert into ArtistaEntity (id, privado, nombre, tecnina, tema, usuario, contrasenia) values (5, 0, 'Ebba', 'Nollie', 'Kali', 'kquinnell4', 'eILC4Qe3tapk');

insert into AnimacionEntity (id, nombre, descripcion, precio, tecnica, tags, calificacion, link, fecha, artista_id, typeofanimation) values (1, 'Xunlei Limited', 'Mock Goldenweed', 867, 'Striped hyena', 'Hyaena hyaena', 5, 'Eget.jpeg', '10/20/2018', 1, 'A');
insert into AnimacionEntity (id, nombre, descripcion, precio, tecnica, tags, calificacion, link, fecha, artista_id, typeofanimation) values (2, 'Public Storage', 'British Felt Lichen', 385, 'Long-necked turtle', 'Chelodina longicollis', 1, 'SedInterdumVenenatis.pdf', '3/15/2018', 2, 'A');
insert into AnimacionEntity (id, nombre, descripcion, precio, tecnica, tags, calificacion, link, fecha, artista_id, typeofanimation) values (3, 'Ares Capital Corporation', 'Blessed Thistle', 148, 'Trumpeter, green-winged', 'Psophia viridis', 1, 'DonecSemper.jpeg', '8/2/2018', 2, 'A');