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
        int dx[] = {0,0,-1,1};
        int dy[] = {-1,1,0,0};
        for(int k=0; k<4; k++){
             if(valid(r + dx[k], c + dy[k]) && dist(r + dx[k], c + dy[k], i, j) < min){
                min = dist(r + dx[k], c + dy[k], i, j);
                index = k;
            }
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
