package fr.diginamic;

import fr.diginamic.entites.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

public class IntegrationOpenFoodFacts {


    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("foodfact");
        EntityManager manager = factory.createEntityManager();



        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        //1. integration des données du fichier en BDD

        Path paths = Paths.get("./open-food-facts.csv");

        try {
            List<String> lignes = Files.readAllLines(paths, StandardCharsets.UTF_8);
            lignes.remove(0); // Pour supprimer la première ligne du fichier car on a pas besoin de ce dernier
            Iterator<String> it = lignes.iterator();
            while(it.hasNext()) {
                String ligne = it.next(); // pour avoir chaque ligne de l'iteration
                String [] morceaux = ligne.split("\\|",-1 );  // découper en morceaux chaque line avec le séparateur | précédé de // antislash et la limite à zero pour récuperer les espaces vides
                String categorieProduit = morceaux[0]; // la catégorie du produit
                String marqueProduit = morceaux[1]; // la marque du produit
                String nomProduit = morceaux[2]; // le nom du produit
                String scoreNutritionnelProduit = morceaux[3]; // le score nutritionnel du produit
                String ingredientsProduit = morceaux [4]; // Liste des ingredients
                String valeursNutritionnellesProduit = morceaux [5] + morceaux [6]; // tas de données nutrionnelles
                String allergenesProduit = morceaux[28]; // liste des allergenes du produits
                String additifsProduit = morceaux [29]; // additifs du produit

                //System.out.println(additifs);

                // 2. Insertion des entités en base de données

                //la marque mais à revoir pour les doublons
                Marque marque = new Marque(0,marqueProduit);
                manager.persist(marque);
                if(marque.getLibelle().equalsIgnoreCase(marqueProduit)){
                     marqueProduit = marque.getLibelle();
                }

                //la categorie mais à revoir pour les doublons

                Categorie categorie = new Categorie(0, categorieProduit);
                manager.persist(categorie);

                Ingredient ingredients = new Ingredient();
                Allergene allergenes = new Allergene();
                Additif additifs = new Additif();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }



        transaction.commit();
        manager.close();

    }

}
