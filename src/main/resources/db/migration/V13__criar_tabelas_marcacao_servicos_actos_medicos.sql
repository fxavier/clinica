CREATE TABLE marcacao(
 codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
 codigo_medico BIGINT(20) NOT NULL,
 codigo_especialidade BIGINT(20) NOT NULL,
 data DATE NOT NULL,
 hora_inicio TIME NOT NULL,
 hora_fim TIME NOT NULL,
 codigo_paciente BIGINT(20) NOT NULL,
 estado_marcacao VARCHAR(100) NOT NULL,
 FOREIGN KEY(codigo_medico) REFERENCES medico(codigo),
 FOREIGN KEY(codigo_especialidade) REFERENCES especialidade(codigo),
 FOREIGN KEY(codigo_paciente) REFERENCES paciente(codigo)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE exames(
 codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
 nome VARCHAR(100) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE processo_clinico(
 codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
 codigo_paciente BIGINT(20) NOT NULL,
 diagosticos TEXT NOT NULL,
 sintomas TEXT NOT NULL,
 relatorios TEXT,
 observacoes TEXT NOT NULL,
 medicacao TEXT NOT NULL,
 FOREIGN KEY(codigo_paciente) REFERENCES paciente(codigo)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE servicos(
 codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
 referencia VARCHAR(100) NOT NULL,
 nome VARCHAR(200) NOT NULL,
 descricao VARCHAR(200) NOT NULL,
 preco DECIMAL(10, 2) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE actos_medicos(
 codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
 data DATE NOT NULL,
 codigo_paciente BIGINT(20) NOT NULL,
 codigo_medico BIGINT(20) NOT NULL,
 codigo_servico BIGINT(20) NOT NULL,
 FOREIGN KEY(codigo_medico) REFERENCES medico(codigo),
 FOREIGN KEY(codigo_servico) REFERENCES servicos(codigo),
 FOREIGN KEY(codigo_paciente) REFERENCES paciente(codigo) 
)ENGINE=InnoDB DEFAULT CHARSET=utf8;