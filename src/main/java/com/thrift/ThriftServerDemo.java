package com.thrift;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.apache.thrift.transport.TTransportFactory;

public class ThriftServerDemo {

    public void startServer() {
        try {
            System.out.println("Starting Thrift Server......");

            //处理层
            TProcessor processor = new HelloWorldService.Processor<HelloWorldService.Iface>(new HelloWorldServiceImpl());

            //服务socket
            TServerSocket serverTransport = new TServerSocket(8191);

            //传输层工厂
            TTransportFactory transportFactory = new TFramedTransport.Factory();

            //二进制协议
            TBinaryProtocol.Factory factory = new TBinaryProtocol.Factory();

            //线程池服务模型，使用标准的阻塞式IO，预先创建一组线程处理请求
            //TServer.Args tArgs = new TServer.Args(serverTransport);
            TThreadPoolServer.Args tArgs = new TThreadPoolServer.Args(serverTransport);
            tArgs.protocolFactory(factory);
            tArgs.transportFactory(transportFactory);
            tArgs.processor(processor);

            // 简单的单线程服务模型，一般用于测试
            //TServer server = new TSimpleServer(tArgs);
            //线程池服务模型
            TThreadPoolServer server = new TThreadPoolServer(tArgs);
            server.serve();

        } catch (TTransportException e) {
            System.out.println("Starting Thrift Server......Error!!!");
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        ThriftServerDemo server = new ThriftServerDemo();
        server.startServer();
    }

}

