package mutithread.base;

/**
 * @DESC 搭建舞台，程序入口
 * @Author Anjoulee
 * @Date 2017/12/27
 */
public class Stage extends Thread {
    @Override
    public void run() {
        System.out.println("欢迎观看隋唐演义");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("大幕徐徐拉开");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("话说隋朝末年，随军与农民起义军啥的昏天暗地。。。");


        ArmyRunable armyTaskOfSuiDynasty = new ArmyRunable();
        ArmyRunable armyTaskOfRevolt = new ArmyRunable();

        //使用Runable接口创建线程
        Thread armyOfSuiDynasty = new Thread(armyTaskOfSuiDynasty, "随军");
        Thread armyOfRevolt = new Thread(armyTaskOfRevolt, "农民起义军");

        //启动线程，开始作战
        armyOfSuiDynasty.start();
        armyOfRevolt.start();

        //舞台线程休眠
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("正当双方激战，半路杀出程咬金");

        Thread mrCheng = new KeyPersonThread();
        mrCheng.setName("程咬金");
        System.out.println("程咬金的理想就是结束战争，使百姓安居乐业");
        //停止军队进攻
        //停止线程方法
        armyTaskOfSuiDynasty.keepRunning = false;
        armyTaskOfRevolt.keepRunning = false;

        //测试使用stop()结束线程(不要使用stop()方法结束线程，控制严谨性欠缺)
        //armyOfSuiDynasty.stop();
        //armyOfRevolt.stop();

        //停战2秒钟
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //所有线程等待程大帅完成使命
        mrCheng.start();
        try {
            mrCheng.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("战争结束，世界和平");
        System.out.println("谢谢观看，再见！！！！！");
    }

    public static void main(String[] args) {
        new Stage().start();
    }
}
