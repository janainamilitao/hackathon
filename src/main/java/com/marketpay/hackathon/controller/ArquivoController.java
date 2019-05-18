package com.marketpay.hackathon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import com.marketpay.hackathon.model.ArquivoFTP;
import com.marketpay.hackathon.search.ArquivoSearch;
import com.marketpay.hackathon.service.ArquivoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/arquivos")
public class ArquivoController {

	@Autowired
	private ArquivoService arquivoService;

	private static final String APPLICATION_JSON  = "application/json";

	@ApiOperation(value = "Listagem de arquivos", response = ArquivoFTP.class)
	@RequestMapping(value = "/listarArquivos", method= RequestMethod.POST, produces = APPLICATION_JSON )
	public List<ArquivoFTP> listarAquivos(ArquivoSearch arquivoSearch) throws Exception {
		return arquivoService.listarArquivo(arquivoSearch);
	}

}
