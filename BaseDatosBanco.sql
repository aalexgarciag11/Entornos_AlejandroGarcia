



CREATE TABLE CLIENTE (
  DNI VARCHAR(12) PRIMARY KEY, 
  NOMBRE VARCHAR(30),
  APELLIDO VARCHAR(30),
  EDAD INT(3), 
  SEXO VARCHAR(1)
);

CREATE TABLE CUENTA (
  DNI_CLIENTE VARCHAR(12),
  ISBN VARCHAR(30)PRIMARY KEY,
  CANT_DINERO INT(10),
  FOREIGN KEY (DNI_CLIENTE) REFERENCES CLIENTE(DNI)
);