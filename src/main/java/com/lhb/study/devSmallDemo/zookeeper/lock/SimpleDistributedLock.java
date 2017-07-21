package com.lhb.study.devSmallDemo.zookeeper.lock;

import org.I0Itec.zkclient.ZkClient;

import java.util.concurrent.TimeUnit;

/**
 * @author lianghuaibin
 * @since 2017/7/20
 */
public class SimpleDistributedLock extends BaseDistributedLock implements DistributedLock {

    private String lockPathName;

    public SimpleDistributedLock(ZkClient zkClient,String path, String lockName){
        super(zkClient,path,lockName);
    }

    @Override
    public void acquire() throws Exception {
        lockPathName = this.attemptLock(10000, null);
        System.out.println("acquire lockName："+lockPathName);
    }

    @Override
    public boolean acquire(long time, TimeUnit unit) throws Exception {
        this.attemptLock(time, unit);
        return false;
    }

    @Override
    public void release() throws Exception {
        this.releaseLock(lockPathName);
        System.out.println("SimpleDistributedLock release");
    }
}
