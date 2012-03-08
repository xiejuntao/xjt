/**
@author xjt
 */
package xjt.xml;

import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.DOMReader;
import org.dom4j.io.DOMWriter;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.xml.sax.SAXException;

/**
 * Xml������
 */
public class XmlUtil {
	private Document doc = null;

	public XmlUtil() {
		this.doc = DocumentHelper.createDocument();
	}

	/**
	 * @param fileUrl
	 *            xml�ļ�
	 */
	public XmlUtil(String fileUrl) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			org.w3c.dom.Document domDocument = builder.parse(fileUrl);
			DOMReader reader = new DOMReader();
			doc = reader.read(domDocument);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return Document����
	 */
	public Document getDocument() {
		return doc;
	}

	/**
	 * @return ��Ԫ��RootElement
	 */
	public Element getRootElement() {
		return doc.getRootElement();
	}

	/**
	 * ��Ӹ�Ԫ��
	 * 
	 * @param elementStr
	 *            ��Ԫ����
	 */
	public Element addRootElement(String elementStr) {
		return doc.addElement(elementStr);
	}

	/**
	 * @param element
	 *            Ԫ��
	 * @return ָ��Ԫ�ص�ֵ
	 */
	public String getValue(Element element) {
		return element.getText();
	}

	/**
	 * ���Ԫ�ص�ֵ
	 * 
	 * @param element
	 *            Ԫ��
	 * @param valueStr
	 *            Ԫ�ص�ֵ
	 */
	public void addValue(Element element, String valueStr) {
		element.addText(valueStr);
	}

	/**
	 * @param element
	 *            Ԫ��
	 * @param attribute
	 *            ������
	 * @return ����ֵ
	 */
	public String getAttributeValue(Element element, String attribute) {
		return element.attributeValue(attribute);
	}

	/**
	 * �������
	 * 
	 * @param element
	 *            Ԫ��
	 * @param attribute
	 *            ������
	 * @param valueStr
	 *            ����ֵ
	 */
	public void addAttribute(Element element, String attribute, String valueStr) {
		element.addAttribute(attribute, valueStr);
	}

	/**
	 * @param root
	 *            ��Ԫ��
	 * @param elementStr
	 *            Ԫ����
	 * @return ��Ԫ��
	 */
	public Element getElement(Element root, String elementStr) {
		return root.element(elementStr);
	}

	/**
	 * �洢xml�ĵ�
	 * 
	 * @param fileName
	 *            ������ļ���
	 */
	public void writeXml(String fileName) {
		DOMWriter dw = new DOMWriter();
		try {
			dw.write(doc);
			OutputFormat format = OutputFormat.createPrettyPrint();
			XMLWriter writer = new XMLWriter(new FileWriter(fileName), format);
			writer.write(doc);
			writer.close();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
