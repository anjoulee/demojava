package mutithread.demo;

/**
 * @DESC 线程让步
 * * yield（）方法是一个和sleep方法有点类似的静态方法。yield也可以让当前正在执行的线程暂停
 * 但它不会阻塞该线程，它只是将该线程转入就绪状态。yield只是让当前线程暂停一会儿，让系统的
 * 调度器重新调度一次（完全可能的情况是：当一个线程调用了yield方法暂停之后，线程调度器又马上
 * 将其调度出来重新执行。）
 * 实际上，当前线程调用了yield方法后，只有优先级和当前线程相同，甚至优先级高于当前线程的处于
 * 就绪状态的线程才会获得执行机会。
 * @Author Anjoulee
 * @Date 2017/12/27
 */
public class YieldThread implements Runnable {
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
            if (i == 20) {
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) {
        //启动第一条子线程
        Thread td1 = new Thread(new YieldThread(), "线程1");
        //最高级
//        td1.setPriority(Thread.MAX_PRIORITY);
        //启动第二条子线程
        Thread td2 = new Thread(new YieldThread(), "线程2");
        //最低级
//        td2.setPriority(Thread.MIN_PRIORITY);
        td1.start();
        td2.start();
        System.out.println(Thread.currentThread().getName());
    }
    /**
     * 总结：sleep和yield区别
     A.sleep方法暂停当前线程后，会给其他线程执行机会，不会理会其他线程的优先级。而yield只会给优先级>=当前优先级的线程执行机会
     B.Sleep方法会将线程转入阻塞状态，知道经过阻塞时间才会转入就绪状态。而yield是不会将线程转入阻塞状态的，它只是强制当前线程进入就绪状态。
     C.Sleep会抛出InterruptedException异常。而yield没有声明任何异常
     D.Sleep方法比yield方法有更好的移植性。
     E.通常不依靠yield来控制并发线程控制
     */
}