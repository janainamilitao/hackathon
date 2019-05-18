package com.marketpay.hackathon;

import com.jcraft.jsch.JSchException;
import com.marketpay.hackathon.model.ConfigSFTP;

public class SFTPConexao {


	private static final String USERNAME = "mptechday";
	private static final String HOST = "10.50.4.5";
	private static final int PORT = 22021;
	private static final String PASSWORD = "mptechday@2019*";

	public void consultarArquivos() throws IllegalAccessException, JSchException {

		ConfigSFTP sshConnector = new ConfigSFTP();
		sshConnector.connect(USERNAME, PASSWORD, HOST, PORT);
		sshConnector.disconnect();
	}

}
