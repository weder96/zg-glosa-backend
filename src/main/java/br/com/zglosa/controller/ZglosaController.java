package br.com.zglosa.controller;

import br.com.zglosa.service.ZGlosaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URISyntaxException;


@Controller
public class ZglosaController {

	@Autowired
	private ZGlosaService zglosaService;

	@RequestMapping(value = "/zglosa/all")
	public ResponseEntity<?> getZGlosa() throws URISyntaxException {
		String teste = zglosaService.getGlosa();
			return ResponseEntity.ok(teste);
	}
}
