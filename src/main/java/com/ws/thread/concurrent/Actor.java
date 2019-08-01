package com.ws.thread.concurrent;

/**
 * @author wangsheng
 * @date 2019/8/1 0001 下午 4:04
 */
public class Actor extends Thread {

    /**
     *
     */
    public void run(){
        System.out.println(getName()+"是一个演员!");

        int count = 0;

        boolean keepRunning = true;
        while(keepRunning){
            System.out.println(getName()+"登台演出："+(++count));

            if(count ==100){
                keepRunning = false;
            }

            try {
                if(count%10 ==0){
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(getName()+"的演出结束了!");

    }

    public static void main(String[] args){
        Thread actor = new Actor();
        actor.setName("Mr.Thread");
        actor.start();

        Thread actressThread = new Thread(new Actress(),"Mrs.Runnable");
        actressThread.start();
    }
}
class Actress implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"是一个演员!");

        int count = 0;

        boolean keepRunning = true;
        while(keepRunning){
            System.out.println(Thread.currentThread().getName()+"登台演出："+(++count));

            if(count ==100){
                keepRunning = false;
            }

            try {
                if(count%10 ==0){
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+"的演出结束了!");
    }
}