package com.github.sms.aliyun;

import lombok.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 阿里云 SMS 短信模板.
 *
 * @author cn-src
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SmsTemplate {
    private String signName;
    private String templateCode;
    private Map<String, String> templateParam;
    private List<String> phoneNumbers;
    private String smsDomain;

    public static Builder builder() {
        return new SmsTemplate.Builder();
    }

    public static class Builder {
        private String signName;
        private String templateCode;
        private Map<String, String> templateParam;
        private List<String> phoneNumbers;
        private String smsDomain;

        Builder() {
        }

        public SmsTemplate.Builder signName(String signName) {
            this.signName = signName;
            return this;
        }

        public SmsTemplate.Builder templateCode(String templateCode) {
            this.templateCode = templateCode;
            return this;
        }

        public SmsTemplate.Builder templateParam(Map<String, String> templateParam) {
            this.templateParam = templateParam;
            return this;
        }

        /**
         * 添加短信模板参数.
         *
         * @param key   the key
         * @param value the value
         * @return this
         */
        public Builder addTemplateParam(final String key, final String value) {
            if (null == this.templateParam) {
                this.templateParam = new HashMap<>(3);
            }

            this.templateParam.put(key, value);
            return this;
        }

        public SmsTemplate.Builder phoneNumbers(List<String> phoneNumbers) {
            this.phoneNumbers = phoneNumbers;
            return this;
        }

        public SmsTemplate.Builder smsDomain(String smsDomain) {
            this.smsDomain = smsDomain;
            return this;
        }

        public SmsTemplate build() {
            return new SmsTemplate(this.signName, this.templateCode, this.templateParam, this.phoneNumbers, this.smsDomain);
        }

        @Override
        public String toString() {
            return "SmsTemplate.Builder(signName=" + this.signName + ", templateCode=" + this.templateCode + ", templateParam=" + this.templateParam + ", phoneNumbers=" + this.phoneNumbers + ",smsDomain=" + this.smsDomain + ")";
        }
    }
}
