package com.mwb.business.common.module;

import com.mwb.web.framework.http.client.AbstractHttpClient;

import java.util.Map;

/**
 * Created by MengWeiBo on 2017-01-24
 */
public class QrCode extends AbstractHttpClient {

//    1可以使用<img src="http://qr.topscan.com/api.php?text=x"/>进行引用
//    2下载图片 http://qr.topscan.com/api.php?text=x 进行引用
//    3直接引用网址 http://qr.topscan.com/api.php?text=x

    public static void main(String[] args) throws Exception {
        QrCode qrCode = new QrCode();
        String url = "http://qr.topscan.com/api.php?text=x";
        String s = qrCode.get(url, null, null);
        System.out.println(s);
    }

    @Override
    public String get(String url, Map<String, String> params, Map<String, String> headers) throws Exception {
        return super.get(url, params, headers);
    }
}
