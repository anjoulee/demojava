package mutithread.base;

/**
 * @DESC 错误方式终端线程测试
 * @Author Anjoulee
 * @Date 2017/12/27
 */
public class WrongWayStopThread extends Thread {

    public static void main(String[] args) {
        WrongWayStopThread thread = new WrongWayStopThread();
        System.out.println("Staring thread......");
        thread.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Interrupting thread......");
        thread.interrupt();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Stopping application .......");
    }
    //误的方式
//    @Override
//    public void run() {
//        while (true) {
//            System.out.println("Thread is running .......");
//            long time = System.currentTimeMillis();
//            while (System.currentTimeMillis() - time < 1000) {
//                //减少屏幕输出的空循环
//            }
//        }
//    }


    //正确的的方式，采用旗标的方式来中断线程
    @Override
    public void run() {
        while (!this.isInterrupted()) {
            System.out.println("Thread is running .......");
            long time = System.currentTimeMillis();
            while (System.currentTimeMillis() - time < 1000) {
                //减少屏幕输出的空循环，，如果采用Thread.sleep()的方法来代替While循环，也是不能中断线程的
            }
            //代替上面的While空循环
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}
