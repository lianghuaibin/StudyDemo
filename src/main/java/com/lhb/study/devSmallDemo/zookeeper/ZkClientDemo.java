package com.lhb.study.devSmallDemo.zookeeper;

import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.SerializableSerializer;
import org.apache.zookeeper.*;

import java.io.IOException;

/**
 * zookeeper demo
 * @author lianghuaibin
 * @since 2017/7/20
 */
public class ZkClientDemo {

    // 会话超时时间，设置为与系统默认时间一致
    private static final int SESSION_TIMEOUT = 30 * 1000;

    // 创建 ZooKeeper 实例
    private ZooKeeper zk;

    private ZkClient zkClient;

    // 创建 Watcher 实例
    private Watcher wh = new Watcher() {
        /**
         * Watched事件
         */
        public void process(WatchedEvent event) {
            System.out.println("WatchedEvent >>> " + event.toString());
        }
    };

    // 初始化 ZooKeeper 实例
    private void createZKInstance() throws IOException {
        String ZKServers  = "10.13.91.47:2181,10.13.91.64:2181,10.13.91.66:2181";
        // 连接到ZK服务，多个可以用逗号分割写
        zk = new ZooKeeper(ZKServers , ZkClientDemo.SESSION_TIMEOUT, this.wh);
        zkClient = new ZkClient(ZKServers ,10000,10000,new SerializableSerializer());

    }

    private void ZKOperations() throws IOException, InterruptedException, KeeperException {
        System.out.println("\n1. 创建 ZooKeeper 节点 (znode ： zoo2, 数据： myData2 ，权限： OPEN_ACL_UNSAFE ，节点类型： Persistent");
        zk.create("/zoo2", "myData2".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

        System.out.println("\n2. 查看是否创建成功： ");
        System.out.println(new String(zk.getData("/zoo2", this.wh, null)));// 添加Watch

        // 前面一行我们添加了对/zoo2节点的监视，所以这里对/zoo2进行修改的时候，会触发Watch事件。
        System.out.println("\n3. 修改节点数据 ");
        zk.setData("/zoo2", "shanhy20160310".getBytes(), -1);

        // 这里再次进行修改，则不会触发Watch事件，这就是我们验证ZK的一个特性“一次性触发”，也就是说设置一次监视，只会对下次操作起一次作用。
        System.out.println("\n3-1. 再次修改节点数据 ");
        zk.setData("/zoo2", "shanhy20160310-ABCD".getBytes(), -1);

        System.out.println("\n4. 查看是否修改成功： ");
        System.out.println(new String(zk.getData("/zoo2", false, null)));

        System.out.println("\n5. 删除节点 ");
        zk.delete("/zoo2", -1);

        System.out.println("\n6. 查看节点是否被删除： ");
        System.out.println(" 节点状态： [" + zk.exists("/zoo2", false) + "]");
    }

    private void ZKClose() throws InterruptedException {
        zk.close();
    }

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        ZkClientDemo dm = new ZkClientDemo();
        dm.createZKInstance();
        dm.ZKOperations();
        dm.ZKClose();
    }

    /*public static void main(String[] args) throws Exception {
        String conn="10.13.91.47:2181,10.13.91.64:2181,10.13.91.66:2181";
        ZooKeeper zk = new ZooKeeper(conn, 5000, null);

        zk.create("/test", "test".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        Thread.sleep(30000);
    }*/
}
