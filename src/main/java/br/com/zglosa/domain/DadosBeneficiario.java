package br.com.zglosa.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "dados_beneficiario")
public @Data class DadosBeneficiario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private int numeroCarteira;
	private String atendimentoRN;
	private String nomeBeneficiario;

	@OneToOne(mappedBy = "dadosBeneficiario")
	private GuiaResumoInternacao guiaResumoInternacao;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumeroCarteira() {
		return this.numeroCarteira;
	}

	public void setNumeroCarteira(int numeroCarteira) {
		this.numeroCarteira = numeroCarteira;
	}

	public String getNomeBenificiario() {
		return this.nomeBeneficiario;
	}

	public void setNomeBeneficiario(String nomeBeneficiario) {
		this.nomeBeneficiario = nomeBeneficiario;
	}

	public GuiaResumoInternacao getGuiaResumoInternacao() {
		return this.guiaResumoInternacao;
	}

	public void setGuiaResumoInternacao(GuiaResumoInternacao guiaResumoInternacao) {
		this.guiaResumoInternacao = guiaResumoInternacao;
	}

	public String getAtendimentoRN() {
		return this.atendimentoRN;
	}

	public void setAtendimentoRN(String atendimentoRN) {
		this.atendimentoRN = atendimentoRN;
	}

	public String getNomeBeneficiario() {
		return this.nomeBeneficiario;
	}

}
