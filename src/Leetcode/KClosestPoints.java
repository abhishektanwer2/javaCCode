package Leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPoints {
   public static class Points{
        int x;
        int y;
        int distance;
        Points(int x,int y){
            this.x=x;
            this.y=y;
        }
        public int calculateDistance(int x,int y){
            distance=(x*x)+(y*y);
            return distance;

        }



    }
    public static void main(String []args){
    int[][]points=new int[][]{{3,3},{5,-1},{-2,4}};
    int k=2;
        PriorityQueue<Points> pointsArrayList= new PriorityQueue<>(new Comparator<KClosestPoints.Points>() {
            @Override
            public int compare(KClosestPoints.Points o1, KClosestPoints.Points o2) {
                return o1.distance-o2.distance;
            }
        });
        for(int i=0;i<points.length;i++){
            Points points1=new Points(points[i][0],points[i][1]);
            points1.calculateDistance(points[i][0],points[i][1]);
            pointsArrayList.add(points1);

        }

        ArrayList<Integer[]>results=new ArrayList<>();
        for(int i=0;i<k;i++){
            Points p=(pointsArrayList.remove());
            results.add(new Integer[]{p.x,p.y});

        }
    }

}
