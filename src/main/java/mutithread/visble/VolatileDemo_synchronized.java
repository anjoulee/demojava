package mutithread.visble;

/**
 * @DESC volatile可见性测试（idea测试没通，在Eclipse测试有输出）
 * <p>
 * 保证number自增操作的原子性
 * 1、使用synchronized关键字
 * 2、使用ReentrantLock（java.until.concurrent.locks包下）
 * 3、使用AtomicInteger(vava.util.concurrent.atomic包下)
 * @Author Anjoulee
 * @Date 2017/12/27
 */
public class VolatileDemo_synchronized {

    //    private volatile int number = 0;
    private int number = 0;

    public int getNumber() {
        return number;
    }

    public void increase() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (this) {
            number++;
        }
    }

    public static void main(String[] args) {
        final VolatileDemo_synchronized volatileDemo = new VolatileDemo_synchronized();
        for (int i = 0; i < 500; i++) {
            new Thread(new Runnable() {
                public void run() {
                    volatileDemo.increase();
                }
            }).start();
        }
        //如果还有子线程在运行，主线程就让出CPU资源
        //知道子线程都运行完成，主线程在继续执行
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println("number：" + volatileDemo.getNumber());
    }
}
