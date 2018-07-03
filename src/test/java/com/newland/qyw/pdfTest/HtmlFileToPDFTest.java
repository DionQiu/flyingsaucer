package com.newland.qyw.pdfTest;

import com.newland.util.HtmlToPDF;
import org.junit.Test;

/**
 * @Author qyw
 * @Description TODO
 * @Date Created in 14:27 2018/7/3
 */


public class HtmlFileToPDFTest {

    @Test
    public void test() throws Exception{


        String            inputFile    = "E:\\ideaProjects\\flyingsaucer\\html\\table.html";
        String htmlstr = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\"/>\n" +
                "    <title>Title</title>\n" +
                "    <style>\n" +
                "        body{MARGIN:AUTO;width:690px;font-size:12px; font-family:SimSun,SimHei; color:#222;}\n" +
                "\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div class=\"entry\">\n" +
                "    <h4>横跨两列的单元格：</h4>\n" +
                "    <table border=\"1\">\n" +
                "        <tr>\n" +
                "            <th>姓名</th>\n" +
                "            <th colspan=\"2\">电话</th>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td>Bill Gates</td>\n" +
                "            <td>555 77 854</td>\n" +
                "            <td>555 77 855</td>\n" +
                "        </tr>\n" +
                "    </table>\n" +
                "\n" +
                "    <h4>横跨两行的单元格：</h4>\n" +
                "    <table border=\"1\">\n" +
                "        <tr>\n" +
                "            <th>姓名</th>\n" +
                "            <td>Bill Gates</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <th rowspan=\"2\">电话</th>\n" +
                "            <td>555 77 854</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td>555 77 855</td>\n" +
                "        </tr>\n" +
                "    </table>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>";
        String            outFile      = "C:/Users/newland/Desktop/testHtmlToPdf.pdf";
        boolean           result            = HtmlToPDF.INTANCE.HtmlFileToPDF(inputFile, outFile);
        if(result){
            System.out.println("转换成功");
        }else {
            System.out.println("转换失败");
        }
    }
}
