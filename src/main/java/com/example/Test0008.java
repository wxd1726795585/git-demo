package com.example;

import com.example.utils.PdfUtils;

import java.io.File;

/**
 * \* Created with WXD.
 * \* Date:  2022/3/2
 * \* Description:
 * \* @author 王祥栋
 */
public class Test0008{
    public static void main(String[] args) {
        word2pdf("D:\\jiankang.docx","D:\\a.pdf");

    }
    private static  void word2pdf(String filePath, String pdfBdUrl) {
        try {
            PdfUtils.word2pdf(filePath, pdfBdUrl);
        } catch (Exception e) {
        }
    }
}
