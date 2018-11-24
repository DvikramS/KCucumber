package com.API.classes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


public class Parcel extends Parcels {

	
	private String TrackingNumber;
	
	private String DeliveryInstructionCode;
	
	private String DeliveryInstructionDescription;
	public Parcel(){}
	public Parcel(String TrackingNumber, String DeliveryInstructionCode, String DeliveryInstructionDescription){
		super();
		this.TrackingNumber=TrackingNumber;
		this.DeliveryInstructionCode=DeliveryInstructionCode;
		this.DeliveryInstructionDescription=DeliveryInstructionDescription;
	}
  
	public String getTrackingNumber() {
		return TrackingNumber;
	}
	public void setTrackingNumber(String trackingNumber) {
		TrackingNumber = trackingNumber;
	}
 
	public String getDeliveryInstructionCode() {
		return DeliveryInstructionCode;
	}
	public void setDeliveryInstructionCode(String deliveryInstructionCode) {
		DeliveryInstructionCode = deliveryInstructionCode;
	}
	

	public String getDeliveryInstructionDescription() {
		return DeliveryInstructionDescription;
	}
	public void setDeliveryInstructionDescription(String deliveryInstructionDescription) {
		DeliveryInstructionDescription = deliveryInstructionDescription;
	}
}
