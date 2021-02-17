
package br.com.colaborador;

/**
 *
 * @author gabri
 */
public class Colaborador {
    public Colaborador(String nome, int idade, String nascimento, String endereco, int endereco_numero, String cargo, int rg, int cpf, String telefone, String celular, String email, String data_inicio) {
        this.nome = nome;
        this.idade = idade;
        this.nascimento = nascimento;
        this.endereco = endereco;
        this.endereco_numero = endereco_numero;
        this.cargo = cargo;
        this.rg = rg;
        this.cpf = cpf;
        this.telefone = telefone;
        this.celular = celular;
        this.email = email;
        this.data_inicio = data_inicio;
    }
    
    public Colaborador() {
        
    }
    
    private int codigo;
    private String nome;
    private int idade;
    private String nascimento;
    private String endereco;
    private int endereco_numero;
    private String cargo;
    private int rg;
    private int cpf;
    private String telefone;
    private String celular;
    private String email;
    private String data_inicio;
    
    
    //Funções para retornar o valor do atributo
    public int getCodigo() {
        return this.codigo;
    }
    public String getNome() {
        return this.nome;
    }
    public int getIdade() {
        return this.idade;
    }
    public String getNascimento() {
        return this.nascimento;
    }
    public String getEndereco() {
        return this.endereco;
    }
    public int getEndereco_numero() {
        return this.endereco_numero;
    }
    public String getCargo() {
        return this.cargo;
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
    public String getCelular() {
        return this.celular;
    }
    public String getEmail(){
        return this.email;
    }
    public String getData_inicio(){
        return this.data_inicio;
    }
    //=================================
    
    //Funções para mudar o valor dos atributos
    public int setCodigo(int codigo) {
        this.codigo = codigo;
        return this.codigo;
    }
    public String setNome(String nome) {
        this.nome = nome;
        return this.nome;
    }
    public int setIdade(int idade) {
        this.idade = idade;
        return this.idade;
    }
    public String setNascimento(String nascimento) {
        this.nascimento = nascimento;
        return this.nascimento;
    }
    public String setEndereco(String endereco) {
        this.endereco = endereco;
        return this.endereco;
    }
    public int setEndereco_numero(int endereco_numero) {
        this.endereco_numero = endereco_numero;
        return this.endereco_numero;
    }
    public String setCargo(String cargo) {
        this.cargo = cargo;
        return this.cargo;
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
    public String setCelular(String celular) {
        this.celular = celular;
        return this.celular;
    }
    public String setEmail(String email){
        this.email = email;
        return this.email;
    }
    public String setData_inicio(String data_inicio){
        this.data_inicio = data_inicio;
        return this.data_inicio;
    }
     
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
}
