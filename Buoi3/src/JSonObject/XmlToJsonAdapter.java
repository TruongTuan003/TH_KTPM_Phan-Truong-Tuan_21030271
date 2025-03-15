package JSonObject;

import org.json.JSONObject;
import org.json.XML;

class XmlToJsonAdapter implements JsonService {
    private XmlService xmlService;

    public XmlToJsonAdapter(XmlService xmlService) {
        this.xmlService = xmlService;
    }

    @Override
    public void processJsonData(String jsonData) {
        // Chuyển đổi JSON sang XML
        JSONObject json = new JSONObject(jsonData);
        String xmlData = XML.toString(json, "root");

        System.out.println("🔄 Chuyển đổi JSON -> XML: \n" + xmlData);
        
        // Gửi dữ liệu XML đến hệ thống XML
        xmlService.processXmlData(xmlData);
    }
}