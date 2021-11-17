package com.core.DemoCode;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.BaseFont;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoXi
 * @Classname Html2Pdf
 * @Description TODO
 * @Date 2021/8/4 10:31 上午
 */
public class Html2Pdf {

    /**
     * HTML代码转PDF文档
     *
     * @param content     待转换的HTML代码
     * @param storagePath 保存为PDF文件的路径
     */
    public static void parsePdf(String content, String storagePath) {
        FileOutputStream os = null;
        try {
            File file = new File(storagePath);
            if (!file.exists()) {
                file.createNewFile();
            }
            os = new FileOutputStream(file);

            ITextRenderer renderer = new ITextRenderer();
            //解决中文支持问题
            ITextFontResolver resolver = renderer.getFontResolver();
            resolver.addFont("/Users/v0pr/Downloads/dengxian.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            resolver.addFont("/Users/v0pr/Downloads/simsun-bold.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
    //  resolver.addFont("/Users/v0pr/Downloads/SimHei.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);

            renderer.setDocumentFromString(content);
// 解决图片的相对路径问题,图片路径必须以file开头
// renderer.getSharedContext().setBaseURL("file:/");
            renderer.layout();
            renderer.createPDF(os);

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != os) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 对Html要求特别严格
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String htmlFilePath = "";
        htmlFilePath = "/Users/v0pr/Documents/IdeaProjects/wangjq-core/src/main/java/com/core/domain/32236_20210804100537_1910.html";
        StringBuilder content = new StringBuilder();
        BufferedInputStream in;
        byte[] bys = new byte[1024];
        int len;
        in = new BufferedInputStream(new FileInputStream(htmlFilePath));
        while ((len = in.read(bys)) != -1) {
            content.append(new String(bys, 0, len));
        }
//        String html = closeHTML(content.toString());
        String html = content.toString().replace(" ", " ");

        parsePdf(html, "/Users/v0pr/Downloads/dff.pdf");

    }

//    public static String closeHTML(String str) {
//        List arrTags = new ArrayList();
//        arrTags.add("br");
//        arrTags.add("hr");
//        arrTags.add("link");
//        arrTags.add("meta");
//        arrTags.add("img");
//        arrTags.add("input");
//        for (int i = 0; i < arrTags.size(); i++) {
//            for (int j = 0; j < str.length(); ) {
//                int tagStart = str.indexOf("<" + arrTags.get(i), j);
//                if (tagStart >= 0) {
//                    int tagEnd = str.indexOf(">", tagStart);
//                    j = tagEnd;
//                    String preCloseTag = str.substring(tagEnd - 1, tagEnd);
//                    if (!"/".equals(preCloseTag)) {
//                        String preStr = str.substring(0, tagEnd);
//                        String afterStr = str.substring(tagEnd);
//                        str = preStr + "/" + afterStr;
//                    }
//                } else {
//                    break;
//                }
//            }
//        }
//        System.err.println(str);
//        return str;
//    }
}
