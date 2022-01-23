class Node<E>{
    private E element;
    private Node<E> next;
    public Node (E e, Node<E> n){
        element = e;
        next = n;
    }
    public E getElement(){
        return element;
    }
    public Node<E> getNext(){
        return next;
    }
    public void setNext (Node<E> n){
        next = n;
    }
}

class SinglyLInkedList<E> {
    Node<E> head = null;
    Node<E> tail = null;
    private int size = 0;
    
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public void addlast(E e){
        Node<E> newNode =  new Node<>(e, null);
        if(isEmpty()){
            head=newNode;
        }else{
            tail.setNext(newNode);
        }
        tail=newNode;
        size++;
    }
    public E removeFirst(){
        if(isEmpty()){
            return null;
        } 
        E deleted = head.getElement();
        head = head.getNext();
        size--;
        if(size==0){
            tail=null;
        }
        return deleted;
    }
}

class LinkedQueue<E> extends SinglyLInkedList<E>{
    
    public void enqueue(E element){
        addlast(element);
    }

    public E dequeue(){
        return removeFirst();
    }

    public int sizeQueue(){
        return size();
    }
}