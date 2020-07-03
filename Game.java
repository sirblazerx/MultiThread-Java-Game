package game;




import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.*;
import java.lang.*;

/**
 *
 * @author User
 */
public class Game {

    public static void main(String[] args) {
        
        
   
        
       //Variables Initialization
       
       
        int n,t= 0;
        double x,y,m= 0;
        
        //Create an instance of Scanner class
        Scanner scan = new Scanner(System.in);
        
        //Create an array list containing the Coordinate objects
        ArrayList<Coordinate> coordinates = new ArrayList<>();
        ArrayList<Edge> edge = new ArrayList<>();
        List<Future<Edge>> finaledge = new ArrayList<>();
        //Create an instance of Random class
        Random randomNumber = new Random();
        
        //Getting inputs from user
        System.out.println("Please enter the number of coordinate, n: ");
        n = scan.nextInt();
        
        System.out.println("How long will the program run in seconds, m: ");
        m = scan.nextDouble();
        
        System.out.println("How many threads should be used, t ");
        t = scan.nextInt();
        
        //Create an instance of ExecutorService with thread pool of size, t
       // ExecutorService exe = Executors.newFixedThreadPool(t);
        
        new ExecutorManager(t);
        
        
       long initialtime = System.currentTimeMillis();
      System.out.println("This is the initial time : " +initialtime*0.001);
      
        
      

            
        //Looping based on the number of coordinates, n 
        for(int i=0; i<n; i++) {
           //Generate random number from 0 to 1000
           x = randomNumber.nextDouble()*1000; 
           y = randomNumber.nextDouble()*1000; 
           
        
           //We have to make sure that there are no duplicate random number
           if(coordinates.size() > 2){
               for(int j = 0; j< coordinates.size();j++){
                   double x1 = coordinates.get(j).getX();
                   double y1 = coordinates.get(j).getY();
                   for(int k = 0; k< coordinates.size()-1; k++){
                        double x2 = coordinates.get(k+1).getX();
                        double y2 = coordinates.get(k+1).getY();
                        if(x1==x2){
                            x = randomNumber.nextDouble()*1000; 
                        }
                        if(y1==y2){
                            y = randomNumber.nextDouble()*1000;
                        }
                   }
               }
           }
          
           //Create new object of Coordinate class
           Coordinate myCoordinate = new Coordinate(x, y);
           
           //Add the object into the ArrayList coordinates
            
           //Add the object 
          
                   coordinates.add(myCoordinate);
                   
            } //End of loop 
      
       
         
             for(Coordinate z : coordinates) { 
                 System.out.println(z);  }
         
     
        
        EdgeConnect.init(coordinates);
       while (edge.size() < n / 2 && !ExecutorManager.getExecutorService().isShutdown()) {
            try {
                Future<Edge> f = ExecutorManager.getExecutorService().submit(new CreateEdge());
                edge.add(f.get());
            } catch (Exception e) {
                // expected
            }
      
       }
        long endtime = System.currentTimeMillis();
      System.out.println("This is the end time : " +endtime*0.001);
        
          for(Edge l : edge) { 
                 System.out.println(l.getNode1()+""+l.getNode2());  }
          
         System.out.println("edge size :"+edge.size());
         
      //shutdown
       System.out.println("Finish everything. Prepare to shut down...");
        if (!ExecutorManager.getExecutorService().isShutdown()) {
            ExecutorManager.getExecutorService().shutdownNow();
        }
        System.out.println("Successfully shut down.");
    }
}
 
       
    

    

    


