package com.snce.facturation.service.imp;

import com.snce.facturation.DTO.FactureDTO;
import com.snce.facturation.mapper.MapperService;
import com.snce.facturation.projection.FacturationProjection;
import com.snce.facturation.repository.ArticleFactureRepository;
import com.snce.facturation.repository.FactureRepository;
import com.snce.facturation.service.ReportService;
import com.snce.facturation.util.ConvertisseurMontantEnLettres;
import lombok.AllArgsConstructor;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class ReportServiceImpl implements ReportService {
    private ArticleFactureRepository articleFactureRepository;
    private FactureRepository factureRepository;
    private MapperService mapperService;
    private ArticleFactureRepository  facturationRepository;
    @Override
    public void exportReport(HttpServletResponse response, Long facture_id) throws IOException, JRException {
        List<FacturationProjection> articleFactures = articleFactureRepository.exportReport(facture_id);
        FactureDTO facture = mapperService.fromCommande(factureRepository.findFactureById(facture_id));
        Double totalTTC = facturationRepository.totalTCC(facture_id);
        String totalTTCenLittre = ConvertisseurMontantEnLettres.convertirMontantEnLettres(totalTTC);
        File file = ResourceUtils.getFile("classpath:facture.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(articleFactures);
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("numFacture", facture.getNumFacture());
        parameters.put("dateFacture",facture.getDateFacture());
        parameters.put("ObjetFacture",facture.getObjetFacture());
        parameters.put("ObjetMarche", facture.getObjetMarche());
        parameters.put("ObjetMois", facture.getObjetMois());
        parameters.put("raisonSociale", facture.getClient().getRaisonSociale());
        parameters.put("adresse", facture.getClient().getAdresse());
        parameters.put("libelle_v", facture.getClient().getVille().getLibelleV());
        parameters.put("i_c_e", facture.getClient().getI_c_e());
        parameters.put("mantantLitre", totalTTCenLittre);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters,dataSource);
        JasperExportManager.exportReportToPdfStream(jasperPrint,response.getOutputStream());
        

    }
}
