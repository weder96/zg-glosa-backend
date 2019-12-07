package br.com.zglosa.service.Impl;

import br.com.zglosa.domain.DadosBeneficiario;
import br.com.zglosa.domain.ProcedimentoExecutado;
import br.com.zglosa.repository.DadosBeneficiarioRepository;
import br.com.zglosa.repository.ProcedimentoExecutadoRepository;
import br.com.zglosa.service.DadosBeneficiarioService;
import br.com.zglosa.service.ProcedimentoExecutadoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProcedimentoExecutadoServiceImpl implements ProcedimentoExecutadoService {

	@Autowired
	private ProcedimentoExecutadoRepository procedimentoExecutadoRepository;


	public ProcedimentoExecutado salvar(final ProcedimentoExecutado procedimentoExecutado){
		return procedimentoExecutadoRepository.save(procedimentoExecutado);
	}

}
