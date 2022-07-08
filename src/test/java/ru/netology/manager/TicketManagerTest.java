package ru.netology.manager;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

public class TicketManagerTest {

    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);
    TicketByPriceAscComparator comparator = new TicketByPriceAscComparator();

    Ticket ticket1 = new Ticket(1, 5000, "MOV", "EGO", 60);
    Ticket ticket2 = new Ticket(2, 6000, "MOV", "LED", 50);
    Ticket ticket3 = new Ticket(3, 4000, "MOV", "EGO", 70);
    Ticket ticket4 = new Ticket(4, 5500, "MOV", "LED", 40);
    Ticket ticket5 = new Ticket(5, 5000, "MOV", "EGO", 50);
    Ticket ticket6 = new Ticket(6, 7000, "MOV", "EGO", 60);
    Ticket ticket7 = new Ticket(7, 6500, "MOV", "LED", 450);
    Ticket ticket8 = new Ticket(8, 3500, "MOV", "EGO", 80);
    Ticket ticket9 = new Ticket(9, 11000, "MOV", "OGZ", 150);
    Ticket ticket10 = new Ticket(10, 9000, "MOV", "KUF", 130);

    @BeforeEach
    public void setup() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
    }

    @Test
    public void shouldSearchTicketAndSortByPrice() {

        Ticket[] expected = { ticket8, ticket3, ticket1, ticket5, ticket6 };
        Ticket[] actual = manager.searchBy("MOV", "EGO");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSearchWhenNotTicketByPrice() {

        Ticket[] expected = { };
        Ticket[] actual = manager.searchBy("MOV", "SEV");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearch1TicketByPrice() {

        Ticket[] expected = { ticket10 };
        Ticket[] actual = manager.searchBy("MOV", "KUF");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchTicketAndSortByTime() {

        Ticket[] expected = { ticket5, ticket1, ticket6, ticket3, ticket8 };
        Ticket[] actual = manager.findBySearch("MOV", "EGO", comparator);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSearchWhenNotTicket() {

        Ticket[] expected = { };
        Ticket[] actual = manager.findBySearch("MOV", "SEV", comparator);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearch1TicketByTime() {

        Ticket[] expected = { ticket10 };
        Ticket[] actual = manager.findBySearch("MOV", "KUF", comparator);

        assertArrayEquals(expected, actual);
    }

}
