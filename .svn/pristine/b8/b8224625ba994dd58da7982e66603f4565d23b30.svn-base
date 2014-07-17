package com.engc.oamobile.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 审批实体
 * 
 * @author Administrator
 * 
 */
public class AuditBean implements Parcelable {
	private String id;
	private String approvetypeid;
	private String approvetype;
	private String status;
	private String title;
	private String submitusercode;
	private String submitter;
	private String submittime;
	private String stayusercode;
	private String stayuser;
	private String approveusercode;
	private String approveuser;
	private String approvetime;

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.id);
		dest.writeString(this.approvetypeid);
		dest.writeString(this.approvetype);
		dest.writeString(this.status);
		dest.writeString(this.title);
		dest.writeString(this.submitusercode);
		dest.writeString(this.submitter);
		dest.writeString(this.submittime);
		dest.writeString(this.stayusercode);
		dest.writeString(this.stayuser);
		dest.writeString(this.approveusercode);
		dest.writeString(this.approveuser);
		dest.writeString(this.approvetime);
	}

	public AuditBean() {
	}

	private AuditBean(Parcel in) {
		this.id = in.readString();
		this.approvetypeid = in.readString();
		this.approvetype = in.readString();
		this.status = in.readString();
		this.title = in.readString();
		this.submitusercode = in.readString();
		this.submitter = in.readString();
		this.submittime = in.readString();
		this.stayusercode = in.readString();
		this.stayuser = in.readString();
		this.approveusercode = in.readString();
		this.approveuser = in.readString();
		this.approvetime = in.readString();
	}

	public static Creator<AuditBean> CREATOR = new Creator<AuditBean>() {
		public AuditBean createFromParcel(Parcel source) {
			return new AuditBean(source);
		}

		public AuditBean[] newArray(int size) {
			return new AuditBean[size];
		}
	};
}
