CREATE TABLE users (
  username VARCHAR(50)  NOT NULL PRIMARY KEY,
  password VARCHAR(255) NOT NULL,
  enabled  BOOLEAN      NOT NULL
)
  ENGINE = InnoDb;
CREATE TABLE authorities (
  username  VARCHAR(50) NOT NULL,
  authority VARCHAR(50) NOT NULL,
  FOREIGN KEY (username) REFERENCES users (username),
  UNIQUE INDEX authorities_idx_1 (username, authority)
)
  ENGINE = InnoDb;

CREATE TABLE projects (
  id BIGINT(10) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  province varchar(45)  NOT NULL,
  commune varchar(45)  NOT NULL,
  consistance varchar(45)  NOT NULL,
  situation varchar(45)  NOT NULL,
  petitionnaire varchar(45)  NOT NULL,
  architecte varchar(45)  NOT NULL,
  igt_bet varchar(45)  NOT NULL,
  rf_requisition varchar(45)  NOT NULL,
  observation varchar(45)  ,
  adresse varchar(45)  ,
  num_titre_foncier int(11) NOT NULL,
  superficie varchar(45)  ,
  hauteur varchar(45)  ,
  c_e_s varchar(45)  ,
  c_o_s varchar(45)  ,
  vf_technicien varchar(45)  ,
  vl_agentGU varchar(45) ,
  cat_proj varchar (10)  NOT NULL,
  added_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL

) ENGINE=InnoDB;

CREATE TABLE categories (
  id BIGINT(10) UNSIGNED NOT NULL PRIMARY KEY,
  intitule varchar(45)  NOT NULL
)
ENGINE=InnoDB ;
CREATE TABLE histories (
  id bigint(20) UNSIGNED  AUTO_INCREMENT PRIMARY KEY,
  date_arr date NOT NULL,
  num_arr int(11) NOT NULL,
  date_ex_comm date NOT NULL,
  num_comm int(11) NOT NULL,
  date_env date NOT NULL,
  num_env int(11) NOT NULL,
  project_id bigint(10) UNSIGNED NOT NULL,
  added_date timestamp NULL DEFAULT NULL
) ENGINE=InnoDB ;
INSERT INTO categories values (1,'GPU');
INSERT INTO categories values (2,'GPR');
INSERT INTO categories values (3,'PPU');
INSERT INTO categories values (4,'PPR');