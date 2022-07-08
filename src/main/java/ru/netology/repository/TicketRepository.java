package ru.netology.repository;

import ru.netology.domain.Ticket;

public class TicketRepository {
    Ticket[] tickets = new Ticket[0];

    public void save(Ticket ticket) {
        Ticket[] tmp = new Ticket[tickets.length + 1]; //массив на один больше длиной
        for (int i = 0; i < tickets.length; i++) { //пройдем по циклу
            tmp[i] = tickets[i]; //копируем
        }
        tmp[tmp.length - 1] = ticket; //заполняем последнюю ячейку
        tickets = tmp;
    }

    //получать Products
    public Ticket[] findAll() {
        return tickets;
    }

    //удалять по айди с исключением по удалению несуществующего товара
    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException(
                    "Element with id: " + id + " not found"
            );
        }

        Ticket[] tmp = new Ticket[tickets.length - 1];  //создали массив длиной на 1 меньше
        int copyToIndex = 0; //переменная, сохраняющая место для копирования
        for (Ticket ticket : tickets) {  //пройдем по всему массиву
            if (ticket.getId() != id) {  //если id не совпадает, то копируем в эту ячейку, равную индексу, фильм
                tmp[copyToIndex] = ticket;
                copyToIndex++; //переставляем счетчик
            }
            tickets = tmp;
        }
    }

    //метод поиска по айди для метода removeById
    public Ticket findById(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;  //если совпадает айди, то выводим билет, иначе результат нулл
            }
        }
        return null;
    }



}
