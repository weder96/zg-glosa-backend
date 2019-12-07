package br.com.zglosa.service.Impl;


import br.com.zglosa.domain.ValorTotal;
import br.com.zglosa.repository.ValorTotalRepository;
import br.com.zglosa.service.ValorTotalService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ValorTotalServiceImpl implements ValorTotalService {

	@Autowired
	private ValorTotalRepository valorTotalRepository;

	public ValorTotal salvar(final ValorTotal valorTotal){
		return  valorTotalRepository.save(valorTotal);
	}

}
