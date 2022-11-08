package tk.newsoulmate.web.common;

import tk.newsoulmate.domain.vo.Request;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * ApiKey
 */
public class APIKeys {
    public static Properties prop;{
        String FilePath= Request.class.getResource("/key/APIkey.xml").getPath();
        this.prop=new Properties();
        try {
            prop.loadFromXML(new FileInputStream("FilePath") );
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String NoticeKey=prop.getProperty("NoticeKey");

}
