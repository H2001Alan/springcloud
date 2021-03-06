package springcloud.service.impl;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import springcloud.service.IMessageProvider;

import javax.annotation.Resource;
import java.util.UUID;

@EnableBinding(Source.class)//定义消息的推送管道
public class IMessageProviderImpl implements IMessageProvider {
    @Resource
    private MessageChannel output;//消息发生管道
    @Override
    public String send() {
        String serial= UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        return null;
    }
}
