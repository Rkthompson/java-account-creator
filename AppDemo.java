
public class AppDemo{

    public static void main(String[] args){

        //declare object
        Account user1 = new Account("Wile", "Coyote");

        //set alternative email address
        user1.setAlternativeEmail("Road.Runner@ACME.com");

        //change the default mail box capacity
        user1.setMailBoxCapacity(3000);

        //display account details
        user1.displayAccountDetails();

     } //end main
    
} //end AppDemo