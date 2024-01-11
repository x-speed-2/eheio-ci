package ma.ehei_github_ci;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class ProduitServiceTest {

    private ProduitService produitService;

    @Before
    public void setUp() {
        produitService = new ProduitService();
    }

    @Test
    public void testListerProduits() {
        List<Produit> produits = produitService.listerProduits();
        assertNotNull(produits);
        assertEquals(0, produits.size());
    }

    @Test
    public void testAjouterProduit() {
        Produit produit = new Produit(1L, "TestProduit", 10.0, 5);
        produitService.ajouterProduit(produit);

        List<Produit> produits = produitService.listerProduits();
        assertEquals(1, produits.size());
        assertEquals(produit, produits.get(0));
    }

    @Test(expected = RuntimeException.class)
    public void testTrouverProduitParIdProduitNonExistant() {
        produitService.trouverProduitParId(1L);
    }

    @Test
    public void testTrouverProduitParIdProduitExistant() {
        Produit produit = new Produit(1L, "TestProduit", 10.0, 5);
        produitService.ajouterProduit(produit);

        Produit foundProduit = produitService.trouverProduitParId(1L);
        assertNotNull(foundProduit);
        assertEquals(produit, foundProduit);
    }

    @Test
    public void testMettreAJourProduit() {
        Produit produit = new Produit(1L, "TestProduit", 10.0, 5);
        produitService.ajouterProduit(produit);

        Produit updatedProduit = new Produit(1L, "UpdatedProduit", 20.0, 10);
        produitService.mettreAJourProduit(updatedProduit);

        List<Produit> produits = produitService.listerProduits();
        assertEquals(1, produits.size());
        assertEquals(updatedProduit, produits.get(0));
    }

    @Test
    public void testSupprimerProduit() {
        Produit produit = new Produit(1L, "TestProduit", 10.0, 5);
        produitService.ajouterProduit(produit);

        produitService.supprimerProduit(1L);

        List<Produit> produits = produitService.listerProduits();
        assertEquals(0, produits.size());
    }

}
