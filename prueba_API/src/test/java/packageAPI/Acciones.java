package packageAPI;

import java.io.IOException;
import org.json.JSONObject;

public class Acciones {
	
	public String[] crearUsuario() throws IOException {
		
		JSONObject json = new JSONObject();
		json.put("name", "ToniTon");
		json.put("username", "ToniTon");
		json.put("password", "toniton");
		json.put("role", "QA");
		json.put("email", "ToniTon3@gmail.com");
		String[] respuesta = Utils.hacerPost("https://api-testing-conference.herokuapp.com/v1.0/users",json.toString());
		return respuesta;
		
	}
	
	public String[] obtenerListaUsuarios() throws IOException {
		
		String[] respuesta = Utils.hacerGet("https://api-testing-conference.herokuapp.com/v1.0/users");
		return respuesta;
		
	}
	
	public String[] crearMensajeForo() throws IOException {
		
		JSONObject json = new JSONObject();
		json.put("theme", "Testing");
		json.put("subject", "Curso Python API REST");
		json.put("message", "Vaya profesor más aburrido!!!!");
		String[] respuesta = Utils.hacerPost("https://api-testing-conference.herokuapp.com/v1.0/forum",json.toString());
		return respuesta;
		
	}
	
	public String[] obtenerMensajesForo() throws IOException {
		
		String[] respuesta = Utils.hacerGet("https://api-testing-conference.herokuapp.com/v1.0/forum");
		return respuesta;
		
	}
	
	public String[] crearMensajePrivado(String username, String message) throws IOException {
		
		JSONObject json = new JSONObject();
		json.put("message", message);
		String[] respuesta = Utils.hacerPost("https://api-testing-conference.herokuapp.com/v1.0/users/inbox/"+ username, json.toString());
		return respuesta;
		
	}
	
	public String[] obtenerMensajePrivado(String username, String password) throws IOException {
		
		String[] respuesta = Utils.hacerGetconAuth("https://api-testing-conference.herokuapp.com/v1.0/users/inbox/"+ username,username,password);
		return respuesta;
		
	}
	
	public String[] borrarMensajesPrivados(String username, String password) throws IOException {
		
		String[] respuesta = Utils.hacerDeleteconAuth("https://api-testing-conference.herokuapp.com/v1.0/users/inbox/"+ username,username,password);
		return respuesta;
	   
	}
}
