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

}
