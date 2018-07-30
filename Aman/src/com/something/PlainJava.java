package com.something;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

@XmlRootElement
public class PlainJava {
	
	private String name;
	private String id;
	private JSONObject json;
	
	public PlainJava() {
		json = new JSONObject();
		try {
			json.put("k1", "v1");
		} catch (JSONException e) {
			System.out.println("THis error.");
		}
	}
	
	@XmlElement
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlElement
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "{PlainJava String}";
	}

	@XmlElement
	public JSONObject getJson() {
		return json;
	}

	public void setJson(JSONObject json) {
		this.json = json;
	}
	
	public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("https://scontent.xx.fbcdn.net/v/t1.15752-9/33768757_1851186851848454_8624980279594844160_n.jpg?_nc_cat=0&_nc_ad=z-m&_nc_cid=0&oh=fd72612bae8f91b991bd4bf40bbcfbbb&oe=5B8E290E");
        System.out.println(url.getFile());
        System.out.println(url.getPath().split(".")[1]);
    }
}
