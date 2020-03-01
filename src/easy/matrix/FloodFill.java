package src.easy.matrix;

class FloodFill {
  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
      if (image[sr][sc] == newColor)  return image;
      int color = image[sr][sc];
      image[sr][sc] = newColor;
      if (sr-1>=0 && image[sr-1][sc]==color)   floodFill(image, sr-1, sc, newColor);
      if (sr+1<image.length && image[sr+1][sc]==color)   floodFill(image, sr+1, sc, newColor);
      if (sc-1>=0 && image[sr][sc-1]==color)   floodFill(image, sr, sc-1, newColor);
      if (sc+1<image[sr].length && image[sr][sc+1]==color)   floodFill(image, sr, sc+1, newColor);
      return image;
  }
}