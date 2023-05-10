class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        for(int i=1;i<travel.length;i++){
            travel[i]+=travel[i-1];
        }

        int p=0;
        int m=0;
        int g=0;
        int ans=0;
        for(int i=garbage.length-1;i>=0;i--){
            if(garbage[i].contains("P")){
                p=i;
                break;
            }
        }
         for(int i=garbage.length-1;i>=0;i--){
            if(garbage[i].contains("M")){
                m=i;
                break;
            }
        }
         for(int i=garbage.length-1;i>=0;i--){
            if(garbage[i].contains("G")){
                g=i;
                break;
            }
        }

        for(int i=0;i<garbage.length;i++){
            ans+=garbage[i].length();
        }

        if(p!=0){
            ans+=travel[p-1];
        }
        if(m!=0){
            ans+=travel[m-1];
        }
        if(g!=0){
            ans+=travel[g-1];
        }
        return ans;

    }
}
