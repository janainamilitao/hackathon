package com.marketpay.hackathon.model;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConfigSFTP {
	
	 private Session session;
	 
	 public void connect(String username, String password, String host, int port)
		        throws JSchException, IllegalAccessException {
		        if (this.session == null || !this.session.isConnected()) {
		            JSch jsch = new JSch();
		 
		            this.session = jsch.getSession(username, host, port);
		            this.session.setPassword(password);
		 
		            // Parametro para no validar key de conexion.
		            this.session.setConfig("StrictHostKeyChecking", "no");
		 
		            this.session.connect();
		            System.out.println("Comunicacao estabelecida");
		        } else {
		            throw new IllegalAccessException("Comunicaçao não estabelecida");
		        }
		    }
	 
	 public final void disconnect() {
	        this.session.disconnect();
	    }
		 
}
