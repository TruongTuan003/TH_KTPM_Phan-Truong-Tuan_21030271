package JSonObject;

import org.json.JSONObject;

class JsonWebService implements JsonService {
    @Override
    public void processJsonData(String jsonData) {
        JSONObject json = new JSONObject(jsonData);
        System.out.println("✅ JSON Service nhận dữ liệu: " + json.toString(4));
    }
}