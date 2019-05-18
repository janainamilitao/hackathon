package com.marketpay.hackathon.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.marketpay.hackathon.SFTPConexao;
import com.marketpay.hackathon.model.ArquivoFTP;
import com.marketpay.hackathon.search.ArquivoSearch;

@Service
public class ArquivoService {
	
	public List<ArquivoFTP> listarArquivo(ArquivoSearch arquivoSearch) throws Exception {
		SFTPConexao conexao = new SFTPConexao();
		return conexao.consultarArquivos(arquivoSearch);
	}

}
