package ru.mirea.aod_practice12;
import java.util.Scanner;

import static java.lang.System.out;

public class App {
    FileWorking fw;
    public App() {
        fw=new FileWorking("LibraryCards");
        fw.fillFileFirstTime();
        while (true){
            out.println("Если вы хотите увидеть содержимое файла, введите 1,\nнайти элемент - 2,\nудалить элемент - 3,\nвыйти - 4.");
            Scanner in = new Scanner(System.in);
            int choice=in.nextInt();
            switch (choice){
                case 1:{
                    fw.printArray();
                    break;
                }
                case 2: {
                    out.println("Введите номер читательского билета:");
                    int number=in.nextInt();
                    out.println("Результат: "+fw.find(number));
                    break;
                }
                case 3: {
                    out.println("Введите номер читательского билета:");
                    int number=in.nextInt();
                    out.println("Результат: "+fw.remove(number));
                    break;
                }
                case 4:{
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        new App();
    }
}
