package br.com.zglosa.service.Impl;

import br.com.zglosa.domain.LoteGuias;
import br.com.zglosa.service.ZGlosaServiceLoteGuiasDataImport;
import br.com.zglosa.service.Impl.xmlParser.XMLParser;

/**
 * ZGlosaServiceLoteGuiasDataImportImpl
 */
public class ZGlosaServiceLoteGuiasDataImportImpl implements ZGlosaServiceLoteGuiasDataImport {

    @Override
    public LoteGuias parseData(String path) {
        try {
            XMLParser xmlParser = new XMLParser(path);
            return xmlParser.getLoteGuias();
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
    }

}