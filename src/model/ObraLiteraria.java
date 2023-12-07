package model;

import controller.DataAccessObject;
import java.util.ArrayList;

public class ObraLiteraria extends DataAccessObject {
    
    private int codObraLiteraria;
    private String titulo;
    private String autor;
    private String editora;
    private String nroEdicao;
    private String dataPublicacao;
    private String isbn;
    private String qtdPagina;
    
    private TipoObra tipoObra;
    
    public ObraLiteraria(){
        super("obra_literaria");
    }

    public int getCodObraLiteraria() {
        return codObraLiteraria;
    }

    public String getTitulo() {
        return titulo;
    }
    
    public String getAutor() {
        return autor;
    }
    
    public String getEditora() {
        return editora;
    }
    
    public String getNroEdicao() {
        return nroEdicao;
    }
    
    public String getDataPublicacao() {
        return dataPublicacao;
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    public String getQtdPagina() {
        return qtdPagina;
    }
    
    public TipoObra getTipoObra() {
        return tipoObra;
    }
    
    public void setCodObraLiteraria(int codObraLiteraria) {
        if(codObraLiteraria != this.codObraLiteraria) {
            this.codObraLiteraria = codObraLiteraria;
            addChange("cod_obra_literaria", this.codObraLiteraria);
        }
    }

    public void setTitulo(String titulo) {
        if(!titulo.equals(this.titulo)) {
            this.titulo = titulo;
            addChange("titulo", this.titulo);
        }
    }

    public void setAutor(String autor) {
        if(!autor.equals(this.autor)) {
            this.autor = autor;
            addChange("autor", this.autor);
        }
    }

    public void setEditora(String editora) {
        if(!editora.equals(this.editora)) {
            this.editora = editora;
            addChange("editora", this.editora);
        }
    }

    public void setNroEdicao(String nroEdicao) {
        if(!nroEdicao.equals(this.nroEdicao)) {
            this.nroEdicao = nroEdicao;
            addChange("nro_edicao", this.nroEdicao);
        }
    }

    public void setDataPublicacao(String dataPublicacao) {
        if(!dataPublicacao.equals(this.dataPublicacao)) {
            this.dataPublicacao = dataPublicacao;
            addChange("data_publicacao", this.dataPublicacao);
        }
    }

    public void setIsbn(String isbn) {
        if(!isbn.equals(this.isbn)) {
            this.isbn = isbn;
            addChange("isbn", this.isbn);
        }
    }

    public void setQtdPagina(String qtdPagina) {
        if(!qtdPagina.equals(this.qtdPagina)) {
            this.qtdPagina = qtdPagina;
            addChange("qtd_pagina", this.qtdPagina);
        }
    }
    
    public void setTipoObra(TipoObra tipoObra) throws Exception {
        if(this.tipoObra  == null) {            
            if(tipoObra != null) {                
                this.tipoObra = new TipoObra();
                this.tipoObra.setCodTipoObra(tipoObra.getCodTipoObra());
                this.tipoObra.load();
                addChange("cod_tipo_obra", this.tipoObra.getCodTipoObra());                
            }            
        } else{            
            if(tipoObra == null) {                
                this.tipoObra = null;
                addChange("cod_tipo_obra", null);                
            } else{                
                if(!this.tipoObra.equals(tipoObra)) {                    
                    this.tipoObra.setCodTipoObra(tipoObra.getCodTipoObra());
                    this.tipoObra.load();
                    addChange("cod_tipo_obra", this.tipoObra.getCodTipoObra());
                }                
            }
        }  
    }

    @Override
    public void fill(ArrayList<Object> data) throws Exception {
        codObraLiteraria = (int) data.get(0);
        titulo = (String) data.get(1);
        autor = (String) data.get(2);
        editora = (String) data.get(3);
        nroEdicao = (String) data.get(4);
        
        if(data.get(5) != null){            
            dataPublicacao = (String) data.get(5).toString();
        }
        
        isbn = (String) data.get(6);
        qtdPagina = (String) data.get(7);
        
        if(data.get(8) != null) {
            if(tipoObra == null) {
                tipoObra = new TipoObra();
            }
            
            tipoObra.setCodTipoObra((int) data.get(8));
            tipoObra.load();
        }
    }

    @Override
    public String getWhereClauseForOneEntry() {
        return " cod_obra_literaria = " + this.codObraLiteraria;
    }
}
