package com.example.shop_map;
import android.os.Parcel;
import android.os.Parcelable;

public class Item implements Parcelable {
	
	int id;
	String name = null;
	boolean selected = false;
	int xPosition;
	int yPosition;
	int rowSide;
	int rowNumber;

	public Item(Parcel input) {
		readFromParcel(input);
	}

	public Item(int id, String name, boolean selected) {
		super();
		this.id = id;
		this.name = name;
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
		dest.writeInt(id);
		dest.writeByte((byte) (selected ? 1 : 0));
		dest.writeInt(xPosition);
		dest.writeInt(yPosition);
		dest.writeInt(rowSide);
		dest.writeInt(rowNumber);

	}

	private void readFromParcel(Parcel input) {
		this.name=input.readString();
		this.id=input.readInt();
		this.selected=input.readByte() == 1;
		this.xPosition = input.readInt();
		this.yPosition = input.readInt();
		this.rowSide = input.readInt();
		this.rowNumber = input.readInt();
	}
	
	public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
		public Item createFromParcel(Parcel in){
			return new Item(in);
		}
		
		public Item[] newArray(int size){
			return new Item[size];
		}
	};
	
	/*GETTERS AND SETTERS*/
	
	//get
	
	public int getID() {
		return id;
	}
	public String getName() {
		return name;
	}
	public boolean isSelected() {
		return selected;
	}
	public int getxPosition()
	{
		return xPosition;
	}
	public int getyPosition()
	{
		return yPosition;
	}

	public int getRowSide()
	{
		return rowSide;
	}

	public int getRowNumber()
	{
		return rowNumber;
	}
	
	//set
	public void setId(int id){
		this.id = id;
	}
	public void setName(String name){
		this.name = name;
	}
	
	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public void setXPosition(int xPosition)
	{
		this.xPosition = xPosition;
	}
	public void setYPosition(int yPosition)
	{
		this.yPosition = yPosition;
	}
	public void setRowSide(int rowSide)
	{
		this.rowSide = rowSide;
	}
	
	public void setRowNumber(int i)
	{
		this.rowNumber = i;
	}

}
