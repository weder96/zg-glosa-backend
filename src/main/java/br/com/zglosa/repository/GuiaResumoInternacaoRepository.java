package br.com.zglosa.repository;

import br.com.zglosa.domain.DadosBeneficiario;
import br.com.zglosa.domain.GuiaResumoInternacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuiaResumoInternacaoRepository extends JpaRepository<GuiaResumoInternacao, Long> {

	@Query("SELECT guia FROM GuiaResumoInternacao guia WHERE guia.numeroGuiaPrestado = :numGuiaPrestado")
	List<GuiaResumoInternacao> findByGuiaPrestador(@Param("numGuiaPrestado")  final Long numGuiaPrestado);
}
