package utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;

@Component("RestClient")
public class RestClient {

	Logger logger = Logger.getLogger("RestClient");
	HashMap<String, String> params;
	String baseurl;
	

	public String checkMethodandCallRest(String link, String method) {
		this.baseurl = link;
		if (method.equals("GET")) {
			return getResponseFromRest(retrieveGetURL(), method);
		} else {
			return getResponseFromRest(link, method);
		}
	}

	public String getResponseFromRest(String link, String method) {
		StringBuilder response = new StringBuilder();
		try {
			URL url = new URL(link);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod(method);
			if (method.equals("POST")) {
				conn.setDoOutput(true);
				OutputStreamWriter writer = new OutputStreamWriter(
						conn.getOutputStream());
				writer.write(getPostURL());
				writer.flush();
			}
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));
			String output;
			logger.log(Level.INFO, "Output from server");
			while ((output = br.readLine()) != null) {
				logger.log(Level.INFO, output);
				response.append(output);
			}
			
			conn.disconnect();

		} catch (MalformedURLException e) {
			logger.log(Level.SEVERE, e.toString());
		} catch (IOException e) {
			logger.log(Level.SEVERE, e.toString());
		}
		return response.toString();
	}

	public String getPostURL() {
		StringBuilder sb = new StringBuilder();
		for (String key : params.keySet()) {
			try {
				String value = URLEncoder.encode(params.get(key), "UTF-8");

				if (sb.length() > 0) {
					sb.append("&");
				}
				sb.append(key + "=" + value);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}

		}
		return sb.toString();
	}

	public void addParams(String key, String value) {

		params = new HashMap<String, String>();
		appendParams(key, value);
	}

	public void appendParams(String key, String value) {
		params.put(key, value);
	}

	public String retrieveGetURL() {
		return this.baseurl + "?" + getPostURL();
	}

	@Override
	public String toString() {
		return "RestClient [params=" + params + ", baseurl=" + baseurl + "]";
	}



}
