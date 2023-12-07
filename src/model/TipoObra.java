package model;

import controller.DataAccessObject;
import java.util.ArrayList;

public class TipoObra extends DataAccessObject {
    
    private int codTipoObra;
    private String descricao;
    
    public TipoObra() {
        super("tipo_obra");
    }

    public int getCodTipoObra() {
        return codTipoObra;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public void setCodTipoObra(int codTipoObra) {
        if(codTipoObra != this.codTipoObra) {
            this.codTipoObra = codTipoObra;
            addChange("cod_tipo_obra", this.codTipoObra);
        }
    }

    public void setDescricao(String descricao) {
        if(!descricao.equals(this.descricao)){
            this.descricao = descricao;
            addChange("descricao", this.descricao);
        }
    }

    @Override
    public void fill(ArrayList<Object> data) throws Exception {
        this.codTipoObra = (int) data.get(0);
        this.descricao = (String) data.get(1);
    }

    @Override
    public String getWhereClauseForOneEntry() {
        return " cod_tipo_obra = " + this.codTipoObra;
    }
    
    @Override
    public boolean equals(Object obj) {        
        if(obj instanceof TipoObra) {
           
           TipoObra aux;
           aux = (TipoObra) obj;
            
           if(codTipoObra == aux.getCodTipoObra()) {
               return true;
           }             
        }        
        return false;
    }
}
