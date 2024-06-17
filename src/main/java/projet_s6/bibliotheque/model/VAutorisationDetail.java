package projet_s6.bibliotheque.model;
import jakarta.persistence.*;

@Entity
@Table(name = "v_autorisation_details")
public class VAutorisationDetail {

    @Id
    @Column(name = "id_autorisation")
    private Integer idAutorisation;

    @Column(name = "id_livre")
    private Integer idLivre;

    @Column(name = "titre")
    private String titre;

    @Column(name = "code")
    private String code;

    @Column(name = "age_min")
    private Integer ageMin;

    @Column(name = "id_cat_membre")
    private Integer idCatMembre;

    @Column(name = "nom_categorie")
    private String nomCategorie;

    @Column(name = "id_type_pret")
    private Integer idTypePret;

    @Column(name = "nom_type_pret")
    private String nomTypePret;

    public Integer getIdAutorisation() {
        return idAutorisation;
    }

    public Integer getIdLivre() {
        return idLivre;
    }

    public String getTitre() {
        return titre;
    }

    public String getCode() {
        return code;
    }

    public Integer getAgeMin() {
        return ageMin;
    }

    public Integer getIdCatMembre() {
        return idCatMembre;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public Integer getIdTypePret() {
        return idTypePret;
    }

    public String getNomTypePret() {
        return nomTypePret;
    }
    
}