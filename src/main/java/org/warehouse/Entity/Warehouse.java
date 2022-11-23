package org.warehouse.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Component
@Getter
@Setter
@ToString
public class Warehouse {
    @ToString.Exclude
    private Worker Mishka;
    @ToString.Exclude
    private Worker Zelya;
    private HashMap<String, List<Product>> products;

    @Autowired
    public Warehouse(Worker Mishka, Worker Zelya) {
        this.Mishka = Mishka;
        this.Zelya = Zelya;
        this.products = new HashMap<String, List<Product>>();
        this.products.put(Vodka.class.getSimpleName(), new ArrayList<Product>());
        this.products.put(Bicycle.class.getSimpleName(), new ArrayList<Product>());
    }

    public void AddProduct(Product product) {
        List targetList = this.products.get(product.getClass().getSimpleName());
        targetList.add(product);
    }

    public boolean SellProduct(Product product) {
        List targetList = this.products.get(product.getClass().getSimpleName());
        Optional searchResult = targetList.stream().
                filter(currentProduct -> currentProduct.equals(product)).
                findAny();
        if (searchResult.isPresent()) {
            targetList.remove(searchResult.get());
            return true;
        }
        return false;
    }
}
