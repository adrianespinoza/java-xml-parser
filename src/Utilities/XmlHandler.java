package Utilities;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



public class XmlHandler {
    public static String TYPE_CREDENTIAL = "Adrian.sandbox";

    public static void Reader()
    {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File("./src/Utilities/xmlFile.xml"));
            doc.getDocumentElement().normalize();

            System.out.println("Document: " + doc);
            System.out.println(doc.getDocumentElement().getChildNodes().getLength());

            //NodeList nodosRaiz = doc.getDocumentElement().getChildNodes();
            NodeList nodesRoot = doc.getDocumentElement().getElementsByTagName("credential");
            for(int i = 0; i < nodesRoot.getLength(); i++) {
               System.out.println(nodesRoot.item(i).getNodeName());

               Element elem = (Element)nodesRoot.item(i);
               if (elem.hasAttribute("id") && elem.getAttribute("id").equals(TYPE_CREDENTIAL))
               {
                    System.out.println("Attibute value: " + elem.getAttribute("id"));

                    NodeList adminChildNodes = elem.getElementsByTagName("admin");

                    if (adminChildNodes.getLength() > 0)
                    {
                        //do something
                    }

                    NodeList userChildNodes = elem.getElementsByTagName("user");
                    if (userChildNodes.getLength() > 0)
                    {
                        //do something
                    }
                    System.out.println("Child nodes: " + (userChildNodes.getLength() + adminChildNodes.getLength()));
                    break;
               }
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
