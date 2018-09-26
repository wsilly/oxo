package com.horets.common;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.horets.util.*;
/**
 * 解析server.xml配置文件
 * @author 19777
 *
 */
public class ServerParser {
	private static Logger logger = Logger.getLogger();
	public static int getPort() {
		int port = 8080;
		try {
			SAXReader saxReader = new SAXReader();
			Document document = saxReader.read("serverconfig/server.xml");
			Element connectorEle = (Element)document.selectSingleNode("//connector");
			port = Integer.parseInt(connectorEle.attributeValue("port"));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			logger.log("[ERROR]" + e.toString() + "\n");
			e.printStackTrace();
		}
		
		return port;
	}
}
