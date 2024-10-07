package com.alt.products.controllers;

import com.alt.products.entities.Product;
import com.alt.products.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")  // Définir le chemin de base pour les requêtes de produit
public class ProductController {

    @Autowired
    private ProductService productService; // Injection de dépendance pour le service de produit

    // Méthode pour récupérer tous les produits
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts(); // Appel au service pour obtenir la liste des produits
    }

    // Méthode pour récupérer un produit par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        // Appel au service pour obtenir un produit par ID et renvoyer la réponse appropriée
        return productService.getProductById(id)
                .map(ResponseEntity::ok) // Si le produit est trouvé, retourner un statut 200 avec le produit
                .orElse(ResponseEntity.notFound().build()); // Sinon, retourner un statut 404
    }

    // Méthode pour créer un nouveau produit
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product); // Appel au service pour créer le produit
    }

    // Méthode pour mettre à jour un produit existant
    @PatchMapping("/{id}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable Long id, 
            @RequestBody Product productDetails) {
        // Appel au service pour mettre à jour le produit et retourner la réponse appropriée
        return ResponseEntity.ok(productService.updateProduct(id, productDetails));
    }

    // Méthode pour supprimer un produit par son ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id); // Appel au service pour supprimer le produit
        return ResponseEntity.noContent().build(); // Retourner un statut 204 pour indiquer que la suppression a réussi
    }
}
