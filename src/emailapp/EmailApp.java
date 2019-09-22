package emailapp;

import javax.swing.*;



public class EmailApp extends Email{


    public EmailApp(String firsName, String lastName, String phoneNumber) {
        super(firsName, lastName, phoneNumber);
    }

    public static void main(String[] args) throws Exception {


        String firstName = JOptionPane.showInputDialog("Podaj swoje imię");
        String lastName = JOptionPane.showInputDialog("Podaj swoje nazwisko");
        String phoneNumber = JOptionPane.showInputDialog("podaj telefon kontaktowy");


        Email em1 = new Email(firstName, lastName, phoneNumber);

        getConnection();
        em1.postData();
        System.out.println("Date from DB email");
        getData();



        JOptionPane.showMessageDialog(null,em1.showData());
    }

}
