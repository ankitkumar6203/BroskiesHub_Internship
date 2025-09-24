package org.example;

import java.util.Scanner;

public class StringManipulation{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a String: ");
        String input = sc.nextLine();

        StringBuilder sb = new StringBuilder(input);
        String reverse = sb.reverse().toString();

        int vowels = 0;
        int consonants = 0;
        String lower = input.toLowerCase();
        for(int i=0;i<lower.length();i++){
            char ch = lower.charAt(i);
            if(Character.isLetter(ch)){
                if("aeiou".indexOf(ch) != -1){
                    vowels++;
                }else{
                    consonants++;
                }
            }
        }

        boolean palindrome = input.equalsIgnoreCase(reverse);

        System.out.println("Original String: " + input);
        System.out.println("Reversed String: " + reverse);
        System.out.println("Number of vowels: " + vowels);
        System.out.println("Number of consonants: " + consonants);
        System.out.println("Is Palindrome? " + (palindrome ? "Yes" : "No"));

        sc.close();
    }
}