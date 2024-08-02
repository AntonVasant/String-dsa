package array;

public class LargestTriangle {
    public double largestTriangleArea(int[][] points) {
        double length = 0;
        int n = points.length;
        for (int i = 0; i < n; i++){
            for (int j = i+1; j < n; j++){
                for (int k = j+1; k <n; k++){
                    double area = helper(points[i],points[j],points[k]);
                    length = Math.max(length,area);
                }
            }
        }
        return length;
    }

    private double helper(int[] p1, int[] p2, int[] p3) {
        return Math.abs(p1[0] * (p2[1] - p3[1]) + p2[0] * (p3[1] - p1[1]) + p3[0] * (p1[1] - p2[1])) / 2.0;
    }
}
