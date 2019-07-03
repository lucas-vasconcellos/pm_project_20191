package pm.projetofinal.pm_project;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLReader extends DefaultHandler{
	
	@Override
	public void startDocument() throws SAXException {
		System.out.println("Iniciando a leitura do documento...");
	}
	
	@Override
	public void endDocument() throws SAXException {
		System.out.println("\n Finalizando a leitura do documento...");
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		
	}
}
