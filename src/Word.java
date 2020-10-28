 class Word {
    private String title;
    private String category;
    private String dashedWord;
    public Word(){
        //this.title = title;
    }
    public Word(String title, String category){
        this.title = title;
        this.category = category;
        this.dashedWord = convertWordToDashes();
    }

    public String convertWordToDashes(){
        //first case scenario all dashes with spaces
        String wordToLower = this.title.toLowerCase();
        String subWord ="";
        for(int i=0; i<this.title.length(); i++) {
            if (this.title.charAt(i) == ' '  ) { //if space show as space
                subWord+=" ";
            } else {
                //else show as a dash
                subWord+="_";
            }
        }
        return subWord;
    }
     private String convertDashToChar(int i, String subWord){
         //first case scenario all dashes with spaces
         //String wordToLower = this.title.toLowerCase();
         if(i<this.title.length()){
             //if length of both words match,
             if(subWord.charAt(i)==' '){
                 System.out.println("Invalid input. Spaces cannot be guessed.");

             }
             else if(subWord.charAt(i)=='_'){
                 //if dashed turn into char as title
                 if(i==0){
                     subWord = this.title.charAt(0)+subWord.substring(1,subWord.length());
                     return subWord;
                 }
                 else if (i==subWord.length()-1){
                     subWord = subWord.substring(0,i)+this.title.charAt(i);
                     return subWord;
                 }
                 else if (i<subWord.length()){
                     subWord = subWord.substring(0,i)+this.title.charAt(i)+subWord.substring(i+1,subWord.length());
                     return subWord;
                 }
                 else {
                     //error
                     System.out.println("Index of word guessing out of bounds.");

                 }

             }
             else{
                System.out.println("Index of word already guessed");
             }
         }
         else{
            System.out.println("Index of guessed char out of bounds.");
         }
         return subWord;
     }
    public boolean matchChar( int i, char c){
        if(Character.toLowerCase(this.title.charAt(i))==Character.toLowerCase(c)){
            return true;
        }
        else{
            return false;
        }
    }
    public String convertDashesToCharacters( char c, String subWord){
        int numOfCharsChanged =0;
        for(int i=0; i<subWord.length(); i++) {
            if (this.matchChar(i, c)) {
                //if matched at multiple
                subWord = this.convertDashToChar( i,  subWord);
                numOfCharsChanged++;
                //return subWord;
            }

        }
        if(numOfCharsChanged==0){
            return "Word does not contain this letter.\n" ;
        }
        return subWord;
    }

     public String getTitle() {
         return title;
     }

     public void setTitle(String title) {
         this.title = title;
     }

     public String getCategory() {
         return category;
     }

     public void setCategory(String category) {
         this.category = category;
     }

     public String getDashedWord() {
         return dashedWord;
     }

     public void setDashedWord(String dashedWord) {
         this.dashedWord = dashedWord;
     }


 }
