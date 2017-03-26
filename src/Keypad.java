
import java.util.Scanner;


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

                case 5:
                    exit = true;
                    break;
            }
        } while (!exit);
    }
    public static int QOne(String[][] keypad) {

        System.out.println("Question One is chosen!");
        System.out.print("Input: ");
        String input = scanner.nextLine();

        int totalKeypress = 0;
        char[] letters = input.toCharArray();
        for (int i = 2; i < 10; i++) {
            for (int j = 0; j < keypad[i].length; j++) {
                for (int k = 0; k < letters.length; k++) {
                    if (Character.toString(letters[k]).equalsIgnoreCase(keypad[i][j])) {
                        totalKeypress += j + 1;
                    }
                }
            }
        }
        return totalKeypress;
    }

    public static String QTwo(String[][] keypad){
        System.out.println("Question Two is chosen!");
        System.out.print("Input: ");
        String input = scanner.nextLine();

        String answer ="";
        return answer;
    }
}






//        int totalKeypress = 0;
//        char[]letters = input.toCharArray();
//        for (int i = 2; i<10; i++){
//            for (int j=0;j<keypad[i].length;j++){
//                for (int k=0; k<letters.length;k++){
//                    if (Character.toString(letters[k]).equalsIgnoreCase(keypad[i][j])){
//                        totalKeypress += j+1;
//                }
//            }
//        }
//
//    }
//        System.out.println( "output = " + totalKeypress );
//    }
//}
//
