package br.com.Vendas.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.Vendas.DAO.FornecedoresDAO;
import br.com.Vendas.domain.Fornecedor;

public class FornecedorDAOTest {

	@Test
	
	public void salvar(){
		Fornecedor f1 = new Fornecedor();
		
		
		f1.setDescricao("Hugo Vasconcelos");
		
		
		FornecedoresDAO dao = new FornecedoresDAO();
		
		dao.salvar(f1);
		
	}
	
	@Test
	@Ignore
	public void listar(){
		FornecedoresDAO dao = new FornecedoresDAO();
		List<Fornecedor> fornecedores = dao.listar();
		
		for(Fornecedor fornecedor : fornecedores){
			System.out.println(fornecedor);
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
		FornecedoresDAO dao = new FornecedoresDAO();
		
		Fornecedor fornecedor = dao.buscarPorCodigo(5L);
		
		
		dao.excluir(fornecedor);
		
		
			
	}
	
	
	
	@Test
	@Ignore
	public void editar(){
		
		FornecedoresDAO dao = new FornecedoresDAO();
		
		Fornecedor fornecedor = dao.buscarPorCodigo(7L);
		fornecedor.setDescricao("Paula Campos");
		
		dao.editar(fornecedor);
		
			
	}
	
}
