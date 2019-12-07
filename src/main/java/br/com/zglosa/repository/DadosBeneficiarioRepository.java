package br.com.zglosa.repository;

import br.com.zglosa.domain.DadosBeneficiario;
import br.com.zglosa.domain.GuiaResumoInternacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  DadosBeneficiarioRepository  extends JpaRepository<DadosBeneficiario, Long> {

    @Query("SELECT beneficiario FROM DadosBeneficiario  beneficiario WHERE beneficiario.numeroCarteira = :numeroCarteira")
    DadosBeneficiario getByNumeroCarteira(@Param("numeroCarteira")  final Integer numeroCarteira);

}
