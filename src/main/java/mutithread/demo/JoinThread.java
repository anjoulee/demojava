package mutithread.demo;

/**
 * @DESC join线程
 * 让一个线程等待另一个线程完成的方法：join()。当在某个程序执行流中调用其他线程的join()方法，
 * 那该执行流对应的线程就会阻塞，直到被join()加入的join线程完成为止。join方法通常有使用线程的程序调用，
 * 将大问题划分成许多小问题，每个小问题分配一个线程。当所有的小问题都得到处理后，再调用主线程来进一步操作
 * （Thread t=new Thread();t.start();t.join简单来说就是加入到t线程。等t线程执行完成后才会返回出来执行线程。）
 * Join方法有三种重用形式：
 * Join()：等待被join的线程执行完成
 * Join(long millis):等待join线程的时间最长为millis毫秒（如果在这个时间内，被join的线程还没有执行结束则不再等待）
 * Join(long millis，int nanos)千分之一毫秒（不用）
 * @Author Anjoulee
 * @Date 2017/12/27
 */
public class JoinThread implements Runnable {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //实例化一个Runnable
        JoinThread jt = new JoinThread();
        //创建一个线程
        new Thread(jt).start();
        for (int i = 0; i < 10; i++) {
            if (i == 3) {
                Thread th = new Thread(jt);
                //启动第二个线程
                th.start();
                //main的线程中调用了th线程的join方法
                //让第二个线程执行完成后再执行main
                th.join();
            }
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
