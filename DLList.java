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
    
    public int getBeginning(){
    	return sentinel.next.item;
    }
    
    public int getEnd(){
        return sentinel.prev.item;
    }
    
    public void insertAtBeginning(int i){
        sentinel.next = new Node(sentinel, i, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size++;
    }
    
    public void insertAtEnd(int i){
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
                for(int n= size-1; i!=n; n--){
                    temp = temp.prev;
                }
                return temp.item;
            }
            
        }        
    }
    
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
    // 	 if( i < 0 ||  size < i){
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
    
    
    
    }//change the argument to node type
    
    public void insertBefore(Node n, int i ) {
    	
    	n.prev.next =  new Node(n.prev,i,n);
    	n.prev = n.prev.next;
    }
    
    public void insertAfter(Node n, int i ) {
    	
    	n.next.prev =  new Node(n,i,n.next);
    	n.next = n.next.prev;
    }
    
    
    public void MoveToEnd(Node node) {
        
        remove(node);
        sentinel.prev.next = node;
        node.prev = sentinel.prev;
        node.next = sentinel;
        sentinel.prev = node;
    // 	if( i < 0 ||  size < i){
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
    // 	if( i < 0 ||  size < i){
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
