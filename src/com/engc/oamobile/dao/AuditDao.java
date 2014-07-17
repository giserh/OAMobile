package com.engc.oamobile.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.engc.eop.ClientRequest;
import com.engc.eop.CompositeResponse;
import com.engc.eop.DefaultEngcOpenClient;
import com.engc.eop.EopClient;
import com.engc.eop.MessageFormat;
import com.engc.eop.Utils.SignUtils;

import com.engc.oamobile.bean.AuditBean;
import com.engc.oamobile.bean.URLS;
import com.engc.oamobile.support.http.HttpMethod;
import com.engc.oamobile.support.http.HttpUtility;
import com.engc.oamobile.support.utils.EopClientConstants;

/**
 * 审批相关访问层
 * 
 * @author Administrator
 * 
 */
public class AuditDao {

	/**
	 * 
	 * @param orgId
	 *            组织机构ID
	 * @param userCode
	 * @param auditStatus
	 *            审批状态 0待审核，1审核通过，2审核不通过，3审批中，4审批通过并转交审批
	 * @param approveType
	 *            审批类别
	 * @param pageNo
	 *            当前 页码
	 * @param pageSize
	 *            每页显示条数 默认 20
	 * @return
	 */
	public static List<AuditBean> getAuditList(final String orgId,
			final String userCode, final String auditStatus,
			final String approveType, final String pageNo, final String pageSize) {
		EopClient client = new DefaultEngcOpenClient(
				"http://172.16.17.59:8080/EduOpenPlatform/api",
				"20140521151916944001", "aa768f4e27aed5fb797a71de78c92fcd",
				MessageFormat.json, SignUtils.sign_method_MD5);
		ClientRequest request = client.buildClientRequest();

		
		  request.addParam("usercode", userCode);
		  request.addParam("orgid", orgId); 
		  request.addParam("status", auditStatus);
		  request.addParam("approvetype", approveType); 
		  if (pageNo != null)
		  request.addParam("pageno", pageNo); 
		  if (pageSize != null)
		  request.addParam("pagesize", pageSize);
		 
		List<AuditBean> newsList = new ArrayList<AuditBean>();
		String Json;


		try {
			 CompositeResponse<?> res = request.post("approvelist.get",
			 EopClientConstants.VERSION);
			 if (res.isSuccessful()) {
			 newsList = JSON.parseArray(res.getResponseContent(),
			 AuditBean.class);

			 }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newsList;

	}

}