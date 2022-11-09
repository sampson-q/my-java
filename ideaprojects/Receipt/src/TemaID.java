import java.util.Scanner;

public class TemaID {
    public static void main(String[] args) {
        try {
            Scanner scInt = new Scanner(System.in);
            Scanner scString = new Scanner (System.in);
            Scanner scDouble = new Scanner (System.in);

            System.out.println("Welcome to Tema Mall");

            System.out.print("Please enter name of buyer: ");
            String name = scString.nextLine();

            System.out.print("Please enter phone number: ");
            int phone = scInt.nextInt();

            BuyerID info = new BuyerID(name, phone);

            System.out.print("\nWhat is the price of one Shirt: $");
            double priceShirt = scDouble.nextDouble();

            System.out.print("What is the price of one Skirt: $");
            double priceSkirt = scDouble.nextDouble();

            System.out.print("What is the price of one Scarf: $");
            double priceScarf = scDouble.nextDouble();

            PricesID prices = new PricesID(priceShirt, priceSkirt, priceScarf);

            System.out.print("\nEnter number of Shirts purchased: ");
            int numShirt = scInt.nextInt();

            System.out.print("\nEnter number of Skirts purchased: ");
            int numSkirt = scInt.nextInt();

            System.out.print("\nEnter number of Scarf purchased: ");
            int numScarf = scInt.nextInt();

            ItemsID items = new ItemsID(numShirt, numSkirt, numScarf);

            System.out.println("\nEnter details of transaction date below");
            System.out.println("*****************************************");

            System.out.print("Enter Month-name: ");
            String month = scString.next();

            System.out.print("Enter Day-number: ");
            String day = scString.next();

            System.out.print("Enter year: ");
            String year = scString.next();

            DateID date = new DateID(month, day, year);

            PurchaseID pur = new PurchaseID();

            InvoiceID.displayReceipt(info, prices, items, date, pur);

        } catch (Exception e) {
            System.out.println("Wrong Input");
        }
    }
}
