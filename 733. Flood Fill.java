class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int [][]ans=image;
        int iniColor=image[sr][sc];

        int delRow[]={-1,1,0,0};
        int delCol[]={0,0,1,-1};

        DFS(image,sr,sc,color,iniColor,ans,delRow,delCol);
        return ans;
    }

    public void DFS(int[][] image,int sr, int sc, int color,int iniColor,int [][]ans,
    int delRow[],int delCol[]){
        ans[sr][sc]=color;
        int n=image.length;
        int m=image[0].length;

        for(int i=0;i<4;i++){
            int nrow=sr+delRow[i];
            int ncol=sc+delCol[i];

            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && image[nrow][ncol]==iniColor &&
            ans[nrow][ncol]!=color){
                DFS(image,nrow,ncol,color,iniColor,ans,delRow,delCol);
            }
        }

    }
}
