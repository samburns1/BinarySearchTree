public class Main{
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Node fe = new Node(3);

        if(TestConstructor()) pass++;
        else fail++;
        
        if(testSetter()) pass++;
        else fail++;

        if(testSearch()) pass++;
        else fail++;

        if(testSearchne()) pass++;
        else fail++;

        if(testSearchte()) pass++;
        else fail++;
        
        if(testDelete1()) pass++;
        else fail++;

        if(testDelete2()) pass++;
        else fail++;


        System.out.println("passed: " + pass);
        System.out.println("failed: " + fail);


    }

    static int pass = 0;
    static int fail = 0;

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

    public static boolean testSearchte(){
        BinaryTree fl = new BinaryTree();
        Node fe = new Node(3);
        Node se = new Node(4);
        fl.insert(fe);
        fl.insert(se);
        return fl.search(3) == fe;
    }

    public static boolean testSearch(){
        BinaryTree fl = new BinaryTree();

        return fl.search(3) == null;
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


}