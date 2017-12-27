package mutithread.base;

/**
 * @DESC 军队线程，模拟作战双方的行为
 * @Author Anjoulee
 * @Date 2017/12/27
 */
public class ArmyRunable implements Runnable {
    //volatile保证了线程可以正确的读取其他线程写入的值
    //可见性
    volatile boolean keepRunning = true;

    public void run() {
        //发动5连击
        while (keepRunning) {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "进攻对方【" + i + "】");
                //让出了处理器时间，下次该谁进攻还不一定呢
                Thread.yield();
            }
        }
        System.out.println(Thread.currentThread().getName() + "结束了战斗");

    }
}
