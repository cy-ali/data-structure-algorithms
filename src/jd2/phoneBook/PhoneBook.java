package jd2.phoneBook;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class PhoneBook {

    PersonCard head;
    PersonCard tail;
    int size = 0;

    public boolean isEmpty() {
        return head == null;
    }

    public void add(String firstname, String lastname, String email, int number) {
        PersonCard cardToAdd = new PersonCard(firstname, lastname, email, number);

        if (isEmpty()) {
            head = tail = cardToAdd;
        } else {
            tail.next = cardToAdd;
            tail = cardToAdd;
        }
        size++;
    }

    public void print() {
        PersonCard current = head;

        while (current != null) {
            System.out.println(current.firstname + " " + current.lastname + " " + current.email + " " + current.phoneNumber);
            current = current.next;
        }
    }

    public PersonCard findByName(String firstname) {

        PersonCard current = head;
        while (current != null) {
            if (current.firstname.equals(firstname)) return current;
            else current = current.next;
        }
        return null;
    }

    public ArrayList<PersonCard> findAllByLastName(String lastname) {
        if (isEmpty()) throw new NoSuchElementException("Phone Book is empty");
        ArrayList<PersonCard> cardList = new ArrayList<>();
        PersonCard current = head;
        while (current != null) {
            if (current.lastname.equals(lastname)) cardList.add(current);
            else current = current.next;
        }
        return cardList;
    }




}
