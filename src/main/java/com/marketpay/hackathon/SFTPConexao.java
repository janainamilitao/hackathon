package com.marketpay.hackathon;

import java.util.List;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import com.marketpay.hackathon.config.ConfigSFTP;
import com.marketpay.hackathon.model.ArquivoFTP;
import com.marketpay.hackathon.search.ArquivoSearch;

public class SFTPConexao {


	private static final String USERNAME = "mptechday";
	private static final String HOST = "10.50.4.5";
	private static final int PORT = 22021;
	private static final String PASSWORD = "mptechday@2019*";
	private static final String PATH_FTP = "/mptechday/spc/janaina_jussara/in/";

	public List<ArquivoFTP> consultarArquivos(ArquivoSearch arquivoSearch) throws IllegalAccessException, JSchException, SftpException {

		ConfigSFTP sshConnector = new ConfigSFTP();
		sshConnector.connect(USERNAME, PASSWORD, HOST, PORT);
		List<ArquivoFTP> arquivos  = sshConnector.listFile(PATH_FTP, arquivoSearch);
		sshConnector.disconnect();
		
		return arquivos;
	}
	
	/*
	 * public static void main (String[] args) throws IllegalAccessException,
	 * JSchException, SftpException { SFTPConexao conexao = new SFTPConexao();
	 * conexao.consultarArquivos(); }
	 */

}
