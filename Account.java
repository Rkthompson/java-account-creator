import java.security.SecureRandom;
import java.util.Scanner;

/**
 * Class Account models the account setup for a new user.
 * <p>
 * First name and last name are passed during construction and are used to create email and user names.
 * <p>
 * Terminal interaction is required to select the new users department from a displayed array of options.
 * <p>
 * A random password is generated and assigned to the user.
 * <p>
 * Defaults have been preassigned for company and mail box capacity.
 *  
 */

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

    /**
     * Account creates a user account object,
     * <p>
     * Pass the name to the constructor and user the terminal to select the new users department.
     * @param nFirstName String containing first name.
     * @param nLastName String containing last name.
     */

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

    //all param constructer for future use.

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

    /**
     * setFirstName accepts a String for the first name.
     * @param nFirstName The first name.
     */

    public void setFirstName(String nFirstName){
        firstName = nFirstName;

    } //end setFirstName

    /**
     * setLastName accepts a String for the last name.
     * @param nLastName The last name.
     */

    public void setLastName(String nLastName){
        lastName = nLastName;

    } //end setLastName


    private void setDepartment(String nDepartment){
        department = nDepartment;
    } //end setDepartment


    private void setCompany(String nCompany){
        company = nCompany;

    } //end setCompany

    private void setUserName(String nUserName){
        userName = nUserName;

    } //end setUserName

    private void setPassword(String nPassword){
        password = nPassword;

    }

    /**
     * setMailBoxCapacity accepts an int value to use as the max mail capacity.
     * @param nMailBoxCapacity int value of the max mb of mail capacity.
     */

    public void setMailBoxCapacity(int nMailBoxCapacity){
        mailBoxCapacity = nMailBoxCapacity;

    } //end setMailBoxCapacity

    private void setDomainName(String nDomainName){
        domainName = nDomainName;

    } //end setDomainName

    private void setTopDomain(String nTopDomain){
        topDomain = nTopDomain;

    } //end setTopDomain

    private void setEmail(String nEmail){
        email = nEmail;

    } //end setEmail

    /**
     * setAlternativeEmail allows the user to have a secondary email on record.
     * @param nAlternativeEmail String value of an alt email address.
     */
    
    public void setAlternativeEmail(String nAlternativeEmail){
        alternativeEmail = nAlternativeEmail;

    } //end setAlternativeEmail

    /**
     * setPossibleDepartments accepts an array of Strings containing all department options for a new user.
     * <p>
     * This value feeds the menu of possible choices that displays when a new user is setup,
     * @param nPossibleDepartments String array of departments.
     */

    public void setPossibleDepartments(String[] nPossibleDepartments){
        possibleDepartments = nPossibleDepartments;

    } //end setPossibleDepartments

    //getters - accessors

    /**
     * getFirstName returns the first name as a String.
     * @return The first name.
     */

    public String getFirstName(){
        return firstName;        

    } //end getFirstName

    /**
     * getLastName returns the last name as a String.
     * @return The last name.
     */

    public String getLastName(){
        return lastName;        

    } //end getLastName

    /**
     * getDepartment returns the department as a String.
     * @return The department name selected.
     */

    public String getDepartment(){
        return department;

    } //end getDepartment

    /**
     * getCompany returns the default company value as a String.
     * @return The company name.
     */

    public String getCompany(){
        return company;

    } //end getCompany

    /**
     * getUserName returns the assigned user name.
     * <p>
     * User name format is first inital last name.
     * @return The user name.
     */

    public String getUserName(){
        return userName;

    } //end getUserName

    /**
     * getPassword returns the value of the password as a String.
     * @return The assigned password.
     */

    public String getPassword(){
        return password;

    } //end getPassword

    /**
     * getMailBoxCapacity returns the currently set mail box capacity as an int.
     * <p>
     * Capacity is defined in units of MB.
     * @return The mail box capaity.
     */

    public int getMailBoxCapacity(){
        return mailBoxCapacity;

    } //end getMailBoxCapacity

    /**
     * getDomainName returns the default domain name.
     * @return The domain name.
     */

    public String getDomainName(){
        return domainName;

    } //end getDomainName

    /**
     * getTopDomain returns the top level domain.
     * @return The top domain.
     */

    public String getTopDomain(){
        return topDomain;

    }

    /**
     * getEmail returns the email address created for the user.
     * <p>
     * email address is returned as a string of FirstName.LastName.@Domain.TopDomain.
     * @return The email addresss.
     */

    public String getEmail(){
        return email;

    } //end getEmail
    
    /**
     * getAlternativeEmail returns a saved alternative email addresss if available.
     * @return The alternative email.
     */

    public String getAlternativeEmail(){
        return alternativeEmail;

    } //end getAlternativeEmail

    /**
     * getPossibleDepartments returns an array of String values contianing all of the currently set options for department.
     * <p>
     * The departments are held as full department name in a String.
     * @return Array of departments.
     */

    public String[] getPossibleDepartments(){
        return possibleDepartments;

    }

    //other functions

    /**
     * displayAccountDetails prints to terminal the currently set account attributes.
     */

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

    } //end randomPasswordGen

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
