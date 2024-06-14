package projet_s6.bibliotheque.model;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "membre")
public class Membre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_membre")
    private Integer idMembre;

    @Column(name = "nom_membre")
    private String nomMembre;

    @Column(name = "id_cat_membre")
    private Integer idCatMembre;

    @Column(name = "date_naissance")
    private Date dateNaissance;

    public Integer getIdMembre() {
        return idMembre;
    }

    public void setIdMembre(Integer idMembre) {
        this.idMembre = idMembre;
    }

    public String getNomMembre() {
        return nomMembre;
    }

    public void setNomMembre(String nomMembre) {
        this.nomMembre = nomMembre;
    }

    public Integer getIdCatMembre() {
        return idCatMembre;
    }

    public void setIdCatMembre(Integer idCatMembre) {
        this.idCatMembre = idCatMembre;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }


   
}
