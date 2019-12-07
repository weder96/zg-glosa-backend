package br.com.zglosa.service.Impl;

import br.com.zglosa.domain.DadosBeneficiario;
import br.com.zglosa.domain.GuiaResumoInternacao;
import br.com.zglosa.repository.DadosBeneficiarioRepository;
import br.com.zglosa.repository.GuiaResumoInternacaoRepository;
import br.com.zglosa.service.DadosBeneficiarioService;
import br.com.zglosa.service.GuiaResumoInternacaoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GuiaResumoInternacaoServiceImpl implements GuiaResumoInternacaoService {

	@Autowired
	private GuiaResumoInternacaoRepository guiaResumoInternacaoRepository;

	public List<GuiaResumoInternacao> getGuiaResumoInternacao() {
		return guiaResumoInternacaoRepository.findAll();
	}

	public GuiaResumoInternacao getGuiaResumoInternacaoById(final Long id) {
		return guiaResumoInternacaoRepository.getOne(id);
	}

	public List<GuiaResumoInternacao> findByGuiaPrestador(final Long numGuiaPrestado) {
		return guiaResumoInternacaoRepository.findAll();
	}

}
