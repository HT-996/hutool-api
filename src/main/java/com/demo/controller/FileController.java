package com.demo.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author HuTing
 * @date 2020-06-04 14:23
 */
@SpringBootApplication
@RestController
public class FileController {

    public static void main(String[] args) {
        SpringApplication.run(FileController.class, args);
        System.out.println("http://localhost:9999/test");
        System.out.println("http://localhost:9999/download");
        System.out.println("http://localhost:9999/downloadSplitFloder");
    }

    @RequestMapping(value = "test")
    public String test() {
        return new Date().toString();
    }

    @RequestMapping(value = "download")
    public void download(HttpServletRequest request, HttpServletResponse response) {
        try {
            String downloadFilename = "图片在一个文件夹.zip";
            downloadFilename = URLEncoder.encode(downloadFilename, "UTF-8");
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;filename=" + downloadFilename);
            ZipOutputStream zos;
            zos = new ZipOutputStream(response.getOutputStream());
            String[] files = new String[]{"http://okyd.oss-cn-beijing.aliyuncs.com/img/157164690500022537.jpg", "http://okyd.oss-cn-beijing.aliyuncs.com/img/157164694074782832.jpg"};
            for (int i = 0; i < files.length; i++) {
                URL url = new URL(files[i]);
                zos.putNextEntry(new ZipEntry(i + ".jpg"));
                //读取网络文件
                InputStream fis = url.openConnection().getInputStream();
                byte[] buffer = new byte[1024];
                int r = 0;
                while ((r = fis.read(buffer)) != -1) {
                    zos.write(buffer, 0, r);
                }
                fis.close();
            }
            zos.flush();
            zos.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    @RequestMapping(value = "downloadSplitFloder")
//    public void downloadSplitFloder(HttpServletRequest request, HttpServletResponse response) {
//        try {
//            String downloadFilename = "图片分成2个文件夹.zip";
//            downloadFilename = URLEncoder.encode(downloadFilename, "UTF-8");
//            response.setContentType("application/octet-stream");
//            response.setHeader("Content-Disposition", "attachment;filename=" + downloadFilename);
//            ZipOutputStream zos = new ZipOutputStream(response.getOutputStream());
//            String[] files = new String[]{"http://okyd.oss-cn-beijing.aliyuncs.com/img/157164690500022537.jpg", "http://okyd.oss-cn-beijing.aliyuncs.com/img/157164694074782832.jpg"};
//            for (int i = 0; i < files.length; i++) {
//                URL url = new URL(files[i]);
//                zos.putNextEntry(new ZipEntry("文件夹" + i + "/" + i + ".jpg"));
//                //读取网络文件
//                InputStream fis = url.openConnection().getInputStream();
//                byte[] buffer = new byte[1024];
//                int r = 0;
//                while ((r = fis.read(buffer)) != -1) {
//                    zos.write(buffer, 0, r);
//                }
//                fis.close();
//            }
//            zos.flush();
//            zos.close();
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}
