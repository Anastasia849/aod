package ru.mirea.aod_practice9;

public class ArrayQueue {

    private Object[] queue;
    private int maxSize; // максимальное количество элементов в очереди
    private int nElem;  // текущее количество элементов в очереди
    private int header;
    private int tail;

    public ArrayQueue() {
        maxSize = 10;
        queue = new Object[maxSize];
        nElem = 0;
        header = 0;
        tail = -1;
    }

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        queue = new Object[maxSize];
        nElem = 0;
        header = 0;
        tail = -1;
    }

    public void push(Object o) {

        if (tail == maxSize - 1) { // Если массив полон
            int newMaxSize = (maxSize * 3) / 2 + 1; // Определяем новый размер массива
            Object[] new_queue = new Object[newMaxSize]; // Создаем новый массив

            System.arraycopy(queue, 0, new_queue, 0, maxSize); // Копируем все элименты из старого массива в новый

            this.queue = new_queue; // Переопределяем новый массив
            this.maxSize = newMaxSize; // Переопределяем новый размер массива
        }

        queue[++tail] = o;  //увеличение индекс последнего эллемента
        nElem++;  // увеличение количества элементов в очереди
    }
    public Object front(){
        return queue[header];
    }
    public Object back(){
        return queue[tail];
    }
    public Object pop() {
        Object o = queue[header++]; // получаем первый элемент из очереди

        if (header == maxSize) { // циклический перенос
            header = 0;
        }
        nElem--; // уменьшаем количество элементов в очереди
        return o;
    }


    public boolean isEmpty() {
        return (nElem == 0);
    }

    public int getSize() {
        return nElem;
    }
    public boolean isFilled(){
        return (nElem==maxSize);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        for (int i = tail; i >= header; i--) {
            output.append(queue[i].toString()).append(' ');
        }

        return output.toString();
    }
}
