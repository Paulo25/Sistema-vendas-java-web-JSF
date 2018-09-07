package br.com.Vendas.test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.Vendas.DAO.FornecedoresDAO;
import br.com.Vendas.DAO.FuncionariosDAO;
import br.com.Vendas.DAO.ProdutosDAO;
import br.com.Vendas.DAO.VendasDAO;
import br.com.Vendas.domain.Fornecedor;
import br.com.Vendas.domain.Funcionario;
import br.com.Vendas.domain.Produto;
import br.com.Vendas.domain.Vendas;

public class VendasDAOTeste {

	@Test
	@Ignore
	public void salvar() {

		FuncionariosDAO dao = new FuncionariosDAO();
		Funcionario funcionario = dao.buscarPorCodigo(4L);

		Vendas f1 = new Vendas();

		f1.setHorario(new Date());
		f1.setValor_total(new BigDecimal(10.00D));
		f1.setFuncionario(funcionario);

		VendasDAO vendasdao = new VendasDAO();

		vendasdao.salvar(f1);

	}

	@Test
	@Ignore
	public void listar() {
		VendasDAO dao = new VendasDAO();
		List<Vendas> vendas = dao.listar();

		System.out.println(vendas);

	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		VendasDAO dao = new VendasDAO();
		Vendas f1 = dao.buscarPorCodigo(2L);

		System.out.println(f1);

	}

	@Test
	@Ignore
	public void excluir() {
		VendasDAO dao = new VendasDAO();

		Vendas venda = dao.buscarPorCodigo(2L);

		dao.excluir(venda);

	}

	@Test

	public void editar() {

		FuncionariosDAO fdao = new FuncionariosDAO();
		Funcionario funcionario = fdao.buscarPorCodigo(1L);

	

		VendasDAO dao = new VendasDAO();
		Vendas f1 = dao.buscarPorCodigo(3L);
		
		f1.setHorario(new Date());
		f1.setValor_total(new BigDecimal(20.00D));
		f1.setFuncionario(funcionario);

		
		dao.editar(f1);

	}

}
