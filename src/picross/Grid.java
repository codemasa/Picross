package picross;

import java.util.*;

public class Grid{

    public final int sizeX;
    public final int sizeY;
    public final Cell [][] grid;
    public final Clue [] cluesX;
    public final Clue [] cluesY;

    public Grid(int x, int y){
      this.grid = new Cell [x][y];
      this.cluesX = new Clue[x];
      this.cluesY = new Clue[y];
      this.sizeX = x;
      this.sizeY = y;
      for (int i = 0; i < sizeY; i++) {
        cluesX[i] = new Clue(i, 0);
        for (int j = 0; j < sizeX; j++) {
          grid[j][i] = new Cell(j, i);
          cluesY[j] = new Clue(j, 1);
        }
      }

    }
}
