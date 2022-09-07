public class BinaryTree {

    Node root;

    public Node search(int key){
        Node x = root;
        while( x != null && x.getkey() != key){
            x = x.getLchild();
        }
        return x;
    }

    public void delete(Node a){
        if(a.getParent() != null){
            a.getParent().setLchild(a.getLchild());
        }
        else root = a.getLchild();

        if(a.getLchild() != null){
             a.getLchild().setParent(a.getParent());
        }
    }

    public void insert(Node a){
        a.setLchild(root);
        if(root!=null){
            root.setParent(a);
        }
        root = a;
        a.setParent(null);
    }









}