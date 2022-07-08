package ru.netology.manager;

import ru.netology.domain.Ticket;

import java.util.Comparator;

public class TicketByPriceAscComparator implements Comparator<Ticket> {
    //интерфейс Comparator позволяет создавать объекты, определяющие порядок сортировки других объектов
    @Override
    public int compare(Ticket o1, Ticket o2) {
        return o1.getTime() - o2.getTime();  //сокращенная надпись: время 1 объекта минус время 2 объекта
//        if (o1.getTime() < o2.getTime()) {
//            return -1;
//        } else if (o1.getTime() > o2.getTime()) {
//            return 1;
//        } else {
//            return 0;
//        }
    }
}
