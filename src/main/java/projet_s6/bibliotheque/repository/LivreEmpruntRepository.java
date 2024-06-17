package projet_s6.bibliotheque.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import projet_s6.bibliotheque.model.LivreEmprunt;


@Repository
public class LivreEmpruntRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public LivreEmpruntRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<LivreEmprunt> findTop10LivresEmpruntes() {
        String sql = "SELECT l.id_livre , l.titre AS titre_livre, a.nom_auteur AS nom_auteur, COUNT(p.id_pret) AS nombre_emprunts " +
                     "FROM Livre l " +
                     "JOIN Auteur a ON l.id_auteur = a.id_auteur " +
                     "JOIN ExemplaireLivre el ON l.id_livre = el.id_livre " +
                     "LEFT JOIN Pret p ON el.id_exemplaire = p.id_exemplaire " +
                     "GROUP BY l.id_livre, titre_livre, nom_auteur " +
                     "ORDER BY nombre_emprunts DESC " +
                     "LIMIT 10";

        return jdbcTemplate.query(sql, (resultSet, rowNum) -> {
            LivreEmprunt livreEmprunt = new LivreEmprunt();
            livreEmprunt.setIdLivre(resultSet.getInt("id_livre"));
            livreEmprunt.setTitre(resultSet.getString("titre_livre"));
            livreEmprunt.setNomAuteur(resultSet.getString("nom_auteur"));
            livreEmprunt.setNombreEmprunts(resultSet.getInt("nombre_emprunts"));
            return livreEmprunt;
        });
    }

    public LivreEmprunt findLivrePlusEmprunte() {
        String sql = "SELECT l.id_livre, l.titre AS titre_livre, a.nom_auteur AS nom_auteur, COUNT(p.id_pret) AS nombre_emprunts " +
                    "FROM Livre l " +
                    "JOIN Auteur a ON l.id_auteur = a.id_auteur " +
                    "JOIN ExemplaireLivre el ON l.id_livre = el.id_livre " +
                    "LEFT JOIN Pret p ON el.id_exemplaire = p.id_exemplaire " +
                    "GROUP BY l.id_livre, titre_livre, nom_auteur " +
                    "ORDER BY nombre_emprunts DESC " +
                    "LIMIT 1";

        return jdbcTemplate.queryForObject(sql, (resultSet, rowNum) -> {
            LivreEmprunt livreEmprunt = new LivreEmprunt();
            livreEmprunt.setIdLivre(resultSet.getInt("id_livre"));
            livreEmprunt.setTitre(resultSet.getString("titre_livre"));
            livreEmprunt.setNomAuteur(resultSet.getString("nom_auteur"));
            livreEmprunt.setNombreEmprunts(resultSet.getInt("nombre_emprunts"));
            return livreEmprunt;
        });
    }

    public List<LivreEmprunt> findLivresRendusByMembreId(Integer idMembre) {
        String sql = "SELECT l.id_livre, l.titre AS titre_livre,l.couverture, a.nom_auteur AS nom_auteur, p.id_membre, p.date_rendu_pret " +
                     "FROM Livre l " +
                     "JOIN Auteur a ON l.id_auteur = a.id_auteur " +
                     "JOIN ExemplaireLivre e ON l.id_livre = e.id_livre " +
                     "JOIN Pret p ON e.id_exemplaire = p.id_exemplaire " +
                     "WHERE p.id_membre = ? AND p.date_rendu_pret IS NOT NULL " +
                     "ORDER BY l.id_livre";
    
        return jdbcTemplate.query(sql, new Object[]{idMembre}, (resultSet, rowNum) -> {
            LivreEmprunt livre = new LivreEmprunt();
            livre.setIdLivre(resultSet.getInt("id_livre"));
            livre.setTitre(resultSet.getString("titre_livre"));
            livre.setCouverture(resultSet.getString("couverture"));
            livre.setNomAuteur(resultSet.getString("nom_auteur"));
            livre.setIdMembre(resultSet.getInt("id_membre"));
            livre.setDateRenduPret(resultSet.getDate("date_rendu_pret"));
            return livre;
        });
    }

    public List<LivreEmprunt> findLivresEnCoursByMembreId(Integer idMembre) {
        String sql = "SELECT l.id_livre, l.titre AS titre_livre, l.couverture, a.nom_auteur AS nom_auteur, p.id_membre, p.date_rendu_pret " +
                     "FROM Livre l " +
                     "JOIN Auteur a ON l.id_auteur = a.id_auteur " +
                     "JOIN ExemplaireLivre e ON l.id_livre = e.id_livre " +
                     "JOIN Pret p ON e.id_exemplaire = p.id_exemplaire " +
                     "WHERE p.id_membre = ? AND p.date_rendu_pret IS NULL " +
                     "ORDER BY l.id_livre";
    
        return jdbcTemplate.query(sql, new Object[]{idMembre}, (resultSet, rowNum) -> {
            LivreEmprunt livre = new LivreEmprunt();
            livre.setIdLivre(resultSet.getInt("id_livre"));
            livre.setTitre(resultSet.getString("titre_livre"));
            livre.setCouverture(resultSet.getString("couverture"));
            livre.setNomAuteur(resultSet.getString("nom_auteur"));
            livre.setIdMembre(resultSet.getInt("id_membre"));
            livre.setDateRenduPret(resultSet.getDate("date_rendu_pret"));
            return livre;
        });
    }
    
}
