package projet_s6.bibliotheque.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sanction")
public class Sanction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sanction")
    private Integer idSanction;

    @Column(name = "id_membre")
    private Integer idMembre;

    @Column(name = "date_debut_sanction")
    private Date dateDebutSanction;

    @Column(name = "date_fin_sanction")
    private Date dateFinSanction;

    public Integer getIdSanction() {
        return idSanction;
    }

    public void setIdSanction(Integer idSanction) {
        this.idSanction = idSanction;
    }

    public Integer getIdMembre() {
        return idMembre;
    }

    public void setIdMembre(Integer idMembre) {
        this.idMembre = idMembre;
    }

    public Date getDateDebutSanction() {
        return dateDebutSanction;
    }

    public void setDateDebutSanction(Date dateDebutSanction) {
        this.dateDebutSanction = dateDebutSanction;
    }

    public Date getDateFinSanction() {
        return dateFinSanction;
    }

    public void setDateFinSanction(Date dateFinSanction) {
        this.dateFinSanction = dateFinSanction;
    }

}

