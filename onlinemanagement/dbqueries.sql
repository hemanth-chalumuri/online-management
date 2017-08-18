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

-- used Bcrypt Hash as password.
INSERT INTO user_detail (username,role,password) VALUES ('admin','ADMIN','$2a$06$FTv7qeF6qQ2WLimkgQpsw.4DZm7t6rVOuitvML17MJFXmqS20IB9W');
INSERT INTO user_detail (username,role,password) VALUES ('hemanth','USER','$2a$06$FTv7qeF6qQ2WLimkgQpsw.4DZm7t6rVOuitvML17MJFXmqS20IB9W');