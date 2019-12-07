package br.com.zglosa.service.Impl;

import br.com.zglosa.service.ZGlosaService;
import br.com.zglosa.service.ZGlosaServiceFile;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ZGlosaServiceFileImpl implements ZGlosaServiceFile {

	public List<String> getFileXml() {
		return new ArrayList<String>();
	}

	public List<String> getFileCsv(){
		return new ArrayList<String>();
	}
}
