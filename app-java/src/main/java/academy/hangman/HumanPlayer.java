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
            String a;
            System.out.println("Введите букву русского алфавита");
            while(true){
                try{
                    a = in.nextLine();
                    if(a.length() !=1){
                        System.err.println("Нужно");
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
