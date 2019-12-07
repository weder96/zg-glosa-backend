package br.com.zglosa.service.Impl.xmlParser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.core.io.ClassPathResource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import br.com.zglosa.domain.DadosBeneficiario;
import br.com.zglosa.domain.GuiaResumoInternacao;
import br.com.zglosa.domain.LoteGuias;
import br.com.zglosa.domain.ProcedimentoExecutado;
import br.com.zglosa.domain.ValorTotal;

/**
 * XMLParser
 */
public class XMLParser {

    private File file;

    private Element element;

    public XMLParser(String filePath) throws ParserConfigurationException, SAXException, IOException {
        ClassPathResource classPathResource = new ClassPathResource(filePath);
        this.file = classPathResource.getFile();

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
        NodeList guiaResumoInternacaoNodeList = this.element.getElementsByTagName("guiaResumoInternacao");

        List<GuiaResumoInternacao> guiaResumoInternacoes = new ArrayList<GuiaResumoInternacao>();

        for (int i = 0; i < guiaResumoInternacaoNodeList.getLength(); i++) {
            if (guiaResumoInternacaoNodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element guiaElement = (Element) guiaResumoInternacaoNodeList.item(i);

                long numeroGuiaPrestador = Long.parseLong(this.getTagValue(guiaElement, "numeroGuiaPrestador"));
                long numeroGuiaSolicitacaoInternacao = Long
                        .parseLong(this.getTagValue(guiaElement, "numeroGuiaSolicitacaoInternacao"));
                long numeroGuiaOperadora = Long.parseLong(this.getTagValue(guiaElement, "numeroGuiaOperadora"));
                long senha = Long.parseLong(this.getTagValue(guiaElement, "senha"));

                GuiaResumoInternacao guiaResumoInternacao = new GuiaResumoInternacao();
                guiaResumoInternacao.setNumeroGuiaPrestado(numeroGuiaPrestador);
                guiaResumoInternacao.setNumeroGuiaSolicitacaoInternacao(numeroGuiaSolicitacaoInternacao);
                guiaResumoInternacao.setNumeroGuiaOperadora(numeroGuiaOperadora);
                guiaResumoInternacao.setSenha(senha);

                DadosBeneficiario dadosBeneficiario = this.getDadosBeneficiario(guiaElement);
                guiaResumoInternacao.setDadosBeneficiario(dadosBeneficiario);

                ValorTotal valorTotal = this.getValorTotal(guiaElement);
                guiaResumoInternacao.setValorTotal(valorTotal);

                List<ProcedimentoExecutado> procedimentoExecutados = this.getProcedimentosExecutado(guiaElement);
                guiaResumoInternacao.setProcedimentoExecutados(procedimentoExecutados);
            }
        }

        return guiaResumoInternacoes;
    }

    private DadosBeneficiario getDadosBeneficiario(Element guiaElement) {
        Element dadosBeneficiarioElement = (Element) guiaElement.getElementsByTagName("dadosBeneficiario").item(0);

        DadosBeneficiario dadosBeneficiario = new DadosBeneficiario();

        int numeroCarteira = Integer.parseInt(this.getTagValue(dadosBeneficiarioElement, "numeroCarteira"));
        String atendimentoRN = this.getTagValue(dadosBeneficiarioElement, "atendimentoRN");
        String nomeBeneficiario = this.getTagValue(dadosBeneficiarioElement, "nomeBeneficiario");

        dadosBeneficiario.setNumeroCarteira(numeroCarteira);
        dadosBeneficiario.setAtendimentoRN(atendimentoRN);
        dadosBeneficiario.setNomeBeneficiario(nomeBeneficiario);

        return dadosBeneficiario;
    }

