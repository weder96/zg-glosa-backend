package br.com.zglosa.service.Impl;

import br.com.zglosa.domain.LoteGuias;
import br.com.zglosa.service.ZGlosaServiceLoteGuiasDataImport;
import br.com.zglosa.service.Impl.xmlParser.XMLParser;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

/**
 * ZGlosaServiceLoteGuiasDataImportImpl
 */
@Service
@AllArgsConstructor
public class ZGlosaServiceLoteGuiasDataImportImpl implements ZGlosaServiceLoteGuiasDataImport {

    @Override
    public LoteGuias parseData(String path2) {

        String path = "faturamento_glosamaxx_2016-02-01_161526_3.02.00.xml";

        try {
            XMLParser xmlParser = new XMLParser(path);
            return xmlParser.getLoteGuias();
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
    }

}
