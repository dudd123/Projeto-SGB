package model;

import controller.DataAccessObject;
import java.util.ArrayList;

public class CopiaObra extends DataAccessObject {
    
    private int codCopiaObra;
    private String situacao;
    
    private ObraLiteraria obraLiteraria;
    
    public CopiaObra() {
        super("copia_obra");
    }

    public int getCodCopiaObra() {
        return codCopiaObra;
    }

    public String getSituacao() {
        return situacao;
    }
    
    public ObraLiteraria getObraLiteraria() {
        return obraLiteraria;
    }
    
    public void setCodCopiaObra(int codCopiaObra) {
        if(codCopiaObra != this.codCopiaObra) {
            this.codCopiaObra = codCopiaObra;
            addChange("cod_copia_obra", this.codCopiaObra);
        }
    }

    public void setSituacao(String situacao) {
        if(!situacao.equals(this.situacao)) {
            this.situacao = situacao;
            addChange("situacao", this.situacao);
        }
    }

    public void setObraLiteraria(ObraLiteraria obraLiteraria) throws Exception {        
        if(this.obraLiteraria  == null) {            
            if(obraLiteraria != null) {                
                this.obraLiteraria = new ObraLiteraria();
                this.obraLiteraria.setCodObraLiteraria(obraLiteraria.getCodObraLiteraria());
                this.obraLiteraria.load();
                addChange("cod_obra_literaria", this.obraLiteraria.getCodObraLiteraria());                
            }            
        } else{            
            if(obraLiteraria == null) {                
                this.obraLiteraria = null;
                addChange("cod_obra_literaria", null);                
            } else{                
                if(!this.obraLiteraria.equals(obraLiteraria)) {                    
                    this.obraLiteraria.setCodObraLiteraria(obraLiteraria.getCodObraLiteraria());
                    this.obraLiteraria.load();
                    addChange("cod_obra_literaria", this.obraLiteraria.getCodObraLiteraria());
                }                
            }
        }        
    }

    @Override
    public void fill(ArrayList<Object> data) throws Exception {
        codCopiaObra = (int) data.get(0);
        situacao = (String) data.get(1);
        
        if(data.get(2) != null) {
            if(obraLiteraria == null) {
                obraLiteraria = new ObraLiteraria();
            }
            
            obraLiteraria.setCodObraLiteraria((int) data.get(2));
            obraLiteraria.load();
        }
    }

    @Override
    public String getWhereClauseForOneEntry() {
        return " cod_copia_obra = " + this.codCopiaObra;
    }
    
    @Override
    public boolean equals(Object obj) {        
        if(obj instanceof CopiaObra) {
           
           CopiaObra aux;
           aux = (CopiaObra) obj;
            
           if(codCopiaObra == aux.getCodCopiaObra()) {
               return true;
           }             
        }        
        return false;
    }
}
