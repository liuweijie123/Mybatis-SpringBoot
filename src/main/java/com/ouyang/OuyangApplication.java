package com.ouyang;

import com.github.tobato.fastdfs.FdfsClientConfig;
import com.ouyang.util.FastDFSClientWrapper;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author liuzh
 * @since 2015-12-12 18:22
 */
@Import(FdfsClientConfig.class)
@Controller
@EnableWebMvc
@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = "com.ouyang.mapper")
public class OuyangApplication extends WebMvcConfigurerAdapter {
	public static final Logger logger = LoggerFactory.getLogger(OuyangApplication.class);
	@Autowired
    private FastDFSClientWrapper dfsClient;
	
    public static void main(String[] args) {
    	logger.info("Springboot开始加载");
        SpringApplication.run(OuyangApplication.class, args);
        logger.info("Springboot加载完毕");
    }

    @RequestMapping("/")
    String home() {
        return "redirect:users/select";
    }

}
