package emailapp;

import javax.swing.*;

public class EmailApp {
    public static void main(String[] args) {
        String firstName = JOptionPane.showInputDialog("Podaj swoje imię");
        String lastName = JOptionPane.showInputDialog("Podaj swoje nazwisko");

        Email em1 = new Email(firstName, lastName);
        /*em1.changePassword("qwerty123");
        em1.setMailboxCapacity(500);
        em1.setAlternateEmail("me@google.com");

        System.out.println(em1.getAlternateEmail());
        System.out.println(em1.getMailboxCapacity());
        System.out.println(em1.getPassword());*/

        JOptionPane.showMessageDialog(null,em1.showData());
    }

}
