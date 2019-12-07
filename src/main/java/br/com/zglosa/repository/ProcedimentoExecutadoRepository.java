package br.com.zglosa.repository;

import br.com.zglosa.domain.DadosBeneficiario;
import br.com.zglosa.domain.ProcedimentoExecutado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcedimentoExecutadoRepository extends JpaRepository<ProcedimentoExecutado, Long> {

}
