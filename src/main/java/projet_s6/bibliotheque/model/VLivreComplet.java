package projet_s6.bibliotheque.model;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "v_livre_complets")
public class VLivreComplet {

    @Id
    @Column(name = "id_livre")
    private Integer idLivre;

    @Column(name = "titre")
    private String titre;

    @Column(name = "ISBN")
    private String isbn;

    @Column(name = "id_collection")
    private Long idCollection;

    @Column(name = "nom_collection")
    private String nomCollection;

    @Column(name = "date_edition")
    private Date dateEdition;

    @Column(name = "id_edition")
    private Long idEdition;

    @Column(name = "nom_edition")
    private String nomEdition;

    @Column(name = "id_auteur")
    private Long idAuteur;

    @Column(name = "nom_auteur")
    private String nomAuteur;

    @Column(name = "numero_cote")
    private String numeroCote;

    @Column(name = "couverture")
    private String couverture;

    @Column(name = "nb_pages")
    private Integer nbPages;

    @Column(name = "mots_cle")
    private String motsCle;

    @Column(name = "age_min")
    private Integer ageMin;

    @Column(name = "code")
    private String code;

    @Column(name = "nb_livre_disponible")
    private Integer nbLivreDisponible;

    public Integer getIdLivre() {
        return idLivre;
    }

    public Integer getNbLivreDisponible() {
        return nbLivreDisponible;
    }

    public String getTitre() {
        return titre;
    }

    public String getIsbn() {
        return isbn;
    }

    public Long getIdCollection() {
        return idCollection;
    }

    public String getNomCollection() {
        return nomCollection;
    }

    public Date getDateEdition() {
        return dateEdition;
    }

    public Long getIdEdition() {
        return idEdition;
    }

    public String getNomEdition() {
        return nomEdition;
    }

    public Long getIdAuteur() {
        return idAuteur;
    }

    public String getNomAuteur() {
        return nomAuteur;
    }

    public String getNumeroCote() {
        return numeroCote;
    }

    public String getCouverture() {
        return couverture;
    }

    public Integer getNbPages() {
        return nbPages;
    }

    public String getMotsCle() {
        return motsCle;
    }

    public Integer getAgeMin() {
        return ageMin;
    }

    public String getCode() {
        return code;
    }

}
