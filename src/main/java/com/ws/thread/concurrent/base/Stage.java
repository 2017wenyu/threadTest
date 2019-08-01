package com.ws.thread.concurrent.base;

/**
 * @author wangsheng
 * @date 2019/8/1 0001 下午 4:30
 */
public class Stage extends Thread {

    public static void main(String[] args){

        new Stage().start();
    }

    public void run(){

        System.out.println("演出开始");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("大幕开始");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("大幕徐徐拉开");

        ArmyRunnable armyTaskOfSuiDynasty = new ArmyRunnable();
        ArmyRunnable armyTaskOfRevolt = new ArmyRunnable();

        //使用Runnable 接口创建线程
        Thread armyOfSuiDynasty = new Thread(armyTaskOfSuiDynasty,"隋军");
        Thread armyOfRevolt = new Thread(armyTaskOfRevolt,"农民起义军");

        //启动线程，让军队开始作战
        armyOfSuiDynasty.start();
        armyOfRevolt.start();

        //舞台线程休眠
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

       System.out.println("正当双方激战正酣，半路杀出了一个程咬金");
        Thread mrCheng = new KeyPersonThread();
        mrCheng.setName("程咬金");
        System.out.println("程咬金的理想就是结束战争");

        armyTaskOfSuiDynasty.keepRunning = false;
        armyTaskOfRevolt.keepRunning = false;

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        mrCheng.start();
        try {
            mrCheng.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("战争结束");
        System.out.println("演出结束");

    }
}
