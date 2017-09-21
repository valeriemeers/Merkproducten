package be.oak3.persistence;

import be.oak3.model.Parfum;
import be.oak3.model.Product;
import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class BestellingImpl implements Bestelling {

    // private List<Product> bestelling = new ArrayList<>();
    static List<Product> bestelling = Lists.newArrayList();
    private static int productNummer = 1000;
    private static org.apache.logging.log4j.Logger logger = org.apache.logging.log4j.LogManager.getLogger();

    public void voegProductToe(Product product){
        product.setProductNummer(productNummer++);
        bestelling.add(product);
    }

    @Override
    public void sorteer() {
       bestelling.stream().sorted().forEach(logger::debug);
    }

    @Override
    public void sorteerOpMerk() {
        bestelling.stream().sorted((p1, p2) -> p1.getMerk().compareTo(p2.getMerk())).forEach(System.out::println);
    }

    @Override
    public void sorteerOpVolume() {
        bestelling.stream().sorted((p1,p2)-> p1.getVolume()-p2.getVolume()).forEach(System.out::println);
    }

    @Override
    public void toonPerMerk(String merk) {
        bestelling.stream().filter(p -> p.getMerk().equals(merk)).forEach(productVanMerk -> System.out.println(productVanMerk));
    }

    @Override
    public void toonGoedkopeProducten() {
        bestelling.stream().filter(p -> p.getPrijs() <= 50).forEach(pGoedkoop -> System.out.println(pGoedkoop));
    }

    @Override
    public Product zoekDuursteProduct() {
//        double duurste = 0;
//        Product duursteP = null;
//        for (int i = 0; i < bestelling.size(); i++) {
//            if (bestelling.get(i).getPrijs() > duurste){
//                duursteP = bestelling.get(i);
//                duurste = bestelling.get(i).getPrijs();
//            }
//        }
//        return duursteP;
// mét lambda, maar foute waarde door casting naar double
//        return bestelling.stream().max((p1, p2) -> (int) (p1.getPrijs()-p2.getPrijs())).orElse(null);
// mét lambda met BigDecimal
//        return bestelling.stream().max((p1, p2) -> BigDecimal.valueOf(p1.getPrijs()).compareTo(BigDecimal.valueOf(p2.getPrijs()))).orElse(null);
            return bestelling.stream().max(Comparator.comparing(Product::getPrijs)).orElse(null);
    }

    public void toonParfums() {
        bestelling.stream().filter(p -> p instanceof Parfum).forEach(System.out::println);
    }

    @Override
    public double totalePrijs() {
        return bestelling.stream().mapToDouble(Product::getPrijs).sum();
    }
}
