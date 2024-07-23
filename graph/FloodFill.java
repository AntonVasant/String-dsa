package graph;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int old = image[sr][sc];
            if (old != color)
                dfs(image,sr,sc,old,color);

            return image;
    }

    private void  dfs(int[][] image,int r,int c,int old,int newc){
        if (r < 0 || c < 0 || r >= image.length || c >= image[0].length || image[r][c] != old)
            return;
        image[r][c] = newc;
        dfs(image, r+1, c, old, newc);
        dfs(image, r-1, c, old, newc);
        dfs(image, r, c+1, old, newc);
        dfs(image, r, c-1, old, newc);
    }
}
