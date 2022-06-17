import java.util.Scanner;
import java.util.Random;
public class main {
    Scanner scan = new Scanner(System.in);
    public static void main(String[]args){
        boolean play=mainrun();
        while (play = true){
            play = mainrun();
        }

    }
    public static boolean mainrun(){
        int letters_num = Intro();
        if (letters_num == 5){
            int dif_num = 1;
            char[] wordF = word(letters_num, dif_num);
            String user_guess = chart(letters_num);
            char[] user_guess1 = userInputArray(user_guess);
            checker(user_guess1, wordF);
        }else if ( letters_num !=5){
            int dif_num = Intro_difficultly();
            char[] wordF = word(letters_num, dif_num);
            String user_guess = chart(letters_num);
            char[] user_guess1 = userInputArray(user_guess);
            checker(user_guess1, wordF);
            }
        System.out.println("Do you want to play agian");
        
        return false;
    }
    public static char[] word(int len_word, int dif_number){
        Random rand =  new Random();
        String wordF = "";
        String[] five_letter = {"tests","house"};
        String[] dif_one = {"q","w","e","r","t","y","u","i","o","p"}; // top row only
        String[] dif_two = {"q","w","e","r","t","y","u","i","o","p","a","s","d","f","g","h","j","k","l"}; // top+mid row only
        String[] dif_three = {"q","w","e","r","t","y","u","i","o","p","a","s","d","f","g","h","j","k","l","z","x","c","v","b","n","m"}; // top+mid+bot row only 

        if (len_word == 5){
            int word_num = rand.nextInt(five_letter.length);
            wordF =  five_letter[word_num];
        }
        else if (len_word != 5 && dif_number == 1){
            for (int x=0; x!= dif_one.length; x++){
                int word_num = rand.nextInt(dif_one.length);
                wordF =  wordF + dif_one[word_num];
            }
             
        }
        else if (len_word != 5 && dif_number == 2){
            for (int x=0; x!= dif_one.length; x++){
                int word_num = rand.nextInt(dif_two.length);
                wordF =  wordF + dif_two[word_num];
            }
        }
        else if (len_word != 5 && dif_number == 3){
            for (int x=0; x!= dif_one.length; x++){
                int word_num = rand.nextInt(dif_two.length);
                wordF =  wordF + dif_three[word_num];
            }
        }
        char[] finalword = new char[wordF.length()];
        
        System.out.println(wordF+":");
        for (int x = 0; x!= wordF.length(); x++){
            finalword[x] = wordF.charAt(x);
        }
        return finalword;
    }  

    public static int Intro(){
        Scanner scan = new Scanner(System.in);
        System.out.println("here is a bunch of bs story");
        // make it so the user iputs the numbers
        System.out.println("Enter the amount of letters you want");
        int letters_num = scan.nextInt();
        return letters_num;
    }   
    public static int Intro_difficultly(){
        Scanner scan = new Scanner(System.in);
        System.out.println("enter your diffiucly(1= easy, 2= medium, 3 = hard): ");
        int dif_num = scan.nextInt();
        while (dif_num >=4 || dif_num <=0){
            System.out.println("enter your diffiucly(1 = easy, 2 = medium, 3 = hard): ");
            dif_num = scan.nextInt();
        }
        // make it so the user iputs the numbers
        return dif_num;
    }   

    public static String chart(int letters){
        Scanner scan = new Scanner(System.in);
        // for loop that loops through and prints out the chart depending on the amount of letters
        System.out.println("Enter your guess");
        String user_guess = scan.nextLine();

        return user_guess;
    }

    public static char[] userInputArray(String userInput){
        Scanner scan = new Scanner(System.in);
        char [] userguess = new char[userInput.length()]; 

        for (int x = 0; x!= userInput.length(); x++){
            userguess [x] = userInput.charAt(x);
        }

        return userguess; 
    }
    public static String[] checker(char[]user_guess, char[] wordF){
        Scanner scan = new Scanner(System.in);
        String[] correctArray = new String[user_guess.length];
        if (user_guess == wordF){
            System.out.println("you finished");
            for(int x = 0; x!=user_guess.length; x++){
                correctArray[x] = "*";
            }
            return correctArray;
        }
        for(int x = 0; x!=user_guess.length; x++){
            if (user_guess[x] == wordF[x]){
                correctArray[x] = "#";
            }
            for (int y = 0; y!=wordF.length;y++){
                if (user_guess[x] == wordF[y]){
                    correctArray[x] = "*";
                }
            }
        }
        for (int x = 0; x!=correctArray.length;x++){
            System.out.print(correctArray[x]);

        }
        return correctArray;
    }
}