
class Pair{
    int first;
    int second;
    int step;
    Pair(int fst,int scnd,int step){
        this.first=fst;
        this.second=scnd;
        this.step=step;
    }
}

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int n=maze.length;
        int m=maze[0].length;

        int x=entrance[0];
        int y=entrance[1];

        int delRow[]={1,-1,0,0};
        int delCol[]={0,0,1,-1};
        
        int ans=0;
        
        Queue<Pair>q=new LinkedList<Pair>();
        q.add(new Pair(x,y,0));
        
        while(!q.isEmpty()){
            int row=q.peek().first;
            int col=q.peek().second;
            int step=q.peek().step;
            maze[row][col]='+';

            
            q.poll();

            for(int i=0;i<4;i++){
                int nrow=row+delRow[i];
                int ncol=col+delCol[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && maze[nrow][ncol]=='.'){
                    maze[nrow][ncol]='+';
                    q.add(new Pair(nrow,ncol,step+1));
                    
                    
                    if(nrow==0 || ncol==0 || nrow==n-1 || ncol==m-1){
                        ans=step+1;
                        return ans;
                    }  
                    
                }

            }
            
        }
        return -1;


    }

}
