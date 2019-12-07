package br.com.zglosa.service.Impl;

import br.com.zglosa.domain.DadosBeneficiario;
import br.com.zglosa.domain.GuiaResumoInternacao;
import br.com.zglosa.domain.LoteGuias;
import br.com.zglosa.domain.ProcedimentoExecutado;
import br.com.zglosa.service.FileCSVService;
import br.com.zglosa.to.CsvDTO;
import lombok.AllArgsConstructor;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@AllArgsConstructor
public class FileCSVServiceImpl implements FileCSVService {


    @Override
    public  void downloadCSV() {
        try {
            for(String link:buscaLinkDownload()) {
                URL url = new URL(link);

                File file = new File("aa.csv");

                FileUtils.copyURLToFile(url, file);
                carregarCSV(file);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    


    private void carregarCSV(File file){
        if (file == null) return;

        try (FileReader reader = new FileReader(file);
             BufferedReader br = new BufferedReader(reader)) {

            String linha =  br.readLine();
            List<CsvDTO> csvdto = new ArrayList<>();
            while ((linha = br.readLine()) != null) {
                csvdto.add (mapearCSVDTO(linha));
            }

            System.out.println(csvdto.size());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void transformarDtoParaObjetoRelacional(List<CsvDTO> csvDTOS) {
        for (CsvDTO csvDTO : csvDTOS) {


            LoteGuias loteGuias = new LoteGuias();
            loteGuias.setNumeroLote(Integer.parseInt(csvDTO.getLote()));

            DadosBeneficiario dadosBeneficiario = new DadosBeneficiario();
            dadosBeneficiario.setNumeroCarteira(csvDTO.getMatricula());
            dadosBeneficiario.setAtendimentoRN(csvDTO.getRn());
            dadosBeneficiario.setNomeBenificiariio(csvDTO.getNome());

            GuiaResumoInternacao guiaResumoInternacao = new GuiaResumoInternacao();
            guiaResumoInternacao.setNumeroGuiaPrestador(Long.parseLong(csvDTO.getNumeroGuiaPrestador()));
            guiaResumoInternacao.setNumeroGuiaSolicitacaoInternacao(Long.parseLong(csvDTO.getNumeroGuiaPrestador()));
            guiaResumoInternacao.setSenha(Long.parseLong(csvDTO.getSenha()));
            guiaResumoInternacao.setLoteGuias(loteGuias);
            guiaResumoInternacao.setDadosBeneficiario(dadosBeneficiario);


            ProcedimentoExecutado procedimentoExecutado = new ProcedimentoExecutado();
            procedimentoExecutado.setDataExecucao(csvDTO.getDataExecucao());
            procedimentoExecutado.setHoraFinal(csvDTO.getHoraFinal());
            procedimentoExecutado.setHoraInicial(csvDTO.getHoraInicial());
            procedimentoExecutado.setCodigoTabela(Integer.parseInt(csvDTO.getCodigoTabela()));
            procedimentoExecutado.setCodigoProcedimento(Integer.parseInt(csvDTO.getCodigoProcedimento()));
            procedimentoExecutado.setDescricaoProcedimento(csvDTO.getDescricaoProcedimento());
            procedimentoExecutado.setQuantidadeExecutada(Integer.parseInt(csvDTO.getQuantidadeExecutada()));
            procedimentoExecutado.setValorUnitario(Float.parseFloat(csvDTO.getValorUnitario()));
            procedimentoExecutado.setValorGlosa(Float.parseFloat(csvDTO.getValorGlosa()));
            procedimentoExecutado.setValorApresentado(Float.parseFloat(csvDTO.getValorApresentado()));
            procedimentoExecutado.setValorPago(Float.parseFloat(csvDTO.getValorPago()));
            procedimentoExecutado.setMotivoGlosa(csvDTO.getMotivoGlosa());
            procedimentoExecutado.setGuiaResumoInternacao(guiaResumoInternacao);


        }
    }


    public CsvDTO mapearCSVDTO(String linha){
        String[] split = linha.split(",");
        int i=0;
        CsvDTO csvDTO = new CsvDTO();
        csvDTO.setLote(split[i++]);
        csvDTO.setNumeroGuiaPrestador(split[i++]);
        csvDTO.setNumeroSoliciacaoInternacao(split[i++]);
        csvDTO.setNumeroGuiaOperadora(split[i++]);
        csvDTO.setSenha(split[i++]);
        csvDTO.setMatricula(split[i++]);
        csvDTO.setRn(split[i++]);
        csvDTO.setNome(split[i++]);
        csvDTO.setDataExecucao(split[i++]);
        csvDTO.setHoraInicial(split[i++]);
        csvDTO.setHoraFinal(split[i++]);
        csvDTO.setCodigoTabela(split[i++]);
        csvDTO.setCodigoProcedimento(split[i++]);
        csvDTO.setDescricaoProcedimento(split[i++]);
        csvDTO.setQuantidadeExecutada(split[i++]);
        csvDTO.setValorUnitario(split[i++]);
        csvDTO.setValorApresentado(split[i++]);
        csvDTO.setValorPago(split[i++]);
        csvDTO.setValorGlosa(split[i++]);
        if(split.length<i){
            csvDTO.setMotivoGlosa(split[i++]);
        }

        return csvDTO;
    }



    public  List<String> buscaLinkDownload() {
        try {

            List<String> links = new ArrayList<>();
            preencheListaComLinksHTML(links);
            removeLinksNaoDesejados(links);

            return filtraLinkDaTagHtml(links);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    private  void preencheListaComLinksHTML(List<String> links){
        try {
            URL url =   new URL("http://172.22.1.108:8080/pagamento-glosamax/arquivo/index");
            BufferedReader in = new BufferedReader( new InputStreamReader(url.openStream()));

            String s;
            while ((s = in.readLine()) != null) {
                if(s.contains("<a")){
                    links.add(s);
                }
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private  void removeLinksNaoDesejados(List<String> links){


        Iterator<String> it = links.iterator();
        while (it.hasNext()) {

            String link = it.next();
            if(!link.contains("pagamento_glosamax")){
                it.remove();
            }

        }
    }

    private  List<String> filtraLinkDaTagHtml(List<String> links){
        List<String> retorno = new ArrayList<>();
        for(String htmlTag :links){
            htmlTag=  htmlTag.substring(htmlTag.indexOf("href=")+6);
            retorno.add( htmlTag.substring(0,htmlTag.indexOf("\"")));
        }
        return retorno;
    }


}
