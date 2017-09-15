package be.oak3.model;

import be.oak3.model.Product;

public class testMain {
    public static void main(String[] args) {
            Product product1 = new Parfum(154, "Chanel", "Coco Mademoiselle", 100, 45.25) {
            };
            Product product2 = new Parfum( 130, "DKNY", "Be Delicious Woman", 75, 59.78);

        System.out.println(product1.getProductCode());
        System.out.println(product2.getProductCode());

        System.out.println(product1);
        System.out.println(product2);
    }
}
