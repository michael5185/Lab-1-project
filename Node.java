public class Node {
    
    int x;
    int y;
    Node parent;
    Wall wall;
    
    Node(){
        
    }
    /*set node position */
    Node(int y, int x){
        wall = new Wall();
        this.y = y;
        this.x = x;
        parent = this;
    }
    
    /*return position char sign base on the next Node n position
          w
       a Node d
          s
    */
    char nextNode(Node n){
        if(y > n.y) return 'w';
        if(y < n.y) return 's';
        if(x > n.x) return 'a';
        if(x < n.x) return 'd';
        return 'e';
    }
    
    /* base on the char sign break the wall between two node*/
    void breakWall(Node n){
        char d = nextNode(n);
        
        switch(d){
            case 'w':
                wall.top = true;
                n.wall.down = true;
                break;
            case 's':
                wall.down = true;
                n.wall.top = true;
                break;
            case 'a':
                wall.left = true;
                n.wall.right = true;
                break;
            case 'd':
                wall.right = true;
                n.wall.left = true;
                break;
            default:
                System.out.println("Error Node");
        }
    }
}
