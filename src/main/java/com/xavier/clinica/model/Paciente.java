package com.xavier.clinica.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "paciente")
public class Paciente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(name = "numero_paciente")
	private Long numero;
	
	@Column(name = "teve_marcacao")
	private Boolean teveMarcacao;
	
	@Column(name = "data_abertura_ficha")
	private LocalDate dataAberturaFicha;
	
	@Column(name = "data_nascimento")
	private LocalDate dataNascimento;
	
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	
	@ManyToOne
	@JoinColumn(name = "codigo_pais")
	private Pais pais;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "estado_civil")
	private EstadoCivil estadoCivil;
	
	private String telefone;
	
	private String email;
	
	private String endereco;
	
	@Column(name = "numero_bi")
	private String NumeroBi;
	
	@Column(name = "nome_pai")
	private String nomePai;
	
	@Column(name = "nome_mae")
	private String nomeMae;
	

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Boolean getTeveMarcacao() {
		return teveMarcacao;
	}

	public void setTeveMarcacao(Boolean teveMarcacao) {
		this.teveMarcacao = teveMarcacao;
	}

	public LocalDate getDataAberturaFicha() {
		return dataAberturaFicha;
	}

	public void setDataAberturaFicha(LocalDate dataAberturaFicha) {
		this.dataAberturaFicha = dataAberturaFicha;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
	

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumeroBi() {
		return NumeroBi;
	}

	public void setNumeroBi(String numeroBi) {
		NumeroBi = numeroBi;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente other = (Paciente) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
	
	
	
	

}
