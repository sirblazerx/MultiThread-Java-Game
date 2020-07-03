/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class EdgeConnect {
    private static ArrayList<Coordinate> node;
    
    public static void init(ArrayList<Coordinate> listOfNode) {
        node = listOfNode;
    }
    
    public static Integer getListOfNodeSize() {
        return node.size();
    }

    public static Coordinate get(int index) {
        return node.get(index);
    }
    public synchronized static Edge connect(Coordinate n1, Coordinate n2) throws InterruptedException {
   Edge edge = new Edge();
   edge.setNode1(n1);
   edge.setNode2(n2);
   return edge;
    
    }
    }

