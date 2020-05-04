package EmailAppSetup;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String department;
    private String password;
    private String email;
    private int mailBoxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companyWWebAdd = "gamail.com";

    public Email(String fName, String lName) {
        firstName = fName;
        lastName = lName;

        //Method asking for the department and returns department
        this.department = setDepartment();

        //Method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

        //Combine element to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department+ "." + companyWWebAdd;


    }

    private String setDepartment(){
        System.out.println("New worker: " + firstName + ". Department Codes\n1 sales\n2 development\n3 accounting\n0 None\n\nEnter your department:");
        Scanner in = new Scanner(System.in);
        int dept = in.nextInt();

        if(dept == 1) {
            return "sales";
        }else if(dept == 2) {
            return "dev";
        }else if (dept == 3) {
            return "acct";
        }else {
            return "";
        }
    }

    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for (int i=0; i<length; i++) {
            int rand = (int) (Math.random()*passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    public void setMailBoxCapacity(int capacity) {
        this.mailBoxCapacity = capacity;
    }

    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailBoxCapacity(){
        return mailBoxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    public String showInfo() {
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY NAME: " + email +
                "\nMAILBOX CAPACITY: " +  mailBoxCapacity + "mb";
    }
}
