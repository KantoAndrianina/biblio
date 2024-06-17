package projet_s6.bibliotheque.model;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "v_sanction_details")
public class VSanctionDetail {

    @Id
    @Column(name = "id_sanction")
    private Integer idSanction;

    @Column(name = "id_membre")
    private Integer idMembre;

    @Column(name = "nom_membre")
    private String nomMembre;

    @Column(name = "nom_categorie")
    private String nomCategorie;

    @Column(name = "nb_jour_sanction")
    private Integer nbJourSanction;

    @Column(name = "coefficient")
    private Integer coefficient;

    @Column(name = "date_debut_sanction")
    private Date dateDebutSanction;

    @Column(name = "date_fin_sanction")
    private Date dateFinSanction;

    public Integer getIdSanction() {
        return idSanction;
    }

    public Integer getIdMembre() {
        return idMembre;
    }

    public String getNomMembre() {
        return nomMembre;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public Integer getNbJourSanction() {
        return nbJourSanction;
    }

    public Integer getCoefficient() {
        return coefficient;
    }

    public Date getDateDebutSanction() {
        return dateDebutSanction;
    }

    public Date getDateFinSanction() {
        return dateFinSanction;
    }

    
}
