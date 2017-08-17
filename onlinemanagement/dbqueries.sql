CREATE TABLE product (
	product_id INT NOT NULL AUTO_INCREMENT,
	product_name VARCHAR(50),
	product_description VARCHAR(255),
	PRIMARY KEY ( product_id )

);

CREATE TABLE user_detail (
	id INT NOT NULL AUTO_INCREMENT,
	username VARCHAR(50),
	role VARCHAR(50),
	password VARCHAR(60),
	PRIMARY KEY (id )
);

INSERT INTO user_detail (username,role,password) VALUES ('admin','ADMIN','password');
INSERT INTO user_detail (username,role,password) VALUES ('hemanth','USER','password');