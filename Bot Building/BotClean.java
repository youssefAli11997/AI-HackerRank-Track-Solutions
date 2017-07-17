import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BotClean {
    
    static boolean valid(int i, int j){
        return i >= 0 && i < 5 && j >= 0 && j < 5;
    }
    
    static int dist(int r, int c , int i, int j){
        return Math.abs(r - i) + Math.abs(c - j);
    }
    
    static int whichDirection(int r, int c , int i, int j) {
        int DIST = dist(r, c, i, j);
        int min = 12, index = -1;
        
        //try left
        if(valid(r, c-1) && dist(r, c-1, i, j) < min){
            min = dist(r, c-1, i, j);
            index = 0;
        }
        
        // try right
        if(valid(r, c+1) && dist(r, c+1, i, j) < min){
            min = dist(r, c+1, i, j);
            index = 1;
        }
        
        // try up
        if(valid(r-1, c) && dist(r-1, c, i, j) < min){
            min = dist(r-1, c, i, j);
            index = 2;
        }
        
        // try down
        if(valid(r+1, c) && dist(r+1, c, i, j) < min){
            min = dist(r+1, c, i, j);
            index = 3;
        }
        return index;
    }
    
    static void next_move(int posr, int posc, String[] board){
        if(board[posr].charAt(posc) == 'd'){
            System.out.println("CLEAN");
            return;
        }
        
        String[] dir = {"LEFT", "RIGHT", "UP", "DOWN"};
        int min = 12, index = -1;
        
        // search for the nearest dirty cell from every diection
        
        /*// left
        for(int i = posc-1; i >= 0; i--) if(board[posr].charAt(i) == 'd') {
            min = Math.min(min, dist(posr, posc, posr, i));
            index = 0;
            break;
        }
                
        // right
        for(int i = posc+1; i < board[0].length(); i++) if(board[posr].charAt(i) == 'd') {
            min = Math.min(min, dist(posr, posc, posr, i));
            index = 1;
            break;
        }
                
        // up
        for(int i = posr-1; i >= 0; i--) if(board[i].charAt(posc) == 'd') {
            min = Math.min(min, dist(posr, posc, i, posc));
            index = 2;
            break;
        }
                
        // down
        for(int i = posr+1; i < board.length; i++) if(board[i].charAt(posc) == 'd') {
            min = Math.min(min, dist(posr, posc, i, posc));
            index = 3;
            break;
        }*/
        
        for(int i=0; i<board.length; i++) for(int j=0; j<board[0].length(); j++)
            if(board[i].charAt(j) == 'd') {
                if(dist(posr, posc, i, j) < min){
                    index = whichDirection(posr, posc, i, j);
                    min = dist(posr, posc, i, j);
                }
            }
                
        System.out.println(dir[index]);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int [] pos = new int[2];
        String board[] = new String[5];
        for(int i=0;i<2;i++) pos[i] = in.nextInt();
        for(int i=0;i<5;i++) board[i] = in.next();
        next_move(pos[0], pos[1], board);
    }
}
