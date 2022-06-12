import Menu.MenuTask1;
import Menu.MenuTask2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MenuTask1 menuTask1 = new MenuTask1();
        MenuTask2 menuTask2 = new MenuTask2();

        /*
        int n = 0;
        do {

            System.out.println("Введите номер для навигации в меню : ");
            int m = scanner.nextInt();
            switch (m) {
                case 1 -> menuTask1.menu1();
                case 2 -> menuTask1.menu2();
                case 3 -> menuTask1.menu3();
                case 4 -> menuTask1.menu4();
                case 5 -> menuTask1.menu5();
                case 6 -> menuTask1.menu6();
                case 7 -> menuTask1.menu7();
                case 8 -> menuTask1.menu8();
                case 9 -> menuTask1.menu9();
                case 10 -> menuTask1.menu10();

            }
            System.out.println("Введите 1 для перехода в меню");
            n = scanner.nextInt();
        } while (n == 1); */
        int n = 0;
        do {

            System.out.println("Введите номер для навигации в меню : ");
            int m = scanner.nextInt();
            switch (m) {
                case 1 -> menuTask2.menu1();
                case 2 -> menuTask2.menu2();
                case 3 -> menuTask2.menu3();
                case 4 -> menuTask2.menu4();
                case 5 -> menuTask2.menu5();
                case 6 -> menuTask2.menu6();
                case 7 -> menuTask2.menu7();
                case 8 -> menuTask2.menu8();
                case 9 -> menuTask2.menu9();
                case 10 -> menuTask2.menu10();

            }
            System.out.println("Введите 1 для перехода в меню");
            n = scanner.nextInt();
        } while (n == 1);



    }
}
