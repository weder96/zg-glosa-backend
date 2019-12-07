package br.com.zglosa.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "guia_resumo_internacao")
public @Data class GuiaResumoInternacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long numeronumeroGuiaPrestado;
	private Long numeroGuiaSolicitaçãoInterna;
	private Long numeroGuiaInterna;
	private Long senha;

	@OneToOne
	private DadosBeneficiario dadosBeneficiario;

	@OneToMany(mappedBy = "guiaResumoInternacao")
	@OrderBy("id")
	private List<ProcedimentoExecutado> procedimentoExecutado;

	@OneToOne
	private ValorTotal valorTotal;

	@ManyToOne
	private LoteGuias loteGuias;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumeronumeroGuiaPrestado() {
		return this.numeronumeroGuiaPrestado;
	}

	public void setNumeronumeroGuiaPrestado(Long numeronumeroGuiaPrestado) {
		this.numeronumeroGuiaPrestado = numeronumeroGuiaPrestado;
	}

	public Long getNumeroGuiaSolicitaçãoInterna() {
		return this.numeroGuiaSolicitaçãoInterna;
	}

	public void setNumeroGuiaSolicitaçãoInterna(Long numeroGuiaSolicitaçãoInterna) {
		this.numeroGuiaSolicitaçãoInterna = numeroGuiaSolicitaçãoInterna;
	}

	public Long getNumeroGuiaInterna() {
		return this.numeroGuiaInterna;
	}

	public void setNumeroGuiaInterna(Long numeroGuiaInterna) {
		this.numeroGuiaInterna = numeroGuiaInterna;
	}

	public Long getSenha() {
		return this.senha;
	}

	public void setSenha(Long senha) {
		this.senha = senha;
	}

	public DadosBeneficiario getDadosBeneficiario() {
		return this.dadosBeneficiario;
	}

	public void setDadosBeneficiario(DadosBeneficiario dadosBeneficiario) {
		this.dadosBeneficiario = dadosBeneficiario;
	}

	public List<ProcedimentoExecutado> getProcedimentoExecutado() {
		return this.procedimentoExecutado;
	}

	public void setProcedimentoExecutado(List<ProcedimentoExecutado> procedimentoExecutado) {
		this.procedimentoExecutado = procedimentoExecutado;
	}

	public ValorTotal getValorTotal() {
		return this.valorTotal;
	}

	public void setValorTotal(ValorTotal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public LoteGuias getLoteGuias() {
		return this.loteGuias;
	}

	public void setLoteGuias(LoteGuias loteGuias) {
		this.loteGuias = loteGuias;
	}

}
