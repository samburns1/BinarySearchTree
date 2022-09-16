import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.logging.LogManager;
import java.util.ArrayList;
import java.util.Collection;

public class Main{
    //private static Logger LOGGER = Logger.getLogger(Main.class.getName());
    // simple
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Node fe = new Node(3);

        if(TestConstructor()) pass++;
        else fail++;
        
        if(testSetter()) pass++;
        else fail++;

        // if(testSearch()) pass++;
        // else fail++;

        if(testSearchne()) pass++;
        else fail++;

        

        testFindInsert1();

        testFindInsert2();
        

        if(testDelete1()) pass++;
        else fail++;

        if(testDelete2()) pass++;
        else fail++;

        if(testSuccesor1()) pass++;
        else fail++;

        if(testMin1()) pass++;
        else fail++;

        if(testSpliceOut1()) pass++;
        else fail++;

        if(testRotate1()) pass++;
        else fail++;


        testDeleteHelpers();
    

        System.out.println("passed: " + pass);
        System.out.println("failed: " + fail);


    }

    static int pass = 0;
    static int fail = 0;

    public static void testDeleteHelpers(){

        testScrubParent();
        testSpliceOut1();
        //testRotateOut();
        testSpliceOutTwoIters();
    }


// tests the delete method "rotate" out. Makes sure that the "rotated" node corretly assigns it's new parent and children. 
// Also makes sure the child of the removed node has its parent reassinged.

    public static boolean testRotate1(){
        BinaryTree fl = new BinaryTree();
        Node five = new Node(5);
        Node four = new Node(4);
        Node seven = new Node(7);
        Node two = new Node(2);
        Node one = new Node(1);
        Node three = new Node(3);
        Node six = new Node(6);
        Node eleven = new Node(11);
        Node nine = new Node(9);
        Node twelve = new Node(12);

        fl.insert(five);
        fl.insert(four);
        fl.insert(seven);
        fl.insert(two);
        fl.insert(one);
        fl.insert(three);
        fl.insert(six);
        fl.insert(eleven);
        fl.insert(nine);
        fl.insert(twelve);

        
        fl.rotateOut(seven);
        fl.rotateOut(two);

    
      
        //points to different nodes, as the node's key value is simpy replaced and not swapped.
        return(eleven.getParent().getkey() == nine.getkey() && one.getParent().getkey() == three.getkey());

    }

    public static void testScrubParent(){





        BinaryTree fl = new BinaryTree();
        ArrayList<Integer> expected = new ArrayList<>();
        int testSize = 4;
        for(int i = 0; i<testSize; i++){
            Node n = new Node(i);
            fl.insert(n);
            expected.add(i);
        }

        for(int RemoveMe = testSize -1; RemoveMe>=0; RemoveMe--){
            expected.remove(RemoveMe);
            fl.scrubParent(fl.search(RemoveMe));
            ArrayList<Integer> actual = sortedKeyArrayList(fl.getRoot());
            if(actual.equals(expected)) pass++;
                else{
                    fail++;
                }

            }
                

    }

    public static void testSpliceOutTwoIters(){
        BinaryTree fl = new BinaryTree();
        Node zero = new Node(0);
        Node one = new Node(1);
        fl.insert(zero);
        fl.insert(one);
        fl.spliceOut(zero);
        fl.spliceOut(one);
        if(fl.getRoot() == null) pass++;
        else{
            fail++;
        }
    }

    // tests the method spliceout where the node being deleted only has 1 child

    public static boolean testSpliceOut1(){
       
        BinaryTree fl = new BinaryTree();
        Node five = new Node(5);
        Node four = new Node(4);
        Node seven = new Node(7);
        Node two = new Node(2);
        Node one = new Node(1);
        Node three = new Node(3);
        Node six = new Node(6);

        fl.insert(five);
        fl.insert(four);
        fl.insert(seven);
        fl.insert(two);
        fl.insert(one);
        fl.insert(three);
        fl.insert(six);


        fl.spliceOut(seven);
        fl.spliceOut(four);
        return (six.getParent() == five && two.getParent() == five);
    }
