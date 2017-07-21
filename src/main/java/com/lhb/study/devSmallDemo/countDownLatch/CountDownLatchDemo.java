package com.lhb.study.devSmallDemo.countDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatch 一个同步辅助类的使用
 * @author lianghuaibin
 * @since 2017/7/20
 */
public class CountDownLatchDemo {
    //两个工人的协作
    /*final static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch=new CountDownLatch(1);//两个工人的协作
        Worker worker1=new Worker("zhang san", 5000, latch);
        Worker worker2=new Worker("li si", 8000, latch);
        worker1.start();//
        worker2.start();//
        latch.await();//等待所有工人完成工作
        System.out.println("all work done at "+sdf.format(new Date()));
    }
    static class Worker extends Thread{
        String workerName;
        int workTime;
        CountDownLatch latch;
        public Worker(String workerName ,int workTime ,CountDownLatch latch){
            this.workerName=workerName;
            this.workTime=workTime;
            this.latch=latch;
        }
        public void run(){
            System.out.println("Worker "+workerName+" do work begin at "+sdf.format(new Date()));
            doWork();//工作了
            System.out.println("Worker "+workerName+" do work complete at "+sdf.format(new Date()));
            latch.countDown();//工人完成工作，计数器减一

        }
        private void doWork(){
            try {
                Thread.sleep(workTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }*/

    // 模拟了100米赛跑，10名选手已经准备就绪，只等裁判一声令下。当所有人都到达终点时，比赛结束。
    public static void main(String[] args) throws InterruptedException {
        // 开始的倒数锁
        final CountDownLatch begin = new CountDownLatch(1);
        // 结束的倒数锁
        final CountDownLatch end = new CountDownLatch(10);
        // 十名选手
        final ExecutorService exec = Executors.newFixedThreadPool(10);
        for (int index = 0; index < 10; index++) {
            final int NO = index + 1;
            Runnable run = new Runnable() {
                public void run() {
                    try {
                        // 如果当前计数为零，则此方法立即返回。
                        // 等待
                        begin.await();
                        long time = (long) (Math.random() * 10000);
                        Thread.sleep(time);
                        System.out.println("No." + NO + " arrived; time: "+time);
                    } catch (InterruptedException e) {
                    } finally {
                        // 每个选手到达终点时，end就减一
                        end.countDown();
                    }
                }
            };
            exec.submit(run);
        }
        System.out.println("Game Start");
        // begin减一，开始游戏
        begin.countDown();
        // 等待end变为0，即所有选手到达终点
        end.await();
        System.out.println("Game Over");
        exec.shutdown();
    }

}
