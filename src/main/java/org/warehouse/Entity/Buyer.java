package org.warehouse.Entity;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class Buyer {
    private List<Product> products=new ArrayList<>();

    public void BuyProduct(Warehouse warehouse, Product product)
    {
        if (warehouse.SellProduct(product)) {
            products.add(product);
        }
    }
}
