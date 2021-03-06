package edu.ie.nci.jennifer.xmlreader;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Configuration {

	private String id;
	private String server;
	private String url;
	private String name;
	private String description;
	private List<Path> path;
	private List<String> owner;
	private Client client;

	@Override
	public String toString() {
		return String
				.format("Id: %s\nServer: %s\nurl: %s\nName: %s\nDescription: %s\nPath: %s\nOwner: %s\nClient: %s",
						id, server, url, name, description, path, owner,
						client);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Configuration && obj != null) {
			Configuration that = (Configuration)obj;
			if (!this.id.equalsIgnoreCase(that.id)) return false;
			if (!this.description.equalsIgnoreCase(that.description)) return false;
			if (!this.name.equalsIgnoreCase(that.name)) return false;
			if (!this.client.equals(that.client)) return false;
			if (this.path.size() != that.path.size()) return false;
			if (!this.path.containsAll(that.path)) return false;
			if (this.owner.size() != that.owner.size()) return false;
			if (!this.owner.containsAll(that.owner)) return false;
		} else {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		return 0;
	}


	public Client getClient() {
		return client;
	}

	@XmlElement
	public void setClient(Client client) {
		this.client = client;
	}

	public List<String> getOwner() {
		if (this.owner == null)
			this.owner = new ArrayList<String>();
		return owner;
	}

	// @XmlElement(name = "owner")
	@XmlElementWrapper(name = "owners")
	public void setOwner(List<String> owner) {
		this.owner = owner;
	}


	public String getServer() {
		return this.server;
	}

	@XmlAttribute
	public void setId(String id) {
		this.id = id;
	}

	@XmlElement
	public void setServer(String server) {
		this.server = server;
	}

	public String getId() {
		return this.id;
	}

	@XmlElement
	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return this.url;
	}

	public String getName() {
		return name;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	@XmlElement
	public void setDescription(String description) {
		this.description = description;
	}

	@XmlElement
	@XmlElementWrapper(name = "paths")
	public void setPath(List<Path> paths) {
		this.path = paths;
	}

	public List<Path> getPath() {
		if (this.path == null)
			this.path = new ArrayList<Path>();
		return path;
	}
}
