package be.oak3.persistence;

import be.oak3.model.Berekenbaar;
import be.oak3.model.Product;

public interface Bestelling extends Berekenbaar {

    abstract void voegProductToe(Product product);
    abstract void sorteer();
    abstract void sorteerOpMerk();
    abstract void sorteerOpVolume();
    abstract void toonPerMerk(String merk);
    abstract void toonGoedkopeProducten();
    abstract Product zoekDuursteProduct();
    abstract void toonParfums();
}
