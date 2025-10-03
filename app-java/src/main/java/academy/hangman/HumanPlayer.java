package academy.hangman;

import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HumanPlayer implements Player {
    private final PrintStream out;
    private final Scanner in;

    public HumanPlayer() {
        this.out = System.out;
        this.in =new Scanner(System.in);
    }

    public String move() {
        while (true) {
            out.println("Введи свою букву");
            String a;
            while(true){
                try{
                    a = in.nextLine();
                    if(a.length() !=1){
                        System.err.println("Введи букву");
                        continue;
                    }
                    return a.toLowerCase();
                }catch(InputMismatchException ex){
                    System.err.println("Введи букву");
                    in.next();
                }
            }


        }
    }
}
