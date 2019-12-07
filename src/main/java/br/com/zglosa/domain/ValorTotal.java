package br.com.zglosa.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "valor_total")
public class ValorTotal implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private float valorProcedimentos;
	private float valorDiarias;
	private float valorTaxasAlugueis;
	private float valorMateriais;
	private float valorMedicamento;
	private float valorOpme;
	private float valorGasesMedicinais;
	private float valorTotalGeral;

	@OneToOne(mappedBy = "valorTotal")
	private GuiaResumoInternacao guiaResumoInternacao;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getValorProcedimentos() {
		return this.valorProcedimentos;
	}

	public void setValorProcedimentos(float valorProcedimentos) {
		this.valorProcedimentos = valorProcedimentos;
	}

	public float getValorDiarias() {
		return this.valorDiarias;
	}

	public void setValorDiarias(float valorDiarias) {
		this.valorDiarias = valorDiarias;
	}

	public float getValorTaxasAlugueis() {
		return this.valorTaxasAlugueis;
	}

	public void setValorTaxasAlugueis(float valorTaxasAlugueis) {
		this.valorTaxasAlugueis = valorTaxasAlugueis;
	}

	public float getValorMateriais() {
		return this.valorMateriais;
	}

	public void setValorMateriais(float valorMateriais) {
		this.valorMateriais = valorMateriais;
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

	public float getValorGasesMedicinais() {
		return this.valorGasesMedicinais;
	}

	public void setValorGasesMedicinais(float valorGasesMedicinais) {
		this.valorGasesMedicinais = valorGasesMedicinais;
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
