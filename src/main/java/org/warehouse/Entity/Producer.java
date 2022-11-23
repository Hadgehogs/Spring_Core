package org.warehouse.Entity;

import lombok.SneakyThrows;

public class Producer {
    @SneakyThrows
    protected void shipmentProduct(Warehouse destination, Class productType, Integer productCount) {
        for(int counter = 1; counter <= productCount; counter++)
        {
            Product product=(Product) productType.getDeclaredConstructor().newInstance();
            destination.AddProduct(product);
        }

    }
}
