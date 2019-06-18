public class Counter{
  private String value;
  private int counter;

  public Counter(String value){
    this.value=value;
    counter=1;
  }

  public void inc(){
    ++counter;
  }

  public int size(){
    return this.counter;
  }

  public boolean match(String val){
    return val.equals(this.value);
  }

  public String toString(){
    return "("+value+","+counter+")";
  }



}
