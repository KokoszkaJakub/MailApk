package emailapp;

import java.sql.DriverManager;

public class Connection {
    public static java.sql.Connection getConnection() throws Exception {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            //String url = "jdbc:mysql://localhost:3306/mailDB";
            String url = "jdbc:mysql://localhost/mailDB?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String userName = "root";
            String password = "password";
            Class.forName(driver);
            java.sql.Connection conn = DriverManager.getConnection(url, userName, password);
            return conn;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;


    }


}
