package org.example.thuan;

import org.apache.catalina.startup.Tomcat;

public class Main {
    public static void main(String[] args) throws Exception {
        Tomcat tomcat = new Tomcat();

        tomcat.setPort(8080);

        tomcat.getConnector();

        tomcat.addWebapp(
                "",
                new java.io.File("target/webapp").getAbsolutePath()
        );

        tomcat.start();

        System.out.println("Server started");

        tomcat.getServer().await();
    }
}