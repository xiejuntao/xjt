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
 * Xml工具类
 */
public class XmlUtil {
	private Document doc = null;

	public XmlUtil() {
		this.doc = DocumentHelper.createDocument();
	}

	/**
	 * @param fileUrl
	 *            xml文件
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
	 * @return Document对象
	 */
	public Document getDocument() {
		return doc;
	}

	/**
	 * @return 根元素RootElement
	 */
	public Element getRootElement() {
		return doc.getRootElement();
	}

	/**
	 * 添加根元素
	 * 
	 * @param elementStr
	 *            根元素名
	 */
	public Element addRootElement(String elementStr) {
		return doc.addElement(elementStr);
	}

	/**
	 * @param element
	 *            元素
	 * @return 指定元素的值
	 */
	public String getValue(Element element) {
		return element.getText();
	}

	/**
	 * 添加元素的值
	 * 
	 * @param element
	 *            元素
	 * @param valueStr
	 *            元素的值
	 */
	public void addValue(Element element, String valueStr) {
		element.addText(valueStr);
	}

	/**
	 * @param element
	 *            元素
	 * @param attribute
	 *            属性名
	 * @return 属性值
	 */
	public String getAttributeValue(Element element, String attribute) {
		return element.attributeValue(attribute);
	}

	/**
	 * 添加属性
	 * 
	 * @param element
	 *            元素
	 * @param attribute
	 *            属性名
	 * @param valueStr
	 *            属性值
	 */
	public void addAttribute(Element element, String attribute, String valueStr) {
		element.addAttribute(attribute, valueStr);
	}

	/**
	 * @param root
	 *            父元素
	 * @param elementStr
	 *            元素名
	 * @return 子元素
	 */
	public Element getElement(Element root, String elementStr) {
		return root.element(elementStr);
	}

	/**
	 * 存储xml文档
	 * 
	 * @param fileName
	 *            保存的文件名
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
