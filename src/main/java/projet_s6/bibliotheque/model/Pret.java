package projet_s6.bibliotheque.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pret")
public class Pret {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pret")
    private Integer idPret;

    @Column(name = "date_debut_pret")
    private Date dateDebutPret;

    @Column(name = "date_fin_pret")
    private Date dateFinPret;

    @Column(name = "id_type_pret")
    private Integer idTypePret;

    @Column(name = "id_exemplaire")
    private Integer idExemplaire;

    @Column(name = "id_membre")
    private Integer idMembre;

    @Column(name = "date_rendu_pret")
    private Date dateRenduPret;

    public Integer getIdPret() {
        return idPret;
    }

    public void setIdPret(Integer idPret) {
        this.idPret = idPret;
    }

    public Date getDateDebutPret() {
        return dateDebutPret;
    }

    public void setDateDebutPret(Date dateDebutPret) {
        this.dateDebutPret = dateDebutPret;
    }

    public Date getDateFinPret() {
        return dateFinPret;
    }

    public void setDateFinPret(Date dateFinPret) {
        this.dateFinPret = dateFinPret;
    }

    public Integer getIdTypePret() {
        return idTypePret;
    }

    public void setIdTypePret(Integer idTypePret) {
        this.idTypePret = idTypePret;
    }

    public Integer getIdExemplaire() {
        return idExemplaire;
    }

    public void setIdExemplaire(Integer idExemplaire) {
        this.idExemplaire = idExemplaire;
    }

    public Integer getIdMembre() {
        return idMembre;
    }

    public void setIdMembre(Integer idMembre) {
        this.idMembre = idMembre;
    }

    public Date getDateRenduPret() {
        return dateRenduPret;
    }

    public void setDateRenduPret(Date dateRenduPret) {
        this.dateRenduPret = dateRenduPret;
    }

    
}
