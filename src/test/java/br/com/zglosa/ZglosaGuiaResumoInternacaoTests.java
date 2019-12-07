package br.com.zglosa;

import br.com.zglosa.domain.GuiaResumoInternacao;
import br.com.zglosa.service.GuiaResumoInternacaoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ZglosaGuiaResumoInternacaoTests {

	@Mock
	private GuiaResumoInternacaoService guiaResumoInternacaoService;

	@Test
	void contextLoads() {
	}

	@Test
	void buscarGuiaGuiaResumoInternacao(){
		List<GuiaResumoInternacao> guias = new ArrayList<GuiaResumoInternacao>();
		//guiaResumoInternacaoService.findByGuiaPrestador(1L);
		//Mockito.when(guiaResumoInternacaoService.findByGuiaPrestador(1L)).thenReturn(guias);
	}

}
