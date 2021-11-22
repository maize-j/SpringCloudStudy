package cn.yz.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * TODO
 * 自定义负载均衡算法
 * 实现的是轮询的规则
 * @author 苞谷洁子
 * @ClassName MyLB
 * @date 2020/9/6 16:51
 */
@Component
public class MyLB implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(){
        int current;
        int next;
        do{
            current = this.atomicInteger.get();
            //2147483647为int的最大值
            next = current >= 2147483647 ? 0 : current+1;
            //这个循环是一个自旋锁，当没有得到正确的值时，继续进入循环中，直到两次取值都是正确的
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("********next:"+next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {

        int index = getAndIncrement() % serviceInstances.size();
        //个人觉得这个应该再判断一下这个服务是否存在和是否可用
        return serviceInstances.get(index);
    }
}
