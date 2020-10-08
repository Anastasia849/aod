package ru.mirea.aod_practice9;

public class LinkedQueue {
    private class Unit {
        Unit next;
        Unit previous;
        Object o;

        public Unit(Unit next, Unit previous, Object o) {
            this.next = next;
            this.previous = previous;
            this.o = o;
        }
    }

    private int nElem;  // текущее количество элементов в очереди
    private int maxSize;
    private Unit header;
    private Unit tail;

    public LinkedQueue() {
        this.nElem = 0;
        this.header = null;
        this.tail = null;
    }
    public LinkedQueue(int maxSize) {
        this.nElem = 0;
        this.header = null;
        this.tail = null;
        this.maxSize=maxSize;
    }
    public boolean push(Object o) {
        if (header == null) {
            header = new Unit(null, tail, o);
        } else if (tail == null) {
            tail = new Unit(header, null, o);
            header.previous = tail;
        } else {
            Unit temp = new Unit(tail, null, o);
            tail.previous = temp;
            tail = temp;
        }
        nElem++;
        return true;
    }


    public Object pop() {
        Object o;
        if (header == null) {
            return null;
        } else {
            o = header.o;
            Unit temp = header.previous;
            temp.next = null;
            header = temp;
        }

        nElem--; // уменьшаем количество элементов в очереди
        return o;
    }

    public Object front(){
        return header.o;
    }
    public Object back(){
        return tail.o;
    }

    public boolean isEmpty() {
        return (nElem == 0);
    }

    public int getSize() {
        return nElem;
    }
    public boolean isFilled(){return (nElem==maxSize);}


    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        Unit iter = tail;

        for (int i = 0; i < nElem; i++) {
            output.append(iter.o.toString()).append(' ');
            iter = iter.next;
        }

        return output.toString();
    }
}