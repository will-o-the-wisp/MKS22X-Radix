import java.util.*;
public class Radix{
  public static void radixsort(int[] data){
    if(data.length==0){
      return;
    }
    int max = data[0];
    for(int i=0;i<data.length;i++){
      if(data[i]>max){
        max=data[i];
      }
    }
    int maxd = (int)Math.log10(Math.abs(max))+1;
    ArrayList<MyLinkedList<Integer>> buckets = new ArrayList<MyLinkedList<Integer>>();
    for(int i=0;i<10;i++){
      buckets.add(new MyLinkedList<Integer>());
    }
    
  }
}
