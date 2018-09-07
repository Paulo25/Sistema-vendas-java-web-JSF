package br.com.Vendas.Bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.Vendas.DAO.FornecedoresDAO;
import br.com.Vendas.DAO.FuncionariosDAO;
import br.com.Vendas.DAO.ItemDAO;
import br.com.Vendas.DAO.ProdutosDAO;
import br.com.Vendas.DAO.VendasDAO;
import br.com.Vendas.domain.Fornecedor;
import br.com.Vendas.domain.Funcionario;
import br.com.Vendas.domain.Item;
import br.com.Vendas.domain.Produto;
import br.com.Vendas.domain.Vendas;
import br.com.Vendas.util.JSFUtil;

@ManagedBean(name = "MBVendas")
@ViewScoped
public class VendasBean {

	 private Produto produto;
	 private Vendas vendaCadastro;
	 private List<Item>itens;
	 private List<Item>itensFiltrados;
	 
	 private List<Produto>produtos;
	 private List<Produto>produtosFiltrados;
	
	 
	 public Vendas getVendaCadastro() {
		 if(vendaCadastro == null){
			vendaCadastro = new Vendas();
			vendaCadastro.setValor_total(new BigDecimal("0.00"));
		 }
		return vendaCadastro;
	}
	 
	 public void setVendaCadastro(Vendas vendaCadastro) {
		this.vendaCadastro = vendaCadastro;
	}
	
	public List<Item> getItens() {
		if(itens == null){
			itens = new ArrayList<>();
		}
		return itens;
	}
	
	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	
	
	public List<Item> getItensFiltrados() {
		return itensFiltrados;
	}
	
	public void setItensFiltrados(List<Item> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}
	 
	 
	
	 
	 
	 public Produto getProduto() {
		return produto;
	}
	 
	 public void setProduto(Produto produto) {
		this.produto = produto;
	}
	 
	 
	 public List<Produto> getProdutos() {
		return produtos;
	}
	 
	 public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	 
	 
	 public List<Produto> getProdutosFiltrados() {
		return produtosFiltrados;
	}
	 
	 public void setProdutosFiltrados(List<Produto> produtosFiltrados) {
		this.produtosFiltrados = produtosFiltrados;
	}
	 

	 
	 public void carregarProdutos(){
			
		 try {
			 ProdutosDAO fdao = new ProdutosDAO();
		 produtos = (ArrayList<Produto>) fdao.listar();
		
		 } catch (RuntimeException e) {
		 JSFUtil.adicionarMensagemErro("ex.getMessage()");
		 e.printStackTrace();
		 }
		
		 }
	
	 
	 public void adicionar(Produto produto){
		 
		 int posicaoEncontrada = -1;
		 
		 for(int pos = 0; pos < itens.size() && posicaoEncontrada < 0; pos++){
			Item itemTemp = itens.get(pos);
			
			if(itemTemp.getProduto().equals(produto)){
				posicaoEncontrada = pos;
			}
		 }
		 
		 
		 Item item = new Item();
		 item.setProduto(produto);
		 
		 
		 if(posicaoEncontrada < 0){
		 item.setQuantidade(1);
		 item.setValor_parcial(produto.getPreco());
		 itens.add(item);
		 } else{		 
		
			 Item itemTemp = itens.get(posicaoEncontrada);
			 item.setQuantidade(itemTemp.getQuantidade() + 1);
			 item.setValor_parcial(produto.getPreco().multiply(new BigDecimal(item.getQuantidade())));
			 itens.set(posicaoEncontrada, item);
		 
		 }
		 
		 vendaCadastro.setValor_total(vendaCadastro.getValor_total().add(produto.getPreco()));
		 
	 }
	 
	 public void remover(Item item){
		 
      int posicaoEncontrada = -1;
		 
		 for(int pos = 0; pos < itens.size() && posicaoEncontrada < 0; pos++){
			Item itemTemp = itens.get(pos);
			
			if(itemTemp.getProduto().equals(item.getProduto())){
				posicaoEncontrada = pos;
			}
		 }
		 
		 if(posicaoEncontrada > -1){
			 itens.remove(posicaoEncontrada);
			 vendaCadastro.setValor_total(vendaCadastro.getValor_total().subtract(item.getValor_parcial()));
		 }
		 
	 }
	 
	 public void carregarDadosVenda(){
		 vendaCadastro.setHorario(new Date());
		 
		 FuncionariosDAO dao = new FuncionariosDAO();
		 Funcionario funcionario = dao.buscarPorCodigo(4L);
		 vendaCadastro.setFuncionario(funcionario);
	 }
	 
	 public void salvar(){
		 try {
			
			 
			 VendasDAO vdao = new VendasDAO();
			 Long codigoVenda = vdao.salvar(vendaCadastro);
			 
			 Vendas vendaFK = vdao.buscarPorCodigo(codigoVenda);
			 
			 for(Item item : itens){
				 item.setVenda(vendaFK);
				 ItemDAO itemdao = new ItemDAO();
				 itemdao.salvar(item);
			 }
			 
			 vendaCadastro = new Vendas();
			 vendaCadastro.setValor_total(new BigDecimal("0.00"));
			 itens = new ArrayList<Item>();
		 
		 JSFUtil.adicionarMensagemSucesso("Salvo com Sucesso");
		
		 } catch (RuntimeException e) {
		 JSFUtil.adicionarMensagemErro("ex.getMessage()");
		 e.printStackTrace();
		 }
		 
	 }
	
}
