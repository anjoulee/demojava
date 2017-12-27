package mutithread.demo;

/**
 * @DESC 线程的说明和线程的生命周期
 * @Author Anjoulee
 * @Date 2017/12/27
 */
public class ThreadLiveCycle {
    /**
     *
     1.New新建 :当线程被创建时，该线程处于新建状态，此时它和其他java对象一样，仅仅由Java虚拟机为其分配了内存，
     并初始化了其成员变量的值。此时的线程没有表现出任何表现出任何线程的动态特征，程序也不会执行线程的线程执行体）。



     2.Runnable就绪:就绪也就是说启动线程，但是启动线程使用start方法，而不是run方法！永远不要调用线程对象的run()方法！
     调用start方法来启动线程，系统会将该run方法当成线程执行体来处理。如果直接调用线程对象的run方法。则run方法会立即执行，
     且在这个run方法的执行体未执行结束前其他线程无法并发执行（即系统会将run方法当做一个普通对象的普通方法，而不是线程执行体对待）
     附1：如果有一个主线程，一个子线程。当根据逻辑代码该调用子线程时不一定会立即调用，为了想在子线程start（）后立即调用子线程，
     可以考虑使用Thread.sleep（1），这样会让当前线程（主线程）睡眠1毫秒，因为cpu在这1毫秒中是不会休息的，
     这样就会去执行一条处于就绪状态的线程。
     附2：不能对已经处于就绪状态的线程，再次使用start（）



     3.Running 运行：当处于就绪状态时，该线程获得cpu，执行体开始运行，就处于运行状态了。



     4.Blocked 阻塞：线程不可能一直处于运行状态（线程执行体足够短，瞬间就可以完成的线程排除），线程会在运行过程中需要被中断，
     因为是并发，目的是会让其他线程获得执行的机会，线程的调度细节取决于OS采用的策略。（抢占式调度xp win7 linux unix..）。
     如果是一些特殊的小型设备可能采用 协作式调度（只有线程自己调用它的sleep（）或yield（）才会放弃所占用的资源）。


                                 阻塞
                              -----------
                             -------------
                            ---------------
     sleep时间到IO方法返回获 --             -- sleep IO阻塞等待同步锁
     同步锁收到通知resume   --               -- 等待通知suspend
     （恢复）             --                 --
             start()    ∨   获得处理资源     ∧  error或exception
     新建------------->就绪-------->-------->运行----------------->死亡
                         <--------------------
                           失去处理资源或yield()

     5.Dead死亡：根据上图所示。测试测试某条线程是否已经死亡，可以调用线程对象的isAlive（）方法，当线程处于就绪，运行，阻塞时，返回true。
     线程处于新建，死亡时返回false。不能对已经死亡的线程调用start（）方法使它重新启动，死亡就是死亡，是不能再次作为线程执行的。
     当主线程结束时候，其他线程不受任何影响，并不会随之结束。一旦子线程启动起来后，它就拥有和主线程相同的地位，它不会受到主线程的影响。

     */


    /**
     * 总结：sleep和yield区别
     A.sleep方法暂停当前线程后，会给其他线程执行机会，不会理会其他线程的优先级。而yield只会给优先级>=当前优先级的线程执行机会
     B.Sleep方法会将线程转入阻塞状态，知道经过阻塞时间才会转入就绪状态。而yield是不会将线程转入阻塞状态的，它只是强制当前线程进入就绪状态。
     C.Sleep会抛出InterruptedException异常。而yield没有声明任何异常
     D.Sleep方法比yield方法有更好的移植性。
     E.通常不依靠yield来控制并发线程控制
     */


    /**
     线程的创建：
     new Thread（）                                   线程期启动
     new Thread(String name)                          线程期启动
     new Thread(Runnable target)                      线程期启动
     new Thread（Runnable target，String name）       线程期启动



     线程的方法：
     void start()                                      线程期启动
     static void sleep(long millis)                    线程休眠
     static void sleep(long millis,int nanos)          线程休眠
     void join()                                       使其他线程等待当前线程终止
     void join(long millis)                            使其他线程等待当前线程终止
     void join(long millis,int nanos)                  使其他线程等待当前线程终止
     static void yield()                               当前运行线程释放处理器资源



     获取线程的引用：
     static Thread currentThread()                     返回当前运行的线程引用




     */
}
