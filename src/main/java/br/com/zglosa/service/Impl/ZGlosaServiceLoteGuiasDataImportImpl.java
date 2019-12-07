package br.com.zglosa.service.Impl;

import br.com.zglosa.domain.LoteGuias;
import br.com.zglosa.service.ZGlosaServiceLoteGuiasDataImport;

/**
 * ZGlosaServiceLoteGuiasDataImportImpl
 */
public class ZGlosaServiceLoteGuiasDataImportImpl implements ZGlosaServiceLoteGuiasDataImport {

    @Override
    public LoteGuias parseData(String path) {
        return new LoteGuias();
    }

}