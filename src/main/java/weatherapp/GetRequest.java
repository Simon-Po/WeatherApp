package weatherapp;








import org.apache.hc.client5.http.fluent.Content;
import org.apache.hc.client5.http.fluent.Request;

import java.io.IOException;


public class GetRequest {
    private Content c;
    GetRequest(String path) throws IOException {
        Request r = Request.get(path);
        this.c = r.execute().returnContent();


    }

    public String getContentasString() {
        return this.c.asString();
    }

}
