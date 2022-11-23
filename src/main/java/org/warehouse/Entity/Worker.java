package org.warehouse.Entity;

import org.springframework.stereotype.Component;

@Component
public class Worker {
    public void ArmyMethod(Product product)
    {
        product.setBroken(true);
    }
}
