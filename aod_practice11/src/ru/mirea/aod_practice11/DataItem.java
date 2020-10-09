package ru.mirea.aod_practice11;

public class DataItem {
    private long ISBN;
    private String author;
    private String name;

    public DataItem(long ISBN) {
        this.ISBN = ISBN;
    }

    public DataItem(long isbn, String author, String name)
    {
        this.ISBN = isbn;
        this.author=author;
        this.name=name;
    }

    public long getKey() {
        return ISBN;
    }
    public void setKey(long key){this.ISBN=key;}

    @Override
    public String toString() {
        return "ISBN : "+ ISBN +"; author : "+author+"; name: "+name;
    }
}
