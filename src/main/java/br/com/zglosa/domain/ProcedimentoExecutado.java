package br.com.zglosa.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "procedimento_executado")
public @Data class ProcedimentoExecutado implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String dataExecucao;
	private String horaInicial;
	private String horaFinal;
	private int codigoTabela;
	private int codigoProcedimento;
	private String descricaoProcedimento;
	private int quantidadeExecutada;
	private float reducaoAcrescimo;
	private float valorUnitario;
	private float valorApresentado;
	private float valorPago;
	private float valorGlosa;
	private float valorTotal;
	private String unidadeMediada;
	private String motivoGlosa;

	@ManyToOne
	private GuiaResumoInternacao guiaResumoInternacao;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDataExecucao() {
		return this.dataExecucao;
	}

	public void setDataExecucao(String dataExecucao) {
		this.dataExecucao = dataExecucao;
	}

	public String getHoraInicial() {
		return this.horaInicial;
	}

	public void setHoraInicial(String horaInicial) {
		this.horaInicial = horaInicial;
	}

	public String getHoraFinal() {
		return this.horaFinal;
	}

	public void setHoraFinal(String horaFinal) {
		this.horaFinal = horaFinal;
	}

	public int getCodigoTabela() {
		return this.codigoTabela;
	}

	public void setCodigoTabela(int codigoTabela) {
		this.codigoTabela = codigoTabela;
	}

	public int getCodigoProcedimento() {
		return this.codigoProcedimento;
	}

	public void setCodigoProcedimento(int codigoProcedimento) {
		this.codigoProcedimento = codigoProcedimento;
	}

	public int getQuantidadeExecutada() {
		return this.quantidadeExecutada;
	}

	public void setQuantidadeExecutada(int quantidadeExecutada) {
		this.quantidadeExecutada = quantidadeExecutada;
	}

	public float getReducaoAcrescimo() {
		return this.reducaoAcrescimo;
	}

	public void setReducaoAcrescimo(float reducaoAcrescimo) {
		this.reducaoAcrescimo = reducaoAcrescimo;
	}

	public float getValorUnitario() {
		return this.valorUnitario;
	}

	public void setValorUnitario(float valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public float getValorTotal() {
		return this.valorTotal;
	}

	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getUnidadeMediada() {
		return this.unidadeMediada;
	}

	public void setUnidadeMediada(String unidadeMediada) {
		this.unidadeMediada = unidadeMediada;
	}

	public GuiaResumoInternacao getGuiaResumoInternacao() {
		return this.guiaResumoInternacao;
	}

	public void setGuiaResumoInternacao(GuiaResumoInternacao guiaResumoInternacao) {
		this.guiaResumoInternacao = guiaResumoInternacao;
	}

	public String getDescricaoProcedimento() {
		return descricaoProcedimento;
	}

	public void setDescricaoProcedimento(String descricaoProcedimento) {
		this.descricaoProcedimento = descricaoProcedimento;
	}

	public float getValorApresentado() {
		return valorApresentado;
	}

	public void setValorApresentado(float valorApresentado) {
		this.valorApresentado = valorApresentado;
	}

	public float getValorPago() {
		return valorPago;
	}

	public void setValorPago(float valorPago) {
		this.valorPago = valorPago;
	}

	public float getValorGlosa() {
		return valorGlosa;
	}

	public void setValorGlosa(float valorGlosa) {
		this.valorGlosa = valorGlosa;
	}

	public String getMotivoGlosa() {
		return motivoGlosa;
	}

	public void setMotivoGlosa(String motivoGlosa) {
		this.motivoGlosa = motivoGlosa;
	}
}
