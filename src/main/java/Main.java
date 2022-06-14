import Menu.GeneralMenu;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        GeneralMenu gMenu = new GeneralMenu();
        Scanner scanner = new Scanner(System.in);


        int n = 0;
        do {
        System.out.println("Введите номер нужного меню : ");
        int m = scanner.nextInt();
        switch (m) {
            case 1 -> gMenu.menu1();
            case 2 -> gMenu.menu2();
            case 3 -> gMenu.menu3();
        }
            System.out.println("Введите 1 для перехода в меню");
            n = scanner.nextInt();
        } while (n == 1);
    }
}
