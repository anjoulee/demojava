package mutithread.concurrent;

/**
 * @DESC 宇宙的能量系统
 * 美丽遵循能量守恒定律
 * 能量不会凭空创生或消失，只会从一个出转移到另一处
 * @Author Anjoulee
 * @Date 2017/12/27
 */
public class EnergySystem {

    //能量盒子，能量存贮的地方
    private final double[] eneryBoxes;

    /**
     * @Desc 构造函数
     * @Author Anjoulee
     * @CreateDte 2017/12/27
     * @Param 能量盒子的数量
     * @Return 每个能量盒子初始含有的能量值
     * @Update or Other iNFO
     */
    public EnergySystem(int n, double initialEnergy) {
        eneryBoxes = new double[n];
        for (int i = 0; i < eneryBoxes.length; i++) {
            eneryBoxes[i] = initialEnergy;
        }
    }

    /**
     * @Desc 能量的转移，从给一个盒子到另一个盒子
     * @Author Anjoulee
     * @CreateDte 2017/12/27
     * @Param from 能量源
     * @Param to 能量终点
     * @Param amount 能量值
     * @Return
     * @Update or Other iNFO
     */
    public void transfer(int from, int to, double amount) {
        if (eneryBoxes[from] < amount) {
            return;
        }
        System.out.println(Thread.currentThread().getName());
        eneryBoxes[from] -= amount;
        System.out.printf("从%d转移%10.2f单位能量到%d--->", from, amount, to);
        eneryBoxes[to] += amount;
        System.out.printf("能量总和：%10.2f---%n", getTotalEnergies());
    }

    /**
     * @Desc 获取能量世界的能量总和
     * @Author Anjoulee
     * @CreateDte 2017/12/27
     * @Param
     * @Return
     * @Update or Other iNFO
     */
    private double getTotalEnergies() {
        double sum = 0;
        for (double amount : eneryBoxes) {
            sum += amount;
        }
        return sum;
    }
    public int getBoxAmount(){
        return eneryBoxes.length;
    }
}
