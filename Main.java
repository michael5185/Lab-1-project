
public class Main
{
    public static void printDLList(DLList lst){
        System.out.print("-[");
        for(int i = 0; i < lst.size(); i++){
		    System.out.print(lst.get(i)+ " ");
		}
		
		System.out.println("]");
    }
    
	public static void main(String[] args) {
		DLList<Integer> list = new DLList<>();
		
		for(int i = 0; i <= 8; i++){
		    list.insertAtBeginning(i);
		}
		
		printDLList(list);
		
		System.out.println("first element is : " + list.getBeginning() + ", last element is : " + list.getEnd());
		list.insertAtEnd(-1);
		System.out.println("the last element is updated into '" + list.getEnd() + "'.");
		printDLList(list);
		
		list.removeFromBeginning();
		System.out.println("the first element was removed");
		printDLList(list);
		
		list.removeFromEnd();
		System.out.println("the last element was removed");
		printDLList(list);
		
		list.insertBefore(list.getNode(1),100);
		System.out.println("100 was added in front of the second element");
		printDLList(list);
		
		list.insertAfter(list.getNode(8),-1);
		System.out.println("-1 was added after the 9th element");
		printDLList(list);
		
		list.moveToFront(list.getNode(1));
		System.out.println("100 was moved to the front");
		printDLList(list);
		
		list.moveToEnd(list.getNode(0));
		System.out.println("100 was moved to the End");
		printDLList(list);
		
		
		

	}
}
//<results>
// -[8 7 6 5 4 3 2 1 0 ]                                                                                                                           
// first element is : 8, last element is : 0                                                                                                       
// the last element is updated into '-1'.                                                                                                          
// -[8 7 6 5 4 3 2 1 0 -1 ]                                                                                                                        
// the first element was removed                                                                                                                   
// -[7 6 5 4 3 2 1 0 -1 ]                                                                                                                          
// the last element was removed                                                                                                                    
// -[7 6 5 4 3 2 1 0 ]                                                                                                                             
// 100 was added in front of the second element                                                                                                    
// -[7 100 6 5 4 3 2 1 0 ]                                                                                                                         
// -1 was added after the 9th element                                                                                                              
// -[7 100 6 5 4 3 2 1 0 -1 ]                                                                                                                      
// 100 was moved to the front                                                                                                                      
// -[100 7 6 5 4 3 2 1 0 -1 ]  
