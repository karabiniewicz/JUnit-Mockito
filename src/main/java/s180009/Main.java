package s180009;

import s180009.controller.BeerController;
import s180009.initialize.InitializeTestData;
import s180009.repository.BeerRepository;
import s180009.view.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        BeerController beerController = new BeerController(new BeerRepository());

        InitializeTestData initializeTestData = new InitializeTestData(beerController);
        initializeTestData.init();

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.print("command: ");
            String command = scanner.next();
            switch (command) {
                case "BeerSave":
                    new BeerSave(beerController).display();
                    break;
                case "BeerDelete":
                    new BeerDelete(beerController).display();
                    break;
                case "BeerFind":
                    new BeerFind(beerController).display();
                    break;
/*
                case "viewAll":
                    new DataView(beerController).display();
                    break;
*/
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
