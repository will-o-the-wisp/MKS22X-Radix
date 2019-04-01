public class MyLinkedList<E>{
  private int length;
  private Node<E> start,end;
  public MyLinkedList(){
  }
  public void clear(){
    length = 0;
    start = null;
    end = null;
  }
  public int size(){
    return length;
  }
  public boolean add(E value){
    if(size()>0){
      Node<E> newend = new Node<E>(value, end, null);
      end.setNext(newend);
      end = newend;
    }
    else{
      Node<E> n = new Node<E>(value, null, null);
      start = n;
      end = n;
    }
    length++;
    return true;
  }
  public String toString(){
    String ans="[";
    if(size()>0){
      Node<E> current=start;
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
      Node<E> current=end;
      for(int i=length;i>1;i--){
        ans+=current.getData()+", ";
        current = current.prev();
      }
      ans+=current.getData();
    }
    return ans+"]";
  }
  private Node<E> getNthNode(int n){
    Node<E> current = start;
    for(int i=0;i<n;i++){
      current = current.next();
    }
    return current;
  }
  public E get(int index){
    if (index < 0 || index >= size()){
      throw new IndexOutOfBoundsException("Index out of range");
    }
    else{
      return getNthNode(index).getData();
    }
  }
  public E set(int index, E value){
    if (index < 0 || index >= size()){
      throw new IndexOutOfBoundsException("Index out of range");
    }
    else{
      return getNthNode(index).setData(value);
    }
  }
  public boolean contains(E value){
    Node<E> current = start;
    for(int i=0;i<length;i++){
      if(current.getData()==value){
        return true;
      }
      current=current.next();
    }
    return false;
  }
  public int indexOf(E value){
    int ans=0;
    Node<E> current=start;
    for(int i=0;i<length;i++){
      if(current.getData().equals(value)){
        return ans;
      }
      current=current.next();
      ans++;
    }
    return -1;
  }
  public void add(int index, E value){
    if(index < 0 || index > size()){
      throw new IndexOutOfBoundsException("Index out of bounds");
    }
    else{
      if(size()==0){
        Node<E> n = new Node<E>(value, null, null);
        start = n;
        end = n;
      }
      else if(index == size()){
        Node<E> newend = new Node<E>(value, end, null);
        end.setNext(newend);
        end = newend;
      }
      else if(index == 0){
        Node<E> newstart = new Node<E>(value, null, start);
        start.setPrev(newstart);
        start = newstart;
      }
      else{
        Node<E> prev = getNthNode(index-1);
        Node<E> n = new Node<E>(value, prev, prev.next());
        prev.setNext(n);
        n.next().setPrev(n);
      }
      length++;
    }
  }
  public E remove(int index){
    if(index < 0 || index >= size()){
      throw new IndexOutOfBoundsException("index out of bounds");
    }
    else{
      E ans;
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
        Node<E> n = getNthNode(index);
        ans=n.getData();
        n.prev().setNext(n.next());
        n.next().setPrev(n.prev());
      }
      length--;
      return ans;
    }
  }
  public boolean remove(E value){
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

class Node<E>{
  private E data;
  private Node<E> prev, next;
  public Node(E _data, Node<E> _prev, Node<E> _next){
    data = _data;
    prev = _prev;
    next = _next;
  }
  public E getData(){
    return data;
  }
  public E setData(E i){
    E old = data;
    data = i;
    return old;
  }
  public Node<E> next(){
    return next;
  }
  public Node<E> prev(){
    return prev;
  }
  public void setPrev(Node<E> _prev){
    prev = _prev;
  }
  public void setNext(Node<E> _next){
    next = _next;
  }
  public String toString(){
    return ""+data;
  }
}
