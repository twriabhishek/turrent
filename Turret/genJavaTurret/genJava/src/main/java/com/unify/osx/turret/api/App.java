package com.unify.osx.turret.api;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        CallData callData = new CallData();
        callData.setCallId("Rustam");
        String callId = callData.getCallId();
        BasicLineState byValue = BasicLineState.findByValue(4);
        System.out.println(byValue);
        System.out.println(callId);
    }
}
