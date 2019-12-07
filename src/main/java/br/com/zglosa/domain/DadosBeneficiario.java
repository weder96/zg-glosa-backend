package br.com.zglosa.domain;


import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "dados_beneficiario")
public @Data class DadosBeneficiario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String numeroCarteira;
	private String nomeBenificiariio;

	@OneToOne(mappedBy = "dadosBeneficiario")
	private GuiaResumoInternacao guiaResumoInternacao;

}
