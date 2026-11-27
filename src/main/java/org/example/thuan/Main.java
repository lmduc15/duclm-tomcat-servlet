package org.example.thuan;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;

public class Main {
    public static void main(String[] args) throws Exception {
        Tomcat tomcat = new Tomcat();

        tomcat.setPort(8080);

        tomcat.getConnector();

        Context ctx = tomcat.addContext("", System.getProperty("java.io.tmpdir"));

        Tomcat.addServlet(ctx, "helloServLet", new HelloServlet());

        ctx.addServletMappingDecoded("/hello", "helloServLet");

        tomcat.start();

        System.out.println("Server started");

        tomcat.getServer().await();
    }
}