
CREATE TABLE NACE(
     orderid BIGINT PRIMARY KEY,
     level INT,
     code VARCHAR(255),
     parent VARCHAR(255),
     description VARCHAR(255),
     thisItemIncludes VARCHAR(255),
     thisItemAlsoIncludes VARCHAR(255),
     rulings VARCHAR(255),
     thisItemExcludes VARCHAR(255),
     referenceToISICRev VARCHAR(255)
);