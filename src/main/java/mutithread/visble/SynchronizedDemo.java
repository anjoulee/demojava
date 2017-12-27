package mutithread.visble;

/**
 * @DESC synchronized可见性测试
 * <p>
 * 导致共享变量在线程之间不可见的原因
 * 1、线程的交叉执行
 * 2、重排序结合线程交叉执行
 * 3、共享变量更新后的值没有在工作内存与主内存间及时更新
 * @Author Anjoulee
 * @Date 2017/12/27
 */
public class SynchronizedDemo {
    //共享变量
    private boolean ready = false;
    private int result = 0;
    private int number = 1;

    //写操作
    //    public  void write() {
    public synchronized void write() {
        ready = true;
        number = 2;
    }

    //    public  void read() {
    public synchronized void read() {
        if (ready) {
            result = number * 3;
        }
        System.out.println("result的值为：" + result);
    }


    private class ReadWriteThread extends Thread {
        //根据构造方法中传入的flag的参数，确定该线程执行读操作还是写操作
        private boolean flag;

        public ReadWriteThread(boolean flag) {
            this.flag = flag;
        }

        @Override
        public void run() {
            if (flag) {
                write();
            } else {
                read();
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            SynchronizedDemo demo = new SynchronizedDemo();
            //启动线程写操作
            demo.new ReadWriteThread(true).start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //启动线程读操作
            demo.new ReadWriteThread(false).start();
        }


    }
}
