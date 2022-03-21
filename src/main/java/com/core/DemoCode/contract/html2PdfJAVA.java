package com.core.DemoCode.contract;

import com.core.common.exception.BizException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;

/**
 * @Author: jq.w
 * @Date: 2022/3/7 10:47
 * @Description:
 */
@Slf4j
public class html2PdfJAVA {
    private static String dir = System.getProperty("java.io.tmpdir");

    public static void main(String[] args) throws FileNotFoundException {
        String path = "/Users/qqjqq/Downloads/47456_20220307093505_4385.html";
        File file = new File(path);
        InputStream htmlStream = new FileInputStream(file);
        String htmlLocalPath = FileHelper.path(dir, path);
        String pdfLocalPath = htmlLocalPath.replace(".html", ".pdf");
        String pdfOssPath = path.replace(".html", ".pdf");

        html2PdfJAVA(htmlStream, pdfLocalPath, pdfOssPath);

    }

    public static String html2PdfJAVA(InputStream htmlStream, String pdfLocalPath, String pdfOssPath) {

        FileOutputStream fileOutputStream = null;
        File file = null;
        try {
            file = new File(pdfLocalPath);

            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (!file.exists()) {
                file.createNewFile();
            }

            fileOutputStream = new FileOutputStream(file);

            // HTML -> PDF
            transfer(fileOutputStream, htmlStream);

            // 上传到 oss
            return upload(file, pdfOssPath);
        } catch (PDFException pe) {
            log.error("html to pdf use java pdf exception error, pdfOssPath: {}, error message: {}", pdfOssPath, pe.getMessage(), pe);
        } catch (Exception e) {
            log.error("html to pdf use java error, pdfOssPath: {}, error message: {}", pdfOssPath, e.getMessage(), e);
        } finally {
            try {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (htmlStream != null) {
                    htmlStream.close();
                }
                if (file != null) {
                    file.delete();
                }
            } catch (Exception e) {
                log.error("close steam error, message: {}", e);
            }
        }

        return null;
    }

    private static String upload(File file, String fileOssPath) throws Exception {
        InputStream stream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream(new File(fileOssPath));
        IOUtils.copy(stream, fileOutputStream);
        return fileOssPath;
    }

    private static void transfer(OutputStream write, InputStream inputStream) {
        try {
            Document document = new Document(PageSize.A4, 30, 30, 30, 30);
            document.setMargins(30, 30, 30, 30);

            PdfWriter pdfwriter = PdfWriter.getInstance(document, write);

            pdfwriter.setPageEvent(new PDFBuilder());

            document.open();
            XMLWorkerHelper wh = XMLWorkerHelper.getInstance();
            InputStream cssInput = null;
            wh.parseXHtml(pdfwriter, document, inputStream, cssInput, new MyFontsProvider());
            document.close();
        } catch (PDFException pe) {
            log.error("html to pdf use java error, message: {}", pe.getMessage(), pe);
            throw pe;
        } catch (Exception e) {
            log.error("html to pdf use java error, message: {}", e.getMessage(), e);
            throw new BizException(e);
        }
    }
}

class MyFontsProvider extends XMLWorkerFontProvider {

    public MyFontsProvider() {
        super(null, null);
    }

    @Override
    public Font getFont(final String fontname, final String encoding, final boolean embedded, final float size, final int style, final BaseColor color) {
        BaseFont bf = null;
        try {
            bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",
                    BaseFont.NOT_EMBEDDED);
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Font font = new Font(bf, size, style, color);
        font.setColor(color);
        return font;
    }
}


/**
 * 设置页面附加属性
 */
class PDFBuilder extends PdfPageEventHelper {

    /**
     * 页眉
     */
    public static String header = "";

    /**
     * 文档字体大小，页脚页眉最好和文本大小一致
     */
    public static int presentFontSize = 11;

    /**
     * 基础字体对象
     */
    public static BaseFont baseFont;

    /**
     * 利用基础字体生成的字体对象，一般用于生成中文文字
     */
    private static Font font;

    /**
     * 模板
     */
    public PdfTemplate total;

    static {
        try {
            // 中文字体依赖itext得itext-asian包
            baseFont = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 168; i++) {
                sb.append("\u00a0");
            }
            font = new Font(PDFBuilder.baseFont, presentFontSize, Font.UNDEFINED);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PDFBuilder() {
    }


    /**
     * 共 页 的矩形的长宽高
     *
     * @param writer
     * @param document
     */
    @Override
    public void onOpenDocument(PdfWriter writer, Document document) {
        total = writer.getDirectContent().createTemplate(50, 50);
    }

    /**
     * 关闭每页的时候，写入页眉，写入'第几页共'这几个字。
     *
     * @param writer
     * @param document
     */
    @Override
    public void onEndPage(PdfWriter writer, Document document) {
        this.addPage(writer, document);
    }

    /**
     * 加分页
     *
     * @param writer
     * @param document
     */
    public void addPage(PdfWriter writer, Document document) {
        // 1.写入页眉
        ColumnText.showTextAligned(writer.getDirectContent(),
                Element.ALIGN_LEFT, new Phrase(header, font),
                document.left(), document.top() + 20, 0);

        // 2.写入前半部分的 第 X页/共
        String foot1 = "第 " + writer.getPageNumber() + " 页 /共";

        // 3.计算前半部分的foot1的长度，后面好定位最后一部分的'Y页'这俩字的x轴坐标，字体长度也要计算进去 = len
        float len = baseFont.getWidthPoint(foot1, presentFontSize);

        // 4.拿到当前的PdfContentByte
        PdfContentByte cb = writer.getDirectContent();

        // 5.写入页脚1，x轴就是(右margin+左margin + right() -left()- len)/2.0F
        // 再给偏移20F适合人类视觉感受，否则肉眼看上去就太偏左了
        // ,y轴就是底边界-20,否则就贴边重叠到数据体里了就不是页脚了；注意Y轴是从下往上累加的，最上方的Top值是大于Bottom好几百开外的。
        ColumnText
                .showTextAligned(
                        cb,
                        Element.ALIGN_CENTER,
                        new Phrase(foot1, font),
                        (document.right() - len / 2.0F),
                        document.bottom() - 5, 0);

        // 6.写入页脚2的模板（就是页脚的Y页这俩字）添加到文档中，计算模板的和Y轴,X=(右边界-左边界 - 前半部分的len值)/2.0F +
        // len ， y 轴和之前的保持一致，底边界-20
        cb.addTemplate(total, document.right(), document.bottom() - 5);
    }

    /**
     * 关闭文档时，替换模板，完成整个页眉页脚组件
     *
     * @param writer
     * @param document
     */
    @Override
    public void onCloseDocument(PdfWriter writer, Document document) {
        // 7.最后一步了，就是关闭文档的时候，将模板替换成实际的 Y 值,至此，page x of y 制作完毕，完美兼容各种文档size。
        total.beginText();
        // 生成的模版的字体、颜色
        total.setFontAndSize(baseFont, presentFontSize);
        String foot2 = " " + (writer.getPageNumber() - 1) + " 页";
        // 模版显示的内容
        total.showText(foot2);
        total.endText();
        total.closePath();
    }
}