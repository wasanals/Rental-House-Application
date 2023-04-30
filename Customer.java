import java.io.*;
import java.util.regex.*; 
import java.util.Scanner;

public class Customer {
    
    
    private String name;
    private String phoneNumber;
    
     /*
      constructors 
      
      */
    
    public Customer(){
        name="No Name";
        phoneNumber="no number";
        
    }
   
    public Customer(String n , String phoneN ){
        name = n;
        phoneNumber=phoneN;
       
    }
    
    public Customer(Customer c){
        name = c.name;
        phoneNumber=c.phoneNumber;
        
    }
    /*
      
      setters and getters
     */
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    /*
    toString method
    */
    @Override
    public String toString() {
        return "Customer{" + "name=" + name + ", phoneNumber=" + phoneNumber + '}';
    }
    
    /*
     this is the addCustomer method which add information of the customers in the 
     customer file.
    */
    public static void addCustomer () throws IOException {
        FileWriter fw = new FileWriter("Customer.txt", true);
        PrintWriter pw= new PrintWriter (fw);
        Scanner n = new Scanner(System.in);
        System.out.println("Enter your name:");
        String name = n.nextLine();
        
        System.out.println("Enter your phone number :");
        String phoneN =n.nextLine();
        isValidMobileNo(phoneN);
        do {
        	System.out.println("Enter your phone number :");
            phoneN =n.nextLine();
            isValidMobileNo(phoneN);
        } while(!(isValidMobileNo(phoneN)));
        Customer c1 = new Customer(name,phoneN);
        String na="name:", pn="phonenumber:";
        pw.printf("\n%s"+"%20s\n\n",na,pn);
        pw.printf("%s"+"%20s",c1.getName(),c1.getPhoneNumber());    
        pw.close();
    }
 /*
  this is isValidMobileNo method it checks if the phone number of the user
  is correct or no.
  @param phoneN the phone number that the user will enter
   
  */
    public static boolean isValidMobileNo(String phoneN)  
    {  
    Pattern ptrn = Pattern.compile(phoneN);    
    Matcher match = ptrn.matcher(phoneN);    
    return (match.find() && match.group().equals(phoneN));  
    }  
    
}//end of class
