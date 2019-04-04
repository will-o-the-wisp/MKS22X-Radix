import java.util.*;
public class Radix{
  public static void main(String[] args){
    int[] data = {11,50,7,51,99,80};
    radixsort(data);
    System.out.println(ats(data));
  }
  public static void radixsort(int[] data){
    if(data.length==0){
      return;
    }
    int max = data[0];
    for(int i=0;i<data.length;i++){
      if(Math.abs(data[i])>Math.abs(max)){
        max=data[i];
      }
    }
    int maxd = (int)Math.log10(Math.abs(max))+1;
    MyLinkedList<Integer>[] buckets = new MyLinkedList[10];
    for(int i=0;i<buckets.length;i++){
      buckets[i] = new MyLinkedList();
    }
    for(int i=0;i<data.length;i++){
      int d = data[i]%10;
      buckets[d].add(data[i]);
    }
    printBuckets(buckets);
    for(int j=1;j<maxd+1;j++){
      MyLinkedList<Integer> chain = new MyLinkedList<Integer>();
      for(int i=0;i<buckets.length;i++){
        chain.extend(buckets[i]);
      }
      System.out.println(chain);
      for(int i=0;i<data.length;i++){
        int d = (chain.get(0)/(int)Math.pow(10,j))%10;
        System.out.println(d);
        buckets[d].add(chain.removeFront());
      }
      printBuckets(buckets);
    }
    for(int i=0;i<data.length;i++){
      data[i]=buckets[0].removeFront();
    }
  }
  private static void printBuckets(MyLinkedList<Integer>[] b){
    String a = "";
    for(int i=0;i<b.length;i++){
      a+=b[i]+" ";
    }
    System.out.println(a);
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
