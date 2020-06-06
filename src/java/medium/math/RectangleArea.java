package src.java.medium.math;

public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int sum = (C-A)*(D-B) + (G-E)*(H-F);
        int overLappingA = Math.max(A, E), overLappingB = Math.max(B, F);
        int overLappingC = Math.min(C, G), overLappingD = Math.min(D, H);
        if (overLappingA < overLappingC && overLappingB < overLappingD)
            sum -= (overLappingC-overLappingA)*(overLappingD-overLappingB);
        return sum;
    }
}