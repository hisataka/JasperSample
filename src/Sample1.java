import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class Sample1 {
    /**
     * @param args
     */
   
    public static void main(String[] args) {
        // テンプレートXMLファイルのパス
        String templatePath = "c:/wfdev/workspace/JasperSample/template/report1.jrxml";
        // テンプレートファイルのパス
        // String sourcePath = "e:/iReport-2.0.2/bean.jasper";
        // 出力するPDFファイルのパス
        String destPath = "c:/wfdev/workspace/JasperSample/template/report1.pdf";

        try {
            // （1）テンプレートXMLのコンパイル
            JasperReport jasperReport = JasperCompileManager.compileReport(templatePath);
            // JasperCompileManager.compileReportToFile(templatePath, sourcePath);

            HashMap<String, Object> params = new HashMap<String, Object>();
            params.put("TONAME", "COMPANY");
            params.put("DATACOUNT", 10);
            
            // （4）データの動的バインド
            List list = new ArrayList();
            list.add(new Sample1Bean("01", "AA", "100"));
            list.add(new Sample1Bean("10", "bb", "200"));
            list.add(new Sample1Bean("20", "cc", "300"));
            list.add(new Sample1Bean("31", "dd", "400"));
            list.add(new Sample1Bean("41", "ee", "500"));
            list.add(new Sample1Bean("51", "ff", "600"));
            list.add(new Sample1Bean("61", "gg", "700"));
            list.add(new Sample1Bean("71", "ee", "800"));
            list.add(new Sample1Bean("81", "ww", "900"));
            list.add(new Sample1Bean("91", "qq", "000"));

            JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(list);

            // （5）PDFへ出力
            JasperPrint print = JasperFillManager.fillReport(jasperReport, params, ds);
            JasperExportManager.exportReportToPdfFile(print, destPath);
            // JasperRunManager.runReportToPdfFile(sourcePath, destPath, null, ds);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}