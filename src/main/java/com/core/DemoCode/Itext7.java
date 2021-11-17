package com.core.DemoCode;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.io.font.FontProgram;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.IElement;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.font.FontProvider;
import com.itextpdf.layout.font.FontSet;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author xiaoXi
 * @Classname Itext7
 * @Description TODO
 * @Date 2021/8/5 11:44 上午
 */
public class Itext7 {

    public static final String DEST = "/Users/v0pr/Downloads/wadafdsfsdf.pdf";

    private static final String FONT = "/Users/v0pr/Downloads/SimHei.ttf";

    public static void main(String args[]) throws IOException {
        String htmlFilePath = "/Users/v0pr/Documents/IdeaProjects/wangjq-core/src/main/java/com/core/domain/1390_20210723162540_1639.html";
        createPdf(null, htmlFilePath, DEST);

    }

    /**
     * @param baseUri html用到的css、js、图片等资源根目录。
     * @param src     html模板文件路径
     * @param dest    生成的pdf文件输出的路径
     * @throws IOException
     */
    public static void createPdf(String baseUri, String src, String dest) throws IOException {
        try {

            FontProgram fontProgram = FontProgramFactory.createFont(FONT);

            FontSet fontSet = new FontSet();
            fontSet.addFont(fontProgram, PdfEncodings.IDENTITY_H);
            FontProvider fontProvider = new FontProvider(fontSet);

            ConverterProperties proper = new ConverterProperties();
            proper.setFontProvider(fontProvider);
            proper.setLimitOfLayouts(1);
//            proper.set
            //开始转换
            HtmlConverter.convertToPdf(new FileInputStream(src),
                    new FileOutputStream(dest), proper);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
