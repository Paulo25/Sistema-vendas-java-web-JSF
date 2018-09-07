package br.com.Vendas.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.Vendas.domain.Produto;
import br.com.Vendas.domain.Vendas;
import br.com.Vendas.util.HibernateUtil;

public class VendasDAO {
	
	public Long salvar(Vendas venda) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null;
		Long codigo = null;
		
		try {
			transacao = sessao.beginTransaction(); // abrindo a transação
			codigo = (Long) sessao.save(venda);
			transacao.commit(); // confirmando a transação

		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback(); // desfaz a transação
			}
		
		}

		finally {
			sessao.close();
		}

		return codigo;
		
	}

	@SuppressWarnings("unchecked")
	public List<Vendas> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		List<Vendas> venda = null;

		try {
			
			Query consulta = sessao.getNamedQuery("Venda.listar");
			venda = consulta.list();
			

		} catch (RuntimeException ex) {
			throw ex;
		}

		finally {
			sessao.close();
		}
		
		return venda;
	}
	
	
	
	public Vendas buscarPorCodigo(Long codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Vendas venda = null;

		try {
			
			Query consulta = sessao.getNamedQuery("Venda.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			venda = (Vendas) consulta.uniqueResult();
			

		} catch (RuntimeException ex) {
			throw ex;
		}

		finally {
			sessao.close();
		}
		
		return venda;
	}
	
	
	public void excluir(Vendas venda) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction(); // abrindo a transação
			sessao.delete(venda);
			transacao.commit(); // confirmando a transação

		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback(); // desfaz a transação
			}

		}

		finally {
			sessao.close();
		}

	}
	
	
	
	public void editar(Vendas venda) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction(); // abrindo a transação
			
			sessao.update(venda);
			transacao.commit(); // confirmando a transação

		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback(); // desfaz a transação
			}

		}

		finally {
			sessao.close();
		}

	}
	
	
}