/* 

         BinaryTree fl = new BinaryTree();
        ArrayList<Integer> expected = new ArrayList<>();
        int testSize = 4;
        for(int i = 0; i<testSize; i++){
            Node n = new Node(i);
            fl.insert(n);
            expected.add(i);
        }

        for(int RemoveMe = 0; RemoveMe < testSize; RemoveMe+=2){
            expected.remove(expected.indexOf(RemoveMe));
            Node spliceMe = (fl.search(RemoveMe));
            fl.spliceOut(spliceMe);
            ArrayList<Integer> actual = sortedKeyArrayList(fl.getRoot());
            if(actual.equals(expected)) pass++;
                else{
                    fail++;
                }
        }
    }

    */
/* 
    public static void testRotateOut(){
        BinaryTree fl = new BinaryTree();
        ArrayList<Integer> expected = new ArrayList<>();
        int testSize = 64;
        for(int start = testSize; start>0; start>>=1){
            for(int key = start; key < 2*testSize; key+= 2*start){
        
        }
        Collections.sort(expected);

    }
*/
    public static void testFindInsert1(){
        BinaryTree fl = new BinaryTree();
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        Node eight = new Node(8);

        fl.root = four;
        four.setLchild(two);
        four.setRchild(six);
        two.setLchild(one);
        two.setRchild(three);
        six.setLchild(five);
        six.setRchild(seven);

        Node expectSeven = fl.findInsertNode(8);

        if(expectSeven == seven){
            pass++;
        }
        else{
            fail++;
        }
    }


    public static void testFindInsert2(){
        BinaryTree fl = new BinaryTree();
        Node one = new Node(3);
        Node two = new Node(5);
        Node three = new Node(7);
        Node four = new Node(9);
        Node five = new Node(11);
        Node six = new Node(13);
        Node seven = new Node(15);
        Node n = new Node(8);

        fl.root = four;
        four.setLchild(two);
        four.setRchild(six);
        two.setLchild(one);
        two.setRchild(three);
        six.setLchild(five);
        six.setRchild(seven);

        Node expectThree = fl.findInsertNode(8);

        if(expectThree == three){
            pass++;
        }
        else{
            fail++;
            //LOGGER.log(Level.WARNING, "failed testFindINsert: expected " + three + " got " + expectThree);
        }
    }

    public static boolean testSuccesor1(){
        BinaryTree fl = new BinaryTree();
        Node fe = new Node(3);
        Node se = new Node(4);
        fl.insert(fe);
        fl.insert(se);
        Node sfe = fe.successor();
        return sfe == se;
    }

    public static boolean testMin1(){
        BinaryTree fl = new BinaryTree();
        Node fe = new Node(3);
        Node se = new Node(4);
        fl.insert(fe);
        fl.insert(se);
        Node min = fe.minimum();
        return fe == min;
    }

 

    public static boolean testDelete1(){
        BinaryTree fl = new BinaryTree();
        Node fe = new Node(3);
        Node se = new Node(4);
        fl.insert(fe);
        fl.insert(se);
        fl.delete(fe);
        return fl.search(3) == null;
    }

    public static boolean testDelete2(){
        BinaryTree fl = new BinaryTree();
        Node fe = new Node(3);
        Node se = new Node(4);
        fl.insert(fe);
        fl.insert(se);
        fl.delete(se);
        return fl.search(3) == fe;
    }
    

    public static boolean testSearchne(){
        BinaryTree fl = new BinaryTree();
        Node fe = new Node(3);
        fl.insert(fe);
        return fl.search(3) == fe;
    }



    public static boolean TestConstructor(){
        Node fe = new Node(3);
        return fe.getkey() == 3;

    }

    public static boolean testSetter(){
        Node fe = new Node(3);
        Node se = new Node(4);
        fe.setLchild(se);
        return fe.getLchild().getkey() == 4;
    }

    public static ArrayList<Integer> sortedKeyArrayList(Node thisNode){
        ArrayList<Integer> newarr = new ArrayList<>();
        if(thisNode == null) return newarr;
        Node lchild = thisNode.getLchild();
        Node rchild = thisNode.getRchild();
        if(lchild != null) newarr.addAll(sortedKeyArrayList(lchild));
        newarr.add(thisNode.getkey());
        if(rchild != null) newarr.addAll(sortedKeyArrayList(rchild));
        return newarr;
    }


}