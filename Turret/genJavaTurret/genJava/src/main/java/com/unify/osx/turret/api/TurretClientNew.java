package com.unify.osx.turret.api;

import java.util.Scanner;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.apache.thrift.transport.layered.TFramedTransport;

import com.unify.osx.turret.api.TurretRequestService.Client;

public class TurretClientNew {
	
private final static String notificationIP = "192.168.0.190";

private final static Integer notificationPort = 10052; 


private void getConnection()
  {
	  String [] ipAddresses = {"192.168.10.19"};
	  Integer[] portNos = {9007};
	  
	  try {
		   int i =0;
		   TTransport transport = null;
		   for(String ipAddress: ipAddresses) {
			   System.out.println("**************************");
		  
		   transport = new TSocket(ipAddress, portNos[i]);//192.168.10.19  192.168.0.158
		   
		   Client client = new TurretRequestService.Client(new TBinaryProtocol(new TFramedTransport(transport)));
		    
		   transport.open();
		   
		   SubscriberInfo info = new SubscriberInfo(notificationIP,notificationPort);
		    
		    client.requestNotifications(info);  
		     i++;
		   } 
		    
		    Scanner keyIn = new Scanner(System.in);

		   	System.out.print("\n---------------\nPress Enter to exit\n-------------\n");

		   	keyIn.nextLine();
		   
		   	transport.close();
		   
		  } catch (TTransportException e) {
		   e.printStackTrace();
		  } catch (TException x) {
		   x.printStackTrace();
		  } catch (Exception e) {
			   e.printStackTrace();
			  }
  }
	
	public static void main(String[] args) {
    
		TurretClientNew turretClientNew = new TurretClientNew();
		turretClientNew.getConnection();
		
		/*
		 * try { TTransport transport;
		 * 
		 * transport = new TSocket("192.168.10.19", 9007);//192.168.10.19 //TTransport
		 * transport1 = new TSocket("192.168.0.158", 9007); //TFramedTransport protocol
		 * = new TFramedTransport(transport);
		 * 
		 * //TProtocol protocol = new TBinaryProtocol(transport);
		 * //com.unify.osx.turret.api.TurretRequestService.Client client = new
		 * com.unify.osx.turret.api.TurretRequestService.Client(protocol); Client client
		 * = new TurretRequestService.Client(new TBinaryProtocol(new
		 * TFramedTransport(transport)));
		 * //com.unify.osx.turret.api.TurretNotificationService.Client client = new
		 * TurretNotificationService.Client(new TBinaryProtocol(new
		 * TFramedTransport(transport)));
		 * //com.unify.osx.turret.api.TurretRequestService.Client client = new
		 * com.unify.osx.turret.api.TurretRequestService.Client(tFramedTransport);
		 * //Client client1 = new TurretRequestService.Client(new TBinaryProtocol(new
		 * TFramedTransport(transport1)));
		 * 
		 * transport.open(); //transport1.open();
		 * 
		 * SubscriberInfo info = new SubscriberInfo("192.168.0.190",10052);
		 * 
		 * 
		 * client.requestNotifications(info); //client1.requestNotifications(info);
		 * 
		 * 
		 * Scanner keyIn = new Scanner(System.in);
		 * 
		 * System.out.print("\n---------------\nPress Enter to exit\n-------------\n");
		 * 
		 * keyIn.nextLine();
		 * 
		 * transport.close();
		 * 
		 * } catch (TTransportException e) { e.printStackTrace(); } catch (TException x)
		 * { x.printStackTrace(); } catch (Exception e) { e.printStackTrace(); }
		 */
		 }



}
