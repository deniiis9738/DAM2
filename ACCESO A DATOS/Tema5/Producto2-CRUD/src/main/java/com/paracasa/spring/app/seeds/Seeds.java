package com.paracasa.spring.app.seeds;

import com.paracasa.spring.app.model.Menu;
import com.paracasa.spring.app.model.Product;
import com.paracasa.spring.app.repository.MenuRepository;
import com.paracasa.spring.app.repository.ProductRepository;


public class Seeds {
    private MenuRepository menuRepository;
    private ProductRepository productRepository;

    public Seeds(MenuRepository menuRepository, ProductRepository productRepository)  {
        this.menuRepository = menuRepository;
        this.productRepository = productRepository;
    }

    public void generateSeeds(){
        Menu menuLibanes = new Menu("Libanes", 30.5);
        Menu menuVeggie = new Menu("Veggie", 20);
        Menu menuBurguer = new Menu("Libanes", 25);
        menuRepository.save(menuLibanes);
        menuRepository.save(menuVeggie);
        menuRepository.save(menuBurguer);

        Product productPollo = new Product("Pollo",5.00);
        Product productSeitan = new Product("Seitan",7.00);
        Product productTofu = new Product("Tofu",6.50);
        Product productTernera = new Product("Ternera",5.50);
        Product productSetas = new Product("Setas",2.00);
        productRepository.save(productPollo);
        productRepository.save(productSeitan);
        productRepository.save(productTofu);
        productRepository.save(productTernera);
        productRepository.save(productSetas);



    }
}




