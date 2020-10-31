package ru.mirea.aod_practice12;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.err;
import static java.lang.System.out;

public class FileWorking {
    private String fileName;
    private ArrayList <LibraryCard> libraryCards=new ArrayList<>();

    public FileWorking(String fileName) {
        this.fileName ="src/ru/mirea/aod_practice12/"+fileName+".txt";
    }


    public void fillFileFirstTime(){
        libraryCards.add(new LibraryCard(11111,"Anna","Minina 1"));
        libraryCards.add(new LibraryCard(11112,"Alla","Minina 2"));
        libraryCards.add(new LibraryCard(11113,"Ana","Minina 3"));
        libraryCards.add(new LibraryCard(11114,"Alex","Minina 4"));
        libraryCards.add(new LibraryCard(11115,"Karl","Minina 5"));
        libraryCards.add(new LibraryCard(11116,"Marina","Minina 6"));
        libraryCards.add(new LibraryCard(11117,"Elza","Minina 7"));
        libraryCards.add(new LibraryCard(11118,"Olga","Minina 8"));
        libraryCards.add(new LibraryCard(11119,"Tomas","Minina 9"));
        libraryCards.add(new LibraryCard(11120,"Timur","Minina 10"));

        saveArrayToFile();
    }
    public void saveArrayToFile(){//сохраняет содержимое массива в файл
        try {
            FileWriter writer = new FileWriter(fileName);

            while (!libraryCards.isEmpty()) {
                writer.write(libraryCards.remove(0).toString()+ "\n");
            }
            writer.flush();
        }
        catch (Exception e) {
            err.println("Такого файла нет!");
        }
    }
    public void fillArray() {//заполняет массив карточками из файла
        libraryCards.clear();
        try {
            FileReader reader = new FileReader(fileName);
            Scanner in = new Scanner(reader);
            while (in.hasNextLine()) {
                String string = in.nextLine();
                String[] arr=string.split("; ");
                libraryCards.add(new LibraryCard( Integer.parseInt(arr[0]),arr[1],arr[2]));
            }
        }
        catch (FileNotFoundException e) {
            err.println("Такого файла нет!");
        }
    }
    public void printArray(){//вывод содержимого файла
        if(libraryCards.isEmpty()) fillArray();
        for(LibraryCard lc:libraryCards) out.println(lc);
    }

    public LibraryCard find(int number){//поиск карточки
        if(libraryCards.isEmpty()) fillArray();
        LibraryCard lc=null;
        for (LibraryCard libraryCard : libraryCards) {
            if (number == libraryCard.getLibraryNumber()) {
                lc = libraryCard;
                break;
            }
        }
        return lc;
    }
    public LibraryCard remove(int number){//удаляет карточку, путем замены её последней карточкой
        if(libraryCards.isEmpty()) fillArray();
        int index=libraryCards.indexOf(find(number));
        LibraryCard lc=libraryCards.remove(index);
        libraryCards.add(index,libraryCards.remove(libraryCards.size()-1));
        saveArrayToFile();
        return lc;
    }
}
