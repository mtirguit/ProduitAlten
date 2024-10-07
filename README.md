Voici la mise à jour de votre documentation pour ajouter la possibilité de se connecter à une base de données MariaDB :

---

# API Produit - Application Spring Boot

## Aperçu du Projet

Cette application Spring Boot est conçue pour gérer un catalogue de produits avec des opérations CRUD utilisant des API RESTful. Les API permettent de créer, récupérer, mettre à jour et supprimer des produits, ainsi que d’obtenir les détails de produits spécifiques.

## Fonctionnalités

- Créer un nouveau produit
- Récupérer tous les produits
- Récupérer les détails d'un produit spécifique par ID
- Mettre à jour les détails d'un produit
- Supprimer un produit par ID

## Base de Données

Le projet utilise **H2** comme base de données en mémoire à des fins de test, mais il prend également en charge la connexion à une base de données **MariaDB**.

### Détails de la Base de Données H2 :
- **URL** : `jdbc:h2:mem:testdb`
- **Classe du Driver** : `org.h2.Driver`
- **Nom d'utilisateur** : `admin`
- **Mot de passe** : (Aucun mot de passe requis)

Vous pouvez accéder à la console H2 à partir de l'URL suivante après avoir lancé l'application :
http://localhost:8080/h2-console

- **URL JDBC** : `jdbc:h2:mem:testdb`
- **Nom d'utilisateur** : `admin`
- **Mot de passe** : (Laissez-le vide)

### Configuration de la Base de Données MariaDB

Pour se connecter à une base de données **MariaDB** avec le nom d'utilisateur `root`, vous devez suivre ces étapes :

1. **Dépendance Maven**  
   Assurez-vous que votre fichier `pom.xml` contient la dépendance pour MariaDB. Ajoutez la dépendance suivante dans la section `<dependencies>` :
   ```xml
   <dependency>
       <groupId>org.mariadb.jdbc</groupId>
       <artifactId>mariadb-java-client</artifactId>
       <version>3.0.0</version> <!-- ou la dernière version -->
   </dependency>
   ```

2. **Configuration dans application.properties**  
   Ajoutez les configurations nécessaires dans le fichier `application.properties` pour se connecter à MariaDB. Voici un exemple :
   ```properties
   # Configuration de la base de données MariaDB
   spring.datasource.url=jdbc:mariadb://localhost:3306/nom_de_votre_base_de_donnees
   spring.datasource.username=root
   spring.datasource.password=motdepasse # Remplacez par le mot de passe de l'utilisateur root
   spring.datasource.driver-class-name=org.mariadb.jdbc.Driver

   # Configuration JPA/Hibernate
   spring.jpa.hibernate.ddl-auto=update # Ou "create" si vous souhaitez recréer la base de données à chaque démarrage
   spring.jpa.show-sql=true # Pour afficher les requêtes SQL dans la console
   ```

3. **Créer la Base de Données**  
   Avant de lancer l'application, assurez-vous que la base de données que vous avez spécifiée (`nom_de_votre_base_de_donnees`) existe dans MariaDB. Vous pouvez créer la base de données en utilisant le client MariaDB ou un outil comme phpMyAdmin :
   ```sql
   CREATE DATABASE nom_de_votre_base_de_donnees;
   ```

### Exécution du Projet

Pour exécuter le projet, suivez ces étapes :

1. Clonez le dépôt.
2. Assurez-vous d'avoir **Java 8 ou une version ultérieure** installé.
3. Accédez au répertoire du projet et utilisez la commande suivante pour lancer l'application :
   
   ./mvnw spring-boot:run
  

---

Cette documentation mise à jour fournit des instructions claires sur la façon de configurer et d'utiliser MariaDB avec votre application Spring Boot, en plus de la configuration H2 existante.