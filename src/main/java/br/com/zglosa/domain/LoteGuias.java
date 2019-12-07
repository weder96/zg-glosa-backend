package br.com.zglosa.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "lote_guias")
public @Data class LoteGuias implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int numeroLote;
	private String guiasTISS;

	@OneToMany(mappedBy = "loteGuias")
	@OrderBy("id")
	private List<GuiaResumoInternacao> guiaResumoInternacao;

}
