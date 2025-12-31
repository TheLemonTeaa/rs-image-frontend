package com.ruoyi.common.utils.xml;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.*;
import java.io.File;

public class XmlParseUtils {

    private static final XPath XPATH = XPathFactory.newInstance().newXPath();

    /**
     * 解析 XML 文件
     */
    public static Document parse(File xmlFile) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(false);
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(xmlFile);
    }

    /**
     * 根据 XPath 表达式取字符串值
     */
    public static String getString(Document doc, String expression) {
        try {
            return XPATH.evaluate(expression, doc).trim();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 取 Double
     */
    public static Double getDouble(Document doc, String expression) {
        try {
            String value = getString(doc, expression);
            return value == null || value.isEmpty() ? null : Double.valueOf(value);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 取 Integer
     */
    public static Integer getInteger(Document doc, String expression) {
        try {
            String value = getString(doc, expression);
            return value == null || value.isEmpty() ? null : Integer.valueOf(value);
        } catch (Exception e) {
            return null;
        }
    }
}
