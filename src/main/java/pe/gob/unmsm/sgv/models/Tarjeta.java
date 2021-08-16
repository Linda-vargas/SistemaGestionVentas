
package pe.gob.unmsm.sgv.models;

public class Tarjeta {
    private int tarjetaid;
    private String fechavencimiento;
    private float saldo;
    private char estado;
    private String createdat;
    private String updatedat;

    public int getTarjetaid() {
        return tarjetaid;
    }

    public void setTarjetaid(int tarjetaid) {
        this.tarjetaid = tarjetaid;
    }
    
    public String getFechavencimiento() {
        return fechavencimiento;
    }

    public void setFechavencimiento(String fechavencimiento) {
        this.fechavencimiento = fechavencimiento;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
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
