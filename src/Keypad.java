
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import java.util.regex.*;


public class Keypad {

    private static Scanner scanner = new Scanner( System.in );

    public static void main(String args[]) {

        String[][] keypad = new String[][]{{}, {}, {"a", "b", "c"}, {"d", "e", "f"}, {"g", "h", "i"}, {"j", "k", "l"}, {"m", "n", "o"}, {"p", "q", "r", "s"}, {"t", "u", "v"}, {"w", "x", "y", "z"}};
        boolean exit = false;

        do {
            System.out.println("1.Question One");
            System.out.println("2.Question Two");
            System.out.println("3.Question Three");
            System.out.println("4.Question Four");
            System.out.println("5.Exit");
            System.out.println("Please make your selection");
            System.out.println("Enter your choice: ");
            Scanner sd = new Scanner(System.in);
            int choice = sd.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Output: " + QOne(keypad));
                    break;
                case 2:
                    System.out.println("Output: " + QTwo(keypad));
                    break;
                case 3:
                    System.out.println("Output: " + Arrays.toString(QThree(keypad)));
                    break;
                case 4:
                    System.out.println("Output: " + Arrays.toString(QFour(keypad ,"words.txt")));
                    break;
                case 5:
                    exit = true;
                    break;
            }
        } while (!exit);
    }
    private static int QOne(String[][] keypad) {

        System.out.println("Question One is chosen!");
        System.out.print("Input: ");
        String input = scanner.nextLine();

        int totalKeypress = 0;
        char[] letters = input.toCharArray();

        for (int i = 2; i < 10; i++) {
            for (int j = 0; j < keypad[i].length; j++) {
                for (char letter:letters) {
                    if (Character.toString(letter).equalsIgnoreCase(keypad[i][j])) {
                        totalKeypress += j + 1;
                    }
                }
            }
        }
        return totalKeypress;
    }

    private static String QTwo(String[][] keypad){
        System.out.println("Question Two is chosen!");
        System.out.print("Input: ");
        String input = scanner.nextLine();

        String numPressed = "";
        StringBuilder stringBuilder = new StringBuilder();

        char[] letters = input.toCharArray();

        for (char letter:letters) {
            for (int i = 2; i < 10; i++) {
                for (int j = 0; j < keypad[i].length; j++) {
                    if (Character.toString(letter).equalsIgnoreCase(keypad[i][j])) {
//                        System.out.println("letter: " + letter + "letter pos: " + Integer.toString(i) );
                        stringBuilder.append(Integer.toString(i));
                    }
                }
            }
        }
        numPressed = stringBuilder.toString();
        return numPressed;
    }

    private static String[] QThree(String[][] keypad){
        System.out.println("Question Three is chosen!");
        System.out.print("Input: ");
        String input = scanner.nextLine();

        ArrayList<String[]> numtoLetters = new ArrayList<>();
        String[] finalCombination = {};

        char[] numbers = input.toCharArray();

        for (char num:numbers) {
            numtoLetters.add(keypad[Character.getNumericValue(num)]);
        }

        while (numtoLetters.size()>1)
        {
            finalCombination = basicCombination(numtoLetters.get(0),numtoLetters.get(1));
            numtoLetters.remove(0);
            numtoLetters.remove(0);
            numtoLetters.add(0,finalCombination);
        }

        return finalCombination;

    }

    private static String[] basicCombination (String[] arr1, String[] arr2) {
        String[] resultArr = new String[arr1.length * arr2.length];
        String temporaryString = "";
        int numIterate =0;

            for (int i = 0; i < arr1.length; i++) {
                for (int j = 0; j < arr2.length; j++) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(arr1[i]);
                    stringBuilder.append(arr2[j]);
                    temporaryString = stringBuilder.toString();
                    resultArr[numIterate] = temporaryString;
                    numIterate++;
                }
            }
        return resultArr;
    }
    private static String[] QFour(String[][] keypad, String filename) {
        System.out.println("Question Four is chosen!");
        System.out.print("Input: ");
        String input = scanner.nextLine();

        Scanner sc = null;
        try {
            sc = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<String> lines = new ArrayList<String>();
        while (sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }

        String[] dictionary = lines.toArray(new String[0]);

        ArrayList<String> possibleWords = new ArrayList<>();

        String regex = "";
        char[] numbers = input.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char num:numbers) {

            stringBuilder.append('[');
            int index = Character.getNumericValue(num);

            for (int i=0;i<keypad[index].length;i++){
                stringBuilder.append(keypad[index][i]);
            }
            stringBuilder.append(']');
        }
        regex = stringBuilder.toString();
//        System.out.println("regex: " + regex);

        for (String word:dictionary) {

            if (Pattern.matches(regex, word)) {
                possibleWords.add(word);
            }
        }

    return possibleWords.toArray(new String[possibleWords.size()]);
    }

}
