package com.pdfbox.demo;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author zyz
 * <p>
 * pdf转pngdemo
 */
public class PdfBoxDemo {

    public static void main(String[] args) {

        //调用方法
        String pdfPath = "D:\\614531207560171520.pdf";
        pdfToPng(pdfPath);

    }


    /**
     * pdf转png方法
     *
     * @param pdfPath pdf路径
     */
    public static void pdfToPng(String pdfPath) {
        String savePath = "D://";

        try (final PDDocument document = PDDocument.load(new File(pdfPath))) {
            PDFRenderer pdfRenderer = new PDFRenderer(document);
            BufferedImage bim = pdfRenderer.renderImageWithDPI(0, 300, ImageType.RGB);
            String fileName = savePath + "demo" + ".png";
            ImageIOUtil.writeImage(bim, fileName, 300);
            document.close();
        } catch (IOException e) {
            System.out.println("生成pdf失败" + e.getMessage());
        }

    }
}
