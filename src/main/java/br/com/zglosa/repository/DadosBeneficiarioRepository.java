package br.com.zglosa.repository;

import br.com.zglosa.domain.DadosBeneficiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  DadosBeneficiarioRepository  extends JpaRepository<DadosBeneficiario, Long> {

}
