package com.rhy.memberservice.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.Random;

/**
 * @author: Herion Lemon
 * @date: 2021/1/27 20:51
 * @slogan: 如果你想攀登高峰，切莫把彩虹当梯子
 * @description: 自定义负载均衡算法
 */
public class MyCustomRule extends AbstractLoadBalancerRule {

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public Server choose(Object o) {
        return choose(getLoadBalancer(), o);
    }
    /**
     * 负载均衡算法，随机调用
     * @param lb
     * @param o
     * @return
     */
    public Server choose(ILoadBalancer lb, Object o) {
        // 获取服务器列表
        List<Server> servers = lb.getAllServers();
        // 生产随机数
        Random r = new Random();
        int rand = r.nextInt(servers.size());
        return servers.get(rand);
    }

}
