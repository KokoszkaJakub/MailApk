package emailapp;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmailApp {
    public static void main(String[] args) throws Exception {
        getConnection();
        post();

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
    public static void post() throws Exception {
        String var1 = "Ala";
        String var2 = "makota";
        String var3 = "ex@ex.com";
        String var4 = "qwerty";
        int var5 = 750;
try{
    Connection conn = getConnection();
    PreparedStatement posted = conn.prepareStatement("INSERT INTO mail (firstName, lastName, email, password, mailboxCapacity)" +
            "VALUES ('"+var1+"','"+var2+"','"+var3+"', '"+var4+"', '"+var5+"')");
    posted.executeUpdate();

} catch (SQLException e) {
    e.printStackTrace();
} catch (Exception e) {
    e.printStackTrace();
}
finally {
    System.out.println("insert completed");
}
    }
}
