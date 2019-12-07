package br.com.zglosa.service.Impl;

import br.com.zglosa.domain.DadosBeneficiario;
import br.com.zglosa.domain.GuiaResumoInternacao;
import br.com.zglosa.domain.LoteGuias;
import br.com.zglosa.domain.ValorTotal;
import br.com.zglosa.service.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ZGlosaServiceImpl implements ZGlosaService {

	@Autowired
	private ZGlosaServiceFile zglosaServiceFile;

	@Autowired
	private DadosBeneficiarioService dadosBeneficiarioService;

	@Autowired
	private ZGlosaServiceLoteGuiasDataImport zGlosaServiceLoteGuiasDataImport;

	@Autowired
	private ValorTotalService valorTotalService;

	@Autowired
	private GuiaResumoInternacaoService guiaResumoInternacaoService;



	public String getGlosa() {
		//List<DadosBeneficiario>  beneficiarios = dadosBeneficiarioService.getDadosBeneficia();
		return "test de Service";
	}

	public void salvarDadosXml() {
		LoteGuias lotes = zGlosaServiceLoteGuiasDataImport.parseData("");
		for(GuiaResumoInternacao guia: lotes.getGuiaResumoInternacao()) {
			dadosBeneficiarioService.salvar(guia.getDadosBeneficiario());
			guiaResumoInternacaoService.salvar(guia);
		}


	}

}
