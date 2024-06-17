package projet_s6.bibliotheque.model;

import jakarta.persistence.*;
import java.util.Date;


@Entity
@Table(name = "v_pret_details")
public class VPretDetail {

    @Id
    @Column(name = "id_pret")
    private Integer idPret;

    // date_debut_pret
    @Column(name = "date_debut_pret")
    private Date dateDebutPret;

    // date_fin_pret
    @Column(name = "date_fin_pret")
    private Date dateFinPret;

    // date_rendu_pret
    @Column(name = "date_rendu_pret")
    private Date dateRenduPret;

    // id_type_pret
    @Column(name = "id_type_pret")
    private Integer idTypePret;

    // nom_type_pret
    @Column(name = "nom_type_pret")
    private String nomTypePret;

    // titre
    @Column(name = "titre")
    private String titre;

    // code
    @Column(name = "code")
    private String code;

    // id_exemplaire
    @Column(name = "id_exemplaire")
    private Integer idExemplaire;

    // id_membre
    @Column(name = "id_membre")
    private Integer idMembre;

    // nom_membre
    @Column(name = "nom_membre")
    private String nomMembre;

    // id_cat_membre
    @Column(name = "id_cat_membre")
    private Integer idCategorie;

    // nom_categorie
    @Column(name = "nom_categorie")
    private String nomCategorie;

    // date_naissance
    @Column(name = "date_naissance")
    private Date dateNaissance;

    // age_membre
    @Column(name = "age_membre")
    private Integer ageMembre;


    public Integer getIdPret() {
        return idPret;
    }

    public Date getDateDebutPret() {
        return dateDebutPret;
    }

    public Date getDateFinPret() {
        return dateFinPret;
    }

    public Integer getIdTypePret() {
        return idTypePret;
    }

    public String getNomTypePret() {
        return nomTypePret;
    }

    public String getTitre() {
        return titre;
    }

    public String getCode() {
        return code;
    }

    public Integer getIdExemplaire() {
        return idExemplaire;
    }

    public Integer getIdMembre() {
        return idMembre;
    }

    public String getNomMembre() {
        return nomMembre;
    }

    public Integer getIdCategorie() {
        return idCategorie;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public Integer getAgeMembre() {
        return ageMembre;
    }

    public Date getDateRenduPret() {
        return dateRenduPret;
    }


}