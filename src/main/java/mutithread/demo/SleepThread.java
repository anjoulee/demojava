package mutithread.demo;

import java.util.Date;

/**
 * @DESC 线程睡眠
 * 线程睡眠：sleep有两种重载形式：
 * static void sleep（long millis）
 * static void sleep（long millis，int nanos）
 * @Author Anjoulee
 * @Date 2017/12/27
 */
public class SleepThread {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            System.out.println("线程：" + Thread.currentThread().getName() + "当前时间:" + new Date());
            //让当前线程暂停2秒
            Thread.sleep(2000);
        }
    }
}
