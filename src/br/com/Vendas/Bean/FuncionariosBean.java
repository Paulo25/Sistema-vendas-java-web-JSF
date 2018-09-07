package br.com.Vendas.Bean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


import br.com.Vendas.DAO.FuncionariosDAO;

import br.com.Vendas.domain.Funcionario;
import br.com.Vendas.util.JSFUtil;

@ManagedBean(name = "MBFuncionarios")
@ViewScoped
public class FuncionariosBean {
	private Funcionario funcionario;

	 private ArrayList<Funcionario>itens;
	 private ArrayList<Funcionario>itensFiltrados;
	 private String acao;
	 private Long codigo;
	 
	 
	 public Long getCodigo() {
		return codigo;
	}
	 
	 
	 public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	 
	 
	 public String getAcao() {
		return acao;
	}
	 
	 
	 public void setAcao(String acao) {
		this.acao = acao;
	}
	
	public Funcionario getFuncionario() {
		
		return funcionario;
	}

	//
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	 public ArrayList<Funcionario> getItens() {
	 return itens;
	 }
	
	 public void setItens(ArrayList<Funcionario> itens) {
	 this.itens = itens;
	 }
	
	
	 public ArrayList<Funcionario> getItensFiltrados() {
	 return itensFiltrados;
	 }
	
	 public void setItensFiltrados(ArrayList<Funcionario> itensFiltrados) {
	 this.itensFiltrados = itensFiltrados;
	 }

	// @PostConstruct
	 public void prepararPesquisa(){
		
	 try {
		 FuncionariosDAO fdao = new FuncionariosDAO();
	 itens = (ArrayList<Funcionario>) fdao.listar();
	
	 } catch (RuntimeException e) {
	 JSFUtil.adicionarMensagemErro("ex.getMessage()");
	 e.printStackTrace();
	 }
	
	 }
	 
	 
	 public void carregarCadastro(){

		 try {
		     
			
			 if(codigo != null){
				
				 
				 FuncionariosDAO fdao = new FuncionariosDAO();	
			
			funcionario = fdao.buscarPorCodigo(codigo);
				 
			 }
			 else
				 {
				 funcionario = new Funcionario();
				
			 }
			 
		
		 } catch (RuntimeException e) {
		 JSFUtil.adicionarMensagemErro("ex.getMessage()");
		 e.printStackTrace();
		 }
		
		 } 
	 

	 public void novo(){
		 funcionario = new Funcionario();
	 }

	public void salvar() {

		try {
			FuncionariosDAO fdao = new FuncionariosDAO();
			fdao.salvar(funcionario);
			
			funcionario = new Funcionario();

			

			JSFUtil.adicionarMensagemSucesso("Funcionário salvo com sucesso!");

		} catch (RuntimeException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
	}

	
	
	 public void excluir(){
	 try {
		 FuncionariosDAO fdao = new FuncionariosDAO();
	 fdao.excluir(funcionario);
	
	
	
	 JSFUtil.adicionarMensagemSucesso("Funcionário excluido com sucesso!");
	
	 } catch (RuntimeException e) {
	 JSFUtil.adicionarMensagemErro("Não é possível excluir um funcionário que tenha uma venda associado!");
	 e.printStackTrace();
	 }
	 }
	
	
	
	
	
	 public void editar(){
	 try {
		 FuncionariosDAO fdao = new FuncionariosDAO();
	 fdao.editar(funcionario);
	
	
	 JSFUtil.adicionarMensagemSucesso("Funcionário editado com sucesso!");
	
	 } catch (RuntimeException e) {
	 JSFUtil.adicionarMensagemErro("ex.getMessage()");
	 e.printStackTrace();
	 }
	 }
}
