package mutithread.concurrent;

/**
 * @DESC
 * @Author Anjoulee
 * @Date 2017/12/27
 */
public class EnergyTransferTask implements Runnable {
    //共享的能量世界
    private EnergySystem energySystem;

    //能量转移源，能量盒子下标
    private int formBox;

    //单次能量转移最大单元
    private double maxAmount;

    //最大休眠时间（毫秒），防止服务器过热
    private int DELAY = 10;

    public EnergyTransferTask(EnergySystem energySystem, int from, double max) {
        this.energySystem = energySystem;
        this.formBox = from;
        this.maxAmount = max;
    }

    public void run() {
        try {
            while (true) {
                int toBox = (int) (energySystem.getBoxAmount() * Math.random());
                double amount = maxAmount * Math.random();
                //调用能量转移方法
                energySystem.transfer(formBox, toBox, amount);
                Thread.sleep((int) (DELAY * Math.random()));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
