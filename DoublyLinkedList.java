public class DoublyLinkedList<E> {
    public static class Node<E>{
        private E element;
        private Node<E> prev;
        private Node<E> next;
        public Node(E e, Node<E> p, Node<E> n){
            element = e;
            prev = p;
            next = n;
        }
        public E getElement(){
            return element;
        }
        public Node<E> getPrev(){
            return prev;
        }
        public Node<E> getNext(){
            return next;
        }
        public void setPrev(Node<E> p){
            prev = p;
        }
        public void setNext(Node<E> n){
            next = n;
        }
    }// Node
    
    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;
    public DoublyLinkedList(){
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }
    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public E first(){
        if(isEmpty()){
            return null;
        }
        return header.getNext().getElement();  
    }
    public E last(){
        if(isEmpty()){
            return null;
        }
        return trailer.getPrev().getElement();  
    }
    public Node<E> getHeader(){
        return header;
    }
    public Node<E> getTrailer(){
        return trailer;
    }
    public void addFirst(E e){
        try{
            addBetween(e,header,header.getNext());
        }catch(NullPointerException npe){
            System.out.println("DoublyLinkedList.addFirst() : Could not add element : make sure the related elements are not null." + npe);
        }
    }
    public void addlast(E e){
        try{
            addBetween(e,trailer.getPrev(),trailer);
        }catch(NullPointerException npe){
            System.out.println("DoublyLinkedList.addlast() : Could not add element : make sure the related elements are not null." + npe);
        }
    }
    public E removeFirst() throws Exception{
        E element = null;
        try{
            if(isEmpty()){
               System.out.println("DoublyLinkedList.removeFirst() : The list is empty, please populate the list first"); 
               throw new Exception() ;
            }   
            element = remove(header.getNext());
        }catch(NullPointerException npe){
            System.out.println("DoublyLinkedList.removeFirst() : Could not remove element, make sure the related elements are not null." + npe);
        }
        return element;
    }
    public E removeLast() throws Exception{
        E element = null;
        try{
            if(isEmpty()){
               System.out.println("DoublyLinkedList.removeLast() : The list is empty, please populate the list first"); 
               throw new Exception() ;
            }
                element = remove(trailer.getPrev());
        }catch(NullPointerException npe){
            System.out.println("DoublyLinkedList.removeLast() : Could not remove element, make sure the related elements are not null." + npe);
        }
        return element ; 
    }
    
    private void addBetween(E e, Node<E> predecessor, Node<E> successor) throws NullPointerException{
        Node<E> newest = new Node<>(e,predecessor,successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }
    private E remove(Node<E> node) throws NullPointerException{
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }
    public String toString(){
        Node current = header;
        String string = "";
        while ( current != null )
              { 
                if(current.getElement() != null){
                    string += " " + current.getElement();
                }
                current = current.getNext();
              }
        return string;
    }
}// end DoublyLinkedList
