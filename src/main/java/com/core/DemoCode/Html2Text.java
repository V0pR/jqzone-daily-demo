package com.core.DemoCode;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author xiaoXi
 * @Classname Html2Text
 * @Description TODO
 * @Date 2021/8/5 3:17 下午
 */
public class Html2Text {

    public static void main(String[] args) throws Exception {
        //235
        String s = readFileContent("/Users/v0pr/Documents/imhtml.html");
        String s1 = html2Str(s)
                .replaceAll("<[a-zA-Z]+.*?>([\\s\\S]*?)</[a-zA-Z]*?>" + System.lineSeparator(), "");

        s1 = s1.replace(" ", "");
        int length = s1.length();

        System.err.println(length);//1584
        System.err.println(s1);




    }

    private static String extractText(Node node) {
        if (node instanceof TextNode) {
            return ((TextNode) node).text();
        }
        List<Node> children = node.childNodes();
        StringBuffer buffer = new StringBuffer();
        for (Node child : children) {
            buffer.append(extractText(child));
        }
        return buffer.toString();
    }

    public static String html2Str(String html) {
        Document doc = Jsoup.parse(html);
        return extractText(doc);
    }

    public static String readFileContent(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        StringBuffer sbf = new StringBuffer();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempStr;
            while ((tempStr = reader.readLine()) != null) {
                sbf.append(tempStr);
            }
            reader.close();
            return sbf.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return sbf.toString();
    }
}
