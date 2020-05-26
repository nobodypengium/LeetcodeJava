package greedy.easy;

import java.util.HashSet;
import java.util.Set;

public class WalkingRobotSimulation {
    public int robotSim(int[] commands, int[][] obstacles) {
        int posX=0;
        int posY=0;
        int face=0; //0=N 1=E 2=S 3=W
        int max=0;
        for(int command:commands){
            switch(command){
                case -2:
                    face--;
                    face = (face+4)%4;
                    break;
                case -1:
                    face++;
                    face = (face+4)%4;
                    break;
                default:
                    switch(face){
                        case 0:
                            for(int i=0;i<obstacles.length;i++){
                                if(obstacles[i][0]==posX&&(obstacles[i][1]<=posY+command&&obstacles[i][1]>posY)){
                                    command=obstacles[i][1]-posY-1;
                                }
                            }
                            posY += command;
                            break;
                        case 1:
                            for(int i=0;i<obstacles.length;i++){
                                if(obstacles[i][1]==posY&&(obstacles[i][0]<=posX+command&&obstacles[i][0]>posX)){
                                    command=obstacles[i][0]-posX-1;
                                }
                            }
                            posX += command;
                            break;
                        case 2:
                            for(int i=0;i<obstacles.length;i++){
                                if(obstacles[i][0]==posX&&(obstacles[i][1]>=posY-command&&obstacles[i][1]<posY)){
                                    command=posY-obstacles[i][1]-1;
                                }
                            }
                            posY -= command;
                            break;
                        case 3:
                            for(int i=0;i<obstacles.length;i++){
                                if(obstacles[i][1]==posY&&(obstacles[i][0]>=posX-command&&obstacles[i][0]<posX)){
                                    command=posX-obstacles[i][0]-1;
                                }
                            }
                            posX -= command;
                            break;
                        default:
                            break;
                    }
                    if(posX*posX+posY*posY>max)
                        max = posX*posX+posY*posY;
            }
        }
        return max;
    }
    public int robotSim1(int[] commands, int[][] obstacles){
        int[] dx = new int[]{0,1,0,-1}; // 提前预置每个方向的步数
        int[] dy = new int[]{1,0,-1,0};
        int x=0,y=0;
        int di=0;
        int max_dist=0;
        Set<Long> obsSet = new HashSet<>();
        for(int[] obstacle:obstacles){ // 使用某些方便【查找】的数据结构存储距离
            long ox = (long)obstacle[0]+30000;
            long oy = (long)obstacle[1]+30000;
            long obs = (ox<<16) + oy; // 移位操作，注意正负，【注意加括号】，使每个obstacle可以被唯一查找
            obsSet.add(obs);
        }
        for(int command:commands){
            if(command==-2)
                di=(di+3)%4;
            else if(command==-1)
                di=(di+1)%4;
            else{
                for(int i=0;i<command;i++){
                    int tmpx=x+dx[di];
                    int tmpy=y+dy[di];
                    long tmppos=(((long)tmpx+30000)<<16)+((long)tmpy+30000);
                    if(!obsSet.contains(tmppos)){
                        x=tmpx;
                        y=tmpy;
                        max_dist=Math.max(x*x+y*y,max_dist);
                    }
                }
            }
        }
        return max_dist;
    }

    public int robotSimPractice(int[] commands, int[][] obstacles){
        int[] dx = new int[]{0,1,0,-1};
        int[] dy = new int[]{1,0,-1,0};
        int posx =0;
        int posy =0;
        int face = 0;
        int max = 0;
        Set<Long> obsSet = new HashSet<>();
        for(int[] obstacle:obstacles){
            long obsx=(long)obstacle[0]+30000;
            long obsy=(long)obstacle[1]+30000;
            obsSet.add((obsx<<16)+obsy);
        }
        for(int command:commands){
            if(command==-2){
                face=(face+3)%4;
            }
            else if(command==-1){
                face=(face+1)%4;
            }
            else{
                while(command--!=0) {
                    int tmpx = posx + dx[face];
                    int tmpy = posy + dy[face];
                    long positionTo = (((long) tmpx + 30000) << 16) + (((long) tmpy) + 30000);
                    if (!obsSet.contains(positionTo)) {
                        posx = tmpx;
                        posy = tmpy;
                        max = Math.max(max, posx * posx + posy * posy);
                    }
                }
            }
        }
        return max;
    }
}
