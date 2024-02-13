package com.advanced.proxy.pureproxy.decorator;

import com.advanced.proxy.pureproxy.decorator.code.Component;
import com.advanced.proxy.pureproxy.decorator.code.DecoratorPatternClient;
import com.advanced.proxy.pureproxy.decorator.code.MessageDecorator;
import com.advanced.proxy.pureproxy.decorator.code.RealComponent;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class DecoratorPatternTest {


    @Test
    void noDecorator() {
        Component component = new RealComponent();

        DecoratorPatternClient client= new DecoratorPatternClient(component);
        client.execute();
    }

    @Test
    void decorator1() {
        Component realComponent = new RealComponent();
        Component messageDecorator = new MessageDecorator(realComponent);
        DecoratorPatternClient client = new DecoratorPatternClient(messageDecorator);

        client.execute();
    }
}
