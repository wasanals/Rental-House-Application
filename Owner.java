import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;



public class Owner extends Customer{ //inheritance
    private String name;
    private String phoneNumber;
   ArrayList<Owner>owners=new ArrayList<Owner>();
 
   /*
    * constructors
    */
     public Owner(){
        name="No Name";
        phoneNumber="no number";
               
    }

     public Owner(Owner o){
        name=o.name;
        phoneNumber=o.phoneNumber;
               
    }
  
    public Owner(String n , String phoneN){
        name=n;
        phoneNumber=phoneN;
      
    }
    
    /*
    setters and getters 
    */
    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    /*
    toString method
    */
      @Override
    public String toString() {
        return "OWNER INFORMATIONS:\n" + "name=" + name + "\nphoneNumber=" + phoneNumber + '}';
    }
      /*
      this is the addOwner method which add information of the owners in the 
      owner file.
     */
  public Owner addOwner () throws IOException{
                  FileWriter fw = new FileWriter("Owner.txt", true);
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
                   
                    Owner o1 = new Owner(name,phoneN);
                    owners.add(o1);
                    String na="name:", pn="phonenumber:";
                    pw.printf("\n%s"+"%20s\n\n",na,pn);
                    pw.printf("%s"+"%20s",o1.getName(),o1.getPhoneNumber());     
                    pw.close();
                    return o1;
                    
           }
    
}//end of class
