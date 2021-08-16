package pe.gob.unmsm.sgv.models;



public class Pedido {
        private int pedidoid;
	private String username;
        private char estado;
    	private String createdat;
        private String updatedat;
		
        
        public int getPedidoid() {
            return pedidoid;
	}
        
        public void setPedidoid(int pedidoid) {
            this.pedidoid = pedidoid;
	}
		
        public String getUsername() {
			
            return username;
		
        }
		
        public void setUsername(String username) {
			
            this.username = username;
		
        }
		
        public char getEstado() {
			
            return estado;
		
        }
		
        public void setEstado(char estado) {
			
            this.estado = estado;
		
        }
		
        public String getCreatedat() {
			
            return createdat;
		
        }
		
        public void setCreatedat(String createdat) {
			
            this.createdat = createdat;
		
        }
		
        public String getUpdatedat() {
			
            return updatedat;
		
        }
		
        public void setUpdatedat(String updatedat) {
			
            this.updatedat = updatedat;
		
        }
        
		
	
}
