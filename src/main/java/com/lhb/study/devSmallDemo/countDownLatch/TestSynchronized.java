package com.lhb.study.devSmallDemo.countDownLatch;

public class TestSynchronized implements Runnable
{
    public void test1()
    {
        synchronized(this)
        {
            int i = 5;
            while( i-- > 0)
            {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try
                {
                    Thread.sleep(500);
                }
                catch (InterruptedException ie)
                {
                }
            }
        }
    }
    public synchronized void test2()
    {
        int i = 5;
        while( i-- > 0)
        {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try
            {
                Thread.sleep(500);
            }
            catch (InterruptedException ie)
            {
            }
        }
    }

    public void run() {

//        System.out.println(Thread.currentThread().getName());
        synchronized (this) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        }

    }
    public static void main(String[] args)
    {
        /*final TestSynchronized myt2 = new TestSynchronized();
        Thread test1 = new Thread(  new Runnable() {  public void run() {  myt2.test1();  }  }, "test1"  );
        Thread test2 = new Thread(  new Runnable() {  public void run() { myt2.test2();   }  }, "test2"  );
        test1.start();;
        test2.start();*/
        TestSynchronized mt = new TestSynchronized();
        Thread t1 = new Thread(mt, "t1");
        Thread t2 = new Thread(mt, "t2");
        Thread t3 = new Thread(mt, "t3");
        Thread t4 = new Thread(mt, "t4");
        Thread t5 = new Thread(mt, "t5");
        Thread t6 = new Thread(mt, "t6");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }
}
