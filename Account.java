import java.security.SecureRandom;
import java.util.Scanner;

public class Account {
    
    //declare attributes
    private String firstName;
    private String lastName;
    private String department;
    private String company = "ACME Corp.";
    private String userName;
    private String password;
    private int mailBoxCapacity = 1000;
    private String domainName = "ACME";
    private String topDomain = "com";
    private String email;
    private String alternativeEmail;
    private String[] possibleDepartments = {"Accounting", "Customer Service", "Production", "Sales", "Warehouse"};
    private int defaultPasswordLength = 12;

    //constructors
    //default constructor
    public Account(){
        firstName = "";
        lastName = "";
        department = "";
        userName = "";
        password = "";
        alternativeEmail = "";
        //write to terminal account creation values
        displayAccountDetails();
        
    }

    //firstName, lastName param constructer
    public Account(String nFirstName, String nLastName){
        firstName = nFirstName;
        lastName = nLastName;
        department = "";
        userName = "";
        password = "";
        alternativeEmail = "";

        //ask user for department entry
        setDepartment(askForDepartment());

        //set password
        setPassword(randomPasswordGen(defaultPasswordLength));

        //set email
        setEmail(buildEmailAddress(firstName, lastName, domainName, topDomain));

        //set userName
        setUserName(buildUserName(getFirstName(), getLastName()));

        //write to terminal account creation values
        displayAccountDetails();

    }

    //all param constructer
    public Account(String nFirstName, String nLastName, String  nDepartment, String nCompany, String nUserName, String nPassword, int nMailBoxCapacity, String nAlternativeEmail){
        firstName = nFirstName;
        lastName = nLastName;
        department = nDepartment;
        company = nCompany;
        userName = nUserName;
        password = nPassword;
        mailBoxCapacity = nMailBoxCapacity;
        alternativeEmail = nAlternativeEmail;
        //write to terminal account creation values
        displayAccountDetails();

    }

    //setters - mutators
    public void setFirstName(String nFirstName){
        firstName = nFirstName;

    } //end setFirstName

    public void setLastName(String nLastName){
        lastName = nLastName;

    } //end setLastName

    public void setDepartment(String nDepartment){
        department = nDepartment;
    } //end setDepartment

    public void setCompany(String nCompany){
        company = nCompany;

    } //end setCompany

    public void setUserName(String nUserName){
        userName = nUserName;

    } //end setUserName

    public void setPassword(String nPassword){
        password = nPassword;

    }

    public void setMailBoxCapacity(int nMailBoxCapacity){
        mailBoxCapacity = nMailBoxCapacity;

    } //end setMailBoxCapacity

    public void setDomainName(String nDomainName){
        domainName = nDomainName;

    } //end setDomainName

    public void setTopDomain(String nTopDomain){
        topDomain = nTopDomain;

    } //end setTopDomain

    public void setEmail(String nEmail){
        email = nEmail;

    } //end setEmail
    
    public void setAlternativeEmail(String nAlternativeEmail){
        alternativeEmail = nAlternativeEmail;

    } //end setAlternativeEmail

    public void setPossibleDepartments(String[] nPossibleDepartments){
        possibleDepartments = nPossibleDepartments;

    }

    //getters - accessors
    public String getFirstName(){
        return firstName;        

    } //end getFirstName

    public String getLastName(){
        return lastName;        

    } //end getLastName

    public String getDepartment(){
        return department;

    } //end getDepartment

    public String getCompany(){
        return company;

    } //end getCompany

    public String getUserName(){
        return userName;

    } //end getUserName

    public String getPassword(){
        return password;

    } //end getPassword

    public int getMailBoxCapacity(){
        return mailBoxCapacity;

    } //end getMailBoxCapacity

    public String getDomainName(){
        return domainName;

    } //end getDomainName

    public String getTopDomain(){
        return topDomain;

    }

    public String getEmail(){
        return email;

    } //end getEmail
    
    public String getAlternativeEmail(){
        return alternativeEmail;

    } //end getAlternativeEmail

    public String[] getPossibleDepartments(){
        return possibleDepartments;

    }

