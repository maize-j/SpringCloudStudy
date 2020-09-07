package cn.yz.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName LoadBalancer
 * @date 2020/9/6 16:48
 */
public interface LoadBalancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
