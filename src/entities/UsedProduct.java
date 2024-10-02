package entities;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

public class UsedProduct extends Product {
    private Date date;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private final DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public UsedProduct() {
    }

    public UsedProduct(String name, double price, Date date) {
        super(name, price);
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String priceTag() {
        return
                this.getName() +
                "(used) $ " +
                String.format("%.2f",this.getPrice()) +
                "(Manufactured date: " +
                dateFormat.format(this.date) + ")";
    }
}
