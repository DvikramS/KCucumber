package Utility;

import java.util.Hashtable;

public class XMLgenerator {

	public static String getXML(String TestCase, ExcelUtility xl){
		String s="";
		int rownum=0;
		for(int i=1;i<xl.getRowCount("TestData");i++){
			if(xl.getCellData("TestData", 1, i).equals(TestCase)){
				rownum=i;
				break;
			}
		}
		
		
		int headerrow=rownum+1;
		int col=2;
		
		while(!(xl.getCellData("TestData", col, headerrow).equals(""))){
			col++;
		}
		
		int colcount=col-2;
		Hashtable<String , String> hs=new Hashtable();
		String key="";
		String value="";
		Object ob[][]=new Object[2][colcount];
		int index=0;
		for(int i=0;i<colcount;i++){
			key=xl.getCellData("TestData", i+2, headerrow);
			value=xl.getCellData("TestData", i+2, headerrow+1);
			
			hs.put(key, value);
			ob[0][index]=key;
			ob[1][index]=value;
			index++;
		}
		
		
		
	/*for(int i=0;i<ob.length;i++){
			for(int j=0;j<ob[i].length;j++){
				System.out.println(ob[i][j]);
				}
			}*/
		int i=ob.length;
		int j=0;
		while(j<ob[0].length){
		
			if(ob[0][j].toString().startsWith("//")){
				s=s+"</"+ob[0][j].toString().substring(2)+">";
			
			}
			if(ob[1][j].toString().isEmpty()&& !(ob[0][j].toString().startsWith("//"))){
			s=s+"<"+ob[0][j]+">";
			}
			if(!(ob[1][j].toString().isEmpty()))
			s=s+"<"+ob[0][j]+">"+ob[1][j]+"</"+ob[0][j]+">";
			
			j++;
		}
		
		return s;
		
	}
	
	
	public static void main(String[] args) {
		ExcelUtility xl=new ExcelUtility(".\\TestData.xlsx");
		System.out.println(getXML("Tests", xl));
	}
	
}
