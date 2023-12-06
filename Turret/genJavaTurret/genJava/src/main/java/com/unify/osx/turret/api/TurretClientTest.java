package com.unify.osx.turret.api;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class TurretClientTest {
	
	public static void main(String[] args) {
    try {
        TTransport transport = new TSocket("192.168.0.190", 10052);
        transport.open();

        TProtocol protocol = new TBinaryProtocol(transport);
        TurretRequestService.Client client = new TurretRequestService.Client(protocol);

        String message = "Enemy approaching!";
         client.makeCallFromSpecificLine((short) 0, message, null);
        

        transport.close();
    } catch (TException e) {
        e.printStackTrace();
    }
}
}