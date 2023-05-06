class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}

class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int visit[][]=new int[m][n];
        int delRow[]={0,0,1,-1};
        int delCol[]={1,-1,0,0};
        //'G'=2, 'W=1' 
        
        for(int i=0;i<walls.length;i++){
            visit[walls[i][0]][walls[i][1]]=1;
        }
        Queue<Pair>q=new LinkedList<>();
        
        
        for(int i=0;i<guards.length;i++){
            int start=guards[i][0];
            int end=guards[i][1];
            q.add(new Pair(start,end));
            visit[start][end]=2;
        }
        
        
        while(!q.isEmpty()){
            Pair pr=q.poll();
            int row=pr.first;
            int col=pr.second;
            
            for(int i=0;i<4;i++){
                int nrow=row+delRow[i];
                int ncol=col+delCol[i];
                
                while(nrow<m && nrow>=0 && ncol<n && ncol>=0 && visit[nrow][ncol]!=1 && visit[nrow][ncol]!=2){
                    visit[nrow][ncol]=-1;//-1 for visited cell
                    nrow+=delRow[i];
                    ncol+=delCol[i];
                }
            }
        }
        
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visit[i][j]==0){
                    ans++;
                }
            }
        }
        return ans;
        
        
    }
}
