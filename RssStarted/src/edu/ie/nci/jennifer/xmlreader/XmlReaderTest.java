package edu.ie.nci.jennifer.xmlreader;

import static org.junit.Assert.*;

import org.junit.Test;

public class XmlReaderTest {

	@Test
	public void test() {
		XmlReader reader = new XmlReader();
		assertEquals("no file loaded, not parsed", reader.toString());
		reader.loadFile("/home/jennifer/git/rssStarted/RssStarted/src/test.xml");
		assertEquals("/home/jennifer/git/rssStarted/RssStarted/src/test.xml file loaded, not parsed", reader.toString());
		assertNotNull(reader.getFile());
		Configuration configuration = reader.parse();
		assertEquals("/home/jennifer/git/rssStarted/RssStarted/src/test.xml file loaded, parsed", reader.toString());
		assertNotNull(configuration);
		assertEquals("1", configuration.getId());
		assertEquals("http://www.example.com", configuration.getUrl());
		assertEquals("alvaro", configuration.getServer());
		assertEquals("h21", configuration.getName());
		assertEquals("problem 2.1", configuration.getDescription());
		assertEquals("[john, mary, jennifer]", configuration.getOwner().toString());	
	}
}
