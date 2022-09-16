public class BinaryTree {
// simple
    Node root;

    public BinaryTree(){
    }

    // returns the root node
    public Node getRoot(){
        return root;
    }

    /**
     * Run rsearch() specifically starting from the root and searches for a key.
     * @param key The value being search for
     * @return The node in which contains the key.
     */


    public Node search(int key){
        return rsearch(root, key);
    }

    /**
     * 
     * @param x The starting node for the search
     * @param key The value being searched for
     * @return The node in which contains the key.
     */

    public Node rsearch(Node x, int key){
        if(x!=null && x.getkey() != key){
            if(key<x.getkey())
            return rsearch(x.getLchild(), key);
        else {
            return rsearch(x.getRchild(), key);
        }
    }
    return x;
}

/**
 * Inserts a node into a binary search tree. Utilizes the findInsertNode() method to correctly insert each node.
 * @param newNode New node to be inserted with a key value
 */

    public void insert(Node newNode){
        Node newParent = findInsertNode(newNode.getkey());
        if(newParent == null) root = newNode;
        else{
            newNode.setParent(newParent);
            if(newParent.getkey() > newNode.getkey()) newParent.setLchild(newNode);
            else newParent.setRchild(newNode);
        }
    }
    /**
     * Checks whether a node has children or not.
     * @param a The node to be checked
     * @return Returns false if the node has a left child, a right child, or both, returns true otherwise.
     */
    public boolean nochildren(Node a){
        if(a == null) return true;
        return a.getLchild() == null && a.getRchild() == null;
        }

        /**
         * Checks if the node has a single child
         * @param a The node to be checked
         * @return Returns true is the node has a SINGLE child, false otherwise
         */
    public boolean onechild(Node a){
        return(!nochildren(a)) && (a.getLchild() == null || a.getRchild() == null);
    }


    /**
     * Detaches a leaf node from a parent and is therefor no longer accessable.
     * @param a Leaf node to be detacthed. (No children)
     */
    public void scrubParent(Node a){
        if(a == null) return;
        Node parent = a.getParent();
        if(parent==null) root = null;
        else{
            if(a == parent.getRchild()) parent.setRchild(null);
            else parent.setLchild(null);
        }

    }
    /**
     * Detatches a node that has a single child. The child of the node is connected to the parent of the node.
     * If the node is a root, then the child becomes the new root of the tree.
     * @param a The node with one child to be detached.
     */

    public void spliceOut(Node a) {
        Node theChild = a.getLchild();
        Node theParent = a.getParent();
        if(theChild == null) theChild = a.getRchild();

        if(theChild != null) theChild.setParent(theParent);

        if(theParent == null) root = theChild;
        else{
            if(a == theParent.getRchild()) theParent.setRchild(theChild);
            else theParent.setLchild(theChild);
        }
    }


    /**
     * Changes the key of a node that has two children. Uses succesor() method to find the succesor of the node a, 
     * then replaces the nodes key with it's succesors value.
     * @param a Node with two children to be deleted
     */
    public void rotateOut(Node a){
        if(a==null) return;

        Node replace = a;
        Node suc = a.successor();
        spliceOut(suc);
        a.setKey(suc.getkey());
    }

    

/**
 * Takes a node and decides which deletion method to use based on the amount of children or if it has no children.
 * 1. No children, uses scrubParent()
 * 2. One child, uses spliceOut()
 * 3. Two children, uses RotateOut()
 * @param a Node to be deleted
 */
    public void delete(Node a){
        if(nochildren(a)) {
            scrubParent(a);
            return;
        }
        if(onechild(a)) spliceOut(a);
        else{
            rotateOut(a);
        }
    }

    /**
     * Uses a key value to find where a new node should be inserted. Finds what would be the parent of a new node.
     * @param key Key value to find new insertion point
     * @return A node which would be the parent for a new node being inserted with the provided key.
     */
    public Node findInsertNode(int key){
        Node newparent = null;
        Node x = root;
        while(x != null){

            newparent = x;

            if(key <= x.getkey()) x = x.getLchild();
            else x = x.getRchild();
            
        }

        return newparent;
    }

    
        

    }










