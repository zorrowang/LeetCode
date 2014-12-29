/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if (points == null || points.length==0)
            return 0;
        int max = 0;
        for(int i = 0; i<points.length; i++){
            HashMap<Double, Integer> map = new HashMap<Double, Integer>();
            int duplicate = 1;
            for(int j=i+1; j<points.length; j++){
                if (points[i].x == points[j].x && points[i].y == points[j].y){
                    duplicate++;
                    continue;
                }
                double slope;
                if (points[i].x == points[j].x)
                    slope = Integer.MAX_VALUE;
                else
                    slope = points[i].y == points[j].y ? 0 : 1.0 * (points[i].y - points[j].y)/(points[i].x - points[j].x);
                if (map.containsKey(slope)){
                    int count = map.get(slope)+1;
                    map.put(slope, count);
                }
                else{
                    map.put(slope, 1);
                }
            }
            int tempMax = 0;
            for(double slope : map.keySet()){
                tempMax = Math.max(map.get(slope), tempMax);
            }
            max = Math.max(tempMax+duplicate, max);
        }
        return max;
    }
}