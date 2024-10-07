package com.alt.products.services;

import com.alt.products.entities.Product;
import com.alt.products.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Indique que cette classe est un service Spring
public class ProductService {

    @Autowired
    private ProductRepository productRepository; // Injection de dépendance pour le dépôt de produits

    // Récupérer tous les produits
    public List<Product> getAllProducts() {
        return productRepository.findAll(); // Appel à la méthode findAll du dépôt
    }

    // Récupérer un produit par son ID
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id); // Retourne un Optional contenant le produit ou vide
    }

    // Créer un nouveau produit
    public Product createProduct(Product product) {
        return productRepository.save(product); // Sauvegarde le produit dans le dépôt
    }

    // Mettre à jour un produit existant
    public Product updateProduct(Long id, Product productDetails) {
        return productRepository.findById(id).map(product -> {
            // Mise à jour des détails du produit
            product.setName(productDetails.getName());
            product.setPrice(productDetails.getPrice());
            product.setQuantity(productDetails.getQuantity());
            product.setInventoryStatus(productDetails.getInventoryStatus());
            product.setRating(productDetails.getRating());
            product.setUpdatedAt(productDetails.getUpdatedAt());
            return productRepository.save(product); // Sauvegarde les modifications
        }).orElseThrow(() -> new RuntimeException("Product not found")); // Lancer une exception si le produit n'existe pas
    }

    // Supprimer un produit par son ID
    public void deleteProduct(Long id) {
        productRepository.deleteById(id); // Suppression du produit dans le dépôt
    }
}
