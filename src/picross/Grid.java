package picross;

import java.awt.*;
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

    public Cell getCell(int x, int y){
      if (x >= 0 && x < sizeX && y >= 0 && y < sizeY){
        return grid[x][y];
      }
      else{
        return null;
      }
    }
    public void drawGrid(int x, int y, Graphics2D graphics2D, int cWidth) {
  	switch (boxes[x][y].getState()) {
  		case 0:
  			graphics2D.setColor(WHITE);
  			graphics2D.fillRect(clueLen[0] + x * bSize + cWidth,//draw white background
  					clueLen[1] + y * bSize,
  					bSize,
  					bSize);
  			break;
  		case 1:
  			graphics2D.setColor(GREEN);
  			graphics2D.fillRect(clueLen[0] + x * bSize + cWidth, //draw green background
  					clueLen[1] + y * bSize,
  					bSize,
  					bSize);
  			break;
  		case 2:
  			graphics2D.setColor(WHITE);
  			graphics2D.fillRect(clueLen[0] + x * bSize + cWidth, //draw white background
  					clueLen[1] + y * bSize,
  					bSize,
  					bSize);
  			graphics2D.setColor(BLACK);
  			graphics2D.drawLine(clueLen[0] + x * bSize + bSize / 10 + cWidth, //draw x
  					clueLen[1] + y * bSize + bSize / 10,
  					clueLen[0] + x * bSize + bSize * 9 / 10 + cWidth,
  					clueLen[1] + y * bSize + bSize * 9 / 10);
  			graphics2D.drawLine(clueLen[0] + x * bSize + bSize / 10 + cWidth,
  					clueLen[1] + y * bSize + bSize * 9 / 10,
  					clueLen[0] + x * bSize + bSize * 9 / 10 + cWidth,
  					clueLen[1] + y * bSize + bSize / 10);
  			break;
  		case 3:
  			graphics2D.setColor(RED);
  			graphics2D.fillRect(clueLen[0] + x * bSize + cWidth, //draw red background, but how can the background be red if our eyes aren't red?
  					clueLen[1] + y * bSize,
  					bSize,
  					bSize);
  			graphics2D.setColor(BLACK);
  			graphics2D.drawLine(clueLen[0] + x * bSize + bSize / 10 + cWidth, //draw x
  					clueLen[1] + y * bSize + bSize / 10,
  					clueLen[0] + x * bSize + bSize * 9 / 10 + cWidth,
  					clueLen[1] + y * bSize + bSize * 9 / 10);
  			graphics2D.drawLine(clueLen[0] + x * bSize + bSize / 10 + cWidth,
  					clueLen[1] + y * bSize + bSize * 9 / 10,
  					clueLen[0] + x * bSize + bSize * 9 / 10 + cWidth,
  					clueLen[1] + y * bSize + bSize / 10);
  	}
  }

  public void drawClues(int x, int type, Graphics2D graphics2D, int cWidth) {
  	graphics2D.setFont(graphics2D.getFont().deriveFont(12f));
  	if (type == 0) {
  		String s = cluesX[x].toString();
  		DrawingTools.drawRightText(graphics2D.getFont(), s, clueLen[0] + cWidth, clueLen[1] + x * bSize + bSize / 2 + 6, graphics2D);
  		//graphics2D.drawString(s, 20, GameWindow.clueLen[1] + x * GameWindow.bSize + GameWindow.bSize / 2);
  	} else {
  		List<Integer> values = cluesY[x].getValues();
  		int begin = (clueLen[1] - values.size() * 12);
  		for (int i = 0; i < values.size(); i++) {
  			String s = Integer.toString(values.get(i));
  			DrawingTools.drawCenteredText(graphics2D.getFont(), s, clueLen[0] + x * bSize + bSize / 2 + cWidth, begin + (12 * i), graphics2D);
  			//graphics2D.drawString(s, GameWindow.clueLen[0] + x * GameWindow.bSize + GameWindow.bSize/ 2, 50 + (12 * i));
  		}
  	}
  }

}
