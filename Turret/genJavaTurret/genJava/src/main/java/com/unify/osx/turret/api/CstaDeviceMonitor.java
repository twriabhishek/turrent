package com.unify.osx.turret.api;

import com.sen.openscape.csta.callcontrol.CstaDevice;
import com.sen.openscape.csta.callcontrol.CstaMonitor;
import com.sen.openscape.csta.provider.CstaEventListener;
import com.sen.openscape.csta.provider.CstaEventObject;
import com.sen.openscape.csta.provider.CstaEventType;
import com.sen.openscape.csta.provider.CstaProvider;
import com.sen.openscape.csta.util.CstaException;
import com.sen.openscape.csta.xml.CstaQueuedEvent;


public class CstaDeviceMonitor implements CstaEventListener {

	private CstaMonitor monitor;

	public boolean startMonitor(CstaProvider provider, String device) {

		CstaDevice myDevice = provider.addDevice(device);

		try {

			monitor = provider.MonitorStart(myDevice);

			provider.registerEventListener(this);

			System.out.println("\n---\nStarted monitoring " + monitor.fqnDn + "\n---\n");

			return true;

		} catch (CstaException e) {

			System.err.println("Failed to start monitor: " + e.toString());

			return false;

		}

	}

	public void stopMonitor(CstaProvider provider) {

		try {

			provider.MonitorStop(monitor.crossRefId);

			System.out.println("\n---\nStopped monitoring " + monitor.fqnDn + "\n---\n");

			provider.removeDevice(monitor.fqnDn);

		} catch (CstaException e) {

			System.err.println("Failed to stop monitor: " + e.toString());

		}

	}

	@Override

	public void newCstaEvent(CstaEventObject evt) {

		if(evt.evtType == CstaEventType.QUEUED){
    	//CstaDeliveredEvent deliveredXml = (CstaDeliveredEvent) evt.currentObject;
    	
    	CstaQueuedEvent deliveredXml = (CstaQueuedEvent) evt.currentObject;
    	System.out.print("display Calling Device    #####"+deliveredXml.getCallingDevice().getDeviceIdentifier());
			
			
			
    		}
		
			/*
			 * try { boolean value = connection.DeflectCall("9615");
			 * connection.ClearConnection();
			 * 
			 * if(true) { System.out.print("Successfuly DeflectCall"); } else {
			 * System.out.print("DeflectCall failed"); }
			 * 
			 * } catch (CstaException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */
		 
		


		System.out.print(
				"\n--- Device " + evt.fqnDn + " received event: type=" + evt.evtType + ", callID=" + evt.callID + "\n");

	}

}
