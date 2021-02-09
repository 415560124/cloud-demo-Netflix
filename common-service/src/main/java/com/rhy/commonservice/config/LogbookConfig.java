package com.rhy.commonservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zalando.logbook.DefaultSink;
import org.zalando.logbook.Logbook;
import org.zalando.logbook.StreamHttpLogWriter;
import org.zalando.logbook.json.JsonHttpLogFormatter;

/**
 * @author: Herion Lemon
 * @date: 2021/2/8 22:57
 * @slogan: 如果你想攀登高峰，切莫把彩虹当梯子
 * @description: logbook日志配置
 */
@Configuration
public class LogbookConfig {
    @Bean
    public Logbook logbook(){
        return Logbook.builder()
                /**
                 * {@link JsonHttpLogFormatter}HTTP格式化方式
                 * {@link StreamHttpLogWriter}日志写入级别
                 */
                .sink(new DefaultSink(new JsonHttpLogFormatter(),
                        new StreamHttpLogWriter(System.out)))
                .build();
    }
}
