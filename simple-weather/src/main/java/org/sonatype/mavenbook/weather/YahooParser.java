package org.sonatype.mavenbook.weather;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentFactory;
import org.dom4j.io.SAXReader;

public class YahooParser {
	
	private static Logger logger = Logger.getLogger(YahooParser.class);
	
	public Weather parse(InputStream inputStream) throws DocumentException{
		Weather weather = new Weather();
		logger.info("Creating XML reader");
		SAXReader xmlreader = createXmlReader();
		Document doc = xmlreader.read(inputStream);
		
		logger.info("parsing XML Response");
		weather.setChill(doc.valueOf(null));
		return weather;
		
	}

	private SAXReader createXmlReader() {
		// TODO Auto-generated method stub
		Map<String, String> uris = new HashMap<String, String>();
		DocumentFactory factory = new DocumentFactory();
		factory.setXPathNamespaceURIs(uris);
		
		SAXReader xmlReader = new SAXReader();
		xmlReader.setDocumentFactory(factory);
		return xmlReader;
	}

}
