package com.unify.osx.turret.api;

import java.util.List;

import org.apache.thrift.TException;

public class TurretRequestServiceImpl implements TurretRequestService.Iface   {
	
	 TurretRequestServiceImpl()
	{
		 super();
		System.out.println("============== Constructor call ==================");
	}

	@Override
	public void requestNotifications(SubscriberInfo subscriberInfo) throws TurretApiException, TException {
		// TODO Auto-generated method stub
		System.out.println("============== requestNotifications ==================");
		
	}

	@Override
	public List<ProfileInfo> getProfileList() throws TException {
		// TODO Auto-generated method stub
		System.out.println("============== getProfileList ==================");
		return null;
	}

	@Override
	public String getLoggedInProfileName() throws TurretApiException, TException {
		// TODO Auto-generated method stub
		System.out.println("============== getLoggedInProfileName ==================");
		return null;
	}

	@Override
	public List<SpeechUnitConfiguration> getSpeechUnits() throws TurretApiException, TException {
		// TODO Auto-generated method stub
		System.out.println("============== getSpeechUnits ==================");
		return null;
	}

	@Override
	public List<String> getAvailableLines() throws TurretApiException, TException {
		// TODO Auto-generated method stub
		System.out.println("============== getAvailableLines ==================");
		return null;
	}

	@Override
	public LineStatesData snapshotLineRequest(String lineName) throws TurretApiException, TException {
		// TODO Auto-generated method stub
		System.out.println("============== snapshotLineRequest ==================");
		return null;
	}

	@Override
	public List<CallData> snapshotCalls() throws TException {
		// TODO Auto-generated method stub
		System.out.println("============== snapshotCalls ==================");
		return null;
	}

	@Override
	public void login(String profileName, String password) throws TurretApiException, TException {
		// TODO Auto-generated method stub
		System.out.println("============== login ==================");
		
	}

	@Override
	public void logout() throws TurretApiException, TException {
		// TODO Auto-generated method stub
		System.out.println("============== logout ==================");
		
	}

	@Override
	public void makeCall(short suId, String number) throws TurretApiException, TException {
		// TODO Auto-generated method stub
		System.out.println("============== makeCall ==================");
		
	}

	@Override
	public void makeCallFromSpecificLine(short suId, String lineName, String number)
			throws TurretApiException, TException {
		// TODO Auto-generated method stub
		System.out.println("============== makeCallFromSpecificLine ==================");
		
	}

	@Override
	public void createConsultation(short suId, String number) throws TurretApiException, TException {
		// TODO Auto-generated method stub
		System.out.println("============== createConsultation ==================");
		
	}

	@Override
	public void transfer(short suId) throws TurretApiException, TException {
		// TODO Auto-generated method stub
		System.out.println("============== transfer ==================");
		
	}

	@Override
	public void toggle(short suId) throws TurretApiException, TException {
		// TODO Auto-generated method stub
		System.out.println("============== toggle ==================");
		
	}

	@Override
	public void pbxConference(short suId) throws TurretApiException, TException {
		// TODO Auto-generated method stub
		System.out.println("============== pbxConference ==================");
		
	}

	@Override
	public void answerCall(short suId) throws TurretApiException, TException {
		// TODO Auto-generated method stub
		System.out.println("============== answerCall ==================");
		
	}

	@Override
	public void answerSpecificCall(short suId, String lineName) throws TurretApiException, TException {
		// TODO Auto-generated method stub
		System.out.println("============== answerSpecificCall ==================");
		
	}

	@Override
	public void disconnectCall(short suId) throws TurretApiException, TException {
		// TODO Auto-generated method stub
		
		System.out.println("============== disconnectCall ==================");
	}

	@Override
	public void hold(short suId) throws TurretApiException, TException {
		// TODO Auto-generated method stub
		System.out.println("============== hold ==================");
	}

	@Override
	public void commonHold(short suId) throws TurretApiException, TException {
		// TODO Auto-generated method stub
		System.out.println("============== commonHold ==================");
	}

	@Override
	public void privateHold(short suId) throws TurretApiException, TException {
		// TODO Auto-generated method stub
		System.out.println("============== privateHold ==================");
	}

	@Override
	public void retrieveSpecific(short suId, String lineName) throws TurretApiException, TException {
		// TODO Auto-generated method stub
		System.out.println("============== retrieveSpecific ==================");
		
	}

	@Override
	public void dtmf(short suId, byte digit) throws TurretApiException, TException {
		// TODO Auto-generated method stub
		System.out.println("============== dtmf ==================");
		
	}

	@Override
	public TurretState getLoginState() throws TException {
		// TODO Auto-generated method stub
		System.out.println("============== getLoginState ==================");
		return null;
	}

	@Override
	public String getVersion() throws TException {
		// TODO Auto-generated method stub
		System.out.println("============== getVersion ==================");
		return null;
	}

	@Override
	public List<RingTransferId> getAvailableRingTransfers() throws TurretApiException, TException {
		// TODO Auto-generated method stub
		System.out.println("============== getAvailableRingTransfers ==================");
		return null;
	}

	@Override
	public RingTransferState snapshotRingTransfer(RingTransferId id) throws TurretApiException, TException {
		// TODO Auto-generated method stub
		System.out.println("============== snapshotRingTransfer ==================");
		return null;
	}

	@Override
	public void setRingTransferActive(RingTransferId id, boolean active) throws TurretApiException, TException {
		// TODO Auto-generated method stub
		System.out.println("============== setRingTransferActive ==================");
		
	}

	@Override
	public List<RingTransferId> getAvailableRingtransferSequences() throws TurretApiException, TException {
		// TODO Auto-generated method stub
		System.out.println("============== getAvailableRingtransferSequences ==================");
		return null;
	}

	@Override
	public RingTransferSequenceState snapshotRingTransferSequence(RingTransferId id)
			throws TurretApiException, TException {
		// TODO Auto-generated method stub
		System.out.println("============== RingTransferSequenceState ==================");
		return null;
	}

	@Override
	public void setRingTransferSequenceActive(RingTransferId id, boolean active) throws TurretApiException, TException {
		// TODO Auto-generated method stub
		System.out.println("============== setRingTransferSequenceActive ==================");
		
	}

	@Override
	public List<String> getAvailableInterfaceActions() throws TurretApiException, TException {
		// TODO Auto-generated method stub
		System.out.println("============== getAvailableInterfaceActions ==================");
		return null;
	}

	@Override
	public InterfaceActionState snapshotInterfaceAction(String apiName) throws TurretApiException, TException {
		// TODO Auto-generated method stub
		System.out.println("============== InterfaceActionState ==================");
		return null;
	}

	@Override
	public void setInterfaceActionState(String apiName, InterfaceActionState state)
			throws TurretApiException, TException {
		// TODO Auto-generated method stub
		System.out.println("============== setInterfaceActionState ==================");
		
	}

}
