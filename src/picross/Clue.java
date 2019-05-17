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
  
  }

}
