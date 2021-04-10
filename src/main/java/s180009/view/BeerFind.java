package s180009.view;

import s180009.controller.BeerController;

import java.util.Scanner;

public class BeerFind implements View {
    private final BeerController beerController;

    public BeerFind(BeerController beerController) {
        this.beerController = beerController;
    }

    @Override
    public void display() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("name: ");
        String name = scanner.nextLine();

        String save = beerController.find(name);
        System.out.println(save);
    }
}
