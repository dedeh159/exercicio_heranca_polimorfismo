package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        List<Product> products = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Common, used or imported (c/u/i)? ");
            char choice = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Price: ");
            double price = sc.nextDouble();
            sc.nextLine();
            if (choice == 'c') {
                products.add(new Product(name, price));
            } else if (choice == 'u') {
                System.out.print("Manufactured date (DD/MM/YYYY): ");
                String d = sc.nextLine();
                Date date = sdf.parse(d);
                products.add(new UsedProduct(name, price, date));
            } else {
                System.out.print("Custom fee: ");
                double fee = sc.nextDouble();
                products.add(new ImportedProduct(name, price, fee));
            }
        }
        for (Product p : products) {
            System.out.println(p.priceTag());
        }


        sc.close();
    }
}
