package com.marketpay.hackathon.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import com.marketpay.hackathon.SFTPConexao;
import com.marketpay.hackathon.model.ArquivoFTP;

@Service
public class ArquivoService {
	
	public List<ArquivoFTP> listarArquivo() throws IllegalAccessException, JSchException, SftpException {
		SFTPConexao conexao = new SFTPConexao();
		return conexao.consultarArquivos();
	}

}
