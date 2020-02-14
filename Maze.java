//5104232581
import java.util.Random;

//The Maze class builds an explicit version of a grid that will be used by functions like union, find, connected, and destroyed
public class Maze {
	int size;
	private Node[][] maze;
	//The constructor below is what takes in how big the grid should be
	Maze(int x){
		size = x;
	}
	//randomNode takes in the size of the grid (its a formality)
	//we get a random number from Random() and initialize rand to it.
	//our coordinates x and y are chosen at random and are given values between 0-9. not 10 because 0 is considered as our first point and so 9 will be considered our 10th.
	//the overall output of this function is that we get a node with coordinates (x,y), which is chosen at random from the 10x10 grid maze we have made
	public Node randomNode(int size) {
		Random rand = new Random();
		int x = Math.abs(rand.nextInt()%size);
		rand = new Random();
		int y = Math.abs(rand.nextInt()%size);
		return maze[y][x];
	}
	//this functions whole idea is to make a 10x10 grid. this is made using the idea that a Node represents a coordinate in our grid and that all the Nodes are connected to other nodes as parents
	public void make() {
		maze = new Node[size][size];
		for(int i =0; i<size;i++) {
			for(int j=0;j<size;j++) {
				maze[i][j] = new Node(i,j);

			}
			System.out.println();
		}
	}
	//this function is a different implementation of find in the quick union algorithm. instead of returning the value of an index, this find takes in a Node (which is a point or a coordinate in our grid)
	//and if the parent of the node is not the same as itself (meaning it doesn't have a parent/it is the parent of its node) then it returns the node
	//the whole idea of this is to check if the node is connected to other nodes. because the way i built nodes are like the ones in a list, all nodes are connected in respect to parents(previous nodes)
	//so if i want to check if two points are connected or in "union", then the way i check it is using find.
	public Node find(Node n) {
		while(n.parent != n) {
			n=n.parent;
		}
		return n;
	}
	//this function uses find as a way to check if a node is not connected to anything before it (it can have a child) 
	public boolean destroyed() {
		if(find(maze[size-1][size-1]) == find(maze[0][0])) {
			//System.out.println(maze[0][0]);
			return true;}
		else
			return false;
	}
	public boolean join(Node a, Node b) {
		Node first = find(a);
        Node second = find(b);
        if(first == second){

            return false;
        }
        first.parent = second;
    	System.out.print("("+a.x + " " + a.y+")");
		System.out.print(", ");
		System.out.print("("+b.x + " " + b.y+")");
        System.out.println();
        a.breakWall(b);
        return true;
	}
	public Node connectedNode(Node a) {
		Random rand;
		int x;
		int y;
		do {
			x=a.x;
			y=a.y;
			rand = new Random();
			final int b = Math.abs(rand.nextInt()%4);
			switch (b) {
				default:
					continue;
				case 0:
					y+=1;
					continue;
				case 1:
					x+=1;
					continue;
				case 2:
					y-=1;
					continue;
				case 3:
					x-=1;
					continue;

				
			}
			
		} while(x >(size-1) || x<0||y>(size-1)||y<0);
		return maze[y][x];
	}
	//unlike the union function in the quick union algorithm which uses two inputs and connects them together, this union uses the idea that if 
    public void union(){
        while(!destroyed()){
            Node randomNode = randomNode(size);
            join(randomNode, connectedNode(randomNode));
        }
    }
    
    public String nodeAndWall(Node n){
        Wall w  = n.wall;
        if(w.top && w.down && w.right && w.left)
            return "\u254b";
        if(w.top && w.down && w.right)
            return "\u2523";
        if(w.top && w.down && w.left)
            return "\u252b";
        if(w.top && w.right && w.left)
            return "\u253b";
        if(w.down && w.right && w.left)
            return "\u2533";
        if(w.top && w.down)
            return "\u2503";
        if(w.right && w.left)
            return "\u2501";
        if(w.top && w.left)
            return "\u251b";
        if(w.top && w.right)
            return "\u2517";
        if(w.down && w.left)
            return "\u2513";
        if(w.down && w.right)
            return "\u250F";
        if(w.top)
            return "\u2579";
        if( w.down)
            return "\u257b";
        if(w.right)
            return "\u257A";
        if(w.left)
            return "\u2578";
        return " ";
    }
    
    //displays the complete structure of our final matrix.
    //this basically uses the addresses given in nodeAndWall for each node after destroying all blocks and prints the output
    public void display(){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                Node n = maze[i][j];
                System.out.print(nodeAndWall(n));
            }
            System.out.println();
        }
    }
    //this is the function that initiates the process of constructing a maze
    public void run(){
        make();
        union();
        display();
    }
}
