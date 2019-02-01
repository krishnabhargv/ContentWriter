-- Table: users

-- DROP TABLE users;

CREATE TABLE users
(
  id serial NOT NULL,
  name character varying(50),
  username character varying(50),
  password character varying(50),
  email_address character varying,
  status boolean,
  paid boolean,
  mobile_no bigint,
  dob date,
  gender character(1),
  address character varying(100),
  CONSTRAINT user_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE users
  OWNER TO postgres;

  
  
  
  -- Table: role

-- DROP TABLE role;

CREATE TABLE role
(
  id serial NOT NULL,
  role character varying(50),
  CONSTRAINT role_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE role
  OWNER TO postgres;

  
  
  
  -- Table: user_role

-- DROP TABLE user_role;

CREATE TABLE user_role
(
  user_id integer NOT NULL,
  role_id integer NOT NULL,
  CONSTRAINT user_role_pkey PRIMARY KEY (user_id, role_id),
  CONSTRAINT fk_apcc8lxk2xnug8377fatvbn04 FOREIGN KEY (user_id)
      REFERENCES users (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_it77eq964jhfqtu54081ebtio FOREIGN KEY (role_id)
      REFERENCES role (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE user_role
  OWNER TO postgres;
  
  
  -- Table: content

-- DROP TABLE content;

CREATE TABLE content
(
  id serial NOT NULL,
  content character varying(500),
  user_id bigint NOT NULL,
  CONSTRAINT content_pkey PRIMARY KEY (id),
  CONSTRAINT fk_content_users FOREIGN KEY (user_id)
      REFERENCES users (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE content
  OWNER TO postgres;
  
  
  
  -- Table: history

-- DROP TABLE history;

CREATE TABLE history
(
  id serial NOT NULL,
  remark character varying(500),
  updated_content character varying(500),
  updated_date date,
  user_id bigint NOT NULL,
  content_id bigint NOT NULL,
  CONSTRAINT history_pkey PRIMARY KEY (id),
  CONSTRAINT fk_history_users FOREIGN KEY (user_id)
      REFERENCES users (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE history
  OWNER TO postgres;


