package com.unify.osx.turret.api;



import com.sen.openscape.csta.callcontrol.CstaConnection;
import com.sen.openscape.csta.callcontrol.CstaDevice;
import com.sen.openscape.csta.callcontrol.CstaDeviceID;
import com.sen.openscape.csta.callcontrol.CstaMonitor;
import com.sen.openscape.csta.provider.CstaProvider;
import com.sen.openscape.csta.system.CstaSystem;
import com.sen.openscape.csta.util.CstaConfiguration;


public class CLIAuthentication {
	
	public static void main(String[] args) {
        try {
        	CstaConfiguration cstaConfiguration = new CstaConfiguration("10.48.199.149",1040);
        	
        	cstaConfiguration.setOSV_IP("10.48.199.149");
        	cstaConfiguration.setPort(1040);
        	cstaConfiguration.setKeepAlive(true);
        	
        	CstaSystem cstaSystem = new CstaSystem(cstaConfiguration);
       
       
            // Initialize your CSTA session
        	//CstaConnection cstaConnection = new CstaConnection(cstaSystem);
        	if(cstaSystem !=null)
        	System.out.println("-------------------- Connected ----------------"+cstaSystem.toString());
        	else
        		System.out.println("-------------------- Not Connected ----------------");
        	
			/*
			 * CstaMonitor cstaMonitor = new CstaMonitor(); cstaSession =
			 * cstaMonitor.getConnectionByCallID("912262749615"); String str =
			 * cstaSession.callID;
			 * 
			 * System.out.println(str);
			 */
        	
        	
        	CstaDevice cstaDevice = new CstaDevice("912262749615",  cstaSystem);
        	
        	CstaProvider cstaProvider= new CstaProvider();
        	CstaMonitor cstaMonitor = cstaProvider.MonitorStart(cstaDevice);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

