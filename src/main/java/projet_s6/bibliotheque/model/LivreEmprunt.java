package projet_s6.bibliotheque.model;

public class LivreEmprunt {
    private Integer idLivre;
    private String titre;
    private String nomAuteur;
    private int nombreEmprunts;
    
    public Integer getIdLivre() {
        return idLivre;
    }
    public String getTitre() {
        return titre;
    }
    public String getNomAuteur() {
        return nomAuteur;
    }
    public int getNombreEmprunts() {
        return nombreEmprunts;
    }
    
    public void setIdLivre(Integer idLivre) {
        this.idLivre = idLivre;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }
    public void setNomAuteur(String nomAuteur) {
        this.nomAuteur = nomAuteur;
    }
    public void setNombreEmprunts(int nombreEmprunts) {
        this.nombreEmprunts = nombreEmprunts;
    }
    public LivreEmprunt(Integer idLivre, String titre, String nomAuteur, int nombreEmprunts) {
        this.idLivre = idLivre;
        this.titre = titre;
        this.nomAuteur = nomAuteur;
        this.nombreEmprunts = nombreEmprunts;
    }
    public LivreEmprunt() {
    }
    
    

    
}
