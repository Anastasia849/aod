package ru.mirea.aod_practice11;

public class HashTable {
    private DataItem[] hashArray; // Массив ячеек хеш-таблицы
    private int arraySize;
    private DataItem nonItem; // Для удаленных элементов

    HashTable(int size) // Конструктор
    {
        arraySize = size;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1);
    }

    // -------------------------------------------------------------
    public void displayTable() {
        System.out.println("Table: ");
        for (int j = 0; j < arraySize; j++) {
            if (hashArray[j] != null)
                System.out.println(hashArray[j]+ " ");
            else
                System.out.println("** ");
        }
    }

    // -------------------------------------------------------------
    public int hashFunc1(long key) {
        return (int)(key % arraySize);
    }

    // -------------------------------------------------------------
    public int hashFunc2(long key) {
        // Возвращаемое значение отлично от нуля, меньше размера массива,
        // функция отлична от хеш-функции 1
        // Размер массива должен быть простым по отношению к 5, 4, 3 и 2
        return (int)(5 - key % 5);
    }

    // -------------------------------------------------------------
    // Вставка элемента данных
    public void insert(long key, DataItem item)
    // (Метод предполагает, что таблица не заполнена)
    {
        int hashVal = hashFunc1(key); // Хеширование ключа
        int stepSize = hashFunc2(key); // Вычисление смещения
        // Пока не будет найдена
        boolean flag=true;
        while (hashArray[hashVal] != null && // пустая ячейка или -1
                hashArray[hashVal].getKey() != -1) {
            hashVal += stepSize; // Прибавление смещения
            hashVal %= arraySize; // Возврат к началу
            flag=false;
        }
        if(!flag){
            while (find(key)!=null){
            key+=arraySize;
            item.setKey(key);
            }
        }
        hashArray[hashVal] = item; // Вставка элемента
    }

    public DataItem delete(long key) // Удаление элемента данных
    {
        int hashVal = hashFunc1(key); // Хеширование ключа
        int stepSize = hashFunc2(key); // Вычисление смещения
        while (hashArray[hashVal] != null) // Пока не найдена пустая ячейка
        { // Ключ найден?
            if (hashArray[hashVal].getKey() == key) {
                DataItem temp = hashArray[hashVal]; // Временное сохранение
                hashArray[hashVal] = nonItem; // Удаление элемента
                return temp; // Метод возвращает элемент
            }
            hashVal += stepSize; // Прибавление смещения
            hashVal %= arraySize; // Возврат к началу
        }
        return null; // Элемент не найден
    }

    public DataItem find(long key) // Поиск элемента с заданным ключом
    // (Метод предполагает, что таблица не заполнена)
    {
        int hashVal = hashFunc1(key); // Хеширование ключа
        int stepSize = hashFunc2(key); // Вычисление смещения
        while (hashArray[hashVal] != null) // Пока не найдена пустая ячейка
        { // Ключ найден?
            if (hashArray[hashVal].getKey() == key)
                return hashArray[hashVal]; // Да, метод возвращает элемент
            hashVal += stepSize; // Прибавление смещения
            hashVal %= arraySize; // Возврат к началу
        }
        return null; // Элемент не найден
    }
}
