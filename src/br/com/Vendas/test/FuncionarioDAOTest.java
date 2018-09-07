package br.com.Vendas.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.Vendas.DAO.FornecedoresDAO;
import br.com.Vendas.DAO.FuncionariosDAO;
import br.com.Vendas.domain.Fornecedor;
import br.com.Vendas.domain.Funcionario;

public class FuncionarioDAOTest {
	@Test
	@Ignore
	public void salvar(){
		Funcionario f1 = new Funcionario();
		
		
		f1.setNome("Pedro Freitas");
		f1.setCpf("07014588936");
		f1.setSenha("123");
		f1.setFuncao("funcionário");
		
		
		FuncionariosDAO dao = new FuncionariosDAO();
		
		dao.salvar(f1);
		
	}
	
	@Test
	@Ignore
	public void listar(){
		FuncionariosDAO dao = new FuncionariosDAO();
		List<Funcionario> funcionarios = dao.listar();
		
		for(Funcionario funcionario : funcionarios){
			System.out.println(funcionario);
		}
	}
	
	@Test
	@Ignore
	public void buscarPorCodigo(){
		FornecedoresDAO dao = new FornecedoresDAO();
		Fornecedor f1 = dao.buscarPorCodigo(6L);
		Fornecedor f2 = dao.buscarPorCodigo(4L);
		
			System.out.println(f1);
			System.out.println(f2);
	}
	
	@Test
	@Ignore
	public void excluir(){
		FuncionariosDAO dao = new FuncionariosDAO();
		
		Funcionario funcionario = dao.buscarPorCodigo(5L);
		
		
		dao.excluir(funcionario);
		
		
			
	}
	
	
	
	@Test
	@Ignore
	public void editar(){
		
		FuncionariosDAO dao = new FuncionariosDAO();
		
		Funcionario funcionario = dao.buscarPorCodigo(4L);
		funcionario.setNome("Paula Campos");
		funcionario.setSenha("456");
		funcionario.setCpf("0646454");
		funcionario.setFuncao("Gerente");
		
		dao.editar(funcionario);
		
			
	}
	
}
