public class Node {
    // simple
    private Node parent;
    private Node lchild;
    private Node rchild;
    private int key;
    public Node(int key){
        this.key = key;
    }

    // returns the key value 
    public int getkey(){
        return key;
    }

    //sets the parent of a node
    public void setParent(Node parent){
        this.parent = parent;
    }

    //sets the left child of a node
    public void setLchild(Node lchild){
        this.lchild = lchild;
    }

    //sets the right child of a node
    public void setRchild(Node rchild){
        this.rchild = rchild;
    }


    // returns the right child node of a node
    public Node getLchild(){
        return lchild;
    }

    // returns the left child node of a node
    public Node getRchild(){
        return rchild;
    }

    // returns the parent node of a node
    public Node getParent(){
        return parent;
    }

    // sets the key of a node
    public void setKey(int key){
        this.key = key;
    }

    /**
     * Finds the minimum node, starting the ndoe and moving down through the left child.
     * @return Returns the smallest node. (Leftmost)
     */
    public Node minimum(){
        Node retval = this;
        while(retval.getLchild() != null){
            retval = retval.getLchild();

        }

        return retval;
    }

    /**
     * Finds the succesor node based on key value. (Finds the node with the closest in value and is greater than the node)
     * @return Returns the succesor node.
     */
 
    public Node successor(){
        Node retval = this;
        if(retval.getRchild() != null){
            return retval.getRchild().minimum();
        }
        Node p = retval.getParent();
        while(p != null && retval == p.getRchild()){
            retval = p;
            p = retval.getParent();
        }

        return retval;
    }


    // returns how many children the node has
    public int childcount(){
        int retval = 0;
        if(lchild!= null) retval++;
        if(rchild!= null) retval++;

        return retval;
    }

    public String toString(){
        return " Node with key " + key + "children: " + childcount() + " and reference " + super.toString();
    }

    public void printWalk(){
        if(lchild!= null) lchild.printWalk();
        System.out.println(" " + key);
        if(rchild!= null) rchild.printWalk();
        System.out.println(stringWalk());
    }

    public String stringWalk(){
        String newstr = "";
        if(lchild!= null) newstr += lchild.stringWalk();
        newstr += " " + key + "\n";
        if(rchild!= null) rchild.stringWalk();

        return newstr;
    }

    


}