package com.Question3;
import java.util.Scanner;

public class Question3 {
    public static void SubMenu(String message) {
        System.out.print(message);
    }

    public static void main(String[] args) {
        Scanner UserInput = new Scanner(System.in);
        boolean QuitOption = false;

        do {
            System.out.print("\n\n\n\t\t=========International Heist Bank=========\n\t\t\t\t\tEnter [Q] to Exit\n");
            System.out.print("\t\t\t\t--------------------------\n");
            System.out.print("\t\t[1] Send Money \t\t\t[4] Receive Money\n");
            System.out.print("\t\t[2] Check Balance \t\t[5] Make Deposit\n");
            System.out.print("\t\t[3] Make Payment \t\t[6] Other Services\n");
            System.out.print("\n\t\t-> Enter Choice: ");

            String UserChoice = UserInput.next();
            if (UserChoice.equalsIgnoreCase("q"))
                QuitOption = true;

            else if (UserChoice.equals("1"))
                SubMenu("\n\t\t\t\t\t [1] Send Money  \n\t\t\t\t--------------------------\n\t\t-> Enter Amount: GHC 500.00\n\t\t<- Money sent to #223200IHB\n\t\t\t\t--------------------------");

            else if (UserChoice.equals("2"))
                SubMenu("\n\t\t\t\t\t[2] Check Balance \n\t\t\t\t--------------------------\n\t\t-> Enter PIN: 7893\n\t\t<- Your Balance is GHC 500.00\n\t\t\t\t--------------------------");

            else if (UserChoice.equals("3"))
                SubMenu("\n\t\t\t\t\t  [3] Make Payment \n\t\t\t\t--------------------------\n\t\t-> Payment For: 5 Cars\n\t\t<- Payment made successfully!\n\t\t\t\t--------------------------");

            else if (UserChoice.equals("4"))
                SubMenu("\n\t\t\t\t\t[4] Receive Money \n\t\t\t\t--------------------------\n\t\t<- Money received from account #8898IHB\n\t\t\t\t--------------------------");

            else if (UserChoice.equals("5"))
                SubMenu("\n\t\t\t\t\t[5] Make Deposit \n\t\t\t\t--------------------------\n\t\t-> Amount (GHC): 50000.00\n\t\t<- Deposit made successfully!\n\t\t\t\t--------------------------");

            else if (UserChoice.equals("6"))
                SubMenu("\n\t\t\t\t\t[6] Other Services \n\t\t\t\t--------------------------\n\t\t<- No other services at the moment\n\t\t\t\t--------------------------");
        } while (!QuitOption);
    }
}