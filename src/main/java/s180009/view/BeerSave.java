package s180009.view;

import s180009.controller.BeerManagement;

import java.util.Scanner;

public class BeerSave implements View {
    private final BeerManagement beerManagement;

    public BeerSave(BeerManagement beerManagement) {
        this.beerManagement = beerManagement;
    }

    @Override
    public void display() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("name: ");
        String name = scanner.nextLine();
        System.out.print("percent: ");
        float percent = Float.parseFloat(scanner.nextLine());

        String save = beerManagement.save(name, percent);
        System.out.println(save);
    }
}
