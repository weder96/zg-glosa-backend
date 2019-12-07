package br.com.zglosa.service;

import br.com.zglosa.domain.DadosBeneficiario;

import java.util.List;

public interface DadosBeneficiarioService {

	 List<DadosBeneficiario> getDadosBeneficia();
	DadosBeneficiario getBeneficiaById(final Long id);
	DadosBeneficiario getByNumeroCarteira(final Integer numeroCarteira);
	 DadosBeneficiario salvar(DadosBeneficiario dadosBeneficiario);


}
