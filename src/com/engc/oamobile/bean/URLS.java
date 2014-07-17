package com.engc.oamobile.bean;
/**
 *  接口请求URL帮助类
 * @author Administrator
 *
 */
public class URLS {

	public static final String BASEHOST = "http://172.16.17.33:8081/";
	public static final String ENGINEERURL = "jl/";

	//拉取在线审批 列表
	public static final String GET_ONLINE_AUDIT_LIST ="approvelist.get";

	//发文审批项目详情
	public static final String GET_FLOWOFFICEDOC_DETAIL = BASEHOST + ENGINEERURL
			+ "flowofficedoc.get";

	//收文审批详情
	public static final String GET_CONSUMERE_LIST = BASEHOST + ENGINEERURL
			+ "flowincoming.get";

	//请假审批详情
	public static final String GET_CONSUMERERECORD = BASEHOST + ENGINEERURL
			+ "leave.get";

	public static final String LOGIN = BASEHOST + ENGINEERURL
			+ "phoneInterface/login.do";
}
