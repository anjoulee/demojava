package mutithread.demo;

/**
 * @DESC 实现Runnable接口创建线程类
 *
 * 总结:根据源代码中Thread类构造方法  Ruanalbe接口对象target只能作为参数传递到Thread构造方法中，
 * 所以多个线程可以共用一个Runnable对象，因为都用同一个Runnable对象所以在Runnable实现类的实例变量也可以共享了。
 * 所以Runable非常适合多个相同线程来处理同一份资源的情况。
 * @Author Anjoulee
 * @Date 2017/12/27
 */
public class SecondThread implements Runnable {
    private int i;

    public void run() {
        for (; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + "             .." + i);
            if (i == 10) {
                SecondThread st = new SecondThread();
                //通过new Thread（ Runable target,String name）来创建新线程
                new Thread(st, "线程1").start();
                new Thread(st, "线程2").start();
            }
        }
    }
}
