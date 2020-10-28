import java.util.ArrayList;
import java.lang.Math;
class WordBank {

    protected ArrayList<Word> words;
   // private SportsWords sportsWords;
   // private MovieWords movieWords;
    public WordBank() {
        //this.words = new ArrayList<>();
        //this.movieWords = new MovieWords();
        //this.sportsWords = new SportsWords();
        this.initializeWordBank();


    }

    public  void initializeWordBank(){


        Word w = new  Word("Football","Sports");
        Word w1 = new  Word("Cricket","Sports");
        Word w2 = new  Word("Ice Hockey","Sports");
        Word w3 = new  Word("Marathon","Sports");
        Word w4 = new  Word("Tennis","Sports");
        Word w5 = new  Word("Avengers","movies");
        Word w6 = new  Word("Spider Man","movies");
        Word w7 = new  Word("Iron Man","movies");
        Word w8 = new  Word("Sixth Sense","movies");
        Word w9 = new  Word("Drag Me To Hell","movies");
        this.words.add(w);
        this.words.add(w1);
        this.words.add(w2);
        this.words.add(w3);
        this.words.add(w4);
        this.words.add(w5);
        this.words.add(w6);
        this.words.add(w7);
        this.words.add(w8);
        this.words.add(w9);



    }

    public Word getRandomWord(String category){
        //System.out.println("inside getRandom");
        if (category.equalsIgnoreCase("all")){
            int random_int = (int)(Math.random() * (this.words.size() + 1) + 0);
            //System.out.println("random num: "+random_int);
            return this.words.get(random_int);
        }
        else if(category.equalsIgnoreCase("sports")){
            int random_int = (int)(Math.random() * (4 + 1) + 0);
            //System.out.println("random num: "+random_int);
            return this.words.get(random_int);
        }
        else if(category.equalsIgnoreCase("movies")){
            //System.out.println("inside movies: "+this.movieWords.getMovieWords().size());
            int random_int = (int)(Math.random() * (9-5+ 1) + 5);
            //System.out.println("random num: "+random_int);
            return this.words.get(random_int);
        }
        else {
            System.out.println("Wrong category. Sending back null value.");
            return null;
        }


    }
    public void addToWordBank(int i, String title, String category){
        //this.words.add(i,new Word(title,category));
        if(category.equalsIgnoreCase(MovieWords.getTitle())) {
            //this.movieWords.getMovieWords().add(i,new Word(title,category));
            this.words.add(i,new Word(title,category));
        }
        else if(category.equalsIgnoreCase(SportsWords.getTitle())) {
            //this.sportsWords.getSportsWords().add(i,new Word(title,category));
            this.words.add(i,new Word(title,category));
        }
        else{
            System.out.println("Cannot add word, it's category does not exist.");
        }
    }


}
