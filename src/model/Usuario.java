package model;

import controller.DataAccessObject;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;

public class Usuario extends DataAccessObject {

    private int codUsuario;
    private String nomeCompleto;
    private String cpf;
    private String rg;
    private String dataNasc;
    private String senhaAcesso;
    private String telefone;
    private String celular;
    private String email;
    private String endereco;
    private String nro;
    private String compl;
    private String bairro;
    private String cidade;
    private String estado;
    
    private TipoUsuario tipoUsuario;
    
    public Usuario(){
        super("usuario");
    }
    
    public int getCodUsuario() {
        return codUsuario;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }
    
    public String getCpf() {
        return cpf;
    }
    
    public String getRg() {
        return rg;
    }
    
    public String getDataNasc() {
        return dataNasc;
    }
    
    public String getSenhaAcesso() {
        return senhaAcesso;
    }
    
    public String getTelefone() {
        return telefone;
    }
    
    public String getCelular() {
        return celular;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getEndereco() {
        return endereco;
    }
    
    public String getNro() {
        return nro;
    }
    
    public String getCompl() {
        return compl;
    }
    
    public String getBairro() {
        return bairro;
    }
    
    public String getCidade() {
        return cidade;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }
    
    public void setCodUsuario(int codUsuario) {
        if(codUsuario != this.codUsuario) {
            this.codUsuario = codUsuario;
            addChange("cod_usuario", this.codUsuario);
        }
    }

    public void setNomeCompleto(String nomeCompleto) {
        if(!nomeCompleto.equals(this.nomeCompleto)) {
            this.nomeCompleto = nomeCompleto;
            addChange("nome_completo", this.nomeCompleto);
        }
    }
    
    public void setCpf(String cpf) {
        if(!cpf.equals(this.cpf)) {
            this.cpf = cpf;
            addChange("cpf", this.cpf);
        }
    }

    public void setRg(String rg) {
        if(!rg.equals(this.rg)) {
            this.rg = rg;
            addChange("rg", this.rg);
        }
    }

    public void setDataNasc(String dataNasc) {
        if(!dataNasc.equals(this.dataNasc)) {
            this.dataNasc = dataNasc;
            addChange("data_nascimento", this.dataNasc);
        }
    }

    public void setSenhaAcesso(String senhaAcesso) {
        if(!senhaAcesso.equals(this.senhaAcesso)) {
            this.senhaAcesso = getSenhaHash(senhaAcesso);
            addChange("senha_acesso", this.senhaAcesso);
        }
    }

    public void setTelefone(String telefone) {
        if(!telefone.equals(this.telefone)) {
            this.telefone = telefone;
            addChange("telefone", this.telefone);
        }
    }

    public void setCelular(String celular) {
        if(!celular.equals(this.celular)) {
            this.celular = celular;
            addChange("celular", this.celular);
        }
    }

    public void setEmail(String email) {
        if(!email.equals(this.email)) {
            this.email = email;
            addChange("email", this.email);
        }
    }

    public void setEndereco(String endereco) {
        if(!endereco.equals(this.endereco)) {
            this.endereco = endereco;
            addChange("endereco", this.endereco);
        }
    }

    public void setNro(String nro) {
        if(!nro.equals(this.nro)) {
            this.nro = nro;
            addChange("nro", this.nro);
        }
    }

    public void setCompl(String compl) {
        if(!compl.equals(this.compl)) {
            this.compl = compl;
            addChange("compl", this.compl);
        }
    }

    public void setBairro(String bairro) {
        if(!bairro.equals(this.bairro)) {
            this.bairro = bairro;
            addChange("bairro", this.bairro);
        }
    }

    public void setCidade(String cidade) {
        if(!cidade.equals(this.cidade)) {
            this.cidade = cidade;
            addChange("cidade", this.cidade);
        }
    }

    public void setEstado(String estado) {
        if(!estado.equals(this.estado)) {
            this.estado = estado;
            addChange("estado", this.estado);
        }
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) throws Exception {        
        if(this.tipoUsuario  == null) {            
            if(tipoUsuario != null) {                
                this.tipoUsuario = new TipoUsuario();
                this.tipoUsuario.setCodTipoUsuario(tipoUsuario.getCodTipoUsuario());
                this.tipoUsuario.load();
                addChange("cod_tipo_usuario", this.tipoUsuario.getCodTipoUsuario());                
            }            
        } else{            
            if(tipoUsuario == null) {                
                this.tipoUsuario = null;
                addChange("cod_tipo_usuario", null);                
            } else{                
                if(!this.tipoUsuario.equals(tipoUsuario)) {                    
                    this.tipoUsuario.setCodTipoUsuario(tipoUsuario.getCodTipoUsuario());
                    this.tipoUsuario.load();
                    addChange("cod_tipo_usuario", this.tipoUsuario.getCodTipoUsuario());
                }                
            }
        }        
    }
    
    private String getSenhaHash(String senhaAcesso) {
        String senhaHash = "";
        try {            
            MessageDigest md = MessageDigest.getInstance("SHA-256");            
            senhaAcesso += String.valueOf(getCodUsuario()); // Técnica de Proteção de Morris-Thompson (Sal n-bits)            
            senhaHash = new BigInteger(1, md.digest( senhaAcesso.getBytes("UTF-8"))).toString(16);       
        } catch (Exception ex) {
            ex.printStackTrace();
        }               
        return senhaHash;
    }
    
    @Override
    public void fill(ArrayList<Object> data) throws Exception {
        codUsuario = (int) data.get(0);
        nomeCompleto = (String) data.get(1);
        cpf = (String) data.get(2);
        rg = (String) data.get(3);
        
        if(data.get(4) != null){
            dataNasc = (String) data.get(4).toString();
        }
        
        senhaAcesso = (String) data.get(5);
        telefone = (String) data.get(6);
        celular = (String) data.get(7);
        email = (String) data.get(8);
        endereco = (String) data.get(9);
        nro = (String) data.get(10);
        compl = (String) data.get(11);
        bairro = (String) data.get(12);
        cidade = (String) data.get(13);
        estado = (String) data.get(14);
        
        if(data.get(15) != null) {
            if(tipoUsuario == null) {
                tipoUsuario = new TipoUsuario();
            }
            
            tipoUsuario.setCodTipoUsuario((int) data.get(15));
            tipoUsuario.load();
        }
        
    }

    @Override
    public String getWhereClauseForOneEntry() {
        return " cod_usuario = " + this.codUsuario;
    }
}
