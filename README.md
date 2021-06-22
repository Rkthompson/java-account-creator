# java-account-creator

**AppDemo.java** and **Account.java** are a simple example of class instantiation and functions in Java.

When AppDemo is run it will use **Account.java** and create a new user account object.
- First and last name values are passed to **Account.java** from **AppDemo.java**.
- The constructor then calls the following to populate the remaining object attributes.
```Java
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
```

---

**askForDepartment** uses a flag controlled do...while loop to validate terminal inputs when the user selects a department.

**randomPasswordGen** uses the SecureRandom class to create a random password from a String of possible characters.

**buildEmailAddress** will populate the email address attribute by concatenating the passed values.

**setUserName** will populate the user name attribute with the first initial of the first name plus the last name.

**displayAccountDetails** prints to terminal the new account configuration.

---

**AppDemo.java** will then use the newly created object to call the setters **setAlternativeEmail**  and **setMailBoxCapacity** to change their values.

Finally, **displayAccountDetails** is called again to print to terminal the updated account details.