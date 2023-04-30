public class Rent {

private Customer customer;
private House house;
private Owner owner;

       public Rent(){
            
        }
       
       /*
        * constructors
        */
       public Rent(Customer c ,Owner o, House h){
            Customer c1= new Customer(c);
            Owner o1 = new Owner(o);
            House h1 = new House(h); 
     }
       
        public Rent (Rent r){
            customer = r.customer;
            house = r.house;
            owner=r.owner;
     }
        public Rent(Owner o, House h){
            
            Owner o1 = new Owner(o);
            House h1 = new House(h); 
     }
/*
 setters and getters 
 */
        public void setHouse(House house) {
             this.house = house;
        }

        public void setOwner(Owner owner) {
             this.owner = owner;
        }
         
        public House getHouse() {
        return new House(house);
        }

        public Owner getOwner() {
        return new Owner(owner);
        }
      
        public Customer getCustomer(){

              return new Customer(customer); 
          }
        /*
         toString method
         */
        @Override
          public String toString() {
              return  "customer=" + customer + ", house=" + house + ", owner=" + owner ;
          }

      
   }//end of class
   
        
