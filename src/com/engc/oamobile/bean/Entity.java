package com.engc.oamobile.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 
 * @author Administrator
 * 
 */
public class Entity implements Parcelable {
	private String isError;
	private String message;

	public String getIsError() {
		return isError;
	}

	public void setIsError(String isError) {
		this.isError = isError;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(isError);
		dest.writeString(message);

	}

	public static final Parcelable.Creator<Entity> CREATOR = new Creator<Entity>() {

		@Override
		public Entity[] newArray(int size) {
			// TODO Auto-generated method stub
			return new Entity[size];
		}

		@Override
		public Entity createFromParcel(Parcel source) {
			Entity entity = new Entity();
			entity.isError = source.readString();
			entity.message = source.readString();
			return entity;
		}
	};

}
