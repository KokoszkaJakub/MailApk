package emailapp;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class EmailApp {
    public static void main(String[] args) throws Exception {
        getConnection();

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
    public static Connection getConnection() throws Exception {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            //String url = "jdbc:mysql://localhost:3306/mailDB";
            String url = "jdbc:mysql://localhost/mailDB?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String userName = "root";
            String password = "password";
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, userName, password);

            System.out.println("connected to DB !");
            return conn;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;

    }
}
