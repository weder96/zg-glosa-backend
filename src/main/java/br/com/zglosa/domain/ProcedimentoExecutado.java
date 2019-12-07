package br.com.zglosa.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "procedimento_executado")
public @Data class ProcedimentoExecutado  implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String dataExecucao;
	private String horaInicial;
	private String horaFinal;
	private int codigoTabela;
	private int codigoProcedimento;
	private int quantidadeExecutada;
	private float reducaoAcrescimo;
	private float valorUnitario;
	private float valorTotal;
	private String unidadeMediada;

	@ManyToOne
	private GuiaResumoInternacao guiaResumoInternacao;

}
