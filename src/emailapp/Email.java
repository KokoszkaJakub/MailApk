package emailapp;

import java.util.Scanner;

public class Email {
    private String firsName;
    private String lastName;
    private String password;
    private String email;
    private String department;
    private int mailboxCapacity = 750;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private final String companySuffix = "comapny.com";

    public Email(String firsName, String lastName) {
        this.firsName = firsName;
        this.lastName = lastName;
        this.department = setDepartment();

        email = firsName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;

        this.password = randomPassword(defaultPasswordLength);

    }

    public String setDepartment() {
        System.out.print("DEPARTMENT CODE\n 1 for SALES\n 2 for DEVELOPMENT\n 3 for ACCOUNTING\n 0 for none\n " +
                "Enter department code\n");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) {
            return "sales";
        } else if (depChoice == 2) {
            return "development";
        } else if (depChoice == 3) {
            return "accounting";
        } else {
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
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;

    }
    public  void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }
    public void changePassword(String password){
        this.password = password;

    }
    public int getMailboxCapacity(){
        return mailboxCapacity;
    }
    public String getAlternateEmail(){
        return alternateEmail;
    }
    public String getPassword(){
        return password;
    }
    public String showData(){
        return "DISPLAY NAME: " + firsName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb" +
                "\nYOUR PASSWORD: " + password;
    }
}





