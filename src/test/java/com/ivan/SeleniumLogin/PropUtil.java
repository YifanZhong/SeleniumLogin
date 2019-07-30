package com.ivan.SeleniumLogin;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropUtil {

    private Properties properties;

    private String filePath;

    /**
     * 构造方法
     * @param filePath
     */
    public PropUtil(String filePath) throws IOException {
        this.filePath = filePath;
        this.properties = readProperties();
    }


    /**
     * 读取配置文件
     */
    private Properties readProperties() throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = new FileInputStream(filePath);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        properties.load(bufferedInputStream);

        return properties;
    }

    public String getProperties(String key){
        //Properties properties = new Properties();
        //InputStream inputStream = new BufferedInputStream(new FileInputStream("element.properties"));
        //properties.load(inputStream);


        //String username = properties.getProperty("username");
        if (properties.containsKey(key)){
            String username = properties.getProperty(key);
            return username;
        }else{
            System.out.println("No key!");
            return "";
        }


        //System.out.println(username);
        //return username;
    }

//
//    public static void main(String[] args) throws Exception {
//        PropUtil propUtil = new PropUtil();
//        propUtil.getProperties();
//    }
}
