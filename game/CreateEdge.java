/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

/**
 *
 * @author User
 */
public class CreateEdge implements Callable <Edge> {
    
   private int count = 0;
   Random r = new Random();

    @Override
    public Edge call() throws Exception {
         Edge edge = null;
         
         while (count < 20) {
            // we want the thread to die after executor is ended
           if (ExecutorManager.getExecutorService().isShutdown()) {
                return null;
            }
           int node1 = r.nextInt(EdgeConnect.getListOfNodeSize());
           int node2 = r.nextInt(EdgeConnect.getListOfNodeSize());
           
         if(node1 == node2){
         continue;
         }
           Coordinate one = EdgeConnect.get(node1);
           Coordinate two = EdgeConnect.get(node2);
           
           edge = EdgeConnect.connect(one, two);
           
           if(edge == null) {
               count++;
           }else {break;}
         }
           
          if (count >= 20) {
            throw new IllegalStateException("Counter exceed!");
        } else if (edge == null) {
            throw new IllegalStateException("Edge cannot be null!");
        }
        return edge;
    }
        
    }
    
    

   

