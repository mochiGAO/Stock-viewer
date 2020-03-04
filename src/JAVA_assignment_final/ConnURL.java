package JAVA_assignment_final;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * This class for connecting download path
 * 
 */


public class ConnURL {
	URL url;
	HttpURLConnection httpURLConnection;
	File file;

	public ConnURL(String urlPath) {

		try {
			url = new URL(urlPath);
			httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setRequestMethod("GET");//method to connect
			httpURLConnection.connect();

			//get data input stream
			BufferedInputStream bin = new BufferedInputStream(httpURLConnection.getInputStream());
			file = new File("test.csv");//touch doc named test.csv for saving

			//output stream
			OutputStream out = new FileOutputStream(file);
			
			//write into file
			int size = 0;
			int len = 0;
			byte[] buf = new byte[1024];
			while ((size = bin.read(buf)) != -1) {
				len += size;
				out.write(buf, 0, size);
			}
			bin.close();
			out.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		finally {
			if (httpURLConnection != null) {
				httpURLConnection.disconnect();

			}
		}

	}

}
