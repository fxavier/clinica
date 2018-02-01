CREATE TABLE medico(
  codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(200) NOT NULL,
  numero BIGINT(20) NOT NULL,
  codigo_especialidade BIGINT(20) NOT NULL,
  codigo_pais BIGINT(20) NOT NULL,
  data_nascimento DATE NOT NULL,
  sexo VARCHAR(100) NOT NULL,
  morada VARCHAR(200) NOT NULL,
  email VARCHAR(500) NOT NULL,
  telefone VARCHAR(100) NOT NULL,
  activo BOOLEAN DEFAULT TRUE,
  FOREIGN KEY(codigo_especialidade) REFERENCES especialidade(codigo),
  FOREIGN KEY(codigo_pais) REFERENCES pais(country_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;