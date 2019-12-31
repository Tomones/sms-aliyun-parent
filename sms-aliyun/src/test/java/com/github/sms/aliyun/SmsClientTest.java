package com.github.sms.aliyun;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SmsClientTest {

    public void sendSmsTest() {
        String accessKeyId = "LTAI************";
        String accessKeySecret = "Ijs3************";
        String signName = "中路******";
        String templateCode = "SMS_155*****";
        SmsClient smsClient = new SmsClient(accessKeyId, accessKeySecret);
        SmsTemplate smsTemplate = SmsTemplate.builder()
                .signName(signName)
                .templateCode(templateCode)
                .addTemplateParam("code", "123456")
                .phoneNumbers(Arrays.asList("185*****397"))
                .build();
        smsClient.send(smsTemplate);
    }
}