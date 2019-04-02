import java.util.*;
public class Radix{
  public static void main(String[] args){
    int[] data = {11,32,35,50,99};
    radixsort(data);
    System.out.println(data);
  }
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
    MyLinkedList<Integer>[] buckets = new MyLinkedList[10];
    for(int i=0;i<data.length;i++){
      int d = data[i]%10;
      buckets[d].add(data[i]);
    }
  }
  private static void printBuckets(MyLinkedList<Integer>[] b){
    for(int i=0;i<b.length;i++){
      System.out.println(b[i]);
    }
  }
  private static String ats(int[] a){
    String ans="";
    for(int i=0;i<a.length;i++){
      ans+=a[i];
      ans+=" ";
    }
    return ans;
  }
}
