package br.com.zglosa.repository;

import br.com.zglosa.domain.ProcedimentoExecutado;
import br.com.zglosa.domain.ValorTotal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValorTotalRepository extends JpaRepository<ValorTotal, Long> {

}
