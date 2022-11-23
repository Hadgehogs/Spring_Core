package org.warehouse.Entity;

import org.springframework.stereotype.Component;

@Component
public class Absolut extends Producer {
    public void shipmentProduct(Warehouse destination, Integer count) {
        super.shipmentProduct(destination, Vodka.class, count);
    }
}
