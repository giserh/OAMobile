package com.engc.oamobile.support.http;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import com.engc.eop.DefaultEngcOpenClient;
import com.engc.eop.EopClient;
import com.engc.eop.MessageFormat;
import com.engc.eop.Utils.SignUtils;
import com.engc.oamobile.support.exception.AppException;
import com.engc.oamobile.support.file.FileDownloaderHttpHelper;
import com.engc.oamobile.support.file.FileUploaderHttpHelper;





public class HttpUtility {

	

	public EopClient getEopClient() {
		//EopClient client = new DefaultEngcOpenClient(getContextProperties()
				//.getProperty("EOPURI"), getContextProperties().getProperty(
				//"EOPKEY"), getContextProperties().getProperty("EOPSECRET"),
				//MessageFormat.json, SignUtils.sign_method_MD5);
		 EopClient client = new
		 DefaultEngcOpenClient("http://172.16.17.57:8080/EduOpenPlatform/api",
		 "20140521151916944001",
		 "aa768f4e27aed5fb797a71de78c92fcd",MessageFormat.json,SignUtils.sign_method_MD5);
		return client;
	}
	/**
	 * 获取assets 目录�?属�?文件
	 * 
	 * @return
	 */
	public static Properties getContextProperties() {
		Properties pro = new Properties();
		InputStream in = HttpUtility.class
				.getResourceAsStream("/assets/context.properties");
		try {
			pro.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pro;

	}

	private static HttpUtility httpUtility = new HttpUtility();

	private HttpUtility() {
	}

	public static HttpUtility getInstance() {
		return httpUtility;
	}

	public String executeNormalTask(HttpMethod httpMethod, String url,
			Map<String, String> param) throws Exception {
		return new JavaHttpUtility().executeNormalTask(httpMethod, url, param);
	}

	public boolean executeDownloadTask(String url, String path,
			FileDownloaderHttpHelper.DownloadListener downloadListener) {
		return !Thread.currentThread().isInterrupted()
				&& new JavaHttpUtility().doGetSaveFile(url, path,
						downloadListener);
	}

	public boolean executeUploadTask(String url, Map<String, String> param,
			String path, FileUploaderHttpHelper.ProgressListener listener)
			throws AppException {
		return !Thread.currentThread().isInterrupted()
				&& new JavaHttpUtility().doUploadFile(url, param, path,
						listener);
	}

}
