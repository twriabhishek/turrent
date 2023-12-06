package com.unify.osx.turret.api;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.thrift.TException;

public class TurretNotificationHandler implements TurretNotificationService.Iface {
	TurretNotificationHandler()
	{
		super();
		System.out.println("============== TurretNotificationHandler ==================");
	}
	
	
	Set<BasicLineState> lineStateName = null;
	Map<String , String> callDataMap = null;

	static final String CONNECTED = "Connected";
	static final String CONVERSATION = "Conversation";
	
	
	@Override
	public void onLineStatesChanged(String turretName, LineStatesData states) throws TException {
		// TODO Auto-generated method stub
		System.out.println("============== onLineStatesChanged ==================");
		System.out.println("turretName:"+turretName);
		System.out.println("states:"+states);
		lineStateName = states.getBasicLineStates();
		
		if( lineStateName !=null)
		{
			Object[] obj = lineStateName.toArray();
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  "+ obj[0]);
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  " +obj[1]);
			
		if (obj[0].toString().equals(CONNECTED) && obj[1].toString().equals(CONVERSATION))
		{
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@1111111111111111111111111111111111@@@@@@@@@@@@@@@@@@");
			if(callDataMap != null)
			{
				System.out.println("@@@@@@@@@@@@@22222222222222222222@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			    callCRM(callDataMap);
			}
		}
		}
		
	}

	@Override
	public void onCallDataChanged(String turretName, String lineName, String partyNumber, String partyName,
			String contactName) throws TException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCallDataChangedEx(String turretName, CallData callData) throws TException {
		// TODO Auto-generated method stub
		System.out.println("============== onCallDataChangedEx ==================");
		System.out.println("turretName:"+turretName);
		System.out.println("callData:"+callData);
		
		if(callData != null && callData.isActive()) {
		callDataMap = new HashMap<String, String>();
		callDataMap.put("lineName", callData.getLineName());
		callDataMap.put("partyNumber", callData.getPartyName());
		callDataMap.put("partyName", callData.getPartyNumber());
		callDataMap.put("contactName" , callData.getContactName());
		callDataMap.put("callId",callData.getCallId());
		}
		
		
	
		
	}

	@Override
	public void onLoginStateChanged(String turretName, TurretState state) throws TException {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void onLoginResponse(String turretName, int errorCode, String errorDescription) throws TException {
		// TODO Auto-generated method stub
		
		
		
	}

	@Override
	public void onTopOfCallQueueChanged(String turretName, String lineName) throws TException {
		// TODO Auto-generated method stub
		
		
		
	}

	@Override
	public void onRingTransferStateChanged(String turretName, RingTransferId id, RingTransferState state)
			throws TException {
		// TODO Auto-generated method stub
	
		
	}

	@Override
	public void onRingTransferStateChangeError(String turretName, RingTransferId id, int errorCode,
			String errorDescription) throws TException {
		// TODO Auto-generated method stub
	
		
	}

	@Override
	public void onRingTransferSequenceStateChanged(String turretName, RingTransferId id,
			RingTransferSequenceState state) throws TException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onRingTransferSequenceStateChangeError(String turretName, RingTransferId id, int errorCode,
			String errorDescription) throws TException {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void onInterfaceActionStateChanged(String turretName, String apiName, InterfaceActionState state)
			throws TException {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void onInterfaceActionKeyChanged(String turretName, String apiName, InterfaceActionKeyState keyState)
			throws TException {
		// TODO Auto-generated method stub
		
		
	}

	
	public void callCRM(Map<String, String> callDataMap) {
		
		System.out.print("************************************");
	
		System.out.print(callDataMap);
		
		System.out.print("************************************");
	}
}
