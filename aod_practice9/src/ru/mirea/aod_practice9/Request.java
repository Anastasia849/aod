package ru.mirea.aod_practice9;

public class Request {
    private char category;
    private int id;
    private int time;
    private int priority;

    public Request(char category, int id, int time) {
        this.category = category;
        this.id = id;
        this.time = time;
        setPriority();
    }

    public char getCategory() {
        return category;
    }


    public int getId() {
        return id;
    }


    public int getTime() {
        return time;
    }


    public int getPriority() {
        return priority;
    }

    private void setPriority() {
        if (category=='M')
            this.priority = 1;
        if (category=='K')
            this.priority=2;
        if(category=='P')
            this.priority=3;
    }

    @Override
    public String toString() {
        return "category "+category + " id: "+ id+" time: "+time;
    }
}
