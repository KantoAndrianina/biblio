-- Insérer des données dans la table Collection
INSERT INTO Admin (login,mdp) VALUES 
('admin', 'azerty123');

-- Insérer des données dans la table Collection
INSERT INTO Collection (nom_collection) VALUES 
('Fiction Contemporaine'),
('Science-Fiction'),
('Biographies'),
('Romans Historiques');

-- Insérer des données dans la table Edition
INSERT INTO Edition (nom_edition) VALUES 
('Gallimard'),
('Albin Michel'),
('Hachette'),
('Folio');

-- Insérer des données dans la table Auteur
INSERT INTO Auteur (nom_auteur) VALUES 
('Margaret Atwood'),
('Isaac Asimov'),
('Walter Isaacson'),
('Ken Follett');

-- Insérer des données dans la table Livre
INSERT INTO Livre (titre, ISBN, id_collection, date_edition, id_edition, id_auteur, numero_cote, couverture, nb_pages, mots_cle, age_min) VALUES
('Le Conte de la Servante', '978-0-553-21311-7', 1, '1985-09-01', 1, 1, 'FIC/ATW', 'hardcover', 311, 'dystopie, féminisme', 16),
('Fondation', '978-0-553-80371-0', 2, '1951-06-01', 2, 2, 'SF/ASI', 'paperback', 244, 'science-fiction, empire galactique', 14),
('Steve Jobs', '978-1-4516-4853-9', 3, '2011-10-24', 3, 3, 'BIO/ISA', 'hardcover', 656, 'biographie, technologie', 16),
('Les Piliers de la Terre', '978-0-451-20020-7', 4, '1989-10-03', 4, 4, 'HIST/FOL', 'hardcover', 973, 'roman historique, architecture', 18),
('Oryx et Crake', '978-0-7475-6671-2', 1, '2003-05-06', 1, 1, 'FIC/ATW', 'hardcover', 376, 'science-fiction, dystopie', 16),
('Les Robots', '978-0-553-29438-9', 2, '1950-12-02', 2, 2, 'SF/ASI', 'paperback', 320, 'science-fiction, robots', 14),
('Einstein: Sa Vie et Son Univers', '978-0-7432-9405-9', 3, '2007-04-10', 3, 3, 'BIO/ISA', 'hardcover', 675, 'biographie, physique', 16),
('Un Monde Sans Fin', '978-0-525-94976-0', 4, '2007-10-09', 4, 4, 'HIST/FOL', 'hardcover', 1024, 'roman historique, Moyen Âge', 18),
('Alias Grace', '978-0-385-72227-5', 1, '1996-09-04', 1, 1, 'FIC/ATW', 'hardcover', 460, 'roman historique, féminisme', 16),
('Le Cycle des Robots', '978-0-553-28825-8', 2, '1990-11-01', 2, 2, 'SF/ASI', 'paperback', 607, 'science-fiction, robots', 14);

UPDATE livre SET code = CONCAT('CL', id_livre::TEXT) WHERE code IS NULL;

-- Insérer des données dans la table TypePret
INSERT INTO TypePret (nom_type_pret) VALUES 
('Sur place'),
('A Domicile');

-- Insérer des données dans la table CategorieMembre
INSERT INTO CategorieMembre (nom_categorie, nb_jour_pret, nb_jour_sanction, coefficient) VALUES 
('Professeur', 15, 5, 2),
('Etudiant', 10, 7, 3),
('Salarié', 7, 7, 3),
('Normal', 5, 5, 4);

-- Insérer des données dans la table Membre
INSERT INTO Membre (nom_membre, id_cat_membre, date_naissance) VALUES 
('Jack Daniels', 1, '1979-06-21'),
('John Peters', 2 , '2003-08-22'),
('Johnny Walker', 3 , '1990-11-12'),
('Jim Beam', 4 , '1998-10-02');

-- Insérer des données dans la table Membre
INSERT INTO Membre (nom_membre, id_cat_membre, date_naissance) VALUES 
('Jayden Smith', 4, '2012-06-21');

-- Insérer des données dans la table Membre
INSERT INTO Membre (nom_membre, id_cat_membre, date_naissance) VALUES 
('Jack Sparrow', 1, '2000-06-21');

-- Insérer des données dans la table ExemplaireLivre
INSERT INTO ExemplaireLivre (id_livre) VALUES 
(1),
(2),
(2),
(2),
(3),
(3),
(4),
(5),
(6),
(6),
(6),
(6),
(7),
(8),
(9),
(10),
(10);

-- Insérer des données dans la table AutorisationException
INSERT INTO AutorisationException (id_livre, id_cat_membre, id_type_pret) VALUES 
(7, 1, 2),
(4, 1, 2);

-- Insérer des données dans la table Pret
INSERT INTO Pret (date_debut_pret, date_fin_pret, id_type_pret, id_exemplaire, id_membre) VALUES 
('2024-06-11', '2024-06-26', 2, 2, 1),
('2024-06-11', '2024-06-21', 2, 5, 2);

INSERT INTO Pret (date_debut_pret, date_fin_pret, id_type_pret, id_exemplaire, id_membre, date_rendu_pret) VALUES 
('2024-06-01', '2024-06-16', 2, 16, 1, '2024-06-11');

INSERT INTO Pret (date_debut_pret, date_fin_pret, id_type_pret, id_exemplaire, id_membre) VALUES 
('2024-06-08', '2024-06-13', 2, 1, 4);

INSERT INTO Sanction (id_membre, date_debut_sanction, date_fin_sanction) VALUES 
(1, '2024-06-10', '2024-06-21');

INSERT INTO Sanction (id_membre, date_debut_sanction, date_fin_sanction) VALUES 
(1, '2024-06-10', '2024-06-13');

19:33
INSERT INTO Pret (date_debut_pret, date_fin_pret, id_type_pret, id_exemplaire, id_membre) VALUES 
('2024-06-08', '2024-06-13', 2, 1, 4);
INSERT INTO Pret (date_debut_pret, date_fin_pret, id_type_pret, id_exemplaire, id_membre) VALUES 
('2024-06-07', '2024-06-12', 2, 1, 4);