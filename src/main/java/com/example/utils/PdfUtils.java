package com.example.utils;


import com.aspose.words.Document;
import com.aspose.words.License;
import com.aspose.words.SaveFormat;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * @author wusubin
 * @date 2019-07-31 10:00
 */
@Slf4j
@Component
public class PdfUtils {

    private static String s = "<License><Data><Products><Product>Aspose.Total for Java</Product><Product>Aspose.Words for Java</Product></Products><EditionType>Enterprise</EditionType><SubscriptionExpiry>20991231</SubscriptionExpiry><LicenseExpiry>20991231</LicenseExpiry><SerialNumber>8bfe198c-7f0c-4ef8-8ff0-acc3237bf0d7</SerialNumber></Data><Signature>sNLLKGMUdF0r8O1kKilWAGdgfs2BvJb/2Xp8p5iuDVfZXmhppo+d0Ran1P9TKdjV4ABwAgKXxJ3jcQTqE/2IRfqwnPf8itN8aFZlV3TJPYeD3yWE7IT55Gz6EijUpC7aKeoohTb4w2fpox58wWoF3SNp6sK6jDfiAUGEHYJ9pjU=</Signature></License>";

    public static void word2pdf(String docPath, String pdfPath) throws Exception {

        /**
         *  验证License 若不验证则转化出的pdf文档会有水印产生
         */
        ByteArrayInputStream is = new ByteArrayInputStream(s.getBytes());
        License license = new License();
        license.setLicense(is);
        Document document = new Document(docPath);
        document.save(new FileOutputStream(new File(pdfPath)), SaveFormat.PDF);
    }

}





