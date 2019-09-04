package emailapp;

import javax.swing.*;


public class EmailApp extends Email{
    public EmailApp(String firsName, String lastName) {
        super(firsName, lastName);
    }

    public static void main(String[] args) throws Exception {


        String firstName = JOptionPane.showInputDialog("Podaj swoje imię");
        String lastName = JOptionPane.showInputDialog("Podaj swoje nazwisko");
        Email em1 = new Email(firstName, lastName);

        getConnection();
        em1.post();

        JOptionPane.showMessageDialog(null,em1.showData());
    }

}
