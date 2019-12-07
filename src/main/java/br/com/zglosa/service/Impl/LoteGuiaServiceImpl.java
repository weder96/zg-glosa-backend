package br.com.zglosa.service.Impl;

import br.com.zglosa.domain.DadosBeneficiario;
import br.com.zglosa.domain.LoteGuias;
import br.com.zglosa.repository.DadosBeneficiarioRepository;
import br.com.zglosa.repository.LoteGuiaRepository;
import br.com.zglosa.service.DadosBeneficiarioService;
import br.com.zglosa.service.LoteGuiaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LoteGuiaServiceImpl implements LoteGuiaService {


	@Autowired
	private LoteGuiaRepository loteGuiaRepository;

	public LoteGuias salvar(final LoteGuias loteGuias){
       return loteGuiaRepository.save(loteGuias);
	}

}
