public class Node {
    private Node parent;
    private Node lchild;
    private Node rchild;
    private int key;
    public Node(int key){
        this.key = key;
    }

    public int getkey(){
        return key;
    }

    public void setParent(Node parent){
        this.parent = parent;
    }

    public void setLchild(Node lchild){
        this.lchild = lchild;
    }

    public void setRchild(Node rchild){
        this.rchild = rchild;
    }

    public Node getLchild(){
        return lchild;
    }

    public Node getRchild(){
        return rchild;
    }

    public Node getParent(){
        return parent;
    }


}