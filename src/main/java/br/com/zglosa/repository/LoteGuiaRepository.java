package br.com.zglosa.repository;

import br.com.zglosa.domain.LoteGuias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoteGuiaRepository extends JpaRepository<LoteGuias, Long> {

}
