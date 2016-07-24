DROP TABLE if EXISTS person CASCADE;
CREATE TABLE person (
    id bigserial NOT NULL,
	person_first_name varchar(250) NOT NULL,
    person_middle_name varchar(250) NOT NULL,
	person_last_name varchar(250) NOT NULL,
    person_suffix varchar(250),
    person_title varchar(250),
	gender varchar(6),
	gwa real,
	person_birthday date,
	person_date_hired date,
	person_employed boolean,
	address_street_number varchar(250) NOT NULL,
    address_barangay varchar(250) NOT NULL,
    address_city varchar(250) NOT NULL,
    address_zipcode varchar(250) NOT NULL,
	CONSTRAINT person_pkey PRIMARY KEY (id)
);

DROP TABLE if EXISTS contact CASCADE;
CREATE TABLE contact (
    id bigserial NOT NULL,
    contact_type varchar(250) NOT NULL,
    contact_value varchar(250) NOT NULL,
    person_id bigint NOT NULL,
	CONSTRAINT contact_pkey PRIMARY KEY (id),
	CONSTRAINT person_fkey FOREIGN KEY (person_id)
	REFERENCES person(id) MATCH SIMPLE ON DELETE CASCADE
);

DROP TABLE if EXISTS roles CASCADE;
CREATE TABLE roles (
    id bigserial NOT NULL,
    role_type varchar(250) NOT NULL,
	CONSTRAINT role_pkey PRIMARY KEY (id)
);

DROP TABLE if EXISTS personrole CASCADE;
CREATE TABLE personrole (
    person_id bigint NOT NULL,
    role_id bigint NOT NULL,
	CONSTRAINT person_fkey FOREIGN KEY (person_id)
	REFERENCES person(id) MATCH SIMPLE ON DELETE CASCADE,
	CONSTRAINT role_fkey FOREIGN KEY (role_id)
	REFERENCES roles(id) MATCH SIMPLE ON DELETE CASCADE
	
);

INSERT INTO roles VALUES(1,'dev');
INSERT INTO roles VALUES(2,'qa');
INSERT INTO roles VALUES(3,'ba');

