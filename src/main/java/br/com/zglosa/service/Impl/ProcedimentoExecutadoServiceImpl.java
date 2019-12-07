package br.com.zglosa.service.Impl;

import br.com.zglosa.domain.ProcedimentoExecutado;
import br.com.zglosa.repository.ProcedimentoExecutadoRepository;
import br.com.zglosa.service.ProcedimentoExecutadoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProcedimentoExecutadoServiceImpl implements ProcedimentoExecutadoService {

	@Autowired
	private ProcedimentoExecutadoRepository procedimentoExecutadoRepository;


	@Override
	public String getGlosa() {
		return null;
	}

	@Override
	public void salvar(ProcedimentoExecutado procedimentoExecutado){
		procedimentoExecutadoRepository.save(procedimentoExecutado);
	}
}
