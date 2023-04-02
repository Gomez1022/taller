package com.banco;


import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;

import com.banco.controladores.CuentaController;
import com.banco.controladores.TransaccionController;
import com.banco.controladores.UsuarioController;

public class App 
{
    public static void main( String[] args )
    {
        Server server = new Server(8080);
        server.setHandler(new DefaultHandler());

        ServletContextHandler context = new ServletContextHandler();

        context.setContextPath("/");
        context.addServlet(UsuarioController.class, "/persona/*");
        context.addServlet(CuentaController.class, "/cuenta/*");
        context.addServlet(TransaccionController.class, "/transacciones/*");
        server.setHandler(context);

        try{
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
