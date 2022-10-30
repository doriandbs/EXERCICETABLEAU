import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.Exception;
import java.util.regex.*;

import static java.lang.System.in;

import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        Integer[] tableau = {5, 11, 10, 5, 64, 9, 1, 0, 2, 3};
        Integer[] tableau2 = {1, 56, 51, 80, 95};
        int min;
        int max;
        infostab(tableau);
        infostab(tableau2);
        trier(tableau);
        trier(tableau2);
        List<Integer> Tab = Arrays.asList(tableau);
        min = Collections.min(Tab);
        max = Collections.max(Tab);
        MinMax(tableau,min,max);
        Integer[] newTab = TabConca(tableau, tableau2);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("rentrer une valeur : ");
        int saisie = Integer.parseInt(br.readLine());

            if(verifsaisie(saisie, newTab)==false){
                existe(newTab, saisie);
            }

    }


    public static <Integer> Integer[] TabConca(Integer[] premierTab, Integer[] sndTab) {
        Integer[] newTab = Arrays.copyOf(premierTab, premierTab.length + sndTab.length);
        System.arraycopy(sndTab, 0, newTab, premierTab.length, sndTab.length);
        System.out.println("\nNouveau tableau concaténé : " + Arrays.toString(newTab) + " | taille : " + newTab.length);
        Arrays.sort(newTab);
        System.out.println("\nTableau concaténé trié : " + Arrays.toString(newTab));
        return newTab;

    }

   public static void existe(Integer[]newTab, int saisie) {
       int result=0;
        System.out.println("\nSi votre saisie est dans le tableau, nous allons multiplier par 5 chaques valeurs correspondantes à votre saisie");
       for (int i = 0; i < newTab.length; i++) {
           if (saisie == newTab[i]) {
              newTab[i] = saisie * 5;
              result=1;
              System.out.println("Valeur trouvée");
           }
       }
       if(result==0) {
            System.out.println("Malheureusement, votre valeur n'est pas dans le tableau");
       }else {
           System.out.println("\nVotre nouveau tableau : " + Arrays.toString(newTab));
       }
    }
    public static void MinMax(Integer[]tableau, int min, int max){
        System.out.println("\nElement maximum : " + max + " | Indice : " + Arrays.binarySearch(tableau, max));
        System.out.print("\nElement minimum : " + min + " |Indice : " + Arrays.binarySearch(tableau, min));
    }
    public static void trier(Integer[] tableau) {
        Arrays.sort(tableau);
        System.out.print("\nTableau trié :" + Arrays.toString(tableau));

    }

    public static void infostab(Integer[] tableau) {
            System.out.print("\nTableau " + Arrays.toString(tableau) + " | taille : " + tableau.length);
    }

    public static boolean verifsaisie(int saisie, Integer[] newTab)  {
        String regex = "[0-9]";
        if (Pattern.matches(regex, "saisie")) {
            System.out.println("Pas au bon format");
            return false;
        } else {
            existe(newTab, saisie);
            return true;

        }

    }
}

