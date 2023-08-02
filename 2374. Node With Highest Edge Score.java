class Solution {
    public int edgeScore(int[] edges) {

        long indegree[]=new long[edges.length];

        for(int i=0;i<indegree.length;i++){
            indegree[edges[i]]+=i;
        }

        int node=0;
        for(int i=0;i<indegree.length;i++){

            if(indegree[i]>indegree[node]){
                node=i;
            }
        }

        return node;

    }
}
