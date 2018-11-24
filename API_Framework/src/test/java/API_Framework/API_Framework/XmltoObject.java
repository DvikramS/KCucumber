
package API_Framework.API_Framework;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.API.classes.Parcel;
import com.API.classes.Parcels;
import com.google.common.util.concurrent.CycleDetectingLockFactory.WithExplicitOrdering;

import io.restassured.path.xml.XmlPath;

public class XmltoObject {
	
	public static void main(String[] args) {
		
		File f=new File(".\\input.xml");
		//XmlPath x=new XmlPath(".\\input.xm");
	XmlPath.with(f).get("bookstore.book[*]");
		System.out.println(XmlPath.with(f).get("bookstore.book[*]"));
		
		File file=null;
		try{
	 file = new File(".\\input.xml");
		}
		catch(Exception e){
			System.out.println("2");
		}
		JAXBContext jaxbContext;
		
		try {
			jaxbContext = JAXBContext.newInstance(Parcels.class);
			 Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller(); 
			Parcels  p1= (Parcels) jaxbUnmarshaller.unmarshal(file);
			 /* List<Parcel> p2=p.getParcel();
			  for(Parcel p1:p2 ){*/
			/*  System.out.println(p1.getParcel().getDeliveryInstructionCode());
			  System.out.println(p1.getParcel().getTrackingNumber());
			  System.out.println(p1.getParcel().getDeliveryInstructionDescription());
			  */
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			
			
			
		}
		  
		  
		  
	}

}
