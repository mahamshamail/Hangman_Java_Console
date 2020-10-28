import java.util.ArrayList;

public class SportsWords extends WordBank {
    private  ArrayList <Word> sportsWords= new ArrayList<Word>();
    private static String  title = "sports";

    public SportsWords() {
        this.initializeWordBank();
    }
    @Override
    public void initializeWordBank(){
        this.sportsWords.add(1,new Word("Football",title));
        this.sportsWords.add(2,new Word("Cricket",title));
        this.sportsWords.add(3,new Word("Ice Hockey",title));
        this.sportsWords.add(4,new Word("Marathon",title));
        this.sportsWords.add(5,new Word("Tennis",title));
    }


    public ArrayList<Word> getSportsWords() {
        return sportsWords;
    }

    public void setSportsWords(ArrayList<Word> sportsWords) {
        this.sportsWords = sportsWords;
    }

    public static String getTitle() {
        return title;
    }

    public static void setTitle(String title) {
        SportsWords.title = title;
    }
}
