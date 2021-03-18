package org.mazhuang.httptest;

import cn.hutool.core.lang.Console;
import cn.hutool.http.HttpRequest;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author mazhuang
 */
@SpringBootApplication
public class HttpTestApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(HttpTestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String url = "https://baidu.com";

		testHuTool(url);

		testHttpUrlConnection(url);

		testHttpClientLegacy(url);
	}

	private void testHttpClientLegacy(String url) throws IOException {
		HttpClient httpclient = new HttpClient();
		PostMethod httpPost = new PostMethod(url);
		try {
			httpclient.executeMethod(httpPost);
			System.out.println(httpPost.getStatusLine());
		} finally {
			httpPost.releaseConnection();
		}
	}

	private void testHuTool(String url) {
		String result = HttpRequest.post(url)
				.body("{}")
				.setSSLProtocol("TLSv1.2")
				.execute()
				.body();

		Console.log(result);
	}

	private void testHttpUrlConnection(String url) throws IOException {
		URL uri = new URL(url);
		URLConnection conn = uri.openConnection();
		System.out.println("Successfully connected: " + ((HttpURLConnection) conn).getResponseCode());
	}
}
