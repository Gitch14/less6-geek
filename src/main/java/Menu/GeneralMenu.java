package Menu;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GeneralMenu {

    Scanner scanner = new Scanner(System.in);
    MenuTask1 menuTask1 = new MenuTask1();
    MenuTask2 menuTask2 = new MenuTask2();
    MenuTask3 menuTask3 = new MenuTask3();

    public int menu1() throws IOException {


        int n1 = 0;
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
            n1 = scanner.nextInt();
        } while (n1 == 1);

        return 1;
    }

    public int menu2() throws IOException {


        int n2 = 0;
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
            n2 = scanner.nextInt();
        } while (n2 == 1);

        return 2;
    }

    public int menu3() throws IOException {
        File file = new File("task4.sql");
        file.createNewFile();

        FileWriter writer = new FileWriter(file);

        int n3 = 0;
        do {

            System.out.println("Введите номер для навигации в меню : ");
            int m = scanner.nextInt();
            switch (m) {
                case 1 -> menuTask3.menu1();
                case 2 -> menuTask3.menu2();
                case 3 -> menuTask3.menu3();
                case 4 -> menuTask3.menu4();
                case 5 -> menuTask3.menu5();
                case 6 -> menuTask3.menu6();
                case 7 -> menuTask3.menu7();

            }
            System.out.println("Введите 1 для перехода в меню");
            n3 = scanner.nextInt();
        } while (n3 == 1);
        writer.close();
        return 3;
    }
}
