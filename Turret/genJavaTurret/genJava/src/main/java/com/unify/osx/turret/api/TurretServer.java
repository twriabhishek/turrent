package com.unify.osx.turret.api;

import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

import com.unify.osx.turret.api.TurretNotificationService.Iface;
import com.unify.osx.turret.api.TurretNotificationService.Processor;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TSimpleServer;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;


public class TurretServer {

 public static void StartsimpleServer(TurretNotificationService.Processor<TurretNotificationHandler> processor) {
  try {
   InetSocketAddress isa2 = new InetSocketAddress("192.168.0.190", 10052);
   //TServerTransport serverTransport = new TServerSocket(9090);
   TServerTransport serverTransport = new TServerSocket(isa2);
   TServer server = new TSimpleServer(
     new Args(serverTransport).processor(processor));

   // Use this for a multithreaded server
   // TServer server = new TThreadPoolServer(new
   // TThreadPoolServer.Args(serverTransport).processor(processor));

   System.out.println("Starting the simple server...");
   server.serve();
  } catch (Exception e) {
   e.printStackTrace();
  }
 }
 
 public static void main(String[] args) {
	 StartsimpleServer(new Processor<TurretNotificationHandler>(new TurretNotificationHandler()));
 }

}
