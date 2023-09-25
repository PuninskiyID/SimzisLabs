package simzis_1;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PasswordGenerator {

    private static final String ALPHABET = " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";

    public static String generateRandomString(int length) {
        Random rand = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = rand.nextInt(ALPHABET.length());
            password.append(ALPHABET.charAt(randomIndex));
        }

        return password.toString();
    }

    public static void visualizeFrequency(String password) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char c : password.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " times");
        }
    }

    public static double calculateAverageTime(String password) {
        String generatedPassword = password;
        Random rand = new Random();
        char[] passwordChars = password.toCharArray();

        long startTime = System.nanoTime();

        int attempts = 10000;
        for (int i = 0; i < attempts; i++) {
            char randomChar = passwordChars[rand.nextInt(passwordChars.length)];
            if (randomChar == generatedPassword.charAt(0)) {
                break;  // Password found
            }
        }

        long endTime = System.nanoTime();
        double elapsedTime = (endTime - startTime) / 1e9;  // Convert to seconds
        return elapsedTime / attempts;
    }

    
}