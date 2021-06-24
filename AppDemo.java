
public class AppDemo{

    public static void main(String[] args){

        //declare object
        Account user1 = new Account("Wile", "Coyote");

        //set alternative email address
        System.out.println("Setting Alt email address to Road.Runner@ACME.com.");
        System.out.println("\n");
        
        user1.setAlternativeEmail("Road.Runner@ACME.com");

        //change the default mail box capacity
        System.out.println("Changing mail box capacity to 3000 mb.");
        System.out.println("\n");

        user1.setMailBoxCapacity(3000);

        //display account details
        user1.displayAccountDetails();

     } //end main
    
} //end AppDemo