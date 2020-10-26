class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        
        int [][] directions ={{0,1}, {1,0}, {0,-1}, {-1,0}};
        
        Set<String> obstacle = new HashSet<>();
        
        for(int[] ob: obstacles){
            obstacle.add(ob[0] +" "+ ob[1]);
        }
        
        int x=0, y=0, direction = 0, distance = 0;
        
        for(int i=0; i<commands.length;i++){
            
            
            if(commands[i]== -2){
                direction = (direction + 3) % 4;
            } else if(commands[i]== -1){
                direction = (direction + 1) % 4;
            } else {
                int step = 0;
                while(step < commands[i] && (!obstacle.contains(
                           (x + directions[direction][0]) + " " + (y + directions[direction][1]))
                          )){
                    
                    x += directions[direction][0];
                    y += directions[direction][1];
                    step++;

                }
              
            }
            
        distance = Math.max(distance, x * x + y * y);

        }
        
        
         return distance;
    }
    
   
}