package org.warehouse.Entity;

import org.springframework.stereotype.Component;

@Component
public class Aist extends Producer{
    public void shipmentProduct(Warehouse destination, Integer count) {
        super.shipmentProduct(destination, Bicycle.class, count);
    }
}
