import java.util.Random;


public class Maze {
	int size;
	private Node[][] maze;
	Maze(int x){
		size = x;
	}
	public Node randomNode(int size) {
		Random rand = new Random();
		int x = Math.abs(rand.nextInt()%size);
		rand = new Random();
		int y = Math.abs(rand.nextInt()%size);
		return maze[y][x];
	}
	public void make() {
		maze = new Node[size][size];
		for(int i =0; i<size;i++) {
			for(int j=0;j<size;j++) {
				maze[i][j] = new Node(i,j);
				//System.out.print(i + "" + j);
				//System.out.print(" ");
			}
			System.out.println();
		}
	}
	public Node find(Node n) {
		while(n.parent != n) {
			n=n.parent;
		}
		return n;
	}
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
	System.out.print("("a.x + " " + a.y+")");
		System.out.print(", ");
	System.out.print("("b.x + " " + b.y+")");
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
    public void display(){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                Node n = maze[i][j];
                System.out.print(nodeAndWall(n));
            }
            System.out.println();
        }
    }
    public void run(){
        make();
        union();
        display();
    }
}
