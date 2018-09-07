package br.com.Vendas.test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.Vendas.DAO.FornecedoresDAO;
import br.com.Vendas.DAO.FuncionariosDAO;
import br.com.Vendas.DAO.ProdutosDAO;
import br.com.Vendas.domain.Fornecedor;
import br.com.Vendas.domain.Funcionario;
import br.com.Vendas.domain.Produto;

public class ProdutoDAOTest {
	
	@Test
	
	public void salvar(){
		
		FornecedoresDAO dao = new FornecedoresDAO();
		Fornecedor fornecedor = dao.buscarPorCodigo(8L);
		
		Produto f1 = new Produto();
		
		
		f1.setDescricao("Tomate");
		f1.setPreco(new BigDecimal(12.99D));
		f1.setQuantidade(4);
		f1.setFornecedor(fornecedor);
		
		
		ProdutosDAO produtosdao = new ProdutosDAO();
		
		produtosdao.salvar(f1);
		
	}
	
	
	@Test
	@Ignore
	public void listar(){
		ProdutosDAO dao = new ProdutosDAO();
		List<Produto> produtos = dao.listar();
		
		
			System.out.println(produtos);
		
	}
	
	
	@Test
	@Ignore
		public void buscarPorCodigo(){
		ProdutosDAO dao = new ProdutosDAO();
		Produto f1 = dao.buscarPorCodigo(2L);
		
		
			System.out.println(f1);
			
	}
	
	@Test
	@Ignore
	public void excluir(){
		ProdutosDAO dao = new ProdutosDAO();
		
		Produto produto = dao.buscarPorCodigo(2L);
		
		
		dao.excluir(produto);
		
		
	}
	
	
	@Test
	@Ignore
	public void editar(){
		
		FornecedoresDAO fdao = new FornecedoresDAO();
		Fornecedor fornecedor = fdao.buscarPorCodigo(6L);
		
		ProdutosDAO dao = new ProdutosDAO();
		
		Produto produto = dao.buscarPorCodigo(3L);
		produto.setDescricao("Tomate");
		produto.setPreco(new BigDecimal(10.99D));
		produto.setQuantidade(2);
		produto.setFornecedor(fornecedor);
		
		dao.editar(produto);
		
			
	}
	
	
}
