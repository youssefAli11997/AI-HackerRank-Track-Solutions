// a more general code than "BotClean problem".

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BotClean Large {
    static boolean valid(int i, int j, int dimh, int dimw){
        return i >= 0 && i < dimh && j >= 0 && j < dimw;
    }
    
    static int dist(int r, int c , int i, int j){
        return Math.abs(r - i) + Math.abs(c - j);
    }
    
    static int whichDirection(int r, int c , int i, int j, int dimh, int dimw) {
        int DIST = dist(r, c, i, j);
        int min = 12, index = -1;        
        int dx[] = {0,0,-1,1};
        int dy[] = {-1,1,0,0};
        for(int k=0; k<4; k++){
             if(valid(r + dx[k], c + dy[k], dimh, dimw) && dist(r + dx[k], c + dy[k], i, j) < min){
                min = dist(r + dx[k], c + dy[k], i, j);
                index = k;
            }
        }  
        return index;
    }
    
    static void next_move(int posr, int posc, int dimh, int dimw, String[] board){
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
                    index = whichDirection(posr, posc, i, j, dimh, dimw);
                    min = dist(posr, posc, i, j);
                }
            }
        
        System.out.println(dir[index]);
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int [] pos = new int[2];
        int [] dim = new int[2];
        for(int i=0;i<2;i++) pos[i] = in.nextInt();
        for(int i=0;i<2;i++) dim[i] = in.nextInt();
        String board[] = new String[dim[0]];
        for(int i=0;i<dim[0];i++) board[i] = in.next();
        next_move(pos[0], pos[1], dim[0], dim[1], board);
    }
}
