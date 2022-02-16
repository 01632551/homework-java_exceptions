package ru.netology.manager;

import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    private ProductRepository repository;

    public ProductManager (ProductRepository repository){
        this.repository = repository;
    }

    public void addProduct(Product product){
        repository.save(product);
    }

    public Product[] getAll(){
        return repository.findAll();
    }
}
