package br.com.zglosa.service.Impl;

import br.com.zglosa.domain.DadosBeneficiario;
import br.com.zglosa.repository.DadosBeneficiarioRepository;
import br.com.zglosa.service.DadosBeneficiarioService;
import br.com.zglosa.service.ZGlosaService;
import br.com.zglosa.service.ZGlosaServiceFile;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DadosBeneficiarioServiceImpl implements DadosBeneficiarioService {

	@Autowired
	private DadosBeneficiarioRepository dadosBeneficiarioRepository;

	public List<DadosBeneficiario> getDadosBeneficia() {
		return dadosBeneficiarioRepository.findAll();
	}

	public DadosBeneficiario getBeneficiaById(final Long id) {
		return dadosBeneficiarioRepository.getOne(id);
	}

	@Override
	public DadosBeneficiario getByNumeroCarteira(Integer numeroCarteira) {
		return dadosBeneficiarioRepository.getByNumeroCarteira(numeroCarteira);
	}

	public DadosBeneficiario salvar(DadosBeneficiario dadosBeneficiario) {
		return dadosBeneficiarioRepository.save(dadosBeneficiario);
	}

}
