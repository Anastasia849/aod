package ru.mirea.aod_practice12;

public class LibraryCard {
    private int libraryNumber;
    private String name;
    private String address;

    public LibraryCard(int libraryNumber, String name, String address) {
        this.libraryNumber = libraryNumber;
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getLibraryNumber() {
        return libraryNumber;
    }

    @Override
    public String toString() {
        return libraryNumber + "; " +name+"; "+ address;
    }
}
