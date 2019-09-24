package stepik_4_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
/**
 * Sample Input 1:
 *
 * 3
 * 1 3
 * 2 5
 * 3 6
 * Sample Output 1:
 *
 * 1
 * 3
 * Sample Input 2:
 *
 * 4
 * 4 7
 * 1 3
 * 2 5
 * 5 6
 * Sample Output 2:
 *
 * 2
 * 3 6
 * */
public class CoverSegment {
    public static void main(String[] args) throws IOException {
        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfSegments = Integer.parseInt(bufferedReader.readLine());*/
        Scanner s = new Scanner(System.in);
        int numberOfSegments = s.nextInt();
        ArrayList<Segment> segments = new ArrayList<Segment>();

        /*for(int i = 0; i < numberOfSegments; i++){
            segments.add(i, new Segment(Integer.parseInt(bufferedReader.readLine()), Integer.parseInt(bufferedReader.readLine())));
        }*/

        for(int i = 0; i < numberOfSegments; i++){
            segments.add(i, new Segment(s.nextInt(), s.nextInt()));
        }

        segments.sort(Segment.SegmentComparator);
        printSegments(segments);
    }

    private static void printSegments(ArrayList<Segment> segments) {
        ArrayList<Integer> result = new ArrayList();
        int rightPoint = 0;
        while (segments.size() > 0){
            if(segments.size() != 0){
                rightPoint = segments.get(0).rightPoint;
                result.add(rightPoint);
            }

            for(int i = 0; i < segments.size();){
//                System.out.println("i = " + i);
//                System.out.println("rightPoint = " + segments.get(i).rightPoint);
                if(segments.get(i).isPointBelongsSegment(rightPoint)){
                    segments.remove(i);
                } else {
                    break;
                }
            }
        }

        System.out.println(String.format("%d", result.size()));
        if(result.size() == 0){
            System.out.println(String.format("%d", result.size()));
        } else {
            String output = result.get(0).toString();
            for(int i = 1; i < result.size(); i++){
                output += " " + result.get(i).toString();
            }
            System.out.println(output);
        }
    }

    public static class Segment implements Comparable<Segment> {
        public int leftPoint;
        public int rightPoint;

        public Segment(int leftPoint, int rightPoint){
            this.leftPoint = leftPoint;
            this.rightPoint = rightPoint;
        }

        @Override
        public int compareTo(Segment segment) {
            if(this.rightPoint > segment.rightPoint){
                return 1;
            } else {
                return -1;
            }
        }

        public static Comparator<Segment> SegmentComparator = new Comparator<Segment>() {
            @Override
            public int compare(Segment segment1, Segment segment2) {
                if(segment1 == null){
                    return -1;
                }
                if(segment2 == null){
                    return 1;
                }
                if(segment1.equals(segment2)){
                    return 0;
                }
                return segment1.compareTo(segment2);
            }
        };

        public boolean isPointBelongsSegment(int point) {
            return point >= leftPoint;
        }
    }
}
