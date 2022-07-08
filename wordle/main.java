import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
import java.awt.Color;
 
// Erin Tomorri
// Mrs.Katsman
// ICS3U
// 2022-06-16
//My game is basically wordle but labelled as Mastermind. The similarities that I found between the two games are astonishing, you are given the two options on whether the placement is in the right place/near the right place, you get a certain amount of tries and you are given options to input a certain characters/colours. The player is given the option to try to input as many letters as possible, and at 5 letters there are a set of given words, after that, there are a variety of different difficulty levels that the player can choose. If the character of the word is in the right spot the colour of the letter would appear as green and if the character is right but in the wrong spot it would appear as yellow. So to summarise, tiles will change colours depending on how right the word is to the original. So, you try to guess the word/pattern.
public class main {
    Scanner scan = new Scanner(System.in);
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        boolean play = mainrun();
        while (play == true){
            play = mainrun();
        }
        System.out.println("Goodbye");
    }
    public static boolean mainrun(){
        Scanner scan = new Scanner(System.in);
        String name =  name();// gets the user name
        int letters_num = Intro(name); // gets the number length of the word
        int num1;
        if (letters_num == 5){ //if the word length is 5 it will not ask for the difficulty
            int dif_num = 1;
            char[] wordF = word(letters_num, dif_num); // gets the words final length along with the actual word
            int tries = tries(); // gets the amount of tries
            for (int num = 0; num!=tries;num++){ // the loop is what holds the user tries
                String user_guess = guess(letters_num);
                num1 = num;
                char[] user_guess1 = userInputArray(user_guess); // user guess input gets sent into an array
                String[] correctArray = checker(user_guess1, wordF, num1);// checks how correct the user is
                chart(correctArray,user_guess1, wordF, num); //the chart and colours that are printed at the end of the guess
                if (Arrays.equals(user_guess1,wordF)){ // if the user guess array and the final word array are equal it will break the for loop
                    num = tries - 1;
                }
            }
        }
        else if (letters_num != 5){
            int dif_num = Intro_difficultly();
            char[] wordF = word(letters_num, dif_num); // gets the words final length along with the actual word
            int tries = tries(); // gets the amount of tries
            for (int num = 0; num!=tries;num++){ // the loop is what holds the user tries
                String user_guess = guess(letters_num);
                num1 = num;
                char[] user_guess1 = userInputArray(user_guess); // user guess input gets sent into an array
                String[] correctArray = checker(user_guess1, wordF, num1);// checks how correct the user is
                chart(correctArray,user_guess1, wordF, num); //the chart and colours that are printed at the end of the guess
                if (Arrays.equals(user_guess1,wordF)){ // if the user guess array and the final word array are equal it will break the for loop
                    num = tries - 1;
                }
            }
        }
 
        System.out.println("\nDo you want to play again (yes or no): "); // do you want to play again
        String play_again = scan.nextLine();
        play_again = play_again.toLowerCase();
        while (play_again.equals("yes") && play_again.equals("no")){ // if the user doesnt anser yes or no, this part was the hardest part for me
            System.out.println("\nDo you want to play again (yes or no): ");
            play_again = scan.nextLine();
        }
        if (play_again.equals("yes")){
            return true; // if the user wants to play again, it will start over
        }
        return false; // else it will break
    }
    public static int tries(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the amount of tries that you want: ");
        int tries = scan.nextInt(); // enter the amount of tries you want
        while (tries<=0){ // if they enter a number less than 1
            System.out.println("Enter the amount of tries that you want: ");
            tries = scan.nextInt();
        }
        return tries; // return the amount of tries
    }
    public static char[] word(int len_word, int dif_number){
        Scanner scan = new Scanner(System.in);
        Random rand =  new Random();
        String wordF = "";
        // there are two hundreed word below, each 5 letters and have all the ASCII letters (A-Z), I have 5,000 more but it wouldnt be worth putting in all the 5 letter words and I can get a lot more
        String[] five_letter = {"which","there","their","about","would","these","other", "words","could","write","first","water","after","where","right","think","three","years","place","sound","great","again","still","every","small","found","those","never","under","might","while","house","world","below","asked","going","large","until","along","shall",
        "being","often","earth","began","since","study","night","light","above","paper","parts","young","story","point","times","heard","whole","white","given","means","music","miles","thing","today","later","using","money","lines","order","group","among","learn","known","space", "table","early","trees","short","hands","state", "black","shown", "stood", "front","voice","kinds","makes","comes","close","power","lived","vowel","taken","built","heart", "ready","quite","class","bring", "round","horse","shows",
        "piece","green","stand","birds","start","river","tried","least","field","whose","girls", "leave","added","color","third","hours","moved","plant","doing","names","forms","heavy","ideas","cried","check","floor","begin","woman", "alone", "plane","spell","watch","carry","wrote","clear","named","books","child","glass","human","takes","party","build","seems","blood","sides","seven","mouth","solve","north","value","death","maybe","happy","tells", "gives", "looks","shape","lives","steps","areas","sense","speak","force","ocean","speed"};
        String[] dif_one = {"q","w","e","r","t","y","u","i","o","p"}; // top row of keyboard only
        String[] dif_two = {"q","w","e","r","t","y","u","i","o","p","a","s","d","f","g","h","j","k","l"}; // top+mid row of keyboard only
        String[] dif_three = {"q","w","e","r","t","y","u","i","o","p","a","s","d","f","g","h","j","k","l","z","x","c","v","b","n","m"}; // top+mid+bot row of keyboard only
 
        if (len_word == 5){ // if the user adds a five letter word it will choose one at random and save that as the word
            int word_num = rand.nextInt(five_letter.length);
            wordF =  five_letter[word_num];
        }
        else if (len_word != 5 && dif_number == 1){  // if the length isnt 5 and the difficulty is on easy
            for (int x=0; x!= len_word; x++){
                int word_num = rand.nextInt(dif_one.length);
                wordF =  wordF + dif_one[word_num];
            }
             
        }
        else if (len_word != 5 && dif_number == 2){ // if the length is not 5 and the difficulty is on medium
            for (int x=0; x!=len_word ; x++){
                int word_num = rand.nextInt(dif_two.length);
                wordF =  wordF + dif_two[word_num];
            }
        }
        else if (len_word != 5 && dif_number == 3){// if the length is not 5 and the difficulty is on hard
            for (int x=0; x!= len_word; x++){
                int word_num = rand.nextInt(dif_two.length);
                wordF =  wordF + dif_three[word_num];
            }
        }
        char[] finalword = new char[wordF.length()];
        //System.out.println(wordF+": This is to test the code, around line 108 to turn off/on"); // unhide this to test code
        for (int x = 0; x!= wordF.length(); x++){
            finalword[x] = wordF.charAt(x);// this will submit the word into a char array and make it easier to manipulate later on
        }
        return finalword; // retunrn the char array
    }  
    public static String name(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scan.nextLine(); // enter name
        return name;
       
    }
    public static int Intro(String name){
        Scanner scan = new Scanner(System.in); // rules
        System.out.println("HELLO, "+ name+" you currently are on the awesome Erin Show, today we are playing Wordle/Mindmaster.");
        System.out.println("The game took the world by storm & you are about to play a bootleg version of it");
        System.out.println(name+"I suggest you work your way up on the challenges, start with a 5 letter word with 5 tries");
        System.out.println("Next up are some basic rules and facts");
        System.out.println("Rules: 1. you get to choose the amount of letters you want in your word (we only have 5 letter words, everything else is autogenerated)");
        System.out.println("Rules: 2. You get to choose the amount of attempts you want");
        System.out.println("Rules: 3. If the word becomes green its in the right place and if its yellow its the right letter in the wrong place though");
        System.out.println("Rules: 4. If you choose to do more or less than 5 letters, you will be given difficulties, these difficulties are based on the rows of your keyboard");
        System.out.println("Rules: 5. difficulty 1 = top row only, difficulty 2 = middle+top row and difficulty 3 is all the english letters");
        System.out.println("Fact about code: This code is so effiecently coded and jammed pack with different levels/difficulties it would blow away any software developers\n");
 
        // make it so the user iputs the numbers
        System.out.println("Enter the amount of letters you want: ");
        int letters_num = scan.nextInt();
        while (letters_num <=0){ // if the amount of letters is less than 1
            System.out.println("Enter the amount of letters you want: ");
            letters_num = scan.nextInt();
        }
        return letters_num;
    }  
    public static int Intro_difficultly(){
        Scanner scan = new Scanner(System.in); // ask the user for their difficulty level if its not 1,2,3 it will repeate
        System.out.println("enter your difficulty(1= easy, 2= medium, 3 = hard): ");
        int dif_num = scan.nextInt();
        while (dif_num >=4 || dif_num <=0){
            System.out.println("enter your difficulty(1 = easy, 2 = medium, 3 = hard): ");
            dif_num = scan.nextInt();
        }
        // make it so the user inputs the numbers
        return dif_num;
    }  
    public static String guess(int letters){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your guess (letters): ");// the guess of the word
        String user_guess = scan.nextLine();
        user_guess = user_guess.toLowerCase();
        while (user_guess.length() != letters){ // if they guessed to many words it would say they did to many
            System.out.print("Enter your guess (add the amount of letters you said before hand): ");
            user_guess = scan.nextLine();
            user_guess = user_guess.toLowerCase();
        }
        return user_guess;
    }
    public static char[] userInputArray(String userInput){
        Scanner scan = new Scanner(System.in);
        char [] userguess = new char[userInput.length()];
            // changes the user input into an array
        for (int x = 0; x!= userInput.length(); x++){
            userguess [x] = userInput.charAt(x);
        }
 
        return userguess; // returns it
    }
    public static String[] checker(char[]user_guess, char[] wordF, int num){
        Scanner scan = new Scanner(System.in);
        String[] correctArray = new String[user_guess.length];
 
        if (Arrays.equals(user_guess, wordF)){// check if the two arrays are equal to each other
            System.out.println("Congrats you got it in: "+num+1+" tries!"); // it tells the user they won and then they stop playing
            System.out.println("You guess it right congrats!!!!, YOU WON THE $10000000000, in order to get the money you need to give ERIN TOMORRI a really high mark");
            for(int x = 0; x!=user_guess.length; x++){
                correctArray[x] = "#"; // it will replace all the places in the array with the # to signify its correct
            }
            //for (int x = 0; x!=correctArray.length;x++){ //these lines were used to test the code above, I dont think I should delete this
            //    System.out.print(correctArray[x]);
            //}
            return correctArray;
        }
        for(int x = 0; x!=user_guess.length; x++){// this loop will make an array of all of the text that are in the right spot or that are the same letters
            for (int y = 0; y!=wordF.length;y++){
                    if (user_guess[x] == wordF[y] && y!=x){// if the letter is used in the code it will check it and then place a *, will be used later to clolour the console
                        correctArray[x] = "*";
                    }
                    if (user_guess[x] == wordF[x]){
                        correctArray[x] = "#"; // if the letter is in the right spot it will save a # in another array which will be used later to colour the con
                    }
            }
        }
        /* This is used to test if the code above worked and if the symbols appeared in the right place in the array
        for (int x = 0; x!=correctArray.length;x++){
            System.out.print(correctArray[x]);
        for (int x = 0; x!= correctArray.length; x++){
            if (correctArray[x] == null){
                System.out.print(user_guess[x]);
            }
            else if (correctArray[x] == "*"){
                System.out.print(ANSI_YELLOW +user_guess[x]+ANSI_RESET);
            }else if (correctArray[x] == "#"){
                System.out.print(ANSI_GREEN +user_guess[x]+ANSI_RESET);
            }
        }
        }*/
 
        return correctArray;
    }
    public static void chart(String[] correctArray, char[] user_guess, char[] wordF, int num){
    if (num == 0){
        for (int x = 0; x!=correctArray.length;x++){ // this will print out three dashes enough times until it fufills the user amount
            System.out.print("---");
        }
        System.out.print("\n");
        for (int x = 0; x!=correctArray.length;x++){ // this will print out question marks
            System.out.print("|?|");
        }
        System.out.print("\n");
        for (int x = 0; x!=correctArray.length;x++){// this will print out three dashes enough times until it fufills the user amount
            System.out.print("---");
        }
        System.out.print("\n");
    }
        for (int x = 0; x!=correctArray.length;x++){
            if (correctArray[x] == null){ // this will check if the array has a null spot and then it will know not to add colour
                System.out.print("|"+user_guess[x]+"|");
            }else if (correctArray[x] == "*"){ // add a yellow colour if the letter is in the wrong spot
                System.out.print("|"+ANSI_YELLOW +user_guess[x]+ANSI_RESET+"|");
            }else if (correctArray[x] == "#"){// adds green when its in the right spot
                System.out.print("|"+ANSI_GREEN +user_guess[x]+ANSI_RESET+"|");}
        }
        System.out.print("\n");
        for (int x = 0; x!=correctArray.length;x++){
            System.out.print("---"); // it will print out the last portion of the chart, the floor
        }
        System.out.print("\n");
    }
 
 
    public static final String ANSI_RESET = "\u001B[0m"; // to reset the colour back to white in the con
    public static final String ANSI_YELLOW = "\u001B[33m"; // change the colour to yellow when called upon
    public static final String ANSI_GREEN = "\u001B[32m"; // change the colour to green when called upon
}

