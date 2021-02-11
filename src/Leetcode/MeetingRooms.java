package Leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {

public static void main(String []args){
    int[][]meetingrooms=new int[][]{{0,30},{20,20},{15,20}};
    System.out.print(canAttendMeetings(meetingrooms));

}
    public static boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0]-o2[0]);
        for(int i=0;i<intervals.length;i++){
            if(intervals[i][1]>intervals[i+1][0])return false;

        }

        return true;
    }
}
