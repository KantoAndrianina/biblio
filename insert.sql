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

-- Insérer des données dans la table TypePret
INSERT INTO TypePret (nom_type_pret) VALUES 
('Sur place'),
('A Domicile');