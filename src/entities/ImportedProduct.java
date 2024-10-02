package entities;

public class ImportedProduct extends Product {
    private double customsFee;

    public ImportedProduct() {
    }

    public ImportedProduct(String name, double price, double customsFee) {
        super(name, price);
        this.customsFee = customsFee;
    }

    public double getCustomsFee() {
        return customsFee;
    }

    public void setCustomsFee(double customsFee) {
        this.customsFee = customsFee;
    }

    @Override
    public String priceTag() {
        return this.getName() +
                " $ " +
                String.format("%.2f",this.getPrice()+ this.getCustomsFee()) +
                " (Custom fee: $ " + String.format("%.2f",this.getCustomsFee())
                + ")";
    }
}


