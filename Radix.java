import java.util.*;
public class Radix{
  public static void main(String[] args){
    int[] data = {-4, -1, 0, -13, 12, 21, 55, 43};
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
      int d = Math.abs(data[i]%10);
      buckets[d].add(data[i]);
    }
    for(int j=1;j<maxd;j++){
      MyLinkedList<Integer> chain = new MyLinkedList<Integer>();
      for(int i=0;i<buckets.length;i++){
        chain.extend(buckets[i]);
      }
      for(int i=0;i<data.length;i++){
        int v = chain.get(0);
        int d = Math.abs((v/(int)Math.pow(10,j))%10);
        if(v>=0){
          buckets[d].add(chain.removeFront());
        }
        else{
          buckets[d].addFront(chain.removeFront());
        }
      }
    }
    MyLinkedList<Integer> chain = new MyLinkedList<Integer>();
    for(int i=1;i<buckets.length;i++){
      chain.extend(buckets[i]);
    }
    int s = chain.size();
    for(int i=0;i<s;i++){
      int v = chain.get(0);
      if(v>=0){
        buckets[0].add(chain.removeFront());
      }
      else{
        buckets[0].addFront(chain.removeFront());
      }
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
