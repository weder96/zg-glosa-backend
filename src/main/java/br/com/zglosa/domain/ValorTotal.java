package br.com.zglosa.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "valor_total")
public class ValorTotal implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private float valorProcedimento;
	private float valorDiarias;
	private float valorTaxaslugueis;
	private float valormateriais;
	private float valorMedicamento;
	private float valorOpme;
	private float valorcasesMedicinais;
	private float valorTotalGeral;

	@OneToOne(mappedBy = "valorTotal")
	private GuiaResumoInternacao guiaResumoInternacao;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getValorProcedimento() {
		return this.valorProcedimento;
	}

	public void setValorProcedimento(float valorProcedimento) {
		this.valorProcedimento = valorProcedimento;
	}

	public float getValorDiarias() {
		return this.valorDiarias;
	}

	public void setValorDiarias(float valorDiarias) {
		this.valorDiarias = valorDiarias;
	}

	public float getValorTaxaslugueis() {
		return this.valorTaxaslugueis;
	}

	public void setValorTaxaslugueis(float valorTaxaslugueis) {
		this.valorTaxaslugueis = valorTaxaslugueis;
	}

	public float getValormateriais() {
		return this.valormateriais;
	}

	public void setValormateriais(float valormateriais) {
		this.valormateriais = valormateriais;
	}

	public float getValorMedicamento() {
		return this.valorMedicamento;
	}

	public void setValorMedicamento(float valorMedicamento) {
		this.valorMedicamento = valorMedicamento;
	}

	public float getValorOpme() {
		return this.valorOpme;
	}

	public void setValorOpme(float valorOpme) {
		this.valorOpme = valorOpme;
	}

	public float getValorcasesMedicinais() {
		return this.valorcasesMedicinais;
	}

	public void setValorcasesMedicinais(float valorcasesMedicinais) {
		this.valorcasesMedicinais = valorcasesMedicinais;
	}

	public float getValorTotalGeral() {
		return this.valorTotalGeral;
	}

	public void setValorTotalGeral(float valorTotalGeral) {
		this.valorTotalGeral = valorTotalGeral;
	}

	public GuiaResumoInternacao getGuiaResumoInternacao() {
		return this.guiaResumoInternacao;
	}

	public void setGuiaResumoInternacao(GuiaResumoInternacao guiaResumoInternacao) {
		this.guiaResumoInternacao = guiaResumoInternacao;
	}

}
