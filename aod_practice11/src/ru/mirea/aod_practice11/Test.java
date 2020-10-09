package ru.mirea.aod_practice11;

public class Test {

    public static void main(String[] args) {
        HashTable hashTable=new HashTable(37);
        DataItem dataItem;
        for(int i =0; i<10;i++){//вставка 10 элементов
            dataItem=new DataItem(111111111110L+i,"Tomas","Our Earth "+(i+1));
            hashTable.insert(dataItem.getKey(),dataItem);
        }
        for(int i =0; i<10;i++){//вставка 10 элементов с такими же ключами для вызова коллизий
            dataItem=new DataItem(111111111110L+i,"Albert","The sea "+(i+1));
            hashTable.insert(dataItem.getKey(),dataItem);
        }
        hashTable.displayTable();
    }
}
