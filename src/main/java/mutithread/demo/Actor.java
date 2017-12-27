package mutithread.demo;

/**
 * @DESC 继承Thread线程类，实现润方法
 * @Author Anjoulee
 * @Date 2017/12/27
 */
public class Actor extends Thread {
    public void run() {
        System.out.println(getName() + "是一个演员");
        int count = 0;
        boolean keepRunning = true;
        while (keepRunning) {
            System.out.println(getName() + "登台演出：" + (++count));
            if (count == 100) {
                break;
            }

            if (count % 10 == 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(getName() + "的演出结束了");
    }

    /**
     * @Desc Main方法
     * @Author Anjoulee
     * @CreateDte 2017/12/27
     * @Param
     * @Return
     * @Update or Other iNFO
     */
    public static void main(String[] args) {
        Thread actor = new Actor();
        actor.setName("Mr Thread");
        actor.start();


        Thread actressThread = new Thread(new Actree(), "Mr Runable");
        actressThread.start();
    }
}

/**
 * @Desc 继承Runable接口，此处使用内部类
 * @Author Anjoulee
 * @CreateDte 2017/12/27
 * @Param
 * @Return
 * @Update or Other iNFO
 */
class Actree implements Runnable {

    public void run() {
        System.out.println(Thread.currentThread().getName() + "是一个演员");
        int count = 0;
        boolean keepRunning = true;
        while (keepRunning) {
            System.out.println(Thread.currentThread().getName() + "登台演出：" + (++count));
            if (count == 100) {
                break;
            }

            if (count % 10 == 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(Thread.currentThread().getName() + "的演出结束了");
    }
}