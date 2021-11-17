package com.core.DemoCode;

import com.openhtmltopdf.extend.FSSupplier;
import com.openhtmltopdf.outputdevice.helper.BaseRendererBuilder;
import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author xiaoXi
 * @Classname SimpleUsage
 * @Description TODO
 * @Date 2021/8/4 2:54 下午
 */
public class SimpleUsage {
    public static void main(String[] args) throws Exception {
        try (OutputStream os = new FileOutputStream("/Users/v0pr/Downloads/imhtml.pdf")) {
            PdfRendererBuilder builder = new PdfRendererBuilder();
            builder.useFastMode();
            builder.withUri("file:///Users/v0pr/Documents/IdeaProjects/wangjq-core/src/main/java/com/core/domain/imhtml.html");
            builder.toStream(os);
//            builder.useFont(new File("/Users/v0pr/Downloads/simsun.ttf"), "SimHei");
addFont(builder,"/Users/v0pr/Downloads/simsun.ttf");
//            builder.useFont(() -> {
//                try {
//                    //指定 字体文件
//                    return new FileInputStream("/Users/v0pr/Downloads/dengxian.ttf");
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                }
//                return null;
//            }, "dengxian", 400, BaseRendererBuilder.FontStyle.NORMAL, true); //第二个参数 一定要和文件名一样！！作用在html页面上
            builder.run();
        }
    }

    /**
     * 添加字体库
     * @param builder
     * @param dir
     */
    private static void addFont(PdfRendererBuilder builder, String dir) {
        File f = new File(dir);
        if (f.isDirectory()) {
            File[] files = f.listFiles(new FilenameFilter() {
                public boolean accept(File dir, String name) {
                    String lower = name.toLowerCase();
                    lower.endsWith(".otf") ; //对otf库的字体支持有问题，暂时屏蔽
                    return lower.endsWith(".ttf") || lower.endsWith(".ttc");
                }
            });
            for (File subFile:files) {
                String fontFamily = subFile.getName().substring(0, subFile.getName().lastIndexOf("."));
                builder.useFont(subFile, fontFamily);
            }
        }
    }
}
