package com.atm.project;

import java.io.*;
import java.util.ArrayList;

public class TransactionHistory {

    private ArrayList<String> extract = new ArrayList<>();

    /**adding to t. history*/
    public void addToList(String s){
        extract.add(s);
    }

    public void extractAll(){
        System.out.flush();
        for (String s: extract){
            System.out.println(s.toString());
        }
    }

    public void saveToFile(String file){
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(file)))) {
            for (String s: extract) {
                writer.println(s);
            }
        } catch (IOException e) {
            e.getLocalizedMessage();
        }

    }

}
