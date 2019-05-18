package com.marketpay.hackathon.config;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Vector;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.marketpay.hackathon.exception.FTPException;
import com.marketpay.hackathon.model.ArquivoFTP;
import com.marketpay.hackathon.search.ArquivoSearch;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConfigSFTP {

	private static final long  MEGABYTE = 1024L * 1024L;
	
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
		} else {
			throw new IllegalAccessException("Comunicaçao não estabelecida");
		}
	} 

	public final List<ArquivoFTP> listFile(String ftpPath, ArquivoSearch arquivoSearch) throws Exception {
		List<ArquivoFTP> list = new ArrayList<ArquivoFTP>();

		try {			
			if (this.session != null && this.session.isConnected()) {

				ChannelSftp channelSftp = (ChannelSftp) this.session.openChannel("sftp");

				boolean porData = false;
				boolean porNome = false;

				if(arquivoSearch.getNome()!=null && !arquivoSearch.getNome().equals("")) {
					porNome = true;
				}

				if(arquivoSearch.getDataCriacao()!=null) {
					porData = true;
				}

				if(porNome || porData) {

					channelSftp.connect();
					channelSftp.cd(ftpPath);

					Vector<LsEntry> files = channelSftp.ls("*");
					
					for (LsEntry arq : files){
						ArquivoFTP arquivoFTP = new ArquivoFTP();
						
						String dataCriacao = arq.getAttrs().getMtimeString();
						
						dataCriacao = new SimpleDateFormat("dd/MM/yyyy")
					              .format(new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy", Locale.US).parse(dataCriacao));
						
						if(porData && porNome) {							
							if (!arq.getFilename().equals(".") && !arq.getFilename().equals("..") && arq.getFilename().contains(arquivoSearch.getNome()) && dataCriacao.equals(arquivoSearch.getDataCriacao())){
								preencherListaArquivos(list, arq, arquivoFTP);
							}
						}else {
							if(porNome) {
								if (!arq.getFilename().equals(".") && !arq.getFilename().equals("..") && arq.getFilename().contains(arquivoSearch.getNome())){
									preencherListaArquivos(list, arq, arquivoFTP);
								}
							}else {
								if (porData && !arq.getFilename().equals(".") && !arq.getFilename().equals("..") && dataCriacao.equals(arquivoSearch.getDataCriacao())){
									preencherListaArquivos(list, arq, arquivoFTP);
								}
							}
						}						
					}
					
					channelSftp.exit();
					channelSftp.disconnect();	
				}else {
					new FTPException("Pelo menos um campo de pesquisa deve ser preenchido.");
				}
			} 
			else {
				throw new IllegalAccessException("Não existe sessão SFTP iniciada.");
			}
			
			if(list==null || list.isEmpty()) {
				throw new Exception("Não foram encontrados arquivos com os critérios de busca");
			}

		} catch (Exception e) {
			throw e;
		}
		
		
		
		return list;
	}

	private void preencherListaArquivos(List<ArquivoFTP> list, LsEntry arq, ArquivoFTP arquivoFTP)
			throws ParseException {
		arquivoFTP.setTamanho(bytesToMeg(arq.getAttrs().getSize()) + " Mb");
		arquivoFTP.setNome(arq.getFilename());	

		String dataCriacao = arq.getAttrs().getMtimeString();
		dataCriacao = new SimpleDateFormat("dd/MM/yyyy")
	              .format(new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy", Locale.US).parse(dataCriacao));
		
		arquivoFTP.setDataCriacao(dataCriacao);
		list.add(arquivoFTP);
	}

	
	public final void disconnect() {
		this.session.disconnect();
	}
	
	public static long bytesToMeg(long bytes) {
	  return bytes / MEGABYTE ;
   }

}
