package mutithread.demo;

/**
 * @DESC 继承Thread类创建线程类
 * 总结 ：从结果可以看出Thread-0和Thread-1两条线程输出的i变量都不连续
 * （ 注意：i变量是FirestThread的实例属性，而不是局部变量，但因为程序每次创建线程都会创建一个FirstThread对象，
 * 所以Thread-0和Thread-1不能共享该实例属性）-----如果想要连续则可以使用volatile。
 * 使用继承Thread类的方法来创建线程类，多条线程之间无法共享线程类的实例变量。
 * @Author Anjoulee
 * @Date 2017/12/27
 */
public class FirstThread extends Thread {
    private int i;

    //重写run方法，run方法的方法体就是线程执行体
    public void run() {
        for (; i < 10; i++) {
            System.out.println(this.getName() + ":" + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + "             .." + i);
            if (i == 10) {
                System.out.println("--------------------------------------------");
                new FirstThread().start();
                new FirstThread().start();
                System.out.println("---------------------------------------------");
            }
        }
    }
}
