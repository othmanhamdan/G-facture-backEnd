package com.snce.facturation.web;


import com.snce.facturation.service.ReportService;
import lombok.AllArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@AllArgsConstructor
@CrossOrigin("*")
public class ReportController {
    private ReportService reportService;
    @GetMapping("/report/{facture_id}")
    //@PostAuthorize("hasAnyAuthority('USER','ADMIN')")
    public void generatedReport(HttpServletResponse response, @PathVariable Long facture_id) throws IOException, JRException {
        response.setContentType("application/pdf");
        String headerKey = "Content-Disposition" ;
        String headerValue = "attachment; filename = facture"+facture_id+".pdf";
        response.setHeader(headerKey,headerValue);
        reportService.exportReport(response,facture_id);
    }
}
