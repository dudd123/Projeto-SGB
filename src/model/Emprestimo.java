package model;

import controller.DataAccessObject;
import java.util.ArrayList;

public class Emprestimo extends DataAccessObject {
    
    private int codEmprestimo;
    private String dataEmprestimo;
    private String dataDevolucao;
    private float valorMulta;
    
    private Usuario usuario;
    
    private CopiaObra copiaObra;
    
    public Emprestimo() {
        super("emprestimo");
    }

    public int getCodEmprestimo() {
        return codEmprestimo;
    }
    
    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }
    
    public CopiaObra getCopiaObra() {
        return copiaObra;
    }
    
    public float getValorMulta() {
        return valorMulta;
    }
    
    public void setCodEmprestimo(int codEmprestimo) {
        if(codEmprestimo != this.codEmprestimo) {
            this.codEmprestimo = codEmprestimo;
            addChange("cod_emprestimo", this.codEmprestimo);
        }
    }

    public void setDataEmprestimo(String dataEmprestimo) {
        if(!dataEmprestimo.equals(this.dataEmprestimo)) {
            this.dataEmprestimo = dataEmprestimo;
            addChange("data_emprestimo", this.dataEmprestimo);
        }
    }

    public void setDataDevolucao(String dataDevolucao) {
        if(!dataDevolucao.equals(this.dataDevolucao)) {
            this.dataDevolucao = dataDevolucao;
            addChange("data_devolucao", this.dataDevolucao);
        }
    }

    public void setValorMulta(float valorMulta) {
        if(valorMulta != this.valorMulta) {
            this.valorMulta = valorMulta;
            addChange("valor_multa", this.valorMulta);
        }
    }
    
    public void setUsuario(Usuario usuario) throws Exception {        
        if(this.usuario  == null) {            
            if(usuario != null) {                
                this.usuario = new Usuario();
                this.usuario.setCodUsuario(usuario.getCodUsuario());
                this.usuario.load();
                addChange("cod_usuario", this.usuario.getCodUsuario());                
            }            
        } else{            
            if(usuario == null) {                
                this.usuario = null;
                addChange("cod_usuario", null);                
            } else{                
                if(!this.usuario.equals(usuario)) {                    
                    this.usuario.setCodUsuario(usuario.getCodUsuario());
                    this.usuario.load();
                    addChange("cod_usuario", this.usuario.getCodUsuario());
                }                
            }
        }
    }
    
    public void setCopiaObra(CopiaObra copiaObra) throws Exception {        
        if(this.copiaObra  == null) {            
            if(copiaObra != null) {                
                this.copiaObra = new CopiaObra();
                this.copiaObra.setCodCopiaObra(copiaObra.getCodCopiaObra());
                this.copiaObra.load();
                addChange("cod_copia_obra", this.copiaObra.getCodCopiaObra());                
            }            
        } else{            
            if(copiaObra == null) {                
                this.copiaObra = null;
                addChange("cod_copia_obra", null);                
            } else{                
                if(!this.copiaObra.equals(copiaObra)) {                    
                    this.copiaObra.setCodCopiaObra(copiaObra.getCodCopiaObra());
                    this.copiaObra.load();
                    addChange("cod_copia_obra", this.copiaObra.getCodCopiaObra());
                }                
            }
        }
    }
    
    @Override
    public void fill(ArrayList<Object> data) throws Exception {
        codEmprestimo = (int) data.get(0);
        
        if(data.get(1) != null){            
            dataEmprestimo = (String) data.get(1).toString();
        }
        
        if(data.get(2) != null){            
            dataDevolucao = (String) data.get(2).toString();
        }
        
        valorMulta = (float) data.get(3);
        
        if(data.get(4) != null) {
            if(usuario == null) {
                usuario = new Usuario();
            }
            
            usuario.setCodUsuario((int) data.get(4));
            usuario.load();
        }
        
        if(data.get(5) != null) {
            if(copiaObra == null) {
                copiaObra = new CopiaObra();
            }
            
            copiaObra.setCodCopiaObra((int) data.get(5));
            copiaObra.load();
        }
    }

    @Override
    public String getWhereClauseForOneEntry() {
        return " cod_emprestimo = " + this.codEmprestimo;
    }
}
