public class DLList
{
    private class Node
    {
        public int item;
        public Node next;
        public Node prev;
       
        Node(Node p, int i, Node n){
            prev = p;
            item = i;
            next = n;
        }
       
       
    }
   
    private Node sentinel;
    private int size;
   
    DLList(){
        sentinel = new Node(null, 0,null );
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
       
    }
    
    DLList(int i){
        sentinel = new Node(null, 0,null );
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        
        sentinel.next = new Node(sentinel, i, sentinel);
        sentinel.prev = sentinel.next;
        size = 1;
       
    }
    
    
    public int getLast(){
        return sentinel.prev.item;
    }
    
    public void addFirst(int i){
        sentinel.next = new Node(sentinel, i, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size++;
    }
    
    public void addLast(int i){
        sentinel.prev = new Node(sentinel.prev , i, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size++;
    }
    
    public int get(int n){
        if( n < 0 ||  size < n){
            System.out.println("Error! index out of bound.");
            return -1;
        }else{ 
            if(n <= size/2){
                Node temp = sentinel.next;
                for(int i= 0; n!=i; i++){
                    temp = temp.next;
                }
                return temp.item;
            }else{
                Node temp = sentinel.prev;
                for(int i= n; n!=i; i--){
                    temp = temp.prev;
                }
                return temp.item;
            }
            
       }
        
    }
   
   
   
}
/*
Implement a class Deque for building doubly-linked lists.
The class should have a nested class inside it, DoubleNode,
where each node contains a reference to the item preceding 
it and the item following it in the list (null if there is
no such item).  Then implement methods for the following tasks:

Insert at the beginning
Insert at the end
Remove from the beginning
Remove from the end
Insert before a given node
Insert after a given node
Remove a given node
Move to front (move an object to the front)
Move to end (move an object to the end)
*/
