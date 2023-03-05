class Solution {
    public int passThePillow(int n, int time) {
        boolean forward =true;
        int i=0;
        time+=1;
        while(time>0){
            if(forward){
                if(i==n){
                    i--;
                    forward=false;
                }
                else{
                    i++;
                }
            }
            else{
                if(i==1){
                    i++;
                    forward=true;
                }
                else{
                    i--;
                }
            }
            time--;
        }
        
        return i;
        
        
    }
}
