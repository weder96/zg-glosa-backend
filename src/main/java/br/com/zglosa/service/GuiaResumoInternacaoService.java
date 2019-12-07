package br.com.zglosa.service;

import br.com.zglosa.domain.GuiaResumoInternacao;

import java.util.List;

public interface GuiaResumoInternacaoService {

	List<GuiaResumoInternacao> getGuiaResumoInternacao();

	GuiaResumoInternacao getGuiaResumoInternacaoById(final Long id);

	List<GuiaResumoInternacao> findByGuiaPrestador(final Long numGuiaPrestado);

	GuiaResumoInternacao salvar(GuiaResumoInternacao guiaResumoInternacao);

}
