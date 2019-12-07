package br.com.zglosa.service.Impl.xmlParser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import br.com.zglosa.domain.DadosBeneficiario;
import br.com.zglosa.domain.GuiaResumoInternacao;
import br.com.zglosa.domain.LoteGuias;
import br.com.zglosa.domain.ValorTotal;

/**
 * XMLParser
 */
public class XMLParser {

    private File file;

    private Element element;

    public XMLParser(String filePath) throws ParserConfigurationException, SAXException, IOException {
        this.file = new File(filePath);

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(this.file);

        Element element = doc.getDocumentElement();
        element.normalize();

        this.element = element;
    }

    public LoteGuias getLoteGuias() {
        LoteGuias loteGuias = new LoteGuias();

        int numeroLote = Integer.parseInt(this.getTagValue("numeroLote"));
        loteGuias.setNumeroLote(numeroLote);

        List<GuiaResumoInternacao> guiaResumoInternacoes = this.getGuiaResumoInternacoes();

        loteGuias.setGuiaResumoInternacao(guiaResumoInternacoes);

        return loteGuias;
    }

    private List<GuiaResumoInternacao> getGuiaResumoInternacoes() {
        NodeList nList = this.element.getElementsByTagName("guiaResumoInternacao");

        List<GuiaResumoInternacao> guiaResumoInternacoes = new ArrayList<GuiaResumoInternacao>();

        for (int i = 0; i < nList.getLength(); i++) {
            if (nList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element guia = (Element) nList.item(i);

                long numeroGuiaPrestador = Long.parseLong(this.getTagValue(guia, "numeroGuiaPrestador"));
                long numeroGuiaSolicitacaoInternacao = Long
                        .parseLong(this.getTagValue(guia, "numeroGuiaSolicitacaoInternacao"));
                long numeroGuiaOperadora = Long.parseLong(this.getTagValue(guia, "numeroGuiaOperadora"));
                long senha = Long.parseLong(this.getTagValue(guia, "senha"));

                GuiaResumoInternacao guiaResumoInternacao = new GuiaResumoInternacao();
                guiaResumoInternacao.setNumeronumeroGuiaPrestado(numeroGuiaPrestador);
                guiaResumoInternacao.setNumeroGuiaSolicitaçãoInterna(numeroGuiaSolicitacaoInternacao);
                guiaResumoInternacao.setNumeroGuiaInterna(numeroGuiaOperadora);
                guiaResumoInternacao.setSenha(senha);

                DadosBeneficiario dadosBeneficiario = this
                        .getDadosBeneficiario((Element) guia.getElementsByTagName("dadosBeneficiario").item(0));

                guiaResumoInternacao.setDadosBeneficiario(dadosBeneficiario);
            }
        }

        return guiaResumoInternacoes;
    }

    private DadosBeneficiario getDadosBeneficiario(Element nodeElement) {
        DadosBeneficiario dadosBeneficiario = new DadosBeneficiario();

        int numeroCarteira = Integer.parseInt(this.getTagValue(nodeElement, "numeroCarteira"));
        String atendimentoRN = this.getTagValue(nodeElement, "atendimentoRN");
        String nomeBeneficiario = this.getTagValue(nodeElement, "nomeBeneficiario");

        dadosBeneficiario.setNumeroCarteira(numeroCarteira);
        dadosBeneficiario.setAtendimentoRN(atendimentoRN);
        dadosBeneficiario.setNomeBeneficiario(nomeBeneficiario);

        return dadosBeneficiario;
    }

    private ValorTotal getValorTotal() {
        ValorTotal valorTotal = new ValorTotal();
        return valorTotal;
    }

    private String getTagValue(String tagName) {
        return this.getTagValue(this.element, tagName);
    }

    private String getTagValue(Element startPoint, String tagName) {
        return element.getElementsByTagName(tagName).item(0).getTextContent();
    }

}