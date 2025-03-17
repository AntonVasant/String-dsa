package math;

public class RectangleArea {
        public static void main(String[] args) {
            int A = -3, B = 0, C = 3, D = 4;
            int E = 0, F = -1, G = 9, H = 2;
            int result = computeArea(A, B, C, D, E, F, G, H);
            System.out.println("Total Area: " + result);
        }

        public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
            int area1 = (C - A) * (D - B);
            int area2 = (G - E) * (H - F);
            int overlapWidth = Math.max(0, Math.min(C, G) - Math.max(A, E));
            int overlapHeight = Math.max(0, Math.min(D, H) - Math.max(B, F));
            int overlapArea = overlapWidth * overlapHeight;
            return area1 + area2 - overlapArea;
        }

    public int computeArea2ndTime(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int length = Math.max(0,Math.min(ax2,bx2) -  Math.max(ax1,bx1));
        int width = Math.max(0,Math.min(ay2,by2) - Math.max(ay1,by1));
        int area = length * width;
        int area1 = (ax2 - ax1) * (ay2 - ay1);
        int area2 = (bx2 - bx1) * (by2 - by1);
        return area1 + area2 - area;
    }
    }