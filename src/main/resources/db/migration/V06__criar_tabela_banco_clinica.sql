CREATE TABLE banco(
   codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
   nome VARCHAR(100) NOT NULL,
   conta VARCHAR(100) NOT NULL,
   nib VARCHAR(100) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE clinica (
    codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    nuit VARCHAR(50) NOT NULL,
    email VARCHAR(200),
    telefone VARCHAR(30) NOT NULL,
    fax VARCHAR(30),
    celular VARCHAR(35),
    codigo_banco BIGINT(20) NOT NULL,
    endereco VARCHAR(120) NOT NULL,
    FOREIGN KEY(codigo_banco) REFERENCES banco(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
