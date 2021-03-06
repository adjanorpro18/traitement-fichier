package fr.diginamic.entites;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Classe Categorie avec un identifaint et un libelle
 * @param idCategorie qui est l'identifaint de la classe
 * @param libelle qui est le libellé de la classe
 */
@Entity
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCategorie;

    @Column
    private String libelle;

    //Relation entre Categorie-Produit = une categorie faisant références à plusiuers produits
    @OneToMany(mappedBy = "categorie")
    private Set<Produit> produits;

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
    public Categorie(int idCategorie, String libelle) {
        this.idCategorie = idCategorie;
        this.libelle = libelle;
        Set<Produit> produits = new HashSet<Produit>();
    }

    /**
     * Getters et Setters des attributs de classe
     */


    /**
     * @return l'identifiant de la classe
     */
    public int getIdCategorie() {
        return idCategorie;
    }

    /**
     * modifie l'identifiant de la classe
     * @param idCategorie
     */
    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
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

    /**
     * @return la liste des produits associés à la categorie
     */
    public Set<Produit> getProduits() {
        return produits;
    }

    /**
     * modifie la liste des produits associés à la categorie
     * @param produits
     */
    public void setProduits(Set<Produit> produits) {
        this.produits = produits;
    }
}
