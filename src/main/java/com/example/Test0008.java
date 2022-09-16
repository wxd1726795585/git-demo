package com.example;

import com.example.enums.Season;
import com.example.utils.PdfUtils;

import java.io.File;
import java.util.ArrayList;

/**
 * \* Created with WXD.
 * \* Date:  2022/3/2
 * \* Description:
 * \* @author 王祥栋
 */
public class Test0008{
    public static void main(String[] args) {
        File file = new File("D:" + File.separator + "wxd.txt");
        long length = file.length();
        System.out.println(length);

    }
    private static  void word2pdf(String filePath, String pdfBdUrl) {
        try {
            PdfUtils.word2pdf(filePath, pdfBdUrl);
        } catch (Exception e) {
        }
    }
}
