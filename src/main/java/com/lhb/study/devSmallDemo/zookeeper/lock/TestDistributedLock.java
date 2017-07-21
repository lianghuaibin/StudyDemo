package com.lhb.study.devSmallDemo.zookeeper.lock;

import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.BytesPushThroughSerializer;

/**
 * 分布式共享锁 Test
 * @author lianghuaibin
 * @since 2017/7/20
 */
public class TestDistributedLock {

    public static void main(String[] args) {
        String ZKServers  = "10.13.91.47:2181,10.13.91.64:2181,10.13.91.66:2181";
        final ZkClient zkClientExt1 = new ZkClient(ZKServers, 5000, 5000, new BytesPushThroughSerializer());
        final SimpleDistributedLock mutex1 = new SimpleDistributedLock(zkClientExt1, "/lock", "lockName");

        final ZkClient zkClientExt2 = new ZkClient(ZKServers, 5000, 5000, new BytesPushThroughSerializer());
        final SimpleDistributedLock mutex2 = new SimpleDistributedLock(zkClientExt2, "/lock", "lockName");

        try {
            mutex1.acquire();
            System.out.println("Client1 locked");
            Thread client2Thd = new Thread(new Runnable() {

                public void run() {
                    try {
                        mutex2.acquire();
                        System.out.println("Client2 locked");
                        mutex2.release();
                        System.out.println("Client2 released lock");

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            client2Thd.start();
            Thread.sleep(5000);
            mutex1.release();
            System.out.println("Client1 released lock");

            client2Thd.join();

        } catch (Exception e) {

            e.printStackTrace();
        }

    }

}
