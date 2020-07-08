package entity;

import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

public class Item {
	private String itemId;
	private String name;
	private String address;
	private Set<String> keywords;
	private String imageUrl;
	private String url;

	private Item(ItemBuilder builder) { // string -> jarray -> item
		this.itemId = builder.itemId;
		this.name = builder.name;
		this.address = builder.address;
		this.imageUrl = builder.imageUrl;
		this.url = builder.url;
		this.keywords = builder.keywords;
	}
	/*
	 to make data fields can be accessed by others, normally we need Getter and Setter for each of them. 
	 In this case, we just need Getters because we don’t want to change an item instance once it’s constructed.
	 */
	
	public String getItemId() {
		return itemId;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public Set<String> getKeywords() {
		return keywords;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public String getUrl() {
		return url;
	}
	public JSONObject toJSONObject() {
		JSONObject obj = new JSONObject();
		obj.put("item_id", itemId);
		obj.put("name", name);
		obj.put("address", address);
		obj.put("keywords", new JSONArray(keywords));
		obj.put("image_url", imageUrl);
		obj.put("url", url);
		return obj;
}
/*
 Builder pattern builds a complex object using simple objects and using a step by step approach. 
 It separates the construction of a complex object from its representation so that the same construction process can create different representations. 
 We can also make the object to build immutable. 
 */
	public static class ItemBuilder {
		private String itemId;
		private String name;
		private String address;
		private String imageUrl;
		private String url;
		private Set<String> keywords;
		
		public void setItemId(String itemId) {
			this.itemId = itemId;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public void setKeywords(Set<String> keywords) {
			this.keywords = keywords;
		}
		public Item build() {
			return new Item(this);
		}
	}

}

