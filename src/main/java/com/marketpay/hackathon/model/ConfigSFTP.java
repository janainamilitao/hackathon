package com.marketpay.hackathon.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

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

			// Parametro para no validar key de conexão.
			this.session.setConfig("StrictHostKeyChecking", "no");

			this.session.connect();
			System.out.println("Comunicacao estabelecida");
		} else {
			throw new IllegalAccessException("Comunicaçao não estabelecida");
		}
	} 

	public final void listFile(String ftpPath) throws IllegalAccessException, JSchException, SftpException {
		try {
			if (this.session != null && this.session.isConnected()) {
				
				ChannelSftp channelSftp = (ChannelSftp) this.session.
						openChannel("sftp");
				
				List<String> list = new ArrayList<>();

				channelSftp.connect();
				channelSftp.cd(ftpPath);
			
				Vector<LsEntry> files = channelSftp.ls("*");
				
				for (LsEntry entry : files)
				{
				    if (!entry.getFilename().equals(".") && !entry.getFilename().equals(".."))
				    {
				        list.add(entry.getFilename());
				    }
				}

				System.out.println(list);
				
				channelSftp.exit();
				channelSftp.disconnect();
				
				
			} 
			else {
				throw new IllegalAccessException("Não existe sessão SFTP iniciada.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public final void addFile(String ftpPath, String filePath,
			String fileName) throws IllegalAccessException, IOException,
	SftpException, JSchException {
		if (this.session != null && this.session.isConnected()) {

			// Abrimos un canal SFTP. Es como abrir una consola.
			ChannelSftp channelSftp = (ChannelSftp) this.session.
					openChannel("sftp");

			// Nos ubicamos en el directorio del FTP.
			channelSftp.cd(ftpPath);
			channelSftp.connect();

			System.out.println(String.format("Creando archivo %s en el " +
					"directorio %s", fileName, ftpPath));
			channelSftp.put(filePath, fileName);

			System.out.println("Archivo subido exitosamente");

			channelSftp.exit();
			channelSftp.disconnect();
		} else {
			throw new IllegalAccessException("No existe sesion SFTP iniciada.");
		}
	}

	public final void disconnect() {
		this.session.disconnect();
	}

}
