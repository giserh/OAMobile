package com.engc.oamobile.ui.home;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.engc.oamobile.R;
import com.engc.oamobile.support.utils.BitmapManager;
import com.engc.oamobile.support.utils.GlobalContext;
import com.engc.oamobile.support.widgets.ShowMorePopupWindow;
import com.engc.oamobile.ui.audit.OnlineAudit;

@SuppressLint("NewApi")
public class MainActivity extends Activity {
	private GridView gvModem;
	public List<String> imgtitleList; // 存放应用标题list
	public List<Integer> imgList; // 存放应用图片list
	public View[] itemViews;
	private ShowMorePopupWindow smPw;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ActionBar action = getActionBar();
		action.hide();
		initView();
		initGridData();

	}

	private void initView() {
		gvModem = (GridView) findViewById(R.id.gvmodem);
		ImageView imgMore = (ImageView) findViewById(R.id.img_titlebar_more);
		imgMore.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				showPopupWindow();
				showPopupView();

			}
		});

		gvModem.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent;
				switch (position) {
				case 0:
					intent = new Intent(MainActivity.this, OnlineAudit.class);
					startActivity(intent);

					break;
				case 1:

					break;

				default:
					break;
				}

			}
		});

	}
	
	public void showPopupWindow() {
		smPw = new ShowMorePopupWindow(MainActivity.this, itemsOnClick);
		// 显示窗口
		View view = MainActivity.this.findViewById(R.id.img_titlebar_more);
		// 计算坐标的偏移量
		int xoffInPixels = smPw.getWidth() - view.getWidth() + 10;
		smPw.showAsDropDown(view, -xoffInPixels, 0);

	}

	// 为弹出窗口实现监听类
	private OnClickListener itemsOnClick = new OnClickListener() {

		public void onClick(View v) {
			smPw.dismiss();
		}
	};

	// 设置popupView
	private void showPopupView() {
		View view = ShowMorePopupWindow.initView();
	/*	ImageView userFace = (ImageView) view.findViewById(R.id.userface);
		TextView userName = (TextView) view.findViewById(R.id.username);*/
		// userName.setText(GlobalContext.getInstance().getSpUtil().getUserInfo().getUsername());
		// String url
		// =GlobalContext.getInstance().getSpUtil().getUserInfo().getPhoto();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		/*
		 * if (id == R.id.action_settings) { return true; }
		 */
		return super.onOptionsItemSelected(item);
	}

	private void initGridData() {
		imgtitleList = new ArrayList<String>();
		imgList = new ArrayList<Integer>();

		imgtitleList.clear();
		imgList.clear();
		imgtitleList.add("新闻公告");
		imgtitleList.add("在线审批");
		imgtitleList.add("请假");
		imgtitleList.add("即时消息");
		imgtitleList.add("通讯录");
		imgtitleList.add("请假记录");
		imgList.add(R.drawable.icon_news);
		imgList.add(R.drawable.icon_online_audit);
		imgList.add(R.drawable.icon_leave);
		imgList.add(R.drawable.icon_message);
		imgList.add(R.drawable.icon_contact);
		imgList.add(R.drawable.icon_leave_record);
		gvModem.setAdapter(new GridViewModemAdapter(imgtitleList, imgList));

	}

	/**
	 * 
	 * @ClassName: GridViewModemAdapter
	 * @Description: APPs 九宫格 数据适配源
	 * @author wutao
	 * @date 2013-10-10 上午11:23:54
	 * 
	 */
	public class GridViewModemAdapter extends BaseAdapter {

		public GridViewModemAdapter(List<String> imgTitles, List<Integer> images) {
			itemViews = new View[images.size()];
			for (int i = 0; i < itemViews.length; i++) {
				itemViews[i] = makeItemView(imgTitles.get(i), images.get(i));
			}
		}

		public View makeItemView(String imageTitilsId, int imageId) {
			// try {
			// LayoutInflater inflater = (LayoutInflater)
			// UtitlsModemFragment.this
			// .getSystemService(LAYOUT_INFLATER_SERVICE);
			// View
			// view=LayoutInflater.from(getActivity().getApplicationContext()).inflate(R.layout.grid_apps_item,
			// null);
			LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
			View itemView = inflater.inflate(R.layout.grid_apps_item, null);
			TextView title = (TextView) itemView.findViewById(R.id.TextItemId);
			title.setText(imageTitilsId);
			ImageView image = (ImageView) itemView
					.findViewById(R.id.ImageItemId);
			image.setImageResource(imageId);
			// image.setScaleType(ImageView.ScaleType.FIT_CENTER);
			return itemView;
			/*
			 * } catch (Exception e) {
			 * System.out.println("makeItemView Exception error" +
			 * e.getMessage()); return null; }
			 */

		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return itemViews.length;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return itemViews[position];
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			if (convertView == null) {
				return itemViews[position];
			}
			return convertView;
		}
	}

}
