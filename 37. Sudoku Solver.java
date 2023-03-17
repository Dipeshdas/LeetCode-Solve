class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    public boolean solve(char[][]board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){

                if(board[i][j]=='.'){

                    for(char num='1';num<='9';num++){
                        if(isPossible(board,i,j,num)){
                            board[i][j]=num;
                            if(solve(board)){
                                return true;
                            }
                            //if the solve function return false then the prev num must be in wrong pos so then backtrack
                            //and fill that with '.'. 
                            else{
                                board[i][j]='.';
                            }
                        }
                    }

                    //if it is not possible to select a number from 1 to 9 the solve function return false;
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isPossible(char[][]board,int row,int col,char c){
        for(int i=0;i<9;i++){
            if(board[i][col]==c) return false;//col check

            if(board[row][i]==c) return false; //row check

            if(board[3*(row/3)+i/3][3*(col/3)+i%3]==c) return false;//checking in each 3 x 3 matrix
        }
        return true;

    }
}
