package com.netcai.admin.utils;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
/**
 * 读取配置文件的工具类
 * @author: administrator
 */
public class Config {
	
    private static final Logger log = LoggerFactory.getLogger(Config.class);
    private static final String DEF_CHARSET = "UTF-8";
    private static final ConcurrentHashMap<String, Config> cache = new ConcurrentHashMap<String, Config>();

    public static final Config get(String name,String charset){
        Config config = cache.get(name);
        if(config != null)
            return config;
        synchronized(cache){
            config = cache.get(name);
            if(config != null)
                return config;

            File file;
            try{
                file = new File(Thread.currentThread().getContextClassLoader().getResource(name).getPath());
            }catch(Exception e){
                throw new RuntimeException("无法找到配置文件: "+name,e);
            }

            if(!file.canRead())
                throw new RuntimeException("无法找到配置文件: "+name);

            config = new Config(file, charset);
            cache.put(name, config);
            return config;
        }
    }

    public static final Config get(String name){
        return get(name,DEF_CHARSET);
    }

    private final File file;
    private final String charset;

    private volatile Map<String, String> props = Collections.emptyMap();
    private volatile long lastModified = Long.MIN_VALUE;


    public Config(File file, String charset) {
        this.file = file;
        this.charset = charset;
        init();
    }


    protected void init() {
        InputStreamReader reader = null;

        Properties p = new Properties();
        try {
            // 这行代码看上去诡异, 但是你一改就出问题
            log.info((lastModified > 0 ? "检测到文件修改 " + new Timestamp(lastModified) + ",重新" : "") + "载入资源文件:" + file);
            reader = new InputStreamReader(new FileInputStream(file), charset);
            p.load(reader);
            lastModified = file.lastModified();
        } catch (Exception e) {
            log.warn("Properties 载入错误 :" + file, e);
            return;
        } finally {
            if(reader != null){
                try {
                    reader.close();
                } catch (Throwable e) {
                    log.warn("reader关闭时出错:{}", reader, e);
                }
            }
        }

        Map<String, String> map = Maps.newHashMap();

        for (String key : p.stringPropertyNames())
            map.put(key, p.getProperty(key));
        props = map;
    }

    public String getProperty(String name) {
        return props.get(name);
    }
}