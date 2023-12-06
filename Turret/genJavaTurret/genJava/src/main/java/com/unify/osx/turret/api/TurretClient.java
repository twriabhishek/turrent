package com.unify.osx.turret.api;

import java.util.Scanner;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.apache.thrift.transport.layered.TFramedTransport;

public class TurretClient {

 public static void main(String[] args) {

  try {
   TTransport transport;

   transport = new TSocket("192.168.10.19", 9007);
   //TProtocol protocol = new TFramedTransport(transport);

   TProtocol protocol = new TBinaryProtocol(transport);
   com.unify.osx.turret.api.TurretRequestService.Client client = new com.unify.osx.turret.api.TurretRequestService.Client(protocol);
   
   //com.unify.osx.turret.api.TurretRequestService.Client client = new com.unify.osx.turret.api.TurretRequestService.Client(tFramedTransport);
   transport.open();
   
   SubscriberInfo info = new SubscriberInfo("192.168.0.190",10052);
    
   
    client.requestNotifications(info);   
    
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

}