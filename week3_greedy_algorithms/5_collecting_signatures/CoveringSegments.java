import java.util.*;

public class CoveringSegments {

    private static int[] optimalPoints(Segment[] segments) {
        Arrays.sort(segments, Comparator.comparingInt(segment -> segment.start)); // sort by start point of segment
        List<Integer> points =  new ArrayList<>();
        int point =  segments[0].end;
        for (int i = 1; i < segments.length; i++) {
            if (segments[i].start <= point) { // overlap
                point = Math.min(point, segments[i].end);
            } else {
                points.add(point);
                point = segments[i].end;
            }
        }
        points.add(point);
        return points.stream().mapToInt(i -> i).toArray();
    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
 
