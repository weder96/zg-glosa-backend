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

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumeroLote() {
		return this.numeroLote;
	}

	public void setNumeroLote(int numeroLote) {
		this.numeroLote = numeroLote;
	}

	public String getGuiasTISS() {
		return this.guiasTISS;
	}

	public void setGuiasTISS(String guiasTISS) {
		this.guiasTISS = guiasTISS;
	}

	public List<GuiaResumoInternacao> getGuiaResumoInternacao() {
		return this.guiaResumoInternacao;
	}

	public void setGuiaResumoInternacao(List<GuiaResumoInternacao> guiaResumoInternacao) {
		this.guiaResumoInternacao = guiaResumoInternacao;
	}

}
