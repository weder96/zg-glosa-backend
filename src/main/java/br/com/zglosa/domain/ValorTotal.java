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


}
