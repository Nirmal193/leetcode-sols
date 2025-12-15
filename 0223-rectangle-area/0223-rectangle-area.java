class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int width = Math.max(0,Math.min(ax2,bx2) - Math.max(ax1,bx1));
        int height = Math.max(0,Math.min(ay2,by2) - Math.max(ay1,by1));
        int internal_area =  width*height;
        int f1_area = (ax2 - ax1) * (ay2 - ay1);
        int f2_area = (bx2 - bx1) * (by2 - by1);
        return f1_area + f2_area - internal_area;
    }
}