package picross;
import java.util.*;

public class Clue{

  private enum Type {ROW, COLUMN};
  private Type type;
  private final int position;
  private List<Integer> values = new ArrayList<>();


  public Clue(int position, int type){
      if(type == 0){
        this.type = Type.ROW;
      }else{
        this.type = Type.COLUMN;
      }
      this.position = position;
  }

  public List<Integer> getValues(){
    if(values.size() > 0){
      return values;
    }
    else {
      return new ArrayList<>(Collections.singletonList(0));
    }
  }

  public void generateClue(Grid grid){
    int temp = 0;
    int x = 0;
    int length = (this.type == Type.ROW ? grid.sizeX : grid.sizeY);
    int y = this.position;
    while (x < length){
      Cell curCell = grid.getCell(this.type == Type.ROW ? x : y, this.type == Type.ROW ? y : x);
      if(curCell.getState() == Cell.Marking.EMPTY){
        temp++;
      }
      else if(temp > 0){
        this.values.add(temp);
      }
      x++;
    }
    if(temp > 0){
      this.values.add(temp);
    }
  }

}
