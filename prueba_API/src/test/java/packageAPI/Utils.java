package packageAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.net.ssl.HttpsURLConnection;

public class Utils {

	public static String[] hacerGet(String urlParaVisitar) throws IOException {
		
		  int code = 0;
		  StringBuilder resultado = new StringBuilder();
		  URL url = new URL(urlParaVisitar);

		  HttpsURLConnection conexion = (HttpsURLConnection) url.openConnection();
		  conexion.setRequestMethod("GET");

		  code = conexion.getResponseCode();

		  BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
		  String linea;
		  
		  while ((linea = rd.readLine()) != null) {
		    resultado.append(linea);
		  }
		  
		  rd.close();
		  
		  String[] respuesta = {code + "", resultado.toString()};
		  
		  return respuesta;
	}
	
	public static String[] hacerGetconAuth(String urlParaVisitar, String username, String password) throws IOException {
		
		  int code = 0;
		  StringBuilder resultado = new StringBuilder();
		  URL url = new URL(urlParaVisitar);

		  HttpsURLConnection conexion = (HttpsURLConnection) url.openConnection();
		  conexion.setRequestMethod("GET");
		  
		  conexion.setRequestProperty("Accept", "application/json");
		  conexion.setRequestProperty("Authorization","Basic " + Base64.getEncoder().encodeToString((username + ":" + password).getBytes()));
		  
		  code = conexion.getResponseCode();

		  BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
		  String linea;
		  
		  while ((linea = rd.readLine()) != null) {
		    resultado.append(linea);
		  }
		  
		  rd.close();
		  
		  String[] respuesta = {code + "", resultado.toString()};
		  
		  return respuesta;
	}
	
	public static String[] hacerPost(String urlParaVisitar, String values) throws IOException  {
		
		  int code = 0;
		  byte[] out = values.getBytes(StandardCharsets.UTF_8);
		
		  StringBuilder resultado = new StringBuilder();
		  URL url = new URL(urlParaVisitar);
		
		  HttpsURLConnection conexion = (HttpsURLConnection) url.openConnection();
		  conexion.setDoOutput(true);
		  conexion.setRequestMethod("POST");
		  conexion.setRequestProperty("Content-Type", "application/json");
		
		  OutputStream os = conexion.getOutputStream();

		  os.write(out);
		  
		  code = conexion.getResponseCode();
		
		  BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
		  String linea;
		
		  while ((linea = rd.readLine()) != null) {
		    resultado.append(linea);
		  }
		  
		  rd.close();
		  
		  String[] respuesta = {code + "", resultado.toString()};
		  
		  return respuesta;
	}
	
	public static String[] hacerDeleteconAuth(String urlParaVisitar, String username, String password) throws IOException {
		
		  int code = 0;
		  StringBuilder resultado = new StringBuilder();
		  URL url = new URL(urlParaVisitar);

		  HttpsURLConnection conexion = (HttpsURLConnection) url.openConnection();
		  conexion.setRequestMethod("DELETE");
		  
		  conexion.setRequestProperty("Accept", "application/json");
		  conexion.setRequestProperty("Authorization","Basic " + Base64.getEncoder().encodeToString((username + ":" + password).getBytes()));
		  
		  code = conexion.getResponseCode();

		  BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
		  String linea;
		  
		  while ((linea = rd.readLine()) != null) {
		    resultado.append(linea);
		  }
		  
		  rd.close();
		  
		  String[] respuesta = {code + "", resultado.toString()};
		  
		  return respuesta;
	}
}
