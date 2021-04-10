package s180009.view;

import s180009.controller.BeerController;
import s180009.entity.Beer;

import java.util.Scanner;

public class BeerSave implements View {
    private final BeerController beerController;

    public BeerSave(BeerController beerController) {
        this.beerController = beerController;
    }

    @Override
    public void display() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("name: ");
        String name = scanner.nextLine();
        System.out.print("price: ");
        long price = Long.parseLong(scanner.nextLine());

        String save = beerController.save(name, price);
        System.out.println(save);
    }
}
