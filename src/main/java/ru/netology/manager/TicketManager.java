package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;
import java.util.Comparator;

public class TicketManager {
    private TicketRepository repo;

    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }

    public void add(Ticket ticket) {
        repo.save(ticket);
    }

    public Ticket[] findAll() {
        return repo.findAll();
    }

    //осуществляет поиск по добавленным в репозиторий Билетам c сортировкой по цене интерфейсом comparable
//    Менеджер при переборе всех продуктов, хранящихся в репозитории, должен для каждого продукта вызывать
//    определённый в классе менеджера же метод matches, который проверяет, соответствует ли продукт поисковому
//    запросу.
    public Ticket[] searchBy(String from, String to) {
        Ticket[] result = new Ticket[0]; // тут будем хранить подошедшие запросу продукты, изначально нулевой
        for (Ticket ticket: repo.findAll()) {
            if (matches(ticket, from, to)) {
                // "добавляем в конец" массива result продукт product
                Ticket[] tmp = new Ticket[result.length + 1];//массив для хран-я найд.д-х длиной на 1 больше result
                for (int i = 0; i < result.length; i++) { //чтобы сохранять несколько вариантов делаем цикл
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket; //заполняем последнюю ячейку

                result = tmp; //заменяем
            }
        }
        Arrays.sort(result);// сортируем результат от меньшему к большему
        return result;
    }

    // метод определения соответствия билета запросу search
    //При проверке на соответствие запросу товару мы проверяем вхождение запроса в текст названия товара.

    public boolean matches(Ticket ticket, String from, String to) {
        if (ticket.getDepartureAeroport().contains(from) && ticket.getArrivalAeroport().contains(to)) {
            return true;
        } else {
            return false;
        }
    }

// поиск по билетам по городам отправления-прибытия с сортировкой по времени с интерфейсом компаратора
   public Ticket[] findBySearch(String from, String to, Comparator<Ticket> comparator) {
        Ticket[] result = new Ticket[0]; // тут будем хранить подошедшие запросу продукты, изначально нулевой
        for (Ticket ticket : repo.findAll()) {
            if (matches(ticket, from, to)) {
                // "добавляем в конец" массива result продукт product
                Ticket[] tmp = new Ticket[result.length + 1];//массив для хран-я найд.д-х длиной на 1 больше result
                for (int i = 0; i < result.length; i++) { //чтобы сохранять несколько вариантов делаем цикл
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket; //заполняем последнюю ячейку

                result = tmp; //заменяем
            }
        }
        Arrays.sort(result, comparator);// сортируем результат от меньшему к большему
        //передаем в этот метод объект любого класса, реализующий интерфейс Comparator<Ticket>
        return result;
    }
}

