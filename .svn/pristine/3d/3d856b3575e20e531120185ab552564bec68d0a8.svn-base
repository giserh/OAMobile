package com.engc.oamobile.test;

import com.engc.eop.ClientRequest;
import com.engc.eop.CompositeResponse;
import com.engc.eop.DefaultEngcOpenClient;
import com.engc.eop.EopClient;
import com.engc.eop.MessageFormat;
import com.engc.eop.Utils.SignUtils;
import com.engc.oamobile.support.utils.EopClientConstants;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EopClient client = new DefaultEngcOpenClient(
				"http://172.16.17.57:8080/EduOpenPlatform/api",
				"20140521151916944001", "aa768f4e27aed5fb797a71de78c92fcd",
				MessageFormat.json, SignUtils.sign_method_MD5);
		ClientRequest request = client.buildClientRequest();
		request.addParam("schoolOrgid", "060082");

		/*
		 * request.addParam("usercode", userCode); request.addParam("orgid",
		 * orgId); request.addParam("status", auditStatus);
		 * request.addParam("approvetype", approveType); if (pageNo != null)
		 * request.addParam("pageno", pageNo); if (pageSize != null)
		 * request.addParam("pagesize", pageSize);
		 */

		// try {
		CompositeResponse<?> res = request.post("getSameSchoolTopic",
				EopClientConstants.VERSION);

	}

}
