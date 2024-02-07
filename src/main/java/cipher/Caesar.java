package cipher;

import constants.Alphabets;

import com.github.pemistahl.lingua.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


import static com.github.pemistahl.lingua.api.Language.*;


public class Caesar {
    public static String toCipher(int key, String textToCipher) {
        StringBuilder result = new StringBuilder();
        if (textToCipher.isEmpty())
            return "";
        else {
            //get alphabet using an external library
            String alphabet = Alphabets.valueOf(
                    LanguageDetectorBuilder.fromLanguages(ENGLISH, UKRAINIAN).build()
                            .detectLanguageOf(textToCipher).toString()).getAlphabet();
            // adjust key
            key = keyAdjustment(key, alphabet.length());

            for (int i = 0; i < textToCipher.length(); i++) {
                //adjust shift
                char currentChar = textToCipher.charAt(i);
                if (Character.isLowerCase(currentChar)) {
                    result.append(alphabet.charAt((alphabet.indexOf(currentChar) + key) % alphabet.length()));

                } else if (Character.isUpperCase(currentChar)) {
                    char temp = Character.toLowerCase(currentChar);
                    result.append(Character.toUpperCase(alphabet.charAt((alphabet.indexOf(temp) + key) % alphabet.length())));
                } else
                    result.append(currentChar);
            }
        }
        return result.toString();
    }

    private static int keyAdjustment(int key, int length) {
        if (key < 0) {
            key += length;
        } else if (key >= length) {
            key -= length;
        }
        return key;
    }

    public static String toDecipher(int key, String textToDecipher) {
        return toCipher(-key, textToDecipher);
    }

    public static int getKey(String textToDecipher) {
        String alphabet = Alphabets.valueOf("UKRAINIAN").getAlphabet();
        //initializing arraylist with logarithms
        Double[] arrayWithLogarithms = {-3.6, -6.0, -4.2, -6.0, -13.3, -4.8, -4.4, -8.0, -7.1, -5.6, -4.1, -6.3, -4.0, -6.9, -4.6, -4.7, -5.0, -3.8, -3.4, -5.1, -4.2, -4.5, -4.4, -4.9, -8.2, -6.4, -6.6, -6.4, -7.1, -8.3, -5.8, -7.2, -5.3};
        ArrayList<Double> logArray =  new ArrayList(Arrays.asList(arrayWithLogarithms));
        //counting all occurrences of letters
        ArrayList<Integer> occurrencesArray = getOccurrencesArray(textToDecipher, alphabet);
        //getting the formula calculated
        ArrayList<Double> logarithmicProbabilityArray = getLogarithmicProbabilityArray(logArray, occurrencesArray, alphabet.length());
        //end result
        Integer key = logarithmicProbabilityArray.indexOf(Collections.max(logarithmicProbabilityArray));
        System.out.println(key);
        chart.LineChartEx.chart(logarithmicProbabilityArray);
        return key;
    }

    private static ArrayList<Integer> getOccurrencesArray(String text, String alphabet) {
        ArrayList<Integer> result = new ArrayList<>();
        for (char a : alphabet.toCharArray()) {
            int counter = 0;
            for (char t : text.toLowerCase().toCharArray()) {
                if (Character.isAlphabetic(t)) {
                    if (a == t)
                        counter++;
                }
            }
            result.add(counter);
        }
        return result;
    }

    private static ArrayList<Double> getLogarithmicProbabilityArray(ArrayList<Double> logArray,
                                                                    ArrayList<Integer> occurrencesArray, int length) {
        ArrayList<Double> result = new ArrayList<>();
        for (int k = 0; k < length; k++) {
            double temp = 0;
            for (int j = 0; j < length; j++) {
                temp += occurrencesArray.get((j + k) % length) * logArray.get(j);
            }
            result.add(temp);
        }
        return result;
    }
}
