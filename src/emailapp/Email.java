package emailapp;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Email extends emailapp.Connection {
    private String firsName;
    private String lastName;
    private String phoneNumber;
    private String addressWithNumber;
    private String zipCodeAndCity;
    private String password;
    private String email;
    private String department;
    private int mailboxCapacity = 750;
    private final int defaultPasswordLength = 10;
    private String alternateEmail;
    private final String companySuffix = "company.com";

    public Email(String firsName, String lastName) {
        this.firsName = firsName;
        this.lastName = lastName;
        this.department = setDepartment();

        email = firsName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + companySuffix;

        this.password = randomPassword(defaultPasswordLength);

    }

    public String setDepartment() {
        try {
            String depCode = JOptionPane.showInputDialog(
                    "DEPARTMENT CODE\n " +
                            "1 for SALES\n " +
                            "2 for DEVELOPMENT\n " +
                            "3 for ACCOUNTING\n " +
                            "0 for none\n" +
                            "Enter department code");


            int depChoice = Integer.parseInt(depCode);
            if (depChoice == 1) {
                return "sales.";
            } else if (depChoice == 2) {
                return "development.";
            } else if (depChoice == 3) {
                return "accounting.";
            } else {
                return "";
            }

        } catch (NumberFormatException e) {
            return "";

        }
    }


    private String randomPassword(int length) {
        String passwordSet = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpRrSsTtOuWwXxYyZz123456789!@#$%&*_+";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;

    }

    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    public void changePassword(String password) {
        this.password = password;

    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    public String showData() {


        return "EMPLOYEE NAME: " + firsName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb" +
                "\nYOUR PASSWORD: " + password +
                "\nPHONE NUMBER: " + phoneNumber;

    }


    public void postData() throws Exception {

        try {
            Connection conn = getConnection();
            PreparedStatement posted = conn.prepareStatement("INSERT INTO mail (firstName, lastName, email , password, mailboxCapacity)" +
                    "VALUES ('" + this.firsName + "','" + this.lastName + "','" + this.email + "',  '" + this.password + "', '" + this.mailboxCapacity + "')");
            posted.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("insert completed");
        }


    }

    public static ArrayList<String> getData() throws Exception {
        try {
            getConnection();
            PreparedStatement statement = getConnection().prepareStatement("SELECT firstName, lastName, email, phoneNumber FROM mail");
            ResultSet result = statement.executeQuery();
            ArrayList<String> employee = new ArrayList<String>();
            while (result.next()) {
                System.out.println("Employee: ");
                System.out.print(result.getString("firstName"));
                System.out.print(" ");
                System.out.println(result.getString("lastName"));
                System.out.print("email address: ");
                System.out.println(result.getString("email"));
                System.out.print("phone number: ");
                System.out.println(result.getString("phoneNumber"));

                employee.add(result.getString("firstName"));
                employee.add(result.getString("lastName"));
                employee.add(result.getString("email"));
            }
            return employee;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }


    }
}



