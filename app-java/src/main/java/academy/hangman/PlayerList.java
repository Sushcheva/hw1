package academy.hangman;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class PlayerList {
    public Player[] wins;
    public int numberWins;
    public int numberDefeats;
    public Player[] defeats;
    public int[] skips;
    public int numberSkips;

    public PlayerList() {
        wins = new Player[1];
        numberWins = 0;
        defeats = new Player[1];
        numberDefeats = 0;
        skips = new int[1];
        numberSkips = 0;
    }
    public void pushWins(Player element){
        if (wins.length <= numberWins) {
            wins = Arrays.copyOf(wins, numberWins * 2);
        }
        wins[numberWins] = element;
        numberWins++;
    }
    public void pushDefeats(Player element){
        if (defeats.length <= numberDefeats) {
            defeats = Arrays.copyOf(defeats, numberDefeats * 2);
        }
        defeats[numberDefeats] = element;
        numberDefeats++;
    }
    public void pushSkips(int element){
        if (skips.length <= numberSkips) {
            skips = Arrays.copyOf(skips, numberSkips * 2);
        }
        skips[numberSkips] = element;
        numberSkips++;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("\n");
        if(numberWins>0){
            sb.append("Wins: ");
            for(int i=0;i<numberWins;i++){
                sb.append(wins[i]).append(" ");
            }
            sb.append("\n");
        }

        if(numberDefeats>0){
            sb.append("Defeats:");
            for(int i=0;i<numberDefeats;i++){
                sb.append(defeats[i]).append(" ");
            }
            sb.append("\n");
        }
        if(numberSkips>0){
            sb.append("Skips:");
            for(int i=0;i<numberSkips;i++){
                sb.append(skips[i]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
