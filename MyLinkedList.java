public class MyLinkedList{
  private int length;
  private Node start,end;
  public MyLinkedList(){
    length = 0;
  }
  public int size(){
    return length;
  }
  public boolean add(Integer value){
    if(size()>0){
      Node newend = new Node(value, end, null);
      end.setNext(newend);
      end = newend;
    }
    else{
      Node n = new Node(value, null, null);
      start = n;
      end = n;
    }
    length++;
    return true;
  }
  public String toString(){
    String ans="[";
    if(size()>0){
      Node current=start;
      for(int i=0;i<length-1;i++){
        ans+=current.getData()+", ";
        current = current.next();
      }
      ans+=current.getData();
    }
    return ans+"]";
  }
  public String reverse(){
    String ans="[";
    if(size()>0){
      Node current=end;
      for(int i=length;i>1;i--){
        ans+=current.getData()+", ";
        current = current.prev();
      }
      ans+=current.getData();
    }
    return ans+"]";
  }
  private Node getNthNode(int n){
    Node current = start;
    for(int i=0;i<n;i++){
      current = current.next();
    }
    return current;
  }
  public Integer get(int index){
    if (index < 0 || index >= size()){
      throw new IndexOutOfBoundsException("Index out of range");
    }
    else{
      return getNthNode(index).getData();
    }
  }
  public Integer set(int index, Integer value){
    if (index < 0 || index >= size()){
      throw new IndexOutOfBoundsException("Index out of range");
    }
    else{
      return getNthNode(index).setData(value);
    }
  }
  public boolean contains(Integer value){
    Node current = start;
    for(int i=0;i<length;i++){
      if(current.getData()==value){
        return true;
      }
      current=current.next();
    }
    return false;
  }
  public int indexOf(Integer value){
    int ans=0;
    Node current=start;
    for(int i=0;i<length;i++){
      if((int)(current.getData())==(int)value){
        return ans;
      }
      current=current.next();
      ans++;
    }
    return -1;
  }
  public void add(int index, Integer value){
    if(index < 0 || index > size()){
      throw new IndexOutOfBoundsException("Index out of bounds");
    }
    else{
      if(size()==0){
        Node n = new Node(value, null, null);
        start = n;
        end = n;
      }
      else if(index == size()){
        Node newend = new Node(value, end, null);
        end.setNext(newend);
        end = newend;
      }
      else if(index == 0){
        Node newstart = new Node(value, null, start);
        start.setPrev(newstart);
        start = newstart;
      }
      else{
        Node prev = getNthNode(index-1);
        Node n = new Node(value, prev, prev.next());
        prev.setNext(n);
        n.next().setPrev(n);
      }
      length++;
    }
  }
  public Integer remove(int index){
    if(index < 0 || index >= size()){
      throw new IndexOutOfBoundsException("index out of bounds");
    }
    else{
      int ans;
      if(index == size()-1){
        ans=end.getData();
        end=end.prev();
        end.setNext(null);
      }
      else if(index == 0){
        ans=start.getData();
        start=start.next();
        start.setPrev(null);
      }
      else{
        Node n = getNthNode(index);
        ans=n.getData();
        n.prev().setNext(n.next());
        n.next().setPrev(n.prev());
      }
      length--;
      return ans;
    }
  }
  public boolean remove(Integer value){
    int i = indexOf(value);
    if(i==-1){
      return false;
    }
    else{
      remove(i);
      return true;
    }
  }
  public void extend(MyLinkedList other){
    end.setNext(other.start);
    other.start.setPrev(end);
    end=other.end;
    other.start=null;
    other.end=null;
    length=length+other.length;
    other.length=0;
  }
}

class Node{
  private Integer data;
  private Node prev, next;
  public Node(int _data, Node _prev, Node _next){
    data = _data;
    prev = _prev;
    next = _next;
  }
  public Integer getData(){
    return data;
  }
  public Integer setData(Integer i){
    Integer old = data;
    data = i;
    return old;
  }
  public Node next(){
    return next;
  }
  public Node prev(){
    return prev;
  }
  public void setPrev(Node _prev){
    prev = _prev;
  }
  public void setNext(Node _next){
    next = _next;
  }
  public String toString(){
    return ""+data;
  }
}
