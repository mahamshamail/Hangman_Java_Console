import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Game {
    //properties
    private Player player;
    private WordBank wordBank;
    private char letterBank []  ;
    private int currentLevel =1;
    private ArrayList<Character> wrongGuesses;
    private ArrayList<Character> rightGuesses;
    private ArrayList<String> guessedWords;
    private Scanner scan ;
    private static int quitGame = 0;
    private String menuSelection = "start";
    private final String[] hangmans = {"                                   +        +\n" +
                                 "                                             \n" +
                                 "                                             \n" +
                                 "                                             \n" +
                                 "                                             \n" +
                                 "                                             \n" +
                                "                     ==============HANGMAN=============",
                                 "                                   +        +\n" +
                                 "                                            |\n" +
                                 "                                            |\n" +
                                 "                                            |\n" +
                                 "                                            |\n" +
                                 "                                            |\n" +
                                 "                     ==============HANGMAN=============",
                                 "                                   +--------+\n" +
                                 "                                            |\n" +
                                 "                                            |\n" +
                                 "                                            |\n" +
                                 "                                            |\n" +
                                 "                                            |\n" +
                                 "                     ==============HANGMAN=============",
                                "                                   +--------+\n" +
                                "                                       |    |\n" +
                                "                                            |\n" +
                                "                                            |\n" +
                                "                                            |\n" +
                                "                                            |\n" +
                                "                     ==============HANGMAN=============",
                                "                                    +--------+\n" +
                                "                                        |    |\n" +
                                "                                        0    |\n" +
                                "                                             |\n" +
                                "                                             |\n" +
                                "                                             |\n" +
                                "                     ==============HANGMAN=============",
                                "                                   +--------+\n" +
                                "                                        |    |\n" +
                                "                                        0    |\n" +
                                "                                        |    |\n" +
                                "                                             |\n" +
                                "                                             |\n" +
                                "                     ==============HANGMAN=============",
                                "                                    +--------+\n" +
                                "                                        |    |\n" +
                                "                                        0    |\n" +
                                "                                       /|    |\n" +
                                "                                             |\n" +
                                "                                             |\n" +
                                "                     ==============HANGMAN=============",

                                "                                   +--------+\n" +
                                "                                       |    |\n" +
                                "                                       0    |\n" +
                                "                                      /|\\   |\n" +
                                "                                            |\n" +
                                "                                            |\n" +
                                "                     ==============HANGMAN=============",
                                "                                   +--------+\n" +
                                "                                       |    |\n" +
                                "                                       0    |\n" +
                                "                                      /|\\   |\n" +
                                "                                      /     |\n" +
                                "                                            |\n" +
                                "                     ==============HANGMAN=============",
                                "                                  +--------+\n" +
                                "                                      |    |\n" +
                                "                                      0    |\n" +
                                "                                     /|\\   |\n" +
                                "                                     / \\   |\n" +
                                "                                           |\n" +
                                "                     ==============HANGMAN============="};
    //private SportsWords sportsWords = new SportsWords();
    //private MovieWords movieWords = new MovieWords();
    private static final String hangman =
                                   "________________________________________________________________________________\n" +
                                   "                                 HANGMAN GAME\n" +
                                   "               ______________+===================+______________\n" +
                                   "                                       |    |\n" +
                                   "                                       O    |\n" +
                                   "                                      /|\\   |\n" +
                                   "                                      / \\   |\n" +
                                   "                                            |\n" +
                                   "               ________________===================_______________\n" +
                                   "________________________________________________________________________________\n";
    //here
    private static final String otherOptions =
            "\tOTHER OPTIONS:-\n" +
            "\t->Press '1' to go BACK to PREVIOUS MENU.\n" +
            "\t->Press '2' to go QUIT.\n" +
            "________________________________________________________________________________\n"+
            "User Input: ";
    private static final String mainMenu =
            "________________________________________________________________________________\n"+
            "________________________________      MAIN MENU    _____________________________\n" +
            "\t-> Press 'S' to START GAME.\n" +
            "\t-> Press 'V' to VIEW THE RULES of the game.\n" +
            "\t-> Press 'R' to RESET player NAME.\n" +
            "\t-> Press '2' to QUIT.\n" +
             "________________________________________________________________________________\n"+
            "User Input: ";
    private static final String wrongInput = "ERROR: Wrong Input. TRY AGAIN!\n"+
            "User Input: ";
    //here

    private static final String wordCategoryOptions =
            "________________________________________________________________________________\n" +
            "_____________________________ SELECT WORD CATEGORY _____________________________\n" +
            "\t-> Press 'M' to play MOVIES category.\n" +
            "\t-> Press 'P' to play SPORTS category.\n"+
            "\t-> Press 'A' to play ALL categories.\n";
    private static final String rules =
            "____________________________ THE RULES OF THE GAME _____________________________\n" +
            "________________________________________________________________________________\n" +
            "                              ~ INSTRUCTIONS ~\n\n" +
            "\t\tGuess letters   one   at   a time  to  solve  the word  puzzle.\n" +
            "\t\tUsing your keyboard  type one letter each time to pick a guess.\n" +
            "\t\tEach  time you  solve  a  word,  you will advance to  the  next\n" +
            "\t\tlevel and guess again. \n" +
            " \n" +
            "\t\t\t\t\t\t~ HANGMAN TIPS AND STRATEGIES ~\n" +
            " \n" +
            "\t\tTry guessing  the  vowels - A good  strategy  is to   begin  by\n" +
            "\t\tguessing a few vowels. With only five  vowels  in  the  English\n" +
            "\t\talphabet, you’ll quickly fill up those  blanks  without  losing\n" +
            "\t\ttoo many balloons.\n" +
            " \n" +
            "\t\tEtaoin  shrdlu   -  \"Etaoin shrdlu\"   isn’t  a  phrase  from  a\n" +
            "\t\tforeign  language. It’s just a list  of the most common letters\n" +
            "\t\tused  in  English,  in   order  of  frequency. \"E\" is  the most\n" +
            "\t\tcommonly  used  letter,\"t\" is  second-most common, etc. So  try\n" +
            "\t\tguessing those letters first.\n" +
            " \n" +
            "\t\tRemember the category -  During each  round  of  hangman you'll\n" +
            "\t\twant to use that hint to focus your guesses.\n" +
            " \n" +
            "\t\tSolve individual words - Sometimes  you’re not   solving  for a\n" +
            "\t\tword, but a phrase. Make sure you’re trying to  solve   each of\n" +
            "\t\tthe words individually and not just hyper-focusing on  guessing\n" +
            "\t\tthe correct letters.  If you’re able to solve even one  word in\n" +
            "\t\tthe phrase, that word, combined with the tip at the top  of the\n" +
            "\t\twindow, will greatly increase your  chances  of  winning   that\n" +
            "\t\tround of hangman.\n" +
            " \n" +
            "\t\tDon’t forget your Js and Zs -  The letters J  and  Z always trip\n" +
            "\t\tpeople up. They’re both fairly  rare and it’s not always obvious\n" +
            "\t\twhen you need one to  complete a word or phrase. Don’t guess a Z\n" +
            "\t\tor a J at the very beginning, but keep them in mind as you play.\n" +
            " \n" +
            "\t\t\t\t~ WHAT DO YOU LEARN FROM PLAYING HANGMAN ~\n" +
            " \n" +
            "\t\tHangman teaches  you  spelling,  vocabulary, and  other  related\n" +
            "\t\tlanguage  skills. Hangman can  also  help  expand  your  topical\n" +
            "\t\tknowledge.\n" +
            "________________________________________________________________________________\n" ;
    private static final String gameStarted =
            "________________________________________________________________________________\n" +
            "______________________________      GAME HAS STARTED!   _________________________\n";
    //constructors
    public Game(){
        this.letterBank = new char[26] ;
        scan = new Scanner(System.in);
        rightGuesses= new  ArrayList<Character>();
        guessedWords= new  ArrayList<String>();
        wrongGuesses= new  ArrayList<Character>();
        this.wordBank = new WordBank();
        System.out.print(hangman);
        this.player = new Player();
        System.out.println(//"________________________________________________________________________________\n" +
                "                          WELCOME TO HANGMAN "+this.player.getName().toUpperCase()+"!");
        this.startMenu();
    }

    //methods
    public void startMenu(){
        while(this.quitGame!=1){
            Word currentWord = new Word();
            //enters program
            if(this.menuSelection.equalsIgnoreCase("start") || this.menuSelection.equalsIgnoreCase("back")) {
                //main menu
                System.out.print(mainMenu);
                this.menuSelection = scan.next();// user selects an option from main menu s= start game, v= view rules, q= quit
            }
            else if(this.menuSelection.equalsIgnoreCase("s")){
                //start game option selected by the player
                while(!this.menuSelection.equalsIgnoreCase("back")){ //enters here
                    //if this loop breaks then it goes back to main menu
                    this.menuSelection = playGame(currentWord,1,wordCategoryOptions, wrongInput, this.menuSelection, otherOptions, "back");
                }
            }
            else if(this.menuSelection.equalsIgnoreCase("v")){
                this.menuSelection= playGame(currentWord,5,rules, wrongInput,  this.menuSelection,  otherOptions,"back");
            }
            else if(this.menuSelection.equalsIgnoreCase("2")) {
                quitGame=exitGame();
            }
            else if(this.menuSelection.equalsIgnoreCase("r")) {
                System.out.print("Reset Player Name: ");
                this.player.setName(scan.next());
                System.out.println("Returning to main menu.");
                this.menuSelection= "back";
            }
            else{
                System.out.print(wrongInput);
                this.menuSelection = scan.next();
            }
        }
    }

    public static int exitGame(){
        System.out.println("YOU ARE QUITING THE GAME. \nGOODBYE!\n"+
                "________________________________________________________________________________\n" );
        //condition that allows us to end the game;
        return 1;
    }
    public  String playGame(Word currentWord, int i, String cat, String wrongInput, String menuSelection, String otherOptions, String back){
        Scanner scan =new Scanner(System.in);
        System.out.println(cat);
        System.out.println(otherOptions);
        menuSelection = scan.next(); // B=back, q=quit, anything else error
        while(!menuSelection.equalsIgnoreCase(back)){
            if(menuSelection.equalsIgnoreCase("1")){
                menuSelection = back;
                System.out.println("Going back to previous menu.");
                return menuSelection;
            }else if(menuSelection.equalsIgnoreCase("2")) {
                System.out.println("Exiting Program.\n________________________________________________________________________________\n");
                System.exit(0);
            }
            else if(i==1 && menuSelection.equalsIgnoreCase("p")){
                //SPORTS CATEGORY
                 currentWord = wordBank.getRandomWord("sports");
                menuSelection= playGame(currentWord,0,gameStarted, wrongInput,menuSelection,this.initialWordConfig(0,currentWord)+ otherOptions,"back1");
                return menuSelection;
            }
            else if (i==1 && menuSelection.equalsIgnoreCase("m")){
                //MOVIES CATEGORY
                currentWord = wordBank.getRandomWord("movies");
                menuSelection= playGame(currentWord,0,gameStarted, wrongInput, menuSelection,this.initialWordConfig(0,currentWord)+otherOptions, "back1");
                return menuSelection;
            }
            else if (i==1 && menuSelection.equalsIgnoreCase("a")){
                //MOVIES CATEGORY
                currentWord = wordBank.getRandomWord("all");
                menuSelection= playGame(currentWord,0,gameStarted, wrongInput, menuSelection,this.initialWordConfig(0,currentWord)+otherOptions, "back1");
                return menuSelection;
            }
            else if(i==0){ //checks character guesses in a word
                //display random word using initialise wordbank?
                // word cat, word in dashes, letter bank,
                // Wrong guesses (Not in letterbank, not in word)  -> updates array of wrong guesses and hangman pic and dashedWord
                // right guesses (is in letterbank, is in the word) -> updates array of right guesses and hangman pic and dashedWord
                // hangman picture -> updated when wrong or right
                int gameEnds=0;
                int chances = 10;
                //game end -> guesses word -> gets hung
                while(gameEnds!=9) {
                    if(menuSelection.equalsIgnoreCase("3")){
                        System.out.print("Next Guess: ");
                        menuSelection = scan.next();
                        if(menuSelection.equals("1") || menuSelection.equals("2") ){
                            gameEnds=9;
                            i =5;
                            this.wrongGuesses.clear();
                            this.rightGuesses.clear();
                            this.guessedWords.clear();
                            this.letterBankReset();
                            gameEnds=0;
                            currentWord.convertWordToDashes();
                            currentLevel =1;
                            System.out.println("Warning: You are exiting a game in progress.\n" +
                                               "Your progress will be lost.");
                            break;
                        }

                    }
                    else if (this.letterBankCheck(menuSelection.charAt(0))) {//letter in letter bank
                        if (!currentWord.convertDashesToCharacters(menuSelection.charAt(0), currentWord.getDashedWord()).equalsIgnoreCase("Word does not contain this letter.\n")) {
                            //char is in word, correct word//right guess
                            this.rightGuesses.add(menuSelection.charAt(0));
                            char [] lb = letterBankUpdate(menuSelection.charAt(0));
                            this.setLetterBank(lb) ;//letterbank updated
                            currentWord.setDashedWord(currentWord.convertDashesToCharacters(menuSelection.charAt(0), currentWord.getDashedWord()));//updated dashed word
                            if(currentWord.getTitle().equalsIgnoreCase(currentWord.getDashedWord())){
                                currentLevel++;
                                guessedWords.add(currentWord.getTitle());
                                if(currentLevel==6){
                                    System.out.println( "  SSSSSSSSSSSS______________________________________________________________________\n" +
                                                        " *SSSSSSSSSSSSSS~!!!!*__~___~__~___~___~____~__~______~____~_~__~___~_______________*\n" +
                                                        "SSSSSSSSSSSSSSSSSS!!!!  ~  OMG! ~  YOU WON!!! ~``\\_(^ w ^)_/    !!!!!SSSSSSSSSSSSSSSS\n" +
                                                        " *__________________~___~__~___~___~____~__~______~____~_~__~___~_____SSSSSSSSSSSSSS \n"+
                                                        "  _________________________________________________________________________________ \n"  );
                                    System.exit(0);
                                }
                                else{
                                    System.out.println("  ______________________________________________________________________________\n" +
                                                       " *____________________~___~__~___~___~____~__~______~____~_~__~___~_______________*\n" +
                                                        "!!!!!!!SSSSSSSSSS           You guessed the word right!         SSSSSSSSSSS!!!!!!!!\n" +
                                                        "!!!!!!!SSSSSSS    Congrats you've advanced to the next level!     SSSSSSSSS!!!!!!!!\n" +
                                                       " *________________~___~__~___~___~____~__~______~____~_~__~___~___________________*\n" +
                                                        "  ______________________________________________________________________________\n"  );
                                    int y=0;
                                    while(y!=1){//checks that guessed words are not repeated in the next level
                                        currentWord.setDashedWord(currentWord.convertWordToDashes());
                                        currentWord =wordBank.getRandomWord(currentWord.getCategory());
                                        int p =0;
                                        for (int k=0; k<guessedWords.size(); k++){
                                            if(guessedWords.get(k).equalsIgnoreCase(currentWord.getTitle())){
                                                currentWord =wordBank.getRandomWord(currentWord.getCategory());
                                                p=1;
                                            }
                                        }
                                        if(p==0){//
                                            y=1;
                                            lb= this.letterBankReset();
                                            gameEnds=0;
                                            this.wrongGuesses.clear();
                                            this.rightGuesses.clear();
                                            currentWord.setDashedWord(currentWord.convertWordToDashes());
                                        }
                                    }


                                }
                            }
                            String p="________________________________________________________________________________\n"  +
                                    "__________________________      GAME  is  RUNNING!   ____________________________\n" +
                                    "                                 Current Level : "+this.currentLevel+"\n" +
                                    "________________________________________________________________________________\n" +
                                    "\n" +
                                    hangmans[gameEnds] +"\n"+
                                    "Word category: "+currentWord.getCategory().toUpperCase()+"\n" +
                                    "Word : "+currentWord.getDashedWord()+"\n" +
                                    "Incorrect Letters : "+Arrays.toString(this.wrongGuesses.toArray())+"\n" +
                                    "Correct Letters : "+Arrays.toString(this.rightGuesses.toArray())+"\n" +
                                    "Chances Left : "+(10-(gameEnds))+"\n" +
                                    "\n" +
                                    "\tGAME OPTIONS:-\n" +
                                    "\t-> TAKE A GUESS WITH ONE OF THE FOLLOWING CHARACTERS:-\n" +
                                     Arrays.toString(lb)+ "\n"+
                                    "\tOTHER OPTIONS:-\n" +
                                    "\t->Press '1' to go BACK to PREVIOUS MENU.\n" +
                                    "\t->Press '2' to go QUIT.\n" +
                                    "________________________________________________________________________________\n"   ;
                            System.out.println(p);
                            menuSelection = "3";
                        }
                        else {//char is not in word, wrong guess update wrong guess, update letterbank
                            System.out.println("OOPS! Wrong guess!");
                            char [] lb = letterBankUpdate(menuSelection.charAt(0));
                            this.setLetterBank(lb) ;//letterbank updated
                            this.wrongGuesses.add(menuSelection.charAt(0));
                            gameEnds++;//
                            String p="________________________________________________________________________________\n" +
                                     "___________________________      GAME  is  RUNNING!   __________________________\n" +
                                    "                                Current Level : "+this.currentLevel+"\n" +
                                     "________________________________________________________________________________\n" +
                                    "\n" +
                                    hangmans[gameEnds] +"\n"+
                                    "Word category: "+currentWord.getCategory().toUpperCase()+"\n" +
                                    "Word : "+currentWord.getDashedWord()+"\n" +
                                    "Incorrect Letters : "+Arrays.toString(this.wrongGuesses.toArray())+"\n" +
                                    "Correct Letters : "+Arrays.toString(this.rightGuesses.toArray())+"\n" +
                                    "Chances Left : "+(10-(gameEnds))+"\n" +
                                    "\n" +
                                    "\tGAME OPTIONS:-\n" +
                                    "\t-> TAKE A GUESS WITH ONE OF THE FOLLOWING CHARACTERS:-\n" +
                                    Arrays.toString(lb) + "\n"+
                                    "\tOTHER OPTIONS:-\n" +
                                    "\t->Press '1' to go BACK to PREVIOUS MENU.\n" +
                                    "\t->Press '2' to go QUIT.\n" +
                                    "________________________________________________________________________________\n" ;
                            System.out.println(p);
                            if(gameEnds==9){
                                System.out.println("  ~(T_T)~~(x_x)~~(T_T)~~(x_x)~ MAN HUNG. YOU LOST! (x_x)(T_T)~(T_T)~~(x_x)~\n" +
                                                  "________________________________________________________________________________\n");
                                System.exit(0);
                            }
                            menuSelection = "3";
                        }


                    } else {//letter not in letterbank, already picked error
                        System.out.println("ERORR: Invalid Input. TRY AGAIN!");
                        menuSelection = "3";
                    }
                }


            }
            else{
                System.out.print(wrongInput);
                menuSelection = scan.next();
            }

        }
        return menuSelection;
    }

    public String initialWordConfig(int i, Word currentWord){
                  return  "                                     Current Level : "+this.currentLevel+"\n" +
                          "________________________________________________________________________________\n" +
                             "\n"+
                             this.hangmans[0]+"\n" +
                            "Word category: "+currentWord.getCategory().toUpperCase()+"\n"+
                            "Word : "+currentWord.getDashedWord()+"\n"+
                            "Incorrect Letters : None\n" +
                            "Correct Letters : None\n" +
                            "Chances Left : 10\n" +
                            "\n\tGAME OPTIONS:-\n" +
                            "\t-> TAKE A GUESS WITH ONE OF THE FOLLOWING CHARACTERS:-\n"
                           +Arrays.toString(this.letterBankReset())+"\n";

    }

    public char [] letterBankReset( ){//resets letterbank for every word
        char [] c = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        this.letterBank  = c;
        return this.letterBank;
    }

    public char [] letterBankUpdate( char  c){ //each time user guesses a character letterbank deletes characters from the list
        int change = 0;
        for(int i=0; i<this.letterBank.length; i++){
            if(Character.toLowerCase(this.letterBank[i])==Character.toLowerCase(c)){
                this.letterBank[i]='_';
                change =1;
            }
        }
        if (change==0) {
            System.out.println("ERROR: Invalid Input.\nTry again!");
        }

        return letterBank;

    }

    public boolean letterBankCheck( char  c){//compares a char with chars in letterbank
        int change = 0;
        for(int i=0; i<this.letterBank.length; i++){
            if(Character.toLowerCase(this.letterBank[i])==Character.toLowerCase(c)){
                change =1;
                return true;
            }
        }
        if (change==0) {
            System.out.println("ERROR: Invalid Input.\nLetter already picked.\nTry again.");
            //System.exit(0);
        }
        return false;

    }


    //getters and setters

    public Scanner getScan() {
        return scan;
    }

    public void setScan(Scanner scan) {
        this.scan = scan;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public WordBank getWordBank() {
        return wordBank;
    }

    public void setWordBank(WordBank wordBank) {
        this.wordBank = wordBank;
    }


    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public static int getQuitGame() {
        return quitGame;
    }

    public static void setQuitGame(int quitGame) {
        Game.quitGame = quitGame;
    }

    public String getMenuSelection() {
        return menuSelection;
    }

    public void setMenuSelection(String menuSelection) {
        this.menuSelection = menuSelection;
    }

    public char[] getLetterBank() {
        return letterBank;
    }

    public void setLetterBank(char[] letterBank) {
        this.letterBank = letterBank;
    }

    public static String getHangman() {
        return hangman;
    }



    public static String getOtherOptions() {
        return otherOptions;
    }



    public static String getMainMenu() {
        return mainMenu;
    }


    public static String getWrongInput() {
        return wrongInput;
    }


    public static String getWordCategoryOptions() {
        return wordCategoryOptions;
    }


    public static String getRules() {
        return rules;
    }

    public String getGameStarted() {
        return gameStarted;
    }


}
