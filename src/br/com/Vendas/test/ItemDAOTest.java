package br.com.Vendas.test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.Vendas.DAO.FornecedoresDAO;
import br.com.Vendas.DAO.ItemDAO;
import br.com.Vendas.DAO.ProdutosDAO;
import br.com.Vendas.DAO.VendasDAO;
import br.com.Vendas.domain.Fornecedor;
import br.com.Vendas.domain.Item;
import br.com.Vendas.domain.Produto;
import br.com.Vendas.domain.Vendas;

public class ItemDAOTest {

	
	@Test
	@Ignore
	public void salvar(){
		
		ProdutosDAO dao = new ProdutosDAO();
		Produto produto = dao.buscarPorCodigo(1L);
		
		VendasDAO vdao = new VendasDAO();
		Vendas vendas = vdao.buscarPorCodigo(3L);
		
		Item f1 = new Item();
		
		
		f1.setQuantidade(8);
		f1.setValor_parcial(new BigDecimal(150.99D));
		f1.setProduto(produto);
		f1.setVenda(vendas);
		
		ItemDAO itensdao = new ItemDAO();
		
		itensdao.salvar(f1);
		
	}
	
	
	@Test
	@Ignore
	public void listar(){
		ItemDAO dao = new ItemDAO();
		List<Item> item = dao.listar();
		
		
			System.out.println(item);
		
	}
	
	
	@Test
	@Ignore
		public void buscarPorCodigo(){
		ItemDAO dao = new ItemDAO();
		Item f1 = dao.buscarPorCodigo(2L);
		
		
			System.out.println(f1);
			
	}
	
	@Test
	@Ignore
	public void excluir(){
		ItemDAO dao = new ItemDAO();
		
		Item item = dao.buscarPorCodigo(2L);
		
		
		dao.excluir(item);
		
		
	}
	
	
	@Test
	
	public void editar(){
		
		ProdutosDAO pdao = new ProdutosDAO();
		Produto produto = pdao.buscarPorCodigo(3L);
		
		VendasDAO vdao = new VendasDAO();
		Vendas vendas = vdao.buscarPorCodigo(1L);
		
		ItemDAO dao = new ItemDAO();
		
		Item item = dao.buscarPorCodigo(3L);
		
		item.setValor_parcial(new BigDecimal(5.99D));
		item.setQuantidade(2);
		item.setProduto(produto);
		item.setVenda(vendas);
		
		dao.editar(item);
		
			
	}
	
	
	
}
