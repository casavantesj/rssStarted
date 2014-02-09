package edu.ie.nci.jennifer.xmlreader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class XmlReader {

	private File mFile;
	private String mPath;
	private boolean mParsed;
	private Configuration mConfiguration;

	@Override
	public String toString() {
		String filename = mPath == null? "no" : mPath;
		String parsed = mParsed? "" : " not";
		return String.format("%s file loaded,%s parsed", filename, parsed);
	}
	
	@Override
	public boolean equals(Object obj) {
		return false;
	}
	
	@Override
	public int hashCode() {
		return 0;
	}
	
	public static void main(String[] args) {
		XmlReader reader = new XmlReader();
		reader.loadFile("/home/jennifer/workspace/RssStarted/src/test.xml");
		Configuration configuration = reader.parse();
		System.out.println(configuration);
	}

	public void loadFile(String path) {
		this.mPath = path;
		this.mFile = new File(path);
	}

	public File getFile() {
		return this.mFile;
	}

	public Configuration parse() {
		this.mParsed = true;
		Configuration adr = new Configuration();
	    FileInputStream adrFile = null;
	    try {
	        adrFile = new FileInputStream(mFile);
	        JAXBContext ctx = JAXBContext.newInstance(Configuration.class);
	        Unmarshaller um = ctx.createUnmarshaller();
	        adr = (Configuration) um.unmarshal(adrFile);
	    } catch(IOException exc) {
	    	System.out.println(exc);
	    } catch(JAXBException exc) {
	    	System.out.println(exc);
	    } finally {
	    }
	    this.mConfiguration = adr;
		
	    return adr;
	}
}