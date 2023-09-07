public class Main {
    static void runInstances(){
        ObjectRunner op=new ObjectRunner();
        op.setUp();
        op.tearDown();
        op.testObjectPool();
    }
    public static void main(String args[]) {
       Main.runInstances();
    }
}
