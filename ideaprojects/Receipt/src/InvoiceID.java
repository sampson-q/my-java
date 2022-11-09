import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class InvoiceID {
    static void displayReceipt(BuyerID info, PricesID price, ItemsID item, DateID date, PurchaseID buy) {
        buy.totals(item, price);

        try {
            FileWriter tmaReceipt = new FileWriter("Tema Mall Receipt.txt");
            PrintWriter wrtFile = new PrintWriter(tmaReceipt);

            wrtFile.println("\n-/-\tThe Only Habour City Mall\t-/-");
            wrtFile.println("=====================================");
            wrtFile.println("Customer: " + info.getName());
            wrtFile.println("Contact Number: " + info.getPhone());
            wrtFile.println("Order Date: " + date.getOrderDay() + " - " + date.getOrderMonth() + " - " + date.getOrderYear());

            wrtFile.println("-------------------------------------");
            wrtFile.println("Items\tQty\tUnit/Price\tSub-Total");
            wrtFile.println("Shirts\t" + item.getNumberOfShirt() + "\t$" + price.getPriceShirt() + "\t\t$" + buy.getSubTotalShirts());
            wrtFile.println("Skirts\t" + item.getNumberOfSkirt() + "\t$" + price.getPriceSkirt() + "\t\t$" + buy.getSubTotalSkirts());
            wrtFile.println("Scarfs\t" + item.getNumberOfScarf() + "\t$" + price.getPriceScarf() + "\t\t$" + buy.getSubTotalScarfs());
            wrtFile.println("-------------------------------------");

            wrtFile.println("Number of Items: " + buy.getTotalNumberOfItems());
            wrtFile.println("Total Order: $" + buy.getTotalPurchase());
            wrtFile.println("Total Discount: $" + buy.getTotalDiscount());
            wrtFile.println("=====================================");
            wrtFile.println("Created by Hash 👽, ##4545");
            wrtFile.close();

        } catch (IOException e) {
            System.out.println("Error!");
        }
    }
}
