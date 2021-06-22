package pe.gob.unmsm.sgv.models;

import java.util.List;

public class Pedido {
        private int pedido_id;
	private String username;
        private char estado;
    	private String created_at;
        private String updated_at;
        
		
	public char isEstado() {
		return estado;
	}
	public void setEstado(char estado) {
		this.estado = estado;
	}
	
	public int getPedido_id() {
		return pedido_id;
	}
	public void setPedido_id(int pedido) {
		this.pedido_id = pedido_id;
	}

         public String getUsername() {
        return username;
        }

        public void setUsername(String username) {
        this.username = username;
        }

        

              

        public String getCreated_at() {
        return created_at;
         }

        public void setCreated_at(String created_at) {
        this.created_at = created_at;
        }

        public String getUpdated_at() {
        return updated_at;
        }

        public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
        }
	
}
