package fr.diginamic.entites;

import javax.persistence.*;

/**
 * Classe Allergene un identifiant et un libelle
 * @param id qui est l'identifiant de la classe
 * @param libelle qui est le libelle de la classe
 */

@Entity
public class Allergene {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String libelle;

    /**
     * Constructeur par defaut
     */
    public Allergene() {
    }

    /**
     * Constructeur avec parametres
     * @param id
     * @param libelle
     */
    public Allergene(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    /**
     * Getters et Setters des attributs de la classe
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
