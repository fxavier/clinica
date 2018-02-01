CREATE TABLE paciente(
  codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
  numero_paciente BIGINT(20) NOT NULL,
  teve_marcacao BOOLEAN DEFAULT TRUE,
  data_abertura_ficha DATE,
  data_nascimento DATE,
  sexo VARCHAR(100) NOT NULL,
  codigo_pais BIGINT(20) NOT NULL,
  estado_civil VARCHAR(200) NOT NULL,
  telefone VARCHAR(50),
  email VARCHAR(100),
  endereco VARCHAR(200) NOT NULL,
  numero_bi VARCHAR(100),
  nome_pai VARCHAR(100),
  nome_mae VARCHAR(100),
  FOREIGN KEY(codigo_pais) REFERENCES pais(country_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;