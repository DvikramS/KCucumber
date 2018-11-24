
package com.API.classes;



import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Parcels")
@XmlAccessorType(XmlAccessType.FIELD)
public class Parcels {
	
@XmlElement(name="Parcel", type=Parcel.class)
private Parcel parcel;

public Parcels(){
	
}
public Parcels(Parcel parcel){
	super();
	this.parcel=parcel;
}
public Parcel getParcel() {
	return parcel;
}
public void setParcel(Parcel parcel) {
	this.parcel = parcel;
}




}
