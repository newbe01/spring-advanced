package com.advanced.proxy;

import com.advanced.proxy.config.v2_dynamicproxy.DynamicProxyBasicConfig;
import com.advanced.proxy.config.v2_dynamicproxy.DynamicProxyFilterConfig;
import com.advanced.proxy.config.v3_proxyfactory.ProxyFactoryConfigV1;
import com.advanced.proxy.config.v3_proxyfactory.ProxyFactoryConfigV2;
import com.advanced.proxy.trace.logtrace.LogTrace;
import com.advanced.proxy.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

//@Import(AppV1Config.class)
//@Import({AppV1Config.class, AppV2Config.class})
//@Import(InterfaceProxyConfig.class)
//@Import(ConcreteProxyConfig.class)
//@Import(DynamicProxyBasicConfig.class)
//@Import(DynamicProxyFilterConfig.class)
//@Import(ProxyFactoryConfigV1.class)
@Import(ProxyFactoryConfigV2.class)
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
