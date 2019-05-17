package picross;

import java.util.*;


public class Cell{

  private boolean canModify;

  private final int x;
  private final int y;

  public enum Marking {FILLED, MARKED, FLAGGED, EMPTY};

  private Marking state;

  public Cell(int x, int y){
    this.x = x;
    this.y = y;
    this.state = Marking.EMPTY;
    this.canModify = true;
  }

  public void setCanModify(boolean canModify){
    this.canModify = canModify;
  }

  public int [] getPos(){
    return new int[]{this.x, this.y};
  }

  public Marking getState(){
    return this.state;
  }

  public boolean canModify(){
    return this.canModify;
  }

}
