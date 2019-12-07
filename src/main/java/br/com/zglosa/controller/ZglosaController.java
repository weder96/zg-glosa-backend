package br.com.zglosa.controller;

import br.com.zglosa.service.FileCSVService;
import br.com.zglosa.service.ZGlosaService;
import br.com.zglosa.service.ZGlosaServiceLoteGuiasDataImport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URISyntaxException;


@Controller
public class ZglosaController {

	@Autowired
	private ZGlosaService zglosaService;


	@Autowired
	private FileCSVService fileCSVService;

	@Autowired
	private ZGlosaServiceLoteGuiasDataImport zGlosaServiceLoteGuiasDataImport;


	@RequestMapping(value = "/zglosa/all")
	public ResponseEntity<?> getZGlosa() throws URISyntaxException {
		zglosaService.salvarDadosXml();
		return ResponseEntity.ok("ok");
	}

	@RequestMapping(value = "/zglosa/csv")
	public ResponseEntity<?> getCSV() throws URISyntaxException {
		fileCSVService.alimentarCSVConvenio();
		return ResponseEntity.ok("");
	}

	@RequestMapping(value = "/zglosa/xml")
	public ResponseEntity<?> getXml() throws URISyntaxException {
		return ResponseEntity.ok(zGlosaServiceLoteGuiasDataImport.parseData(""));
	}

}
