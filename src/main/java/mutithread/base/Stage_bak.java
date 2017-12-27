package mutithread.base;

/**
 * @DESC 搭建舞台，程序入口
 * @Author Anjoulee
 * @Date 2017/12/27
 */
public class Stage_bak extends Thread {
    @Override
    public void run() {
        System.out.println("欢迎观看隋唐演义");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("大幕徐徐拉开");
        try {
            Thread.sleep(5000);
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
        armyTaskOfSuiDynasty.keepRunning = false;
        armyTaskOfRevolt.keepRunning = false;

        //使其他线程等待当前进程结束
        try {
            armyOfRevolt.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Stage_bak().start();
    }
}
