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
	private DadosBeneficiario  dadosBeneficiario;

	@OneToMany(mappedBy = "guiaResumoInternacao")
	@OrderBy("id")
	private List<ProcedimentoExecutado> procedimentoExecutado;

	@OneToOne
	private ValorTotal valorTotal;


	@ManyToOne
	private LoteGuias loteGuias;



}
