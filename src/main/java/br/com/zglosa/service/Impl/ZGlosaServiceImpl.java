package br.com.zglosa.service.Impl;

import br.com.zglosa.service.ZGlosaService;
import br.com.zglosa.service.ZGlosaServiceFile;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ZGlosaServiceImpl implements ZGlosaService {

	@Autowired
	private ZGlosaServiceFile zglosaServiceFile;
	public String getGlosa() {
		zglosaServiceFile.getFileCsv();
		zglosaServiceFile.getFileXml();
		return "test de Service";
	}
}
