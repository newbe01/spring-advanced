package com.advanced.proxy;

import com.advanced.proxy.config.AppV1Config;
import com.advanced.proxy.config.AppV2Config;
import com.advanced.proxy.config.v1_proxy.ConcreteProxyConfig;
import com.advanced.proxy.config.v1_proxy.InterfaceProxyConfig;
import com.advanced.proxy.trace.logtrace.LogTrace;
import com.advanced.proxy.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

//@Import(AppV1Config.class)
//@Import({AppV1Config.class, AppV2Config.class})
//@Import(InterfaceProxyConfig.class)
@Import(ConcreteProxyConfig.class)
@SpringBootApplication(scanBasePackages = "com.advanced.proxy.app.v3")
public class ProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProxyApplication.class, args);
	}

	@Bean
	public LogTrace logTrace() {
		return new ThreadLocalLogTrace();
	}

}
