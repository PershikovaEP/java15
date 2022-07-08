package ru.netology.domain;

public class Ticket implements Comparable<Ticket> {
    //интерфейс Comparable определяет порядок сортировки объектов данного класса по умолчанию
    private int id;
    private int price;  //стоимость билета
    private String departureAeroport; //аэпорорт вылета
    private String arrivalAeroport;  //аэропорт прилета
    private int time; //время в пути в минутах

    public Ticket(int id, int price, String departureAeroport, String arrivalAeroport, int time) {
        this.id = id;
        this.price = price;
        this.departureAeroport = departureAeroport;
        this.arrivalAeroport = arrivalAeroport;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDepartureAeroport() {
        return departureAeroport;
    }

    public void setDepartureAeroport(String departureAeroport) {
        this.departureAeroport = departureAeroport;
    }

    public String getArrivalAeroport() {
        return arrivalAeroport;
    }

    public void setArrivalAeroport(String arrivalAeroport) {
        this.arrivalAeroport = arrivalAeroport;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public int compareTo(Ticket o) {
        if (this.price < o.price) {
            return -1;
        } else if (this.price > o.price) {
            return 1;
        } else {
            return 0;
        }
    }
}
