-- nombre de livre dispo
select sum(nb_livre_disponible) from (
    SELECT 
        ex.id_livre,
        COUNT(ex.id_exemplaire) - COUNT(p.id_pret) AS nb_livre_disponible
    FROM 
        v_exemplaire_livres ex
    LEFT JOIN 
        v_prets p ON ex.id_exemplaire = p.id_exemplaire AND p.date_rendu_pret IS NULL
    GROUP BY 
        ex.id_livre
    ORDER BY 
        ex.id_livre) s;

-- liste d'exemplaire disponible
    SELECT 
        ex.id_exemplaire,
        ex.id_livre
    FROM 
        v_exemplaire_livres ex
    LEFT JOIN 
        v_prets p ON ex.id_exemplaire = p.id_exemplaire AND p.date_rendu_pret IS NULL
    WHERE 
        p.id_pret IS NULL;
