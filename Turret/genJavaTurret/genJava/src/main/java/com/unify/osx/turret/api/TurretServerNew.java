package com.unify.osx.turret.api;

import java.net.InetSocketAddress;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.layered.TFramedTransport;

public class TurretServerNew {

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
			
			// StartsimpleServer(new Processor<TurretNotificationHandler>(new TurretNotificationHandler()));
			 try {
		            TServerTransport serverTransport = new TServerSocket(10052);
		            TurretNotificationService.Processor<TurretNotificationHandler> processor = new TurretNotificationService.Processor<>(new TurretNotificationHandler());
		             //TurretRequestService.Processor<TurretRequestServiceImpl> processor = new TurretRequestService.Processor<>(new TurretRequestServiceImpl());

		            //TServer server = new TSimpleServer(new Args(serverTransport).processor(processor));
                    TServer server = new TSimpleServer(new Args(serverTransport).protocolFactory(new TBinaryProtocol.Factory()).transportFactory(new TFramedTransport.Factory()).processor(processor));

		            System.out.println("Starting the server...");
		            server.serve();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
		 }

	
