package com.marketpay.hackathon;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import com.marketpay.hackathon.model.ConfigSFTP;

public class SFTPConexao {


	private static final String USERNAME = "mptechday";
	private static final String HOST = "10.50.4.5";
	private static final int PORT = 22021;
	private static final String PASSWORD = "mptechday@2019*";
	private static final String PATH_FTP = "/mptechday/spc/janaina_jussara/in/";

	public void consultarArquivos() throws IllegalAccessException, JSchException, SftpException {

		ConfigSFTP sshConnector = new ConfigSFTP();
		sshConnector.connect(USERNAME, PASSWORD, HOST, PORT);
		sshConnector.listFile(PATH_FTP);
		sshConnector.disconnect();
	}
	
	  public static void main (String[] args) throws IllegalAccessException, JSchException, SftpException {
		  SFTPConexao conexao = new SFTPConexao();
		  conexao.consultarArquivos();
	  }

}
