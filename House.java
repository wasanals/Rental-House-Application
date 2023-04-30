import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class House {
   
    private String location;
    private String rent;
    private String roomsNumber;
     ArrayList<House>houses=new ArrayList<House>();
   /*
    constructors
    */
     public House() {
        location = "No locality";
        rent = "0.0";
        roomsNumber = "0";
    }

    public House(House h) {
        location = h.location;
        rent = h.rent;
        roomsNumber = h.roomsNumber;

    }

    public House(String l, String roomN ,String r) {
       
        location = l;
        rent = r;
        roomsNumber = roomN;

    }
    /*
    toString method
    */
    @Override
    public String toString() {
        return "HOUSE INFORMATIONS:\n"+ "\nlocation=" + location + "\nrent=" + rent + "\nroomsNumber=" + roomsNumber ;
    }
    
    /*
     this is the addHouse method which add information of a house in the 
     house file. 
      
     */
       public House addHouse() throws IOException{
              
                 Scanner  kb = new Scanner(System.in);
                 System.out.println("If you want to rent your house please provide the following informations: ");
                
                 System.out.println("Enter the number of rooms:");
                 String roomsN=kb.nextLine();
                             
                 System.out.println("Enter the location");
                 String locality=kb.nextLine();
                                
                 System.out.println("Enter the rent cost:");
                 String rentC=kb.nextLine();
                             
                 House hs = new House(locality,roomsN,rentC);
                 houses.add(hs);
                 FileWriter fw = new FileWriter("House.txt", true);
                 PrintWriter pw= new PrintWriter(fw);
                 String adder="The Address:",ronum="Number of rooms:",rent="The Rent:";
                 pw.printf("\n%s "+"%25s"+"%25s\n", adder, ronum, rent);
                 pw.printf("%s "+"%25s"+"%33s\n",hs.getLocation(),hs.getRoomsNumber(),hs.getRent());
                 pw.close();
                     return hs;
                                
             }
         
       /*
         
         setters and getters
        */

            public String getLocation() {
                return location;
            }

            public String getRent() {
                return rent;
            }

            public String getRoomsNumber() {
                return roomsNumber;
            }

            public void setLocation(String locality) {
                this.location = locality;
            }

            public void setRent(String rent) {
                this.rent = rent;
            }

            public void setRoomsNumber(String roomsNumber) {
                this.roomsNumber = roomsNumber;
            }

}//end of class


