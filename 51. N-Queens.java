
import java.util.*;
public class Solution {
    public static ArrayList<ArrayList<Integer>> solveNQueens(int n) {
        int[][]board=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]=0;
            }
        }
        ArrayList<ArrayList<Integer>>ans=new ArrayList<>();
        
        int leftrow[]=new int[n];
        int upperDiagonal[]=new int[2*n-1];
        int lowerDiagonal[]=new int[2*n-1];

        solve(0,ans,board,leftrow,upperDiagonal,lowerDiagonal);
        return ans;
    }
    public static void solve(int col,ArrayList<ArrayList<Integer>>ans,int[][]board,int leftrow[],int upperDiagonal[],int lowerDiagonal[]){
        if(col==board.length){
            ans.add(construct(board));//adding the constructed list in a list of list.
            return;
        }

        for(int row=0;row<board.length;row++){
            if(leftrow[row]==0 && upperDiagonal[board.length-1+col-row]==0 && lowerDiagonal[row+col]==0){
                board[row][col]=1;
                leftrow[row]=1;
                upperDiagonal[board.length-1+col-row]=1;
                lowerDiagonal[row+col]=1;
                solve(col+1,ans,board,leftrow,upperDiagonal,lowerDiagonal);//recursion call

                //for backtrack
                board[row][col]=0;
                leftrow[row]=0;
                upperDiagonal[board.length-1+col-row]=0;
                lowerDiagonal[row+col]=0;
            }
        }
    }

    //construct the string from every row and add them in a list;
    public static ArrayList<Integer> construct(int [][] board){
        ArrayList<Integer>cur=new ArrayList<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                cur.add(board[i][j]);
            }
            
        }
        return cur;
    }
}
