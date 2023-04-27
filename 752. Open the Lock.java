

class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String>set=new HashSet<>();
        for(int i=0;i<deadends.length;i++){
            set.add(deadends[i]);
        }

        Set<String> visited=new HashSet<>();

        Queue<String>q=new LinkedList<>();
        q.add("0000");
        visited.add("0000");
        int steps=0;

        while(!q.isEmpty())
        {
            int size = q.size();
            for(int j = 0; j < size; j++)
            {
                String current = q.poll();
                
                if(current.equals(target)) return steps;
                
                StringBuilder sb = new StringBuilder(current);
                for(int i = 0; i < 4; i++)
                {
                    char c = sb.charAt(i);
                    String s1 = sb.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + sb.substring(i + 1);
                    String s2 = sb.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + sb.substring(i + 1);
                    
                    if(!visited.contains(s1) && !set.contains(current))
                    {
                        visited.add(s1);
                        q.offer(s1);
                    }
                    if(!visited.contains(s2) && !set.contains(current))
                    {
                        visited.add(s2);
                        q.offer(s2);
                    }
                }
            }
            steps++;
        }
        
        return -1;
    }
}
