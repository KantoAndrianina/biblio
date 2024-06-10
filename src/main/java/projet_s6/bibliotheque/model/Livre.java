package projet_s6.bibliotheque.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Livre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_livre;

    private String titre;
    private String ISBN;
    private Integer collection;
    private Date date_edition;
    private Integer edition;
    private Integer auteur;
    private String numero_cote;
    private String couverture;
    private Integer nb_pages;
    private String mots_cle;
    private Integer age_min;
    
    public Integer getId_livre() {
        return id_livre;
    }
    public void setId_livre(Integer id_livre) {
        this.id_livre = id_livre;
    }
    public String getTitre() {
        return titre;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }
    public String getISBN() {
        return ISBN;
    }
    public void setISBN(String iSBN) {
        ISBN = iSBN;
    }
    public Integer getCollection() {
        return collection;
    }
    public void setCollection(Integer collection) {
        this.collection = collection;
    }
    public Date getDate_edition() {
        return date_edition;
    }
    public void setDate_edition(Date date_edition) {
        this.date_edition = date_edition;
    }
    public Integer getEdition() {
        return edition;
    }
    public void setEdition(Integer edition) {
        this.edition = edition;
    }
    public Integer getAuteur() {
        return auteur;
    }
    public void setAuteur(Integer auteur) {
        this.auteur = auteur;
    }
    public String getNumero_cote() {
        return numero_cote;
    }
    public void setNumero_cote(String numero_cote) {
        this.numero_cote = numero_cote;
    }
    public String getCouverture() {
        return couverture;
    }
    public void setCouverture(String couverture) {
        this.couverture = couverture;
    }
    public Integer getNb_pages() {
        return nb_pages;
    }
    public void setNb_pages(Integer nb_pages) {
        this.nb_pages = nb_pages;
    }
    public String getMots_cle() {
        return mots_cle;
    }
    public void setMots_cle(String mots_cle) {
        this.mots_cle = mots_cle;
    }
    public Integer getAge_min() {
        return age_min;
    }
    public void setAge_min(Integer age_min) {
        this.age_min = age_min;
    }
    

}
