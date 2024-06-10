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
