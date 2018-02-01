CREATE TABLE ausencia(
  codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
  codigo_medico BIGINT(20) NOT NULL,
  data_inicio DATE NOT NULL,
  data_fim DATE NOT NULL,
  hora_inicio TIME,
  hora_fim TIME,
  FOREIGN KEY(codigo_medico) REFERENCES medico(codigo)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE periodo_extra(
  codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
  codigo_medico BIGINT(20) NOT NULL,
  codigo_especialidade BIGINT(20) NOT NULL,
  observacao TEXT NOT NULL,
  FOREIGN KEY(codigo_medico) REFERENCES medico(codigo),
  FOREIGN KEY(codigo_especialidade) REFERENCES especialidade(codigo)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;