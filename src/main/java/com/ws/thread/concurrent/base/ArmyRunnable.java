package com.ws.thread.concurrent.base;

/**
 * @author wangsheng
 * @date 2019/8/1 0001 下午 4:24
 * 模拟作战双方的行为
 */
public class ArmyRunnable implements Runnable {

    //保证了线程可以正确的读取其他线程写入的值
    //可见性 ref JMM happens-before
    volatile boolean keepRunning = true;

    @Override
    public void run() {
        while(keepRunning){
            for(int i=0;i<5;i++){
                System.out.println(Thread.currentThread().getName()+"进攻对方【"+i+"】");

                //让出处理器时间
                Thread.yield();
            }
        }

        System.out.println(Thread.currentThread().getName()+"结束了战斗！");
    }
}
