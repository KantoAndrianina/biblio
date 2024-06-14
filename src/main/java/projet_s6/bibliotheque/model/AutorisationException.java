package projet_s6.bibliotheque.model;

import jakarta.persistence.*;

@Entity
@Table(name = "autorisation_exception")
public class AutorisationException {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_autorisation")
    private Integer idAutorisation;

    @Column(name = "id_livre")
    private Integer idLivre;

    @Column(name = "id_cat_membre")
    private Integer idCatMembre;

    @Column(name = "id_type_pret")
    private Integer idTypePret;


    public AutorisationException() {
    }

    public AutorisationException(Integer idLivre, Integer idCatMembre, Integer idTypePret) {
        this.idLivre = idLivre;
        this.idCatMembre = idCatMembre;
        this.idTypePret = idTypePret;
    }

    public Integer getIdAutorisation() {
        return idAutorisation;
    }

    public void setIdAutorisation(Integer idAutorisation) {
        this.idAutorisation = idAutorisation;
    }

    public Integer getIdLivre() {
        return idLivre;
    }

    public void setIdLivre(Integer idLivre) {
        this.idLivre = idLivre;
    }

    public Integer getIdCatMembre() {
        return idCatMembre;
    }

    public void setIdCatMembre(Integer idCatMembre) {
        this.idCatMembre = idCatMembre;
    }

    public Integer getIdTypePret() {
        return idTypePret;
    }

    public void setIdTypePret(Integer idTypePret) {
        this.idTypePret = idTypePret;
    }

    @Override
    public String toString() {
        return "AutorisationException{" +
                "idAutorisation=" + idAutorisation +
                ", idLivre=" + idLivre +
                ", idCatMembre=" + idCatMembre +
                ", idTypePret=" + idTypePret +
                '}';
    }
}
