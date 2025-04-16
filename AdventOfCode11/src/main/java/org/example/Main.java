package org.example;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArrayList<Long> arrangement = new ArrayList<>();
        arrangement.ensureCapacity(1000000000);
        try{
            File input = new File("AdventOfCode11Input.txt");
            Scanner myScanner = new Scanner(input);
            while(myScanner.hasNextInt()){
                arrangement.add(myScanner.nextLong());
            }
        }
        catch(FileNotFoundException e){
            System.out.println("An error has occurred");
        }
        for(int i = 0; i < 75; i++){
            for(int j = 0; j < arrangement.size(); j++){
                if(arrangement.get(j) == 0){
                    arrangement.set(j, (long)1);
                }
                else if(String.valueOf(arrangement.get(j)).length() % 2 == 0){
                    String placeHolder = String.valueOf(arrangement.get(j));
                    String newValue1 = placeHolder.substring(0, placeHolder.length()/2);
                    String newValue2 = placeHolder.substring(placeHolder.length()/2);
                    arrangement.set(j, Long.parseLong(newValue1));
                    j++;
                    arrangement.add(j, Long.parseLong(newValue2));
                }
                else{
                    long temp = arrangement.get(j);
                    temp *= 2024;
                    arrangement.set(j, temp);
                }
            }
            System.out.println(i);
        }
        System.out.println(arrangement.size());
    }
}