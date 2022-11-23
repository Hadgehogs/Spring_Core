package org.warehouse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.warehouse.Entity.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Business {
    public static void shipmentProducts(AnnotationConfigApplicationContext context) {
        Warehouse warehouse = context.getBean(Warehouse.class);
        Absolut absolut = context.getBean(Absolut.class);
        absolut.shipmentProduct(warehouse, 3);
        Aist aist = context.getBean(Aist.class);
        aist.shipmentProduct(warehouse, 3);
    }

    public static void armyMethod(AnnotationConfigApplicationContext context) {
        Warehouse warehouse = context.getBean(Warehouse.class);
        HashMap<Worker, String> workersMap = new HashMap<>();
        // Зеля портит водку, Мишка - велики
        workersMap.put(warehouse.getZelya(), Vodka.class.getSimpleName());
        workersMap.put(warehouse.getMishka(), Bicycle.class.getSimpleName());
        HashMap<String, List<Product>> products = warehouse.getProducts();
        workersMap.forEach((worker, productType) -> {
            List<Product> productsList = products.get(productType);
            for (int counter = 0; counter < productsList.size(); counter++) {
                if ((counter + 1) % 2 == 0) {
                    worker.ArmyMethod(productsList.get(counter));
                }
            }
        });
    }
    public static void SellProducts(AnnotationConfigApplicationContext context) {
        Warehouse warehouse = context.getBean(Warehouse.class);
        HashMap<Buyer, String> BuyerMap = new HashMap<>();
        // Петрович берет только сломаную водку. Решар только рабочие велосипеды.
        BuyerMap.put(context.getBean(Petrovich.class), Vodka.class.getSimpleName());
        BuyerMap.put(context.getBean(Reshar.class), Bicycle.class.getSimpleName());
        HashMap<String, List<Product>> products = warehouse.getProducts();
        BuyerMap.forEach((buyer, productType) -> {
            Boolean needBroken=productType.equals("Vodka");
            List<Product> productsList = products.get(productType);
            List<Product> filteredProductsList = productsList.stream().filter(product -> product.isBroken() == needBroken).
                    collect(Collectors.toList());
            filteredProductsList.forEach(product -> buyer.BuyProduct(warehouse,product));

        }
        );
    }

    public static void ShowResult(AnnotationConfigApplicationContext context) {
        Warehouse warehouse = context.getBean(Warehouse.class);
        System.out.println(warehouse);

        System.out.println(context.getBean(Petrovich.class));
        System.out.println(context.getBean(Reshar.class));

    }
}
