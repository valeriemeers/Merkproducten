package be.oak3.model;

import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;

public abstract class Product implements Comparable<Product> {
    private int productNummer;
    private String merk;
    private String naam;
    private int volume;
    private double prijs;

    public Product(int productNummer, String merk, String naam, int volume, double prijs) {
        this.setProductNummer(productNummer);
        this.setMerk(merk);
        this.setNaam(naam);
        this.setVolume(volume);
        this.setPrijs(prijs);
    }

    public int getProductNummer() {
        return productNummer;
    }

    public void setProductNummer(int productNummer) {
        this.productNummer = productNummer;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public String getProductCode() {
//        String productCode;
//        StringBuilder builder = new StringBuilder();
//        productCode = builder.append(getMerk().substring(0, 3)).append(getNaam().substring(0, 3)).append(String.valueOf(getVolume())).toString();
//        return productCode.replace(' ', '_').toUpperCase();

        //String productCode;
        //return StringUtils.left(getMerk(),3);
        return StringUtils.join(StringUtils.left(getMerk(),3),StringUtils.left(getNaam(),3),String.valueOf(getVolume())).toUpperCase().replace(' ', '_');
    }

    public static Comparator<Product> sorteerOpMerkNaam() {
        return (p1, p2) -> p1.getMerk().compareTo(p2.getMerk());
    }

    //voor java8
//    Comparator<Product> comparator = new Comparator<Product>() {
//        @Override
//        public int compare(Product o1, Product o2) {
//            return p1.getMerk().compareTo(p2.getMerk());
//        }
//    };
//    return comparator;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return productNummer == product.productNummer;
    }

    @Override
    public int hashCode() {
        return productNummer;
    }

    @Override
    public int compareTo(Product p){
        return productNummer-p.getProductNummer();
    }

    @Override
    public String toString(){
        StringBuilder SB = new StringBuilder();
        return SB.append(getProductNummer()).append(" Merk: ").append(String.format("%-20s",getMerk())).append("Naam: ").append(String.format("%-30s",getNaam())).append("Volume: ").append(String.format("%5s",getVolume()+"ml")).append(String.format("%10s","Prijs: ")).append(String.format("%5.2f",getPrijs())).append(String.format(" Code: ","%9s")) + getProductCode();
    }
}
