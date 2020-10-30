package com.zbw.server.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class FileConfig implements WebMvcConfigurer {
    //配置虚拟目录 即url路径
    @Value("${file.vpath}")
    private String vpath;
    //配置访问的储存路径
    @Value("${file.diskPath}")
    private String diskPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
            //通过url:  http://localhost:8080/file/文件名.后缀名  就能访问
            .addResourceHandler(this.vpath+"/**")
            //file:D:\\background\\upload
            .addResourceLocations("file:"+this.diskPath);
    }
}
