package com.API_Framework.URLs;

public enum resources {

	get_itemsById("/posts/"),
	post_items("/posts/"),
	put_items("/posts/"),
	patch_items("/posts/"),
	delete_items("/posts/");
	
	String Resources;
	
	resources(String Resources){
		this.Resources=Resources;
	}
		public String getResources(){
			
		return Resources;
	}
	public String getResources(String data){
		return Resources+data;
	}
}
