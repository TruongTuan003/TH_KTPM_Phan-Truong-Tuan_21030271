	package JSonObject;
public class AdapterPatternExample {
    public static void main(String[] args) {
        // Dữ liệu JSON đầu vào
        String jsonData = "{ \"name\": \"Alice\", \"age\": 25, \"city\": \"Hà Nội\" }";

        // Hệ thống XML ban đầu không hiểu JSON
        XmlService xmlService = new XmlService();

        // Sử dụng Adapter để chuyển đổi JSON -> XML
        JsonService adapter = new XmlToJsonAdapter(xmlService);
        adapter.processJsonData(jsonData);
    }
}