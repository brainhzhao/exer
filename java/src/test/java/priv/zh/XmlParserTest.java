package priv.zh;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.junit.Test;

import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Iterator;

public class XmlParserTest {

    @Test
    public void Dom4jParse(){
        SAXReader reader = new SAXReader();
        try{
            Document document = reader.read(new FileInputStream("D:\\code\\java\\zhdemo\\java\\target\\test-classes\\packet\\渠道发送报文格式.xml"));
            Element rootElement = document.getRootElement();
            Element header = rootElement.element("body");

            for (Iterator iterator = header.elementIterator();iterator.hasNext();){
                Element element = (Element) iterator.next();
                System.out.println(element.getTextTrim());
            }

        } catch (DocumentException ex){
            ex.getStackTrace();
        } catch (FileNotFoundException ex){
            ex.getStackTrace();
        }
    }
}