    //other functions
    public void displayAccountDetails(){
        System.out.println("=======================================");
        System.out.println("Account Details");
        System.out.println("=======================================");
        System.out.println("First Name: " + getFirstName());
        System.out.println("Last Name: " + getLastName());
        System.out.println("Department: " + getDepartment());
        System.out.println("Company: " + getCompany());
        System.out.println("User Name: " + getUserName());
        System.out.println("Password: " + getPassword());
        System.out.println("Mail Box Capacity: " + getMailBoxCapacity());
        System.out.println("Email: " + getEmail());
        System.out.println("Alternative Email: " + getAlternativeEmail());
        System.out.print("\n");

    } //end displayAccountDetails

    //check department
    private String askForDepartment(){
        //declare variables
        String newDepartment = "";
        String[] departmentList = getPossibleDepartments();
        Scanner keyboardIn = new Scanner(System.in);

        //write to terminal
        System.out.println("Please select department from values below:");
        //iterate through the possible departments array
        for(int index = 0; index < departmentList.length; index++){
            //display department
            System.out.println("Option " + (index + 1) + ": " + departmentList[index]);

        }

        //Accept input from user for department
        String departmentChoice = keyboardIn.nextLine();

        //check that input is int and a number in range of choices
        //control verification loop with error count flag.
        int errorCount = 0;

        do{
            //check that department choice is numeric
            if(isInteger(departmentChoice)){
                //check that department choice is in range of the array
                int intDepartmentChoice = Integer.parseInt(departmentChoice);
                if(intDepartmentChoice < 1 || intDepartmentChoice > (departmentList.length)){
                    System.out.println(departmentChoice + " is not an accpetable entry.");
                    System.out.println("Please enter a value between 1 and " + (departmentList.length));
                                        
                    //take input again
                    departmentChoice = keyboardIn.nextLine();

                    //flag as an error to ensure a second pass of input verification.
                    errorCount = 1;

                }
                else{
                    //input was an int and is in range
                    //set value of choice to return in newDepartment
                    newDepartment = departmentList[(intDepartmentChoice - 1)];

                    //set errorCount to zero to allow loop to end
                    errorCount = 0;

                    //close scanner
                    keyboardIn.close();
                }
                
            }
            else{
                //input was not numeric
                System.out.println(departmentChoice + " is not an accpetable entry.");
                System.out.println("Please enter a value between 1 and " + (departmentList.length));
                
                //take input again
                departmentChoice = keyboardIn.nextLine();
                //flag as an error to ensure a second pass of input verification.
                errorCount = 1;
            }

        }while(errorCount > 0);

        return newDepartment;

    } //end askForDepartment
        
    //Create a random password
    private String randomPasswordGen(int nPasswordLength){
        //String of possible password characters
        String passwordSet = "abcdefghijklmnopqrstuwxyzABCDEFGHIJKLMNOPQRSTUWXYZ0123456789!@#$%";

        //array of characters the length of the password length param
        char[] password = new char[nPasswordLength];

        //random number generator using SecureRandom
        SecureRandom randomNumber = new SecureRandom();

        //loop through the characters and select a random character for each position
        for(int index = 0; index < password.length; index++){
            //gen random index postion
            int randomIndexPos = randomNumber.nextInt(passwordSet.length());

            //randomly select a character for each postion of the password
            password[index] = passwordSet.charAt(randomIndexPos);

        }

        return new String(password);

    } //end randowmPasswordGen

    //build an email address
    private String buildEmailAddress(String nFirstName, String nLastName, String nDomainName, String nTopDomain){
        String newEmail = nFirstName + "." + nLastName + "@" + nDomainName + "." + nTopDomain;

        return newEmail;
    } //end buildEmailAddress

    //build user name first intial lastname
    private String buildUserName(String nFirstName, String nLastName){
        String newUserName = nFirstName.substring(0, 1) + nLastName;

        return newUserName;

    } //end buildUserName

    //check that a string is an integer - return true if it is - else return false
    private boolean isInteger(String input){
        try{
            Integer.parseInt( input );
            return true;

        }
        catch( Exception e ){
            return false;

        }

    } //end isInteger
    
} //end class Account
