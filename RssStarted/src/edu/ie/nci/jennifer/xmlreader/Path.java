package edu.ie.nci.jennifer.xmlreader;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Path {
	private String input;
	private String output;
	
	public Path() {}
	
	public Path(String input, String output) {
		this.input = input;
		this.output = output;
	}
	
	@Override
	public String toString() {
		return String.format("\nInput: %s Output: %s", input, output);
	}
	
	@Override
	public boolean equals(Object obj) {
		return false;
	}
	
	@Override
	public int hashCode() {
		return 0;
	}

	@XmlElement
	public void setInput(String input) {
		this.input = input;
	}
	
	public String getInput() {
		return this.input;
	}

	@XmlElement
	public void setOutput(String output) {
		this.output = output;
	}
	
	public String getOutput() {
		return this.output;
	}
}
