package mutithread.concurrent;

/**
 * @DESC
 * @Author Anjoulee
 * @Date 2017/12/27
 */
public class EnergySystemTest {

    //将要构建的能量世界中能量盒子数量
    public static final int BOX_AMOUNT = 100;
    //每个盒子初始能量
    public static final double INITAL_ENERGY = 1000;

    public static void main(String[] args) {
        //能量不守恒
//        EnergySystem eng = new EnergySystem(BOX_AMOUNT, INITAL_ENERGY);
        //能量守恒
        EnergySystem_synchronized eng = new EnergySystem_synchronized(BOX_AMOUNT, INITAL_ENERGY);
        for (int i = 0; i < BOX_AMOUNT; i++) {
            EnergyTransferTask_synchronized task = new EnergyTransferTask_synchronized(eng, i, INITAL_ENERGY);
            Thread th = new Thread(task, "TransferThread_" + i);
            th.start();
        }
    }
}
