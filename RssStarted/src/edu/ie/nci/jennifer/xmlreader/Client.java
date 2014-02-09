package edu.ie.nci.jennifer.xmlreader;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Client {
	private String name;
	private String address;

	public Client() {
	}

	public Client(String name, String address) {

		this.name = name;
		this.address = address;

	}
	@Override
	public String toString() {
		return String.format("\nname: %s, address: %s", name, address);
	}

	public String getName() {
		return this.name;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return this.address;
	}

	@XmlElement
	public void setAddress(String address) {
		this.address = address;
	}

}
