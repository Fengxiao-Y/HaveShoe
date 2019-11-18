package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016091700529756";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC4E2lPumCj+Qb1gF5VGpGygci9i+7ZMxslSfKP2w15muBjojBUFXpumkBKL/RMSseP74sGjBpp8g+lkA4QiJsSEiQCKYJKdw/ZSwHez5xOFWQmZfbL9c3xFyeL3sZFC9uwiii4wz8CzH0qK2B04qav0TveKZeTzR/nvp2cR8eCQUikoLwN7HH7FBKZo8nnWBrOudN2dIfUaBqHcY54QqXaGBDjSY7YBhyNx3CCQjriLvBJKdZQRKkFIfQpC+LUM7wzLJ9QlNh96tiE/Lv/Dn9/02gSczOMun/JAVTlAfj+DYFSec+1tNcmcDpRHLJSkbErmM7NCtIB2+2rfqIDLDG1AgMBAAECggEAXMRLmoaPFZP20dqzr6gILTIC/KN857E9yPkPaTg3/kTzOMMQIBAC96J9K+Ym9BvrnrpWEiKhXStEf2et7t8pZ14FD6Hjq6t9LUED3Eo8t41IP6G7Uua5tvq4T2EiAsILIVk/VH3xT3PG0G2z2rQu1QRZa4kCftYtchk6TPxPq3Bn8REMqaBxchkXBnOQOhP3mOlIek1jsGZlC1WBWK1TEKPfmkJj3ZiESLI8PdZkk47jClBEPSC8Ia1E5wEoknWcffGEbM+GgYHmJOJeyJ4QibyyFaWHKu0JsKE9lPNhIO9dlFfVbiAQahUIUJ6Ffg/EC7vZoyTdoYwjkKRLnYNUMQKBgQDnVn0IS6niO/+1sTwHGz9svMTj8w/RfjsaU9MMfa6H175s/YYSqVUOslC1PGMsRGMvXGSSEnW429gscnWH/e3AdiD5u6zbwdiLN/JnDf8p71uQW60FqlOHgHkru/RxGHYuQOniIjW+AxlnZY4AmkQt+KI7bmG/EcLpnV/ybzx7cwKBgQDLsxSuzvaMAZgu5sXmONtfQE0Jxt/oHXv83u1wSiUn6kyd3b/Hdc/Tl2P3g1ziNBuBurxJYJZYmFVq6oi3YwusR1a4Wh99XLsnBTsqaXkMhTwxPD/VJb3GudwaOv8o7d2Hb8W8usxHSU7OaWlhSoIEVahPmlLgecXS0JP404ikNwKBgQC9W2IExEpOUGZCxswn1PnZe7p+C5rLE9Q0/KAn/Ug7ETFh7TMtW0WwPe0qLD/RIDk/rxTzLAEIS4tq9lWV9xgBDbB4OlKHnugtLKJSEHboUHBWfXPmy0CMDXEhhzvSxv8VZTUMUIxE+Cx3If1WKO/d4UKJ+xQvXc55gsPioYKUWQKBgQCjfgu2tqSKAOmdk1n5i17/l4N9umKSUb/nWSIoA0rJO7Pc7VN1CykQgi0ZRxUw9XOybyeamWxylWnRk4bB8jw3PVbsRmGJ4/jOu9MeGmOu2e1S8zGkqVMlgp2XbAzKVAh/IQYLkb5N5RfcchzDmuK6Ceo6Yfns87AEoaZyi43bhwKBgGaiSEtxDCsUluCOW6pD0pSdaYqmBzDDmlkloKL/UDdKaqAJ1nhXvjQgJQsqU/LN4Mw3RqIRmO/sTDOvOu3oO21Jv/dSeaIFjtpWnAqDQ8b6bzQCBHoifXrp9LreFm/FPESeEblwoOCzws/llNWf6JLxW6aSikDnnAUnNQsu6vi4";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAuBNpT7pgo/kG9YBeVRqRsoHIvYvu2TMbJUnyj9sNeZrgY6IwVBV6bppASi/0TErHj++LBowaafIPpZAOEIibEhIkAimCSncP2UsB3s+cThVkJmX2y/XN8Rcni97GRQvbsIoouMM/Asx9KitgdOKmr9E73imXk80f576dnEfHgkFIpKC8Dexx+xQSmaPJ51gazrnTdnSH1Ggah3GOeEKl2hgQ40mO2AYcjcdwgkI64i7wSSnWUESpBSH0KQvi1DO8MyyfUJTYferYhPy7/w5/f9NoEnMzjLp/yQFU5QH4/g2BUnnPtbTXJnA6URyyUpGxK5jOzQrSAdvtq36iAywxtQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/Youjia/jsp/home.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "https://openapi.alipaydev.com/gateway.do";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

