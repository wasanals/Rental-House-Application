import java.util.Scanner;
import java.io.*;
 
public class RentingDemo extends Customer { //inheritance

   
          
           public static void main(String[] args) throws IOException {
               
                   int choice; 
                   Scanner scan = new Scanner(System.in);    //object from scanner class       
                   Owner o1 = new Owner(); //object from owner class
                 
                 do {
                       
                  System.out.println("< Welcome to House Renting Application >");
                  System.out.println("1-Customer");
                  System.out.println("2-Owner");
                  System.out.println("3-Exit");
                  System.out.println("Enter your choice:");
                  choice = scan.nextInt();
                            
                   switch(choice){
                      case 1:
                          addCustomer();
                          searchMenu();
                            break;
                  
                       case 2:
                           Rent r = new Rent(); //object from rent class
                           House i = new House(); //object from house class
                           Owner owner = o1.addOwner(); //object from owner class
                           r.setOwner(owner);
                           House house =i.addHouse();
                           r.setHouse(house);
                           bill(r.getHouse(),r.getOwner());
                           break; 
                           
                        case 3:
                           System.out.println("Goodbye!!");
                           System.exit(0);
                           break;
                   
                       default:
                        System.out.println("Wrong choice, please enter a vaild choice: \n");
                          break;
                          
                  }
              }while(choice > 3); //end of do-while
        
           }//end of main

           /*
             this method display search menu for the users to choose 
             to search by (location, number of rooms, their budget ).
             
            */
             
            public static void searchMenu() throws IOException{
                 int choice;
                 Scanner scan = new Scanner(System.in);
                      do {
                  
                      System.out.println(" Search on house by \n 1-number of rooms \n 2-location \n 3-rent cost :");
                             System.out.println("Enter your choice :");
                             choice=scan.nextInt();
                             
                      switch(choice) {
                     
                      case 1:
                                 
                             Scanner askk = new Scanner(System.in);
                             System.out.println("enter number of rooms you search for:");
                             String rooms = askk.nextLine();
                             SearchRoom(rooms);
                                 break;
                                
                      case 2:
                              System.out.println("enter the location you search for:");
                               Scanner ask = new Scanner(System.in);
                               String loc = ask.nextLine();                               
                               searchLO(loc);
                                 break;
                                
                      case 3:
                                 System.out.println("enter the rent cost you search for:");
                                 Scanner asl = new Scanner(System.in);
                                 String rent = asl.nextLine();                               
                                 searchRent(rent);
                                
                                 break;
                                
                      default:
                                 System.out.println("Wrong choice, please enter a vaild choice: \n");
                                
                               break;
                      }
                   } while(choice > 3);//end of do-while
           }//end of searchMenu method
            
            /*
             this method open the house file to search for a house that is
             suitable for the customer by the location of the house.
             @param loc the location that the user will enter and the method will search by it
            */
            
            public static void searchLO(String loc) throws IOException{
                File file = new File("House.txt");
                         
                          if(!file.exists()) {
                                    System.out.println("file is not found");
                          System.exit(0);
                         }
                         
                              Scanner inputFile = new Scanner(file);
                          while(inputFile.hasNext()) {
                                    String line = inputFile.nextLine();
                                    if(line.contains(loc)) {
                                               System.out.println("These are the available houses with this location:");
                                         System.out.println(line);
                                         break;
                                    }
                                    else if(!(inputFile.hasNext()) && !(line.contains(loc))){
                                               System.out.println("We are sorry, there are no available houses with this location.");
                                    }
                         }
                         
                          inputFile.close();
              }//end of searchLO method
            
            /*
            this method open the house file to search for a house that is
            suitable for the customer by the rent cost of the house.
            @param rent the budget of the customer that the user will enter and the method will search by it
           */
            
            public static void searchRent(String rent) throws IOException{
                
                File file = new File("House.txt");
               
                if(!file.exists()) {
                          System.out.println("file is not found");
                System.exit(0);
               }
               
                Scanner inputFile = new Scanner(file);
               while(inputFile.hasNext()) {
                          String line = inputFile.nextLine();
                          if(line.contains(rent)) {
                                     System.out.println("These are the available houses with your budget.");
                               System.out.println(line);
                               break;
                          }
                          else if(!(inputFile.hasNext()) && !(line.contains(rent))){
                                     System.out.println("We are sorry, there are no available houses in the range of your budget");
                          }
               }
               
                inputFile.close();
    }//end of searchRent method

            /*
            this method open the house file to search for a house that is
            suitable for the customer by the number of rooms of the house.
            @param rooms number of rooms that the user will enter and the method will search by it
           */
            
            public static void SearchRoom(String rooms) throws IOException{
                
                File file = new File("House.txt");
               
                if(!file.exists()) {
                          System.out.println("file is not found");
                System.exit(0);
               }
               
                Scanner inputFile = new Scanner(file);
               while(inputFile.hasNext()) {
                          String line = inputFile.nextLine();
                          if(line.contains(rooms)) {
                                     System.out.printf("These are the available houses with %s room/s:\n",rooms);
                               System.out.println(line);
                               break;
                          }
                          else if(!(inputFile.hasNext()) && !(line.contains(rooms))){
                                     System.out.printf("We are sorry, there are no available houses with %s room/s.\n",rooms);
                          }
               }
               
                inputFile.close();
    } //end of searchRoom method
            
            /*
              this method display the Renting Contract for
              the owner.
              @param h display the toString method of the house class
              @param o display the toString method of the owner class
             */
          
             public static void bill(House h,Owner o) {
                      
                     
                      System.out.println("....Renting Contract...." );
                      System.out.println(h);
                      System.out.println(o);
                      String rt=h.getRent();
                      double rentCost=Double.parseDouble(rt);
                      double tax= 0.25*rentCost;
                      double total = rentCost+tax;
                      System.out.println("....THE BILL....");
                      System.out.println("the rent cost: "+rentCost+"\n"+"the tax: "+tax+"\n"+"the total: "+total);
                     
            }//end of bill method

}//end of class