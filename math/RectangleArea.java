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

            // Calculate overlap width
            int overlapWidth = Math.max(0, Math.min(C, G) - Math.max(A, E));
            // Calculate overlap height
            int overlapHeight = Math.max(0, Math.min(D, H) - Math.max(B, F));

            // Area of the overlapping region
            int overlapArea = overlapWidth * overlapHeight;

            // Total area covered by the two rectangles
            return area1 + area2 - overlapArea;
        }
    }