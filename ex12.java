import java.util.Scanner; 

class ElectricityAnalyzer {    
    private int previousReading, currentReading;    
    private int unitsConsumed;    
    private double slab1, slab2, slab3, slab4, totalBill;    
    Scanner sc = new Scanner(System.in);    

    void getReadings() {        
        System.out.print("Enter Previous Reading: ");        
        previousReading = sc.nextInt();        

        System.out.print("Enter Current Reading: ");        
        currentReading = sc.nextInt();      

        if (previousReading < 0 || currentReading < 0)            
            throw new IllegalArgumentException(                
                "Readings cannot be negative.");        

        if (currentReading < previousReading)            
            throw new IllegalArgumentException(                
                "Current reading must be greater than or equal to previous reading.");    
    }    
    void calculateBill() {        
        unitsConsumed = currentReading - previousReading;        
        int units = unitsConsumed;        
       
        slab1 = Math.min(units, 100) * 1.0;    
        units = Math.max(0, units - 100);    

        slab2 = Math.min(units, 100) * 2.5;     
        units = Math.max(0, units - 100);   

       slab3 = Math.min(units, 300) * 4.0;   
       units = Math.max(0, units - 300);     

       slab4 = units * 6.0;    

       totalBill = slab1 + slab2 + slab3 + slab4;    
    }    

    void displayBill() {        
        System.out.println("\\n--- ELECTRICITY BILL ---");   
        System.out.println("Units Consumed: " + unitsConsumed);    
        System.out.println("First 100 Units: Rs. " + slab1);   
        System.out.println("Next 100 Units: Rs. " + slab2);   
        System.out.println("Next 300 Units: Rs. " + slab3); 
        System.out.println("Above 500 Units: Rs. " + slab4);  
        System.out.println("Total Bill: Rs. " + totalBill);    
    } 
} 

public class ElectricityConsumptionAnalyzer {    
    public static void main(String[] args) {        
        try {         
            ElectricityAnalyzer obj = new ElectricityAnalyzer();     
            obj.getReadings();       
            obj.calculateBill();
            obj.displayBill();        
        } catch (java.util.InputMismatchException e) {           
            System.out.println("Error: Please enter valid integer readings.");    
        } catch (IllegalArgumentException e) {     
            System.out.println("Error: " + e.getMessage()); 
        }    
    }        
} 