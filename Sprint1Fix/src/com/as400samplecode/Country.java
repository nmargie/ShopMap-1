package com.as400samplecode;

import android.os.Parcel;
import android.os.Parcelable;

public class Country implements Parcelable {

	String code = null;
	String name = null;
	boolean selected = false;

	public Country(Parcel input) {
		readFromParcel(input);
	}

	public Country(String code, String name, boolean selected) {
		super();
		this.code = code;
		this.name = name;
		this.selected = selected;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {

		dest.writeString(name);
		dest.writeString(code);
		dest.writeByte((byte) (selected ? 1 : 0));

	}

	private void readFromParcel(Parcel input) {
		this.name=input.readString();
		this.code=input.readString();
		this.selected=input.readByte() == 1;
	}
	
	public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
		public Country createFromParcel(Parcel in){
			return new Country(in);
		}
		
		public Country[] newArray(int size){
			return new Country[size];
		}
	};
	
}

