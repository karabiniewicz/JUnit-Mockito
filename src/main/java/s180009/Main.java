package s180009;

import s180009.controller.BeerManagement;
import s180009.repository.BeerBase;
import s180009.view.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        BeerManagement beerManagement = new BeerManagement(new BeerBase());

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.print("command: ");
            String command = scanner.next();
            switch (command) {
                case "BeerSave":
                    new BeerSave(beerManagement).display();
                    break;
                case "BeerDelete":
                    new BeerDelete(beerManagement).display();
                    break;
                case "BeerFind":
                    new BeerFind(beerManagement).display();
                    break;
                case "quit":
                    exit = true;
                    break;
                default:
                    System.out.println("BeerSave|BeerDelete|BeerFind||quit");
            }
            System.out.println();
        }
    }
}