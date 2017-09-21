package be.oak3.persistence;

import be.oak3.model.Product;

import java.util.List;


public class TestApp {
    //private static Logger logger = Logger.getLogger(TestApp.class .getName());

    public static void main(String[] args) {

        System.out.printf("Oplossing van %s %s\n", "Kenneth Van Gijsel ",
                "Java Instructeur");

        Bestelling bestelling = new BestellingImpl();
        List<Product> lijst = Data.getData();

        for (Product artikel : lijst) {
            bestelling.voegProductToe(artikel);
        }

        System.out.println("Lijst gesorteerd op natuurlijke volgorde: ");
        bestelling.sorteer();

        System.out.println("Lijst gesorteerd op merknaam: ");
        bestelling.sorteerOpMerk();

        System.out.println("Lijst gesorteerd op volume: ");
        bestelling.sorteerOpVolume();

        System.out.println("Van het merk Georgio Armani:");
        bestelling.toonPerMerk("Georgio Armani");

        System.out.println("Alle Parfums:");
        bestelling.toonParfums();

        System.out.println("Alle producten onder €50; ");
        bestelling.toonGoedkopeProducten();

        Product product = bestelling.zoekDuursteProduct();
        System.out.println("Duurste product:\n" + product);

        System.out.printf("\nTotale prijs: €%.2f", bestelling.totalePrijs());
        //logger.info("Totale prijs: €" + bestelling.totalePrijs());

    }
}
