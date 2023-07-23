
class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {

        ArrayList<ArrayList<Integer>>adjRed=new ArrayList<>();
        ArrayList<ArrayList<Integer>>adjBlue=new ArrayList<>();
        for(int i=0;i<n;i++){
            adjRed.add(new ArrayList<>());
            adjBlue.add(new ArrayList<>());
        }
        for(int i=0;i<redEdges.length;i++){
            adjRed.get(redEdges[i][0]).add(redEdges[i][1]);
        }
        for(int i=0;i<blueEdges.length;i++){
            adjBlue.get(blueEdges[i][0]).add(blueEdges[i][1]);
        }

        int visit[][]=new int[n][2];// 2 column - one for redColor another for blueColor
        int ans[]=new int[n];
        Arrays.fill(ans,-1);

        Queue<Pair>q=new LinkedList<>();

        if(adjRed.get(0)==null){}
        q.add(new Pair(0,0));
        q.add(new Pair(0,1));

        visit[0][0]=0;//0 means red
        visit[0][1]=1;//1 means blue;

        ans[0]=0;
        int level=1;
        while(!q.isEmpty()){
            int len=q.size();
            while(len-->0){
                Pair pt=q.poll();
                int node=pt.first;
                int colorUsed=pt.second;
                if(colorUsed==0){//when the color used is red(0)
                    for(int e:adjRed.get(node)){
                        if(visit[e][0]==0){
                            q.add(new Pair(e,1));//we have to add new adj node with blue (1)
                            visit[e][0]=1;
                            if(ans[e]==-1) ans[e]=level;
                        }
                    }
                }

                else{
                    for(int e:adjBlue.get(node)){
                        if(visit[e][1]==0){
                            q.add(new Pair(e,0));
                            visit[e][1]=1;
                            if(ans[e]==-1) ans[e]=level;
                        }
                    }
                }
            }
            level++;
        }

        return ans;
    }
}
