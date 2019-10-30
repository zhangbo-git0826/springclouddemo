package com.example.userweb01.service;

import com.example.userweb01.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
@Service
public class UserServiceImpl implements UserService {
    //远程服务调用客户端
    @Autowired
    RestTemplate restTemplate;

    String url = "http://USERPROVIDER01";

    //Eureka客户端
    /*@Autowired
    DiscoveryClient discoveryClient;
    @Autowired
    LoadBalancerClient loadBalancerClient;
    *//***
     * 通过客户端负载均衡器获取生产者服务器基础地址
     * @return
     *//*
    public String url {
        //通过客户端调用服务均衡器查找服务
        ServiceInstance inst = loadBalancerClient.choose("USERPROVIDER01");
        //获取服务提供者服务器ip、端口号
        String ip = inst.getHost();
        int port = inst.getPort();
        //拼接调用地址
        String url="http://"+ip+":"+port+"/user";
        return url;
    }*/
    @Override
    public Map getUserMap() {
        Map map = restTemplate.getForObject(url+"/user/getall", Map.class);
        return map;
    }

    @Override
    public void createUser(User user) {

        restTemplate.postForObject(url+"/user/save", user,String.class);

    }

    @Override
    public User getUser(Long id) {

        return restTemplate.getForObject(url+"/user/get/"+id, User.class);
    }

    @Override
    public void updateUser(Long id, User user) {
        restTemplate.put(url+"/user/update/"+id, user);

    }

    @Override
    public void deleteUser(Long id) {
        restTemplate.delete(url+"/user/delete/"+id);
    }
}
