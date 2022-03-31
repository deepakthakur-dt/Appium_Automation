package Base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    Properties pro;

    public ConfigReader() {

        File src = new File("./config/config.properties");
        try {
            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis);
        } catch (Exception e) {
            System.out.println("Exception is " + e.getMessage());
        }
    }

    public String getP_Name() {
        String p_name = pro.getProperty("P_name");
        return p_name;
    }

    public String getPlatformName() {
        String pname = pro.getProperty("Platform_name");
        return pname;
    }

    public String getPlatformVersion() {
        String pversion = pro.getProperty("Platform_version");
        return pversion;
    }
    public String getPVersion() {
        String p_version = pro.getProperty("P_version");
        return p_version;
    }

    public String getDeviceName() {
        String dname = pro.getProperty("Device_name");
        return dname;
    }
    public String getDName() {
        String d_name = pro.getProperty("D_name");
        return d_name;
    }


    public String getApp() {
        String app = pro.getProperty("app");
        return app;
    }

    public String getUrl() {
        String url = pro.getProperty("url");
        return url;
    }
    public String getBrowserstack_u() {
        String u_name = pro.getProperty("Browserstack_u");
        return u_name;
    }
    public String getBrowserstack_k() {
        String u_key = pro.getProperty("Browserstack_k");
        return u_key;
    }
    public String getBrowserstack_url() {
        String b_url = pro.getProperty("app_url");
        return b_url;
    }
}
