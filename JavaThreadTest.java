public class JavaThreadTest{

    private static Object sLockOject = new Object();
    private static class hello extends Thread{

        private String name;
        public hello(){}

        public hello(String name){
            this.name = name;
        }

        public void run(){
            for (int i = 0; i < 5; i++) {
                System.out.println(name + "运行" + i);
            }
        }
    }


    static class WaitThread extends Thread{

        public void run(){
            try {
                synchronized(sLockOject){
                    Thread.sleep(3000);
                    sLockOject.notify();
                }
            } catch (Exception e) {
                
            }
        }
    }

    public static void main(String[] args) {
        // hello h1 = new hello("A");
        // hello h2 = new hello("B");
        // h1.start();
        // h2.start();
        Thread thread = new WaitThread();
        thread.start();
        long starttime = System.currentTimeMillis();
        try {
            synchronized(sLockOject){
                System.out.println("主线程等待");
                sLockOject.wait();
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
        long times = (System.currentTimeMillis()-starttime);
        System.out.println(times);
    }

}