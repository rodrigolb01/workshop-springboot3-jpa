CREATE TABLE IF NOT EXISTS tb_users (
    ID int NOT NULL AUTO_INCREMENT,
    Name varchar(255),
    Email varchar(255),
    Password varchar(255),
    PRIMARY KEY (ID)
);

INSERT INTO tb_users (Name, Email, Password) VALUES('john cena', 'john@gmail.com', '1234');

INSERT INTO tb_users (Name, Email, Password) VALUES('beatrice cena', 'bea@gmail.com', '4321');