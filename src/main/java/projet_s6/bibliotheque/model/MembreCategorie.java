package projet_s6.bibliotheque.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "v_categorie_membre_complets")
public class MembreCategorie {
    
    @Id
    @Column(name = "id_membre")
    private Integer idMembre;

    @Column(name = "nom_membre")
    private String nomMembre;

    @Column(name = "date_naissance")
    private Date dateNaissance;

    @Column(name = "id_cat_membre")
    private Integer idCatMembre;

    @Column(name = "nom_categorie")
    private String nomCategorie;

    @Column(name = "nb_jour_pret")
    private Integer nbJourPret;

    @Column(name = "nb_jour_sanction")
    private Integer nbJourSanction;

    @Column(name = "coefficient")
    private Integer coefficient;

    public Integer getIdMembre() {
        return idMembre;
    }

    public String getNomMembre() {
        return nomMembre;
    }

    public Integer getIdCatMembre() {
        return idCatMembre;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public Integer getNbJourPret() {
        return nbJourPret;
    }

    public Integer getNbJourSanction() {
        return nbJourSanction;
    }

    public Integer getCoefficient() {
        return coefficient;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }
    
}
