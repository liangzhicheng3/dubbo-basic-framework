package com.liangzhicheng.config.http;

import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import javax.net.ssl.SSLContext;
import java.security.NoSuchAlgorithmException;

/**
 * @description http连接管理相关类
 * @author liangzhicheng
 * @since 2021-08-28
 */
public class HttpConnectionManager {

	/**
	 * http连接池管理
	 */
	private PoolingHttpClientConnectionManager cm = null;

	/**
	 * http连接管理
	 */
	private static HttpConnectionManager connectionManager;

	/**
	 * @description 获取http连接实例
	 * @return HttpConnectionManager
	 */
	public static HttpConnectionManager getInstance() {
		if (connectionManager == null) {
			synchronized (HttpConnectionManager.class) {
				if (connectionManager == null) {
					connectionManager = new HttpConnectionManager();
					connectionManager.init();
				}
			}
		}
		return connectionManager;
	}

	/**
	 * @description 初始化
	 */
	private void init() {
		LayeredConnectionSocketFactory sslsf = null;
		try {
			sslsf = new SSLConnectionSocketFactory(SSLContext.getDefault());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();			
		}
		Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory> create()
				.register("https", sslsf).register("http", new PlainConnectionSocketFactory()).build();
		cm = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
		cm.setMaxTotal(200);
		cm.setDefaultMaxPerRoute(20);
	}

	public CloseableHttpClient getHttpClient() {
		return HttpClients.custom().setConnectionManager(cm).build();
	}

}
