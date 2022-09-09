public class BinaryTree {
// simple
    Node root;

    public BinaryTree(){
    }

    public Node search(int key){

        Node x = null;

        if(root != null) x = root;


        while(x!=null && x.getLchild() != null && x.getRchild() != null && x.getkey() != key){
            if(x.getLchild().getkey() == key) x = x.getLchild();
            else x = x.getRchild();
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

    public boolean isLeft(Node a, Node b){

        boolean left = false;

        if(a.getkey() <= b.getkey()) left = true;

        return left;
    }

    public void insert(Node a){
            boolean left = false;
            boolean isRoot = false;
            Node tmp = a;

            if(root!=null) a.setParent(root);
            else{
                isRoot = true;
                root = a;
            }

            while(a.getParent() != null){
                left = isLeft(a, root);
                a = root;
            }
                a = tmp;

            if(left && !isRoot){
                root.setLchild(a);
                }
            else if(!isRoot){ 
                root.setRchild(a);
            }
        }
        

    }










