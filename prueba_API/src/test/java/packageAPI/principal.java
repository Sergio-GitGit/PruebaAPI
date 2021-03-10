package packageAPI;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;
import org.json.JSONObject;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class principal {
	
	Acciones acc = new Acciones();
	static String username = null;
	static String password = null;
	JSONObject json = null;
	String mensajePrivado = "Mensaje privado al usuario";
	String mensajePrivadoObtenido = null;

	 @Test(priority=1)
     public void crear_usuario(){
		try {	
			
			String[] respuesta = acc.crearUsuario();
			assertTrue(respuesta[0].contentEquals("200"), "Usuario creado");	
			
		} catch (Exception e) {
			fail(e.getMessage());
		} 
		
	}
	 
	 @Test(priority=2)
     public void obtener_usuarios(){
		try {	
			
			String[] respuesta = acc.obtenerListaUsuarios();
			json = new JSONObject(respuesta[1]);
			username = json.getJSONArray("users").getJSONObject(0).getString("username");
			password = json.getJSONArray("users").getJSONObject(0).getString("password");
			assertTrue(respuesta[0].contentEquals("200"), "Lista usuarios obtenida");	
			
		} catch (Exception e) {
			fail(e.getMessage());
		} 
		
	}
	 
	 @Test(priority=3)
     public void crear_mensaje_foro(){
		try {	
			
			String[] respuesta = acc.crearMensajeForo();
			assertTrue(respuesta[0].contentEquals("200"), "Mensaje foro creado");	
			
		} catch (Exception e) {
			fail(e.getMessage());
		} 
		
	}
	 
	 @Test(priority=4)
     public void obtener_mensajes_foro(){
		try {	
			
			String[] respuesta = acc.obtenerMensajesForo();
			assertTrue(respuesta[0].contentEquals("200"), "Mensajes foro obtenidos");	
			
		} catch (Exception e) {
			fail(e.getMessage());
		} 
		
	}
	 
	 @Test(priority=5)
     public void enviar_mensaje_privado(){
		try {	
			
			String[] respuesta = acc.crearMensajePrivado(username, mensajePrivado);
			assertTrue(respuesta[0].contentEquals("200"), "Mensaje privado enviado");	
			
		} catch (Exception e) {
			fail(e.getMessage());
		} 
		
	}
	 
	 @Test(priority=6)
     public void obtener_mensaje_privado(){
		try {	
			
			String[] respuesta = acc.obtenerMensajePrivado(username,password);
			json = new JSONObject(respuesta[1]);
			mensajePrivadoObtenido = json.getJSONArray("messages").getJSONObject(0).getString("message");
			assertTrue(respuesta[0].contentEquals("200") && mensajePrivadoObtenido.contentEquals(mensajePrivado), "Mensaje privado obtenido");
			
		} catch (Exception e) {
			fail(e.getMessage());
		} 
		
	}
	 
	 @AfterTest
	 
	 //Faltaría un borrar_usuarios para dejarlo tal como estaba antes de la prueba, pero esa opción no se contempla en la API
	 
	 public void borrar_mensajes_privados() throws Exception {
	 
		 String[] respuesta = acc.borrarMensajesPrivados(username,password);
		 System.out.println(respuesta[1].toString());
		 
	 }

}
