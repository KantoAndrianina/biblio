CREATE DATABASE db_bibliotheque;
\c db_bibliotheque

CREATE TABLE Collection (
    id_collection SERIAL PRIMARY KEY UNIQUE,
    nom_collection VARCHAR(100)
);

CREATE TABLE Edition (
    id_edition SERIAL PRIMARY KEY UNIQUE,
    nom_edition VARCHAR(100)
);

CREATE TABLE Auteur (
    id_auteur SERIAL PRIMARY KEY UNIQUE,
    nom_auteur VARCHAR(100)
);

CREATE TABLE Livre (
    id_livre SERIAL PRIMARY KEY UNIQUE,
    titre VARCHAR(255),
    ISBN VARCHAR(100),
    id_collection INTEGER REFERENCES Collection(id_collection),
    date_edition DATE,
    id_edition INTEGER REFERENCES Edition(id_edition),
    id_auteur INTEGER REFERENCES Auteur(id_auteur),
    numero_cote VARCHAR(255),
    couverture VARCHAR(255),
    nb_pages INTEGER,
    mots_cle VARCHAR(255),
    age_min INTEGER
);
ALTER TABLE livre ADD COLUMN code VARCHAR(255);

CREATE SEQUENCE code_sequence
START WITH 11
INCREMENT BY 1
NO MINVALUE
NO MAXVALUE
CACHE 1;


CREATE TABLE TypePret (
    id_type_pret SERIAL PRIMARY KEY UNIQUE,
    nom_type_pret VARCHAR(100)
);

CREATE TABLE CategorieMembre (
    id_cat_membre SERIAL PRIMARY KEY UNIQUE,
    nom_categorie VARCHAR(100),
    nb_jour_pret INTEGER,
    nb_jour_sanction INTEGER,
    coefficient INTEGER
);

CREATE TABLE Membre (
    id_membre SERIAL PRIMARY KEY UNIQUE,
    nom_membre VARCHAR(255),
    id_cat_membre INTEGER REFERENCES CategorieMembre(id_cat_membre)
);

CREATE TABLE ExemplaireLivre (
    id_exemplaire SERIAL PRIMARY KEY UNIQUE,
    id_livre INTEGER REFERENCES Livre(id_livre)
);

CREATE TABLE Pret (
    id_pret SERIAL PRIMARY KEY UNIQUE,
    date_debut_pret DATE,
    date_fin_pret DATE,
    id_type_pret INTEGER REFERENCES TypePret(id_type_pret),
    id_exemplaire INTEGER REFERENCES ExemplaireLivre(id_exemplaire),
    id_membre INTEGER REFERENCES Membre(id_membre)
);

CREATE TABLE Autorisation_Exception (
    id_autorisation SERIAL PRIMARY KEY UNIQUE,
    id_livre INTEGER REFERENCES Livre(id_livre),
    id_cat_membre INTEGER REFERENCES CategorieMembre(id_cat_membre),
    id_type_pret INTEGER REFERENCES TypePret(id_type_pret)
);

CREATE TABLE Sanction (
    id_sanction SERIAL PRIMARY KEY UNIQUE,
    id_membre INTEGER REFERENCES Membre(id_membre),
    date_debut_sanction DATE,
    date_fin_sanction DATE
);

CREATE TABLE Admin (
    id_admin SERIAL PRIMARY KEY UNIQUE,
    login VARCHAR(255),
    mdp VARCHAR(15)
);

-- Vue pour la table Collection
CREATE VIEW v_collections AS
    SELECT
        id_collection,
        nom_collection
    FROM
        Collection;

-- Vue pour la table Edition
CREATE VIEW v_editions AS
    SELECT
        id_edition,
        nom_edition
    FROM
        Edition;

-- Vue pour la table Auteur
CREATE VIEW v_auteurs AS
    SELECT
        id_auteur,
        nom_auteur
    FROM
        Auteur;

CREATE VIEW v_livres AS
    SELECT
        id_livre,
        titre,
        ISBN,
        id_collection,
        date_edition,
        id_edition,
        id_auteur,
        numero_cote,
        couverture,
        nb_pages,
        mots_cle,
        age_min, 
        code
    FROM
        Livre;

-- Vue pour la table TypePret
CREATE VIEW v_type_prets AS
    SELECT
        id_type_pret,
        nom_type_pret
    FROM
        TypePret;

-- Vue pour la table CategorieMembre
CREATE VIEW v_categorie_membres AS
    SELECT
        id_cat_membre,
        nom_categorie,
        nb_jour_pret,
        nb_jour_sanction,
        coefficient
    FROM
        CategorieMembre;

-- Vue pour la table Membre
CREATE VIEW v_membres AS
    SELECT
        id_membre,
        nom_membre,
        id_cat_membre
    FROM
        Membre;

-- Vue pour la table ExemplaireLivre
CREATE VIEW v_exemplaire_livres AS
    SELECT
        id_exemplaire,
        id_livre
    FROM
        ExemplaireLivre;

-- Vue pour la table Pret
CREATE VIEW v_prets AS
    SELECT
        id_pret,
        date_debut_pret,
        date_fin_pret,
        id_type_pret,
        id_exemplaire,
        id_membre
    FROM
        Pret;

-- Vue pour la table Autorisation_Exception
CREATE VIEW v_autorisation_exceptions AS
    SELECT
        id_autorisation,
        id_livre,
        id_cat_membre,
        id_type_pret
    FROM
        Autorisation_Exception;

-- Vue pour la table Sanction
CREATE VIEW v_sanctions AS
    SELECT
        id_sanction,
        id_membre,
        date_debut_sanction,
        date_fin_sanction
    FROM
        Sanction;

-- Créer une vue qui relie 4 tables
CREATE VIEW v_livre_complets AS
    SELECT
        l.id_livre,
        l.titre,
        l.ISBN,
        c.id_collection,
        c.nom_collection,
        l.date_edition,
        e.id_edition,
        e.nom_edition,
        a.id_auteur,
        a.nom_auteur,
        l.numero_cote,
        l.couverture,
        l.nb_pages,
        l.mots_cle,
        l.age_min,
        l.code
    FROM
        v_livres l
    JOIN
        v_collections c ON l.id_collection = c.id_collection
    JOIN
        v_editions e ON l.id_edition = e.id_edition
    JOIN
        v_auteurs a ON l.id_auteur = a.id_auteur;
