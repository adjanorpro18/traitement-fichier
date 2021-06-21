package fr.diginamic.entites;

import javax.persistence.*;

/**
 * Classe Categorie avec un identifaint et un libelle
 * @param id qui est l'identifaint de la classe
 * @param libelle qui est le libellé de la classe
 */
@Entity
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String libelle;

    /**
     * Constructeur par defaut
     */
    public Categorie() {
    }

    /**
     * Constructeur avec parametres
     * @param id
     * @param libelle
     */
    public Categorie(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    /**
     * Getters et Setters des attributs de classe
     */


    /**
     * @return l'identifiant de la classe
     */
    public int getId() {
        return id;
    }

    /**
     * modifie l'identifiant de la classe
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return le libelle de la classe
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * modifie le libelle de la classe
     * @param libelle
     */
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
