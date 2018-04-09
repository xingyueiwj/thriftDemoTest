package com.thrift;

import org.apache.thrift.TException;

public class HelloWorldServiceImpl implements HelloWorldService.Iface {

    public HelloWorldServiceImpl() {
    }

    @Override
    public String sayHello(String username) throws TException {
        return "Hi," + username + " welcome to thrift demo world";
    }

}
