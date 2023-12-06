package com.unify.osx.turret.api;

import java.util.Scanner;

import com.sen.openscape.csta.provider.CstaProvider;
import com.sen.openscape.csta.util.CstaConfiguration;
import com.sen.openscape.csta.util.CstaException;

public class CstaMonitorMain {

    /**
     *
     * The IP address of the CSTA interface in OpenScape Voice
     *
     */
    private static final String CSTA_SERVER_IP_ADDRESS = "10.48.199.149";

    /**
     *
     * The port number - it's usually 1040, very rarely changed
     *
     */
    private static final int CSTA_SERVER_PORT = 1040;

    /**
     *
     * The phone number we will monitor Must match the configured in OSV and
     * must
     *
     * have CSTA service assigned
     *
     */
    private static final String DEVICE_TO_MONITOR = "912262749601";//"912262749615";

    public static void main(String[] args) {

    	
    	
        CstaProvider myProvider = connect();

        if (myProvider != null) {

            CstaDeviceMonitor monitor = new CstaDeviceMonitor();
            String[] Nomber = {"912262749601", "912262749600"};
            for(int i=0; i<=1;i++)
            {
            	monitor.startMonitor(myProvider, Nomber[i]);
            }

            if (monitor.startMonitor(myProvider, DEVICE_TO_MONITOR)) {

                // Let it run until the user hits the enter key
                Scanner keyIn = new Scanner(System.in);

                System.out.print("\n\nPress Enter to exit\n\n");

                keyIn.nextLine();

                monitor.stopMonitor(myProvider);

            }

            disconnect(myProvider);

        }

    }

    private static CstaProvider connect() {

        CstaConfiguration cfg = new CstaConfiguration(CSTA_SERVER_IP_ADDRESS, CSTA_SERVER_PORT);
//        cfg.setTransportType(CstaTransports.HTTP_SOAP);

        try {

            CstaProvider provider = new CstaProvider();
            provider.connectToSystem(cfg);
            System.out.println("\n---\nConnected to " + CSTA_SERVER_IP_ADDRESS + "\n---\n");
            provider.startHeartbeat(60, 60);
            return provider;

        } catch (CstaException e) {
            System.err.println("Failed to connect: " + e.toString());
            return null;
        }
    }

    private static void disconnect(CstaProvider provider) {

        try {

            provider.endHeartbeat();

            provider.disconnectFromSystem();

            System.out.println("\n---\nDisconnected from " + CSTA_SERVER_IP_ADDRESS + "\n---\n");

        } catch (CstaException e) {

            System.err.println("Failed to disconnect: " + e.toString());

        }

    }

}