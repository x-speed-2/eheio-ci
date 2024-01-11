package ma.ehei_github_ci;

import java.util.ArrayList;
import java.util.List;



public class ProduitService {
	private List<Produit> produits;

    public ProduitService() {
        this.produits = new ArrayList<>();
    }
    
    public List<Produit> listerProduits() {
        return produits;
    }
    
    public Produit trouverProduitParId(Long id) {
        for (Produit produit : produits) {
            if (produit.getId().equals(id)) {
                return produit;
            }
        }
        throw new RuntimeException("Erreur : Produit non trouvé avec l'ID " + id);
    }
    private boolean produitExisteParId(Long id) {
        for (Produit produit : produits) {
            if (produit.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
    private boolean produitExisteParNom(String nom) {
        for (Produit produit : produits) {
            if (produit.getNom().equalsIgnoreCase(nom)) {
                return true;
            }
        }
        return false;
    }

    public void ajouterProduit(Produit nouveauProduit) {
        if (produitExisteParId(nouveauProduit.getId()) || produitExisteParNom(nouveauProduit.getNom())) {
            System.out.println("Erreur : Un produit avec le même ID ou nom existe déjà.");
            return;
        }

        if (nouveauProduit.getPrix() < 0 || nouveauProduit.getQuantite() < 0) {
            System.out.println("Erreur : Le prix et la quantité des produits doivent être positifs.");
            return;
        }

        produits.add(nouveauProduit);
        System.out.println("Produit ajouté avec succès : " + nouveauProduit);
    }

}
