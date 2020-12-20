/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class Main {

    // Iterative function to generate all permutations of a String in Java
    // using Collections
    public static void permutations(String Letters)
    {
        // create an empty ArrayList to store (partial) permutations
        List<String> partial = new ArrayList<>();
 
        // initialize the list with the first character of the string
        partial.add(String.valueOf(Letters.charAt(0)));
 
        // do for every character of the specified string
        for (int forwardLetter = 1; forwardLetter< Letters.length(); forwardLetter++)
        {
            // consider previously constructed partial permutation one by one
 
            // (iterate backwards to avoid ConcurrentModificationException)
            for (int backwardLetter = partial.size() - 1; backwardLetter >= 0 ; backwardLetter--)
            {
                // remove current partial permutation from the ArrayList
                String str = partial.remove(backwardLetter);
 
                // Insert next character of the specified string in all
                // possible positions of current partial permutation. Then
                // insert each of these newly constructed string in the list
 
                for (int nextLetter = 0; nextLetter <= str.length(); nextLetter++)
                {
                    // Advice: use StringBuilder for concatenation
                    partial.add(str.substring(0, nextLetter) + Letters.charAt(forwardLetter) +
                                str.substring(nextLetter));
                }
            }
        }
 
        System.out.println(partial);
    }
 
    // Iterative program to generate all permutations of a String in Java
    public static void main(String[] args) {
        String Letters = "ABC";
        permutations(Letters);
    }
    
}