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

	private Long numeroGuiaPrestado;
	private Long numeroGuiaSolicitacaoInternacao;
	private Long numeroGuiaOperadora;
	private Long senha;

	@OneToOne
	private DadosBeneficiario dadosBeneficiario;

	@OneToMany(mappedBy = "guiaResumoInternacao")
	@OrderBy("id")
	private List<ProcedimentoExecutado> procedimentoExecutados;

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

	public Long getNumeroGuiaPrestado() {
		return this.numeroGuiaPrestado;
	}

	public void setNumeroGuiaPrestado(Long numeroGuiaPrestado) {
		this.numeroGuiaPrestado = numeroGuiaPrestado;
	}

	public Long getNumeroGuiaSolicitacaoInternacao() {
		return this.numeroGuiaSolicitacaoInternacao;
	}

	public void setNumeroGuiaSolicitacaoInternacao(Long numeroGuiaSolicitacaoInternacao) {
		this.numeroGuiaSolicitacaoInternacao = numeroGuiaSolicitacaoInternacao;
	}

	public Long getNumeroGuiaOperadora() {
		return this.numeroGuiaOperadora;
	}

	public void setNumeroGuiaOperadora(Long numeroGuiaOperadora) {
		this.numeroGuiaOperadora = numeroGuiaOperadora;
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

	public List<ProcedimentoExecutado> getProcedimentoExecutados() {
		return this.procedimentoExecutados;
	}

	public void setProcedimentoExecutados(List<ProcedimentoExecutado> procedimentoExecutados) {
		this.procedimentoExecutados = procedimentoExecutados;
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
