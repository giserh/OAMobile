package com.engc.oamobile.ui.audit;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.engc.oamobile.R;
import com.engc.oamobile.bean.AuditBean;
import com.engc.oamobile.dao.AuditDao;
import com.engc.oamobile.support.lib.MyAsyncTask;
import com.engc.oamobile.ui.adapter.AuditsListAdapter;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

/**
 * 未审核 fragment
 * 
 * @author Administrator
 * 
 */
public class UnAuditFragment extends Fragment {
	private AuditsListAdapter adapter;
	protected PullToRefreshListView pullToRefreshListView;
	private List<AuditBean> auditList = new ArrayList<AuditBean>();
	private View view;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.onlineaudit_list, container, false);
		initView();

		return view;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 new GetAuditListDataTask().execute("1000", "1", "0","0");
		

	}

	protected ListView getListView() {
		return pullToRefreshListView.getRefreshableView();
	}

	/*	*//**
	 * 刷新数据
	 * 
	 * @Title: refresh
	 * @Description: TODO
	 * @return: void
	 */

	private void initView() {
		/*
		 * txtEmpty = (TextView) findViewById(R.id.empty); progressBar =
		 * (ProgressBar) findViewById(R.id.progressbar);
		 */
		pullToRefreshListView = (PullToRefreshListView) view
				.findViewById(R.id.listView);
		pullToRefreshListView
				.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {

					@Override
					public void onRefresh(
							PullToRefreshBase<ListView> refreshView) {

						// refresh();

						// getNewsThread("1", "5", "10");

						new GetAuditListDataTask().execute("1000", "1", "0",
								"0");
			

						// new Finish

					}
				});

		pullToRefreshListView
				.setOnLastItemVisibleListener(new PullToRefreshBase.OnLastItemVisibleListener() {
					@Override
					public void onLastItemVisible() {
						// /listViewFooterViewClick(null);
					}
				});

	}
	
	

	/**
	 * 
	 * Copyright © 2014ENGC. All rights reserved.
	 * 
	 * @Title: NewsActivity.java
	 * @Package: com.engc.jlcollege.ui.news
	 * @Description: 通过异步任务 加载 数据
	 * @author: Administrator
	 * @params MyAsyncTask <Params, Progress, Result> Params 这个参数 为传入参数
	 *         ，指定执行异步任务传入参数的类型， Progress 这个参数为将执行进度 返回给UI线程的类型 Result 这个参数表示
	 *         任务执行完需要返回给UI 线程结果的参数
	 * @date: 2014-7-9 下午3:21:20
	 */

	private class GetAuditListDataTask extends
			MyAsyncTask<String, Void, List<AuditBean>> {

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.engc.jlcollege.support.lib.MyAsyncTask#doInBackground(Params[])
		 */
		@Override
		protected List<AuditBean> doInBackground(String... params) {
			
			auditList = AuditDao.getAuditList(params[0], params[1], params[2],
					params[3], null, null);
			return auditList;
		}

		@Override
		protected void onPostExecute(List<AuditBean> list) {
			adapter = new AuditsListAdapter(UnAuditFragment.this, list, null,
					getListView());
			pullToRefreshListView.setAdapter(adapter);
			adapter.notifyDataSetChanged();
			pullToRefreshListView.onRefreshComplete();

		}

	}

}
