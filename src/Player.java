import java.util.PrimitiveIterator;
import java.util.Scanner;

public class Player {
    //properties
    private String name ;
    private Scanner scan = new Scanner(System.in);
    //constructors

    public Player() {
        System.out.print("Set Player Name: ");
        this.name = this.scan.next();
        System.out.print( "Player name set to: " +this.getName()+"\n"+
                "________________________________________________________________________________\n");
    }

    //actions

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("Player Name Reset to "+ this.getName()+".");
    }

}
