package com.snce.facturation.service;

import net.sf.jasperreports.engine.JRException;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface ReportService {
    void exportReport(HttpServletResponse response, Long facture_id) throws IOException, JRException;
}
