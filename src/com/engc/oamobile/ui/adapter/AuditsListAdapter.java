package com.engc.oamobile.ui.adapter;

import java.util.List;

import com.engc.oamobile.R;
import com.engc.oamobile.bean.AuditBean;
import com.engc.oamobile.support.asyncdrawable.BitmapDownloader;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;



/**
 * Copyright © 2014ENGC. All rights reserved.
 * 
 * @Title: NewsListAdapter.java
 * @Package: com.engc.jlcollege.ui.adapter
 * @Description: 在线审批list adapter
 * @author: wutao
 * @date: 2014-7-7 下午4:32:59
 */
public class AuditsListAdapter extends BaseAdapter {

	protected List<AuditBean> list;
	protected Context context;
	protected LayoutInflater inflater;
	protected ListView listview;
	protected int defaultBG;
	private BitmapDownloader commander;


	public AuditsListAdapter(Fragment context, List<AuditBean> list,
			BitmapDownloader commander, ListView listView) {
		this.list = list;
		//this.inflater = LayoutInflater.from(context);
		this.inflater=context.getActivity().getLayoutInflater();
		this.listview = listView;
		//this.context = context;
		this.commander = commander;
		listView.setRecyclerListener(new AbsListView.RecyclerListener() {

			@Override
			public void onMovedToScrapHeap(View view) {
				ViewHolder holder = (ViewHolder) view.getTag();
				if (holder == null) {
					return;
				}
				holder.imgThumbnails.setImageDrawable(null);

			}
		});
	}

	private List<AuditBean> getList() {
		return list;
	}

	@Override
	public int getCount() {
		if (getList() != null && getList().size() > 0) {
			return getList().size();
		} else {
			return 0;
		}
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return getList().get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null || convertView.getTag() == null) {
			holder = new ViewHolder();
			convertView = inflater.inflate(
					R.layout.listview_item_universal_layout, parent, false);
			holder.newsTitle = (TextView) convertView
					.findViewById(R.id.listitem_title);
			holder.createTime = (TextView) convertView
					.findViewById(R.id.listitem_subtitle_or_time);
			holder.imgThumbnails = (ImageView) convertView
					.findViewById(R.id.listitem_Thumbnails);
			convertView.setTag(holder);

		} else {
			holder = (ViewHolder) convertView.getTag();

		}

		AuditBean newsBean = list.get(position);
		holder.newsTitle.setTag(newsBean);
		//holder.newsTitle.setText(newsBean.getTitle() != null ? newsBean
			//	.getTitle() : "");
		//holder.createTime.setText(newsBean.getNewsid() != null ? newsBean
			//	.getNewsid() : "");
		//String url = newsBean.getThumbnails();
		//if (!TextUtils.isEmpty(url))
			//commander.downloadAvatar(holder.imgThumbnails, url);

		return convertView;
	}

	private class ViewHolder {

		TextView newsTitle;

		TextView createTime;

		ImageView imgThumbnails;

		RelativeLayout listview_root;
	}

}
