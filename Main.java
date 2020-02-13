import DLList.java;
public class Main
{
	public static void main(String[] args) {
		DLList list = new DLList();
		list.insertAtBeginning(7);
		list.insertAtBeginning(6);
		list.insertAtBeginning(5);
		list.insertAtBeginning(4);
		list.insertAtBeginning(3);
		list.insertAtBeginning(2);
		list.insertAtBeginning(1);
		list.insertAtBeginning(0);
		list.insertAtEnd(8);
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3));
		System.out.println(list.get(4));
		System.out.println(list.get(5));
		System.out.println(list.get(6));
		System.out.println(list.get(7));
		System.out.println(list.getEnd());
	}
}
