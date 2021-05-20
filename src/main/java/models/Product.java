package models;

import java.time.LocalDateTime;
import java.util.Date;

public class Product {
    private int serial;
    private double price;
    private LocalDateTime expiration;
    private String name;

    public Product() {

    }

    public Product(int serial, double price, LocalDateTime expiration, String name) {
        this.serial = serial;
        this.price = price;
        this.expiration = expiration;
        this.name = name;
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getExpiration() {
        return expiration;
    }

    public void setExpiration(LocalDateTime expiration) {
        this.expiration = expiration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "serial=" + serial +
                ", price=" + price +
                ", expiration=" + expiration +
                ", name='" + name + '\'' +
                '}';
    }
}
