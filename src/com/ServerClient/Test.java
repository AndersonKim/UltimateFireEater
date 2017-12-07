package com.ServerClient;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

public class Test {
    public static void main(String[] args){

        try {
            //InetAddress使用
            InetAddress address=InetAddress.getLocalHost();
            System.out.println("HostAddress : "+address.getHostAddress());
            System.out.println("HostName : "+address.getHostName());
            //URL的使用
            URL url=new URL("https://www.imooc.com");
            URL u=new URL(url,"/video/2858");
            System.out.println("Protocol : "+url.getProtocol());
            System.out.println("Host : "+url.getHost());
            System.out.println("File : "+url.getFile());
            System.out.println("Path : "+url.getPath());
            System.out.println("Protocol : "+url.getProtocol());
            System.out.println("Query : "+url.getQuery());
            System.out.println("Ref : "+url.getRef());
            System.out.println("Port : "+url.getPort());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
