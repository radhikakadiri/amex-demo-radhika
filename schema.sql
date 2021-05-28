CREATE TABLE population.country (
    ccode varchar(3)  NOT NULL ,
    cname VARCHAR(25) NOT NULL,
    PRIMARY KEY (ccode)
);

CREATE TABLE population.state (
    id   INTEGER      NOT NULL AUTO_INCREMENT,
    stcode varchar(3) NOT NULL,
    pop INTEGER,
    stname VARCHAR(25) NOT NULL,
    ccode varchar(3)  NOT NULL,
    FOREIGN KEY (CCODE)
    
);

