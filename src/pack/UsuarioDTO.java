package pack;

public class UsuarioDTO {
	private  String usuario;
	private  String clave;
	
	public UsuarioDTO() {
		this.usuario = usuario;
		this.clave = clave;
	}
	
	

	public String getUsuario() {
		return usuario;
	}



	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}



	public String getClave() {
		return clave;
	}



	public void setClave(String clave) {
		this.clave = clave;
	}



	public boolean checkAdmin(String usuario, String passw) {
		// TODO Auto-generated method stub
		return false;
	}


}
