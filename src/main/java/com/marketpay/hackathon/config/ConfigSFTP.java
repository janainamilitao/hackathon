package com.marketpay.hackathon.config;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Vector;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import com.marketpay.hackathon.model.ArquivoFTP;

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

	public final List<ArquivoFTP> listFile(String ftpPath) throws IllegalAccessException, JSchException, SftpException {
		List<ArquivoFTP> list = new ArrayList<ArquivoFTP>();

		try {			
			if (this.session != null && this.session.isConnected()) {

				ChannelSftp channelSftp = (ChannelSftp) this.session.openChannel("sftp");




				channelSftp.connect();
				channelSftp.cd(ftpPath);

				Vector<LsEntry> files = channelSftp.ls("*");

				for (LsEntry arq : files)
				{
					if (!arq.getFilename().equals(".") && !arq.getFilename().equals(".."))
					{

						ArquivoFTP arquivoFTP = new ArquivoFTP();
						arquivoFTP.setNome(arq.getFilename());	

						SimpleDateFormat format = new SimpleDateFormat(
								"EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
						Date dataCriacao = (Date) format.parse(arq.getAttrs().getMtimeString());
						System.out.println("Mod Date:"+dataCriacao);
						
						arquivoFTP.setDataCriacao(dataCriacao);
						list.add(arquivoFTP);
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
		return list;
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