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
    
    public int getFirst(){
    	return sentinel.next.item;
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
    
    public int get(int i){
    	if( i < 0 ||  size < i){
            System.out.println("Error! index out of bound.");
            return -1;
        }else{ 
            if(i <= size/2){
                Node temp = sentinel.next;
                for(int n= 0; i!=n; n++){
                    temp = temp.next;
                }
                return temp.item;
            }else{
                Node temp = sentinel.prev;
                for(int n= i; i!=n; n--){
                    temp = temp.prev;
                }
                return temp.item;
            }
            
        }        
    }
    
    public void removeFirst() {
    	sentinel.next.next.prev = sentinel;
    	sentinel.next = sentinel.next.next;
    	size--;
    }
    
    public void removeLast() {
    	sentinel.prev.prev.next = sentinel;
    	sentinel.prev = sentinel.prev.prev;
    	size--;
    }

    public void remove(int i) {
    	 if( i < 0 ||  size < i){
             System.out.println("Error! index out of bound.");
            
         }else{ 
             if(i <= size/2){
                 Node temp = sentinel.next;
                 for(int n= 0; i!=n; n++){
                     temp = temp.next;
                 }
                 
                 temp.prev.next = temp.next;
                 temp.next.prev = temp.prev;
             }else{
                 Node temp = sentinel.prev;
                 for(int n= i; i!=n; n--){
                     temp = temp.prev;
                 }
                 
                 temp.prev.next = temp.next;
                 temp.next.prev = temp.prev;
             }
             size--;
             
         }
    }
    
    public void insertBefore(Node n, int i ) {
    	
    	n.prev.next =  new Node(n.prev,i,n);
    	n.prev = n.prev.next;
    }
    
    public void insertBefore(Node n, int i ) {
    	
    	n.next.prev =  new Node(n,i,n.next);
    	n.next = n.next.prev;
    }
    
    public void MoveToEnd(int i) {
    	if( i < 0 ||  size < i){
            System.out.println("Error! index out of bound.");
           
        }else{ 
            if(i <= size/2){
                Node temp = sentinel.next;
                for(int n= 0; i!=n; n++){
                    temp = temp.next;
                }
                temp.next.prev = temp.prev;
                temp.prev.next = temp.next;
                temp.prev= sentienl.prev;
                temp.next = sentinel;
                sentinel.prev.next = temp;
                sentinel.prev = temp;
                
            }else{
                Node temp = sentinel.prev;
                for(int n= i; i!=n; n--){
                    temp = temp.prev;
                }
                
                temp.next.prev = temp.prev;
                temp.prev.next = temp.next;
                temp.prev= sentienl.prev;
                temp.next = sentinel;
                sentinel.prev.next = temp;
                sentinel.prev = temp;
            }
            
        }
    }
    
    public void moveToFront(int i) {
    	if( i < 0 ||  size < i){
            System.out.println("Error! index out of bound.");
           
        }else{ 
            if(i <= size/2){
                Node temp = sentinel.next;
                for(int n= 0; i!=n; n++){
                    temp = temp.next;
                }
                temp.next.prev = temp.prev;
                temp.prev.next = temp.next;
                temp.prev = sentinel;
                temp.next = sentinel.next;
                sentinel.next.prev = temp;
                sentinel.next = temp;
                
            }else{
                Node temp = sentinel.prev;
                for(int n= i; i!=n; n--){
                    temp = temp.prev;
                }
                
                temp.next.prev = temp.prev;
                temp.prev.next = temp.next;
                temp.prev = sentinel;
                temp.next = sentinel.next;
                sentinel.next.prev = temp;
                sentinel.next = temp;
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

Insert at the beginning O
Insert at the end O
Remove from the beginning O
Remove from the end O
Insert before a given node O
Insert after a given node O
Remove a given node O
Move to front (move an object to the front) O
Move to end (move an object to the end) O
*/
