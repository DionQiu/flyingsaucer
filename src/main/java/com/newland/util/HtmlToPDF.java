package com.newland.util;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.BaseFont;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;

/**
 * @Author qyw
 * @Description TODO
 * @Date Created in 14:21 2018/7/3
 */
public enum  HtmlToPDF {

 INTANCE;
/**
* @Author newland
* @Description TODO
* @Date Created in 16:36 2018/7/3
* @Param [html, pdfPath] html:html文件路径或字符串 pdfPath:生成的pdf路径
* @Return boolean
**/
 public static boolean HtmlFileToPDF(String html,String pdfPath) {
     String            inputFile    = html;
     String            outFile      = pdfPath;
     OutputStream     os=null;
     boolean result=true;
     try {
         /*String            inputFile    = "E:\\ideaProjects\\flyingsaucer\\html\\table.html";
         String            outFile      = "C:/Users/newland/Desktop/testHtmlFile.pdf";*/
         os           = new FileOutputStream(outFile);
         ITextRenderer     renderer     = new ITextRenderer();
         ITextFontResolver fontResolver = renderer.getFontResolver();
         //添加字体,windows下解决中文乱码
         fontResolver.addFont("C:/Windows/Fonts/simsun.ttc", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);//宋体
         //fontResolver.addFont("C:/Windows/Fonts/simhei.ttf",BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);//黑体
         String url = new File(inputFile).toURI().toURL().toString();
         if(html.endsWith(".html") || html.endsWith(".htm")){
             renderer.setDocument(url);
         }else{
             renderer.setDocumentFromString(html);
         }
         renderer.layout();
         renderer.createPDF(os);
         os.close();
     }catch (Exception e){
         result=false;
         System.out.println("HTML文件转PDF失败,原因:"+e.getMessage());
         e.printStackTrace();
     }finally {
         if(os!=null){
             try {
                 os.close();
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
     }
      return result;
 }

}