    private ValorTotal getValorTotal(Element guiaElement) {
        Element valorTotalElement = (Element) guiaElement.getElementsByTagName("valorTotal").item(0);

        ValorTotal valorTotal = new ValorTotal();

        float valorProcedimentos = Float.parseFloat(this.getTagValue(valorTotalElement, "valorProcedimentos"));
        float valorDiarias = Float.parseFloat(this.getTagValue(valorTotalElement, "valorDiarias"));
        float valorTaxasAlugueis = Float.parseFloat(this.getTagValue(valorTotalElement, "valorTaxasAlugueis"));
        float valorMateriais = Float.parseFloat(this.getTagValue(valorTotalElement, "valorMateriais"));
        float valorMedicamento = Float.parseFloat(this.getTagValue(valorTotalElement, "valorMedicamentos"));
        float valorOpme = Float.parseFloat(this.getTagValue(valorTotalElement, "valorOPME"));
        float valorGasesMedicinais = Float.parseFloat(this.getTagValue(valorTotalElement, "valorGasesMedicinais"));
        float valorTotalGeral = Float.parseFloat(this.getTagValue(valorTotalElement, "valorTotalGeral"));

        valorTotal.setValorProcedimentos(valorProcedimentos);
        valorTotal.setValorDiarias(valorDiarias);
        valorTotal.setValorTaxasAlugueis(valorTaxasAlugueis);
        valorTotal.setValorMateriais(valorMateriais);
        valorTotal.setValorMedicamento(valorMedicamento);
        valorTotal.setValorOpme(valorOpme);
        valorTotal.setValorGasesMedicinais(valorGasesMedicinais);
        valorTotal.setValorTotalGeral(valorTotalGeral);

        return valorTotal;
    }

    private List<ProcedimentoExecutado> getProcedimentosExecutado(Element guiaElement) {
        NodeList procedimentosExecutadosNodeList = guiaElement.getElementsByTagName("procedimentosExecutados");

        List<ProcedimentoExecutado> procedimentosExecutados = new ArrayList<ProcedimentoExecutado>();

        for (int i = 0; i < procedimentosExecutadosNodeList.getLength(); i++) {
            if (procedimentosExecutadosNodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element procedimentosExecutadoElement = (Element) procedimentosExecutadosNodeList.item(i);

                ProcedimentoExecutado procedimentoExecutado = new ProcedimentoExecutado();

                String dataExecucao = this.getTagValue(procedimentosExecutadoElement, "dataExecucao");
                String horaInicial = this.getTagValue(procedimentosExecutadoElement, "horaInicial");
                String horaFinal = this.getTagValue(procedimentosExecutadoElement, "horaFinal");
                int codigoTabela = Integer.parseInt(this.getTagValue(procedimentosExecutadoElement, "codigoTabela"));
                int codigoProcedimento = Integer
                        .parseInt(this.getTagValue(procedimentosExecutadoElement, "codigoProcedimento"));
                String descricaoProcedimento = this.getTagValue(procedimentosExecutadoElement, "descricaoProcedimento");
                int quantidadeExecutada = Integer
                        .parseInt(this.getTagValue(procedimentosExecutadoElement, "quantidadeExecutada"));
                float reducaoAcrescimo = Float
                        .parseFloat(this.getTagValue(procedimentosExecutadoElement, "quantidadeExecutada"));
                float valorUnitario = Float
                        .parseFloat(this.getTagValue(procedimentosExecutadoElement, "reducaoAcrescimo"));
                float valorTotal = Float.parseFloat(this.getTagValue(procedimentosExecutadoElement, "valorUnitario"));
                String unidadeMediada = this.getTagValue(procedimentosExecutadoElement, "valorTotal");

                procedimentoExecutado.setDataExecucao(dataExecucao);
                procedimentoExecutado.setHoraInicial(horaInicial);
                procedimentoExecutado.setHoraFinal(horaFinal);
                procedimentoExecutado.setCodigoTabela(codigoTabela);
                procedimentoExecutado.setCodigoProcedimento(codigoProcedimento);
                procedimentoExecutado.setDescricaoProcedimento(descricaoProcedimento);
                procedimentoExecutado.setQuantidadeExecutada(quantidadeExecutada);
                procedimentoExecutado.setReducaoAcrescimo(reducaoAcrescimo);
                procedimentoExecutado.setValorUnitario(valorUnitario);
                procedimentoExecutado.setValorTotal(valorTotal);
                procedimentoExecutado.setUnidadeMediada(unidadeMediada);

                procedimentosExecutados.add(procedimentoExecutado);
            }
        }

        return procedimentosExecutados;
    }

    private String getTagValue(String tagName) {
        return this.getTagValue(this.element, tagName);
    }

    private String getTagValue(Element startPoint, String tagName) {
        return element.getElementsByTagName(tagName).item(0).getTextContent();
    }

}