package model;

import controller.DataAccessObject;
import java.util.ArrayList;

public class TipoUsuario extends DataAccessObject {

    private int codTipoUsuario;
    private String nome;
    private String modAdministrativo;
    private String modAtendimento;
    
    public TipoUsuario() {
        super("tipo_usuario");
    }
    
    public int getCodTipoUsuario() {
        return codTipoUsuario;
    }

    public String getNome() {
        return nome;
    }
    
    public String getModAdministrativo() {
        return modAdministrativo;
    }
    
    public String getModAtendimento() {
        return modAtendimento;
    }
    
    public void setCodTipoUsuario(int codTipoUsuario) {
        if(codTipoUsuario != this.codTipoUsuario) {
            this.codTipoUsuario = codTipoUsuario;
            addChange("cod_tipo_usuario", this.codTipoUsuario);
        };
    }

    public void setNome(String nome) {
        if(!nome.equals(this.nome)) {
            this.nome = nome;
            addChange("nome", this.nome);
        }
    }

    public void setModAdministrativo(String modAdministrativo) {
        if(!modAdministrativo.equals(this.modAdministrativo)) {
            this.modAdministrativo = modAdministrativo;
            addChange("modulo_administrativo", this.modAdministrativo);
        }
    }

    public void setModAtendimento(String modAtendimento) {
        if(!modAtendimento.equals(this.modAtendimento)) {
            this.modAtendimento = modAtendimento;
            addChange("modulo_atendimento", this.modAtendimento);
        }
    }
    
    @Override
    public void fill(ArrayList<Object> data) throws Exception {
        codTipoUsuario = (int) data.get(0);
        nome = (String) data.get(1);
        modAdministrativo = (String) data.get(2);
        modAtendimento = (String) data.get(3);
    }
    
    @Override
    public boolean equals(Object obj) {        
        if(obj instanceof TipoUsuario) {
           
           TipoUsuario aux;
           aux = (TipoUsuario) obj;
            
           if(codTipoUsuario == aux.getCodTipoUsuario()) {
               return true;
           }             
        }        
        return false;
    }

    @Override
    public String getWhereClauseForOneEntry() {
        return " cod_tipo_usuario = " + this.codTipoUsuario;
    }
}
