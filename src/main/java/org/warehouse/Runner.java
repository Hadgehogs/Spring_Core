package org.warehouse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.warehouse.Config.Config;

public class Runner {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Business.shipmentProducts(context);
        Business.armyMethod(context);
        Business.SellProducts(context);
        Business.ShowResult(context);
    }
}
