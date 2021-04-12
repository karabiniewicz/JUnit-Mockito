package s180009.view;

import s180009.controller.BeerManagement;

import java.util.Scanner;

public class BeerFind implements View {
    private final BeerManagement beerManagement;

    public BeerFind(BeerManagement beerManagement) {
        this.beerManagement = beerManagement;
    }

    @Override
    public void display() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("name: ");
        String name = scanner.nextLine();

        String save = beerManagement.find(name);
        System.out.println(save);
    }
}
