/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pairingalgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author Jubril
 */
public class PairingAlgorithm {
    static double yearWeight = 0.5;
    static double projectWeight = 0.35;
    static double numberOfLanguageWeight = 0.15;
    static int weight;
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Integer> weightValues = new ArrayList<>();
        ArrayList<String>  names = new ArrayList<>();
        HashMap<String,Integer> hashMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of people per group");
        int numberOfPeoplePerGroup = scanner.nextInt();
        System.out.println("Enter number of people");
        int iteration = scanner.nextInt();
        System.out.println("Enter name, Number of years, number of projects and Number Of Languages");
        for (int i = 0; i < iteration; i++) {
            // takes input calculates the weight and saves the value in the arraylist 
            String name = scanner.next();
            int numberOfYears = scanner.nextInt();
            int numberOfProject = scanner.nextInt();
            int numberOfLanguages = scanner.nextInt();
            weight = (int) ((yearWeight*numberOfYears)+(projectWeight*numberOfProject)+(numberOfLanguageWeight*numberOfLanguages));
            weightValues.add(Integer.signum(weight));
            System.out.println(weight);
            hashMap.put(name,weight);
        }
        // sorts the hashmap
        Map<String, Integer> map = new TreeMap<>(hashMap);
        for (Map.Entry<String,Integer> entry : map.entrySet()){
                 names.add(entry.getKey());
            }
        int startpoint = 0;
        for (int i = numberOfPeoplePerGroup; i <=names.size(); i=i+numberOfPeoplePerGroup) {
              for (int j = startpoint; j <i; j++) {
                  System.out.print(names.get(j)+" ");
                  startpoint = i;
            }
              System.out.println("\n");
              
        }
        
    }
    
    public static float normaliseWeight(int inValue, int min, int max) {
        return (inValue - min)/(max - min);
}
 
    
}
