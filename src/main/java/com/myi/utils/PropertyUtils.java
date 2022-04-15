package com.myi.utils;

import com.myi.constants.FrameworkConstant;
import com.myi.enums.ConfigProperties;
import com.myi.exceptions.PropertyFileUsageException;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public final class PropertyUtils {
    private static Properties properties = new Properties();
    private static final Map<String, String> CONFIGMAP = new HashMap<>();
//FileInputStream fileInputStream = new FileInputStream(FrameworkConstant.getConfigFilePath())
    static {
        try(InputStream fileInputStream = PropertyUtils.class.getClassLoader()
                .getResourceAsStream(FrameworkConstant.getConfigFilePath())) {
            properties.load(fileInputStream);
            for(Map.Entry<Object, Object> propertiesMapValue : properties.entrySet()){
                CONFIGMAP.put(String.valueOf(propertiesMapValue.getKey()),
                        String.valueOf(propertiesMapValue.getValue()));
            }
        }  catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
    public static String getConfigValue(ConfigProperties configProperties){
        if(Objects.isNull(CONFIGMAP.get(configProperties.name().toLowerCase()))){
            throw new PropertyFileUsageException(configProperties + " not found. " +
                    "Pls check config.properties");
        }
        return CONFIGMAP.get(configProperties.name().toLowerCase());
    }

}
