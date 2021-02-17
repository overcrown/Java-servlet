
package br.com.adotantes;

/**
 *
 * @author gabri
 */
public class Adotante {
    public Adotante(String nome, int idade, String nascimento, String endereco, int endereco_numero, int rg, int cpf, String telefone, String celular, String email, String aptidao, String documento, String observacao) {
        this.nome = nome;
        this.idade = idade;
        this.nascimento = nascimento;
        this.endereco = endereco;
        this.endereco_numero = endereco_numero;
        this.rg = rg;
        this.cpf = cpf;
        this.telefone = telefone;
        this.celular = celular;
        this.email = email;
        this.aptidao = aptidao;
        this.documento = documento;
        this.observacao = observacao;
    }
    
    public Adotante() {
        
    }
    
    private int codigo;
    private String nome;
    private int idade;
    private String nascimento;
    private String endereco;
    private int endereco_numero;
    private int rg;
    private int cpf;
    private String telefone;
    private String celular;
    private String email;
    private String aptidao;
    private String documento;
    private String observacao;
    
    //FUNÇÕES QUE RETORNAM O VALOR DO ATRIBUTO
    public int getCodigo() {
        return this.codigo;
    }
    public String getNome(){
        return this.nome;
    }
    public int getIdade() {
        return this.idade;
    }
    public String getNascimento(){
        return this.nascimento;
    }
    public String getEndereco(){
        return this.endereco;
    }
    public int getEndereco_numero(){
        return this.endereco_numero;
    }
    public int getRg() {
        return this.rg;
    }
    public int getCpf() {
        return this.cpf;
    }
    public String getTelefone(){
        return this.telefone;
    }
    public String getCelular(){
        return this.celular;
    }
    public String getEmail(){
        return this.email;
    }
    public String getAptidao(){
        return this.aptidao;
    }
    public String getDocumento(){
        return this.documento;
    }
    public String getObservacao(){
        return this.observacao;
    }
    
    //==================================
    //FUNÇÕES QUE MUDAM O VALOR DO ATRIBUTO
    
    public int setCodigo(int codigo) {
        this.codigo = codigo;
        return this.codigo;
    }
    public String setNome(String nome){
        this.nome = nome;
        return this.nome;
    }
    public int setIdade(int idade) {
        this.idade = idade;
        return this.idade;
    }
    public String setNascimento(String nascimento){
        this.nascimento = nascimento;
        return this.nascimento;
    }
    public String setEndereco(String endereco){
        this.endereco = endereco;
        return this.endereco;
    }
    public int setEndereco_numero(int endereco_numero){
        this.endereco_numero = endereco_numero;
        return this.endereco_numero;
    }
    public int setRg(int rg) {
        this.rg = rg;
        return this.rg;
    }
    public int setCpf(int cpf) {
        this.cpf = cpf;
        return this.cpf;
    }
    public String setTelefone(String telefone){
        this.telefone = telefone;
        return this.telefone;
    }
    public String setCelular(String celular){
        this.celular = celular;
        return this.celular;
    }
    public String setEmail(String email){
        this.email = email;
        return this.email;
    }
    public String setAptidao(String aptidao){
        this.aptidao = aptidao;
        return this.aptidao;
    }
    public String setDocumento(String documento){
        this.documento = documento;
        return this.documento;
    }
    public String setObservacao(String observacao){
        this.observacao = observacao;
        return this.observacao;
    }
}
