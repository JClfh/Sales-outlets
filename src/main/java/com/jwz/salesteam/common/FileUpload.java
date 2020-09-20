package com.jwz.salesteam.common;

import sun.misc.BASE64Decoder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author ：Jiang Weizan
 * @date ：Created in 2020/9/18 15:14
 * @description：文件上传
 * @modified By：
 * @version: 1.0
 */
public class FileUpload {

    public FileUpload() {
    }

    /**
     *
     * 文件上传
     * @param base64
     * @return
     */
    public static String fileUpload(String base64){
        try {
            //取得返回json中的Content数据String content = JSONPath.read(json, "$.Content").toString());//去掉前面的“data:image/jpeg;base64,”的字样
            String imgdata = base64.replace("data:image/jpeg;base64,","");

            //解码base64
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] data = decoder.decodeBuffer(imgdata);
            for(int i =0 ; i < data.length ;i++) {
                if(data[i] < 0) {
                    data[i] += 256;
                }
            }

            //生成文件名字
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
            Random r = new Random();
            StringBuilder tempName = new StringBuilder();
            tempName.append(sdf.format(new Date())).append(r.nextInt(100));
            String newFileName = tempName.toString();
            //String savePath = this.getServletContext().getRealPath("/LoadJsp");
            //文件夹不存在，创建
            File fileDirectory = new File("..\\saleSteam\\src\\main\\resources\\static\\upload\\");
//            System.out.println(fileDirectory);
            if (!fileDirectory.exists()) {
                if (!fileDirectory.mkdir()) {
                    throw new IOException("文件夹创建失败,路径为：" + fileDirectory);
                }
            }

            //生成文件
            FileOutputStream fos = new FileOutputStream ("..\\saleSteam\\src\\main\\resources\\static\\upload\\"+newFileName+".jpg");
            fos.write(data);
            fos.flush();
            fos.close();
            return "/upload/"+newFileName + ".jpg";
        }catch (Exception e){
            return ServiceResultEnum.UPLOAD_ERROR.getResult();
        }
    }
}
