package com.core.DemoCode;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;
import org.apache.commons.lang3.StringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * @author xiaoXi
 * @Classname ReadPdf
 * @Description TODO
 * @Date 2021/8/5 3:13 下午
 */
public class ReadPdf {

    private static final String PDF_LOCAL_PATH = "/Users/v0pr/Downloads/wadafdsfsdf.pdf";
    // private static final String PDF_LOCAL_PATH = "/Users/lingyi/Downloads/6870_c.pdf";
    //private static final String PDF_LOCAL_PATH = "/Users/lingyi/Downloads/6870_20200518171234_8958.pdf";


    public static void main(String[] args) throws Exception {

//        File file = new File(PDF_LOCAL_PATH);
//
//        try (FileInputStream in = new FileInputStream(file)) {
//
//
//            String s = streamToMd5(in);
//            System.err.println(s);
//
//
//
//            //   file.delete();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        getPdfContentUsePdfbox();

    }

    public static String streamToMd5(InputStream inputStream) {
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            byte[] buffer = new byte[1024];
            int numRead = 0;
            while ((numRead = inputStream.read(buffer)) > 0) {
                mdTemp.update(buffer, 0, numRead);
            }
            return toHexString(mdTemp.digest());
        } catch (Exception e) {
            return null;
        }
    }

    private static String toHexString(byte[] md) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};
        int j = md.length;
        char str[] = new char[j * 2];
        for (int i = 0; i < j; i++) {
            byte byte0 = md[i];
            str[2 * i] = hexDigits[byte0 >>> 4 & 0xf];
            str[i * 2 + 1] = hexDigits[byte0 & 0xf];
        }
        return new String(str);
    }

    // @Test
    public void test01() {
        for (int i = 0; i < 100; i++) {
            getPdfContentUsePdfbox();
        }

        while (true) {
        }
    }

    //  @Test
    public void test02() {
        for (int i = 0; i < 100; i++) {
            getPdfContentUsePdfbox();
        }

        while (true) {
        }
    }

    public static void getPdfFileText() {

        PdfReader reader = null;
        String s = null;
        try {
            reader = new PdfReader(PDF_LOCAL_PATH);

            PdfReaderContentParser parser = new PdfReaderContentParser(reader);

            StringBuffer buff = new StringBuffer();

            TextExtractionStrategy strategy;

            for (int i = 1; i <= reader.getNumberOfPages(); i++) {

                strategy = parser.processContent(i, new SimpleTextExtractionStrategy());

                buff.append(strategy.getResultantText());
            }

            s = buff.toString().replaceAll("\\s*|\t|" + System.lineSeparator(), "");

            int length = s.length();
            System.err.println(length);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }

        System.err.println("---------------------------------------------");

        System.err.println(s);
        System.err.println("---------------------------------------------");


    }

    public static void getPdfContentUsePdfbox() {

        try (PDDocument document = PDDocument.load(new File(PDF_LOCAL_PATH))) {

            // 加密文档, 无法读取内容
            if (document.isEncrypted()) {
                System.err.println("加密文档");
                return;
            }

            // 新建一个PDF文本剥离器
            PDFTextStripper stripper = new PDFTextStripper();

            String text = stripper.getText(document);

            // 获取内容长度
            String s1 = text.replaceAll("<[a-zA-Z]+.*?>([\\s\\S]*?)</[a-zA-Z]*?>", text);
            System.err.println(StringUtils.trim(s1));
            byte[] bytes = s1.getBytes(StandardCharsets.UTF_8);
            System.err.println(s1.length());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
