package com.soonyoong.youtube.javabrains.soap;

/**
 * Hello world!
 *
 */
public class T1_soapClientTest 
{	
	//is to act as client of soap, to send request to a web service by soap, using stub generated from wsdl
    public static void main( String[] args )
    {
    	//<wsdl:service name="GeoIPService"> and <wsdl:port name="GeoIPServiceSoap"
    	//start from service, then get the port
        GeoIPService geoIPService = new GeoIPService();
        //geoIPServiceSoap is the stub
        GeoIPServiceSoap geoIPServiceSoap = geoIPService.getGeoIPServiceSoap();
        String ipLocation = geoIPServiceSoap.getIpLocation("143.92.81.70");
        System.out.println(ipLocation);
    }
}
