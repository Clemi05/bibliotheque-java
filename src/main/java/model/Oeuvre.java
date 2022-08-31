package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the oeuvre database table.
 * 
 */
@Entity
@NamedQuery(name="Oeuvre.findAll", query="SELECT o FROM Oeuvre o")
public class Oeuvre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idOeuvre;

	private String auteur;

	private String éditeur;

	private String titre;

	//bi-directional many-to-one association to Exemplaire
	@OneToMany(mappedBy="oeuvre")
	private List<Exemplaire> exemplaires;

	public Oeuvre() {
	}

	public int getIdOeuvre() {
		return this.idOeuvre;
	}

	public void setIdOeuvre(int idOeuvre) {
		this.idOeuvre = idOeuvre;
	}

	public String getAuteur() {
		return this.auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getÉditeur() {
		return this.éditeur;
	}

	public void setÉditeur(String éditeur) {
		this.éditeur = éditeur;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public List<Exemplaire> getExemplaires() {
		return this.exemplaires;
	}

	public void setExemplaires(List<Exemplaire> exemplaires) {
		this.exemplaires = exemplaires;
	}

	public Exemplaire addExemplaire(Exemplaire exemplaire) {
		getExemplaires().add(exemplaire);
		exemplaire.setOeuvre(this);

		return exemplaire;
	}

	public Exemplaire removeExemplaire(Exemplaire exemplaire) {
		getExemplaires().remove(exemplaire);
		exemplaire.setOeuvre(null);

		return exemplaire;
	}

}