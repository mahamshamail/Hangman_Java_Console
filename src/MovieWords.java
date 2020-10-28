import java.util.ArrayList;
import java.util.Queue;

public class MovieWords extends WordBank{
    private  ArrayList<Word> movieWords;
    private static String title ="movies";
    public MovieWords() {
        this.movieWords = new ArrayList<Word>();
        initializeWordBank();
    }

    @Override
    public void initializeWordBank(){
        this.movieWords.add(5,new Word("Avengers",title));
        this.movieWords.add(6,new Word("Spider Man",title));
        this.movieWords.add(7,new Word("Iron Man",title));
        this.movieWords.add(8,new Word("Sixth Sense",title));
        this.movieWords.add(9,new Word("Drag Me To Hell",title));


    }

    public ArrayList<Word> getMovieWords() {
        return movieWords;
    }

    public void setMovieWords(ArrayList<Word> movieWords) {
        this.movieWords = movieWords;
    }

    public static String getTitle() {
        return title;
    }

    public static void setTitle(String title) {
        MovieWords.title = title;
    }
}
