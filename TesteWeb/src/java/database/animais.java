/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author gabri
 */
public class animais {
    //Construtor do objeto
    public animais(String nome, String especie, String cor, String raca, int idade, String castrado, String vacinacao, String dataChegada, String adotado, int adotante, String nascimento, String porte, int cadastrador, String observacao) {
        this.nome = nome;
        this.especie = especie;
        this.cor = cor;
        this.raca = raca;
        this.idade = idade;
        this.castrado = castrado;
        this.vacinacao = vacinacao;
        this.dataChegada = dataChegada;
        this.adotado = adotado;
        this.nascimento = nascimento;
        this.porte = porte;
        this.cadastrador = cadastrador;
        this.adotante = adotante;
        this.observacao = observacao;
    }
    
    public animais() {
        
    }
    
    //Esses atributos vão ser os primeiros a ser inicializados.
    private int codigo;
    private String nome;
    private String especie;
    private String cor;
    private String raca;
    private int idade;
    private String castrado;
    private String vacinacao;
    private String dataChegada;
    private String adotado;
    private int adotante;
    private String nascimento;
    private String porte;
    private int cadastrador;
    private String observacao;
    
    //Funções getters, irao retornar o valor de cada atributo do odjeto
    public int getCodigo(){
        return this.codigo;
    }
    public String getNome() {
        return this.nome;
    }
    public String getEspecie() {
        return this.especie;
    }
    public String getCor() {
        return this.cor;
    }
    public String getRaca() {
        return this.raca;
    }
    public int getIdade() {
        return this.idade;
    }
    public String getCastrado() {
        return this.castrado;
    }
    public String getVacinacao() {
        return this.vacinacao;
    }
    public String getDataChegada() {
        return this.dataChegada;
    }
    public String getAdotado() {
        return this.adotado;
    }
    public int getAdotante() {
        return this.adotante;
    }
    public String getNascimento() { 
        return this.nascimento;
    }
    public String getPorte() {
        return this.porte;
    }
    public int getCadastrador() {
        return this.cadastrador;
    }
    public String getObservacao() {
        return this.observacao;
    }
    //=================================
    
    public int setCodigo(int codigo){
        this.codigo = codigo;
        return this.codigo;
    }
    public String setNome(String nome) {
        this.nome = nome;
        return this.nome;
    }
    public String setEspecie(String especie) {
        this.especie = especie;
        return this.especie;
    }
    public String setCor(String cor) {
        this.cor = cor;
        return this.cor;
    }
    public String setRaca(String raca) {
        this.raca = raca;
        return this.raca;
    }
    public int setIdade(int idade) {
        this.idade = idade;
        return this.idade;
    }
    public String setCastrado(String castrado) {
        this.castrado = castrado;
        return this.castrado;
    }
    public String setVacinacao(String vacinacao) {
        this.vacinacao = vacinacao;
        return this.vacinacao;
    }
    public String setDataChegada(String dataChegada) {
        this.dataChegada = dataChegada;
        return this.dataChegada;
    }
    public String setAdotado(String adotado) {
        this.adotado = adotado;
        return this.adotado;
    }
    public int setAdotante(int adotante) {
        this.adotante = adotante;
        return this.adotante;
    }
    public String setNascimento(String nascimento) { 
        this.nascimento = nascimento;
        return this.nascimento;
    }
    public String setPorte(String porte) {
        this.porte = porte;
        return this.porte;
    }
    public int setCadastrador(int cadastrador) {
        this.cadastrador = cadastrador;
        return this.cadastrador;
    }
    public String setObservacao(String observacao) {
        this.observacao = observacao;
        return this.observacao;
    }
    
}
