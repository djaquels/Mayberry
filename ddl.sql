CREATE TABLE squad(id serial, name varchar(150)
PRIMARY KEY (id)
);


CREATE TABLE component (
  id serial, name varchar(150), url varchar(150),port integer, discover_name varchar(150), id_squad integer, gitlab varchar(150)
, CONSTRAINT fk_squad
 FOREIGN KEY(id_squad)
 REFERENCES squad(id)
);

CREATE TABLE dependencies (
 id serial, grade integer, id_c1 integer, id_c2 integer,
 CONSTRAINT fk_c1
 FOREIGN KEY(id_c1)
 REFERENCES component(id),
 CONSTRAINT fk_c2
 FOREIGN KEY(id_c2)
 REFERENCES component(id)
);

ALTER TABLE component
ADD COLUMN url_development varchar(150);

ALTER TABLE component
ADD COLUMN port_development integer;