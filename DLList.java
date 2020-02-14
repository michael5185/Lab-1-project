/****************************************
* CIS27 Lab 1 Q1 doubly linked list     *
* -Class implementation              	*
* Participant : Uneeb Javed, Taeho Lee  *
****************************************/
public class DLList<element>
{
    private class Node
    {
        public element item;
        public Node next;
        public Node prev;
       
        Node(Node p, element i, Node n){
            prev = p;
            item = i;
            next = n;
        }
       
       
    }
   
    private Node sentinel;// applied sentinel method instead of null method
    private int size;// keeps track of size in order to increase efficiency
   
    DLList(){
        sentinel = new Node(null, null, null );
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
       
    }
    
    DLList(element i){
        sentinel = new Node(null, null,null );
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        
        sentinel.next = new Node(sentinel, i, sentinel);
        sentinel.prev = sentinel.next;
        size = 1;
       
    }
    
    public int size(){//needed for PrintDLList function in Main.java
        return size;
    }
    
    public element getBeginning(){
    	return sentinel.next.item;
    }
    
    public element getEnd(){
        return sentinel.prev.item;
    }
    
    public void insertAtBeginning(element i){
        sentinel.next = new Node(sentinel, i, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size++;
    }
    
    public void insertAtEnd(element i){
        sentinel.prev = new Node(sentinel.prev , i, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size++;
    }
    
    public element get(int i){// i is an index like an array
    	if( i < 0 ||  size-1 < i){//approaching the required index more efficiently
            System.out.println("Error! index out of bound.");
            return null;
        }else{ 
            if(i <= size/2){
                Node temp = sentinel.next;
                for(int n= 0; i!=n; n++){
                    temp = temp.next;
                }
                return temp.item;
            }else{
                Node temp = sentinel.prev;
                for(int n= size-1; i!=n; n--){
                    temp = temp.prev;
                }
                return temp.item;
            }
            
        }        
    }//made it for convenience 
    
    public void removeFromBeginning() {
    	sentinel.next.next.prev = sentinel;
    	sentinel.next = sentinel.next.next;
    	size--;
    }
    
    public void removeFromEnd() {
    	sentinel.prev.prev.next = sentinel;
    	sentinel.prev = sentinel.prev.prev;
    	size--;
    }

    public void remove(Node node) {
    // 	 if( i < 0 ||  size < i){// if the argument was remove(int i) and i is index
    //          System.out.println("Error! index out of bound.");
            
    //      }else{ 
    //          if(i <= size/2){
    //              Node temp = sentinel.next;
    //              for(int n= 0; i!=n; n++){
    //                  temp = temp.next;
    //              }
                 
    //              temp.prev.next = temp.next;
    //              temp.next.prev = temp.prev;
    //          }else{
    //              Node temp = sentinel.prev;
    //              for(int n= i; i!=n; n--){
    //                  temp = temp.prev;
    //              }
                 
    //              temp.prev.next = temp.next;
    //              temp.next.prev = temp.prev;
    //          }
    //          size--;
             
    //      }
        node.prev.next = node.next;
        node.next.prev = node.prev;
    
    
    
    }//changed the argument to node type
    
    public Node getNode(int i){//i is index
    	if( i < 0 ||  size-1 < i){
            System.out.println("Error! index out of bound.");
            return null;
        }else{ 
            if(i <= size/2){
                Node temp = sentinel.next;
                for(int n= 0; i!=n; n++){
                    temp = temp.next;
                }
                return temp;
            }else{
                Node temp = sentinel.prev;
                for(int n= size-1; i!=n; n--){
                    temp = temp.prev;
                }
                return temp;
            }
            
        }        
    }//function for testing the insertBefore/insertAfter/MoveToEnd/moveToFront
    
    public void insertBefore(Node n, element i ) {
    	
    	n.prev.next =  new Node(n.prev,i,n);
    	n.prev = n.prev.next;
    	size++;
    }
    
    public void insertAfter(Node n, element i ) {
    	
    	n.next.prev =  new Node(n,i,n.next);
    	n.next = n.next.prev;
    	size++;
    }
    
    public void moveToEnd(Node node) {
        
        remove(node);
        sentinel.prev.next = node;
        node.prev = sentinel.prev;
        node.next = sentinel;
        sentinel.prev = node;
    // 	if( i < 0 ||  size < i){// if made with moveToEnd(int i) and i is index
    //         System.out.println("Error! index out of bound.");
           
    //     }else{ 
    //         if(i <= size/2){
    //             Node temp = sentinel.next;
    //             for(int n= 0; i!=n; n++){
    //                 temp = temp.next;
    //             }
    //             temp.next.prev = temp.prev;
    //             temp.prev.next = temp.next;
    //             temp.prev= sentienl.prev;
    //             temp.next = sentinel;
    //             sentinel.prev.next = temp;
    //             sentinel.prev = temp;
                
    //         }else{
    //             Node temp = sentinel.prev;
    //             for(int n= i; i!=n; n--){
    //                 temp = temp.prev;
    //             }
                
    //             temp.next.prev = temp.prev;
    //             temp.prev.next = temp.next;
    //             temp.prev= sentienl.prev;
    //             temp.next = sentinel;
    //             sentinel.prev.next = temp;
    //             sentinel.prev = temp;
    //         }
            
    //     }
    }
    
    public void moveToFront(Node node) {
        
        remove(node);
        sentinel.next.prev = node;
        node.next = sentinel.next;
        node.prev = sentinel;
        sentinel.next = node;
    // 	if( i < 0 ||  size < i){// if made with moveToFront(int i) and i is index
    //         System.out.println("Error! index out of bound.");
           
    //     }else{ 
    //         if(i <= size/2){
    //             Node temp = sentinel.next;
    //             for(int n= 0; i!=n; n++){
    //                 temp = temp.next;
    //             }
    //             temp.next.prev = temp.prev;
    //             temp.prev.next = temp.next;
    //             temp.prev = sentinel;
    //             temp.next = sentinel.next;
    //             sentinel.next.prev = temp;
    //             sentinel.next = temp;
                
    //         }else{
    //             Node temp = sentinel.prev;
    //             for(int n= i; i!=n; n--){
    //                 temp = temp.prev;
    //             }
                
    //             temp.next.prev = temp.prev;
    //             temp.prev.next = temp.next;
    //             temp.prev = sentinel;
    //             temp.next = sentinel.next;
    //             sentinel.next.prev = temp;
    //             sentinel.next = temp;
    //         }
            
    //     }
    }
   
    
   
}
/*
<API required>
public void insertAtBeginning(A value)
public void insertAtEnd(A value)
public void removeFromBeginning()
public void removeFromEnd()
public void insertBefore(A value, DoubleNode node)
public void insertAfter(A value, DoubleNode node)
public void remove(DoubleNode node)
public void moveToFront(DoubleNode node)
public void moveToEnd(DoubleNode node)
*/
