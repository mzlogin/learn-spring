package org.mazhuang;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

/**
 * @author zhuang.ma
 */
public class Main {

    public static void main(String[] args) {
        System.setProperty("sun.java2d.cmm", "sun.java2d.cmm.kcms.KcmsServiceProvider");

        String pdfPath = "/Users/zhuang.ma/Downloads/1.pdf";

        File pdfFile = new File(pdfPath);

        try (PDDocument document = PDDocument.load(pdfFile)) {
            int pageCount = document.getNumberOfPages();
            System.out.println("pageCount = " + pageCount);

            AccessPermission ap = document.getCurrentAccessPermission();
            if (!ap.canExtractContent()) {
                throw new IOException("You do not have permission to extract text");
            }

            PDFTextStripper stripper = new PDFTextStripper();
            // 在有列式区域的地方，这个设置会导致文字顺序错乱，按需使用
            // stripper.setSortByPosition(true);

            StringBuilder sb = new StringBuilder();
            for (int p = 1; p <= pageCount; ++p) {
                stripper.setStartPage(p);
                stripper.setEndPage(p);
                String text = stripper.getText(document);
                sb.append(text);
            }
            String content = sb.toString();
            System.out.println(content);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
