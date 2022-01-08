package com.conquistandoavaga.winner;



import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.conquistandoavaga.winner.domain.Categoria;
import com.conquistandoavaga.winner.domain.Cidade;
import com.conquistandoavaga.winner.domain.Cliente;
import com.conquistandoavaga.winner.domain.Endereco;
import com.conquistandoavaga.winner.domain.Estado;
import com.conquistandoavaga.winner.domain.ItemPedido;
import com.conquistandoavaga.winner.domain.Pagamento;
import com.conquistandoavaga.winner.domain.PagamentoComBoleto;
import com.conquistandoavaga.winner.domain.PagamentoComCartao;
import com.conquistandoavaga.winner.domain.Pedido;
import com.conquistandoavaga.winner.domain.Produto;
import com.conquistandoavaga.winner.domain.enums.EstadoPagamento;
import com.conquistandoavaga.winner.domain.enums.TipoCliente;
import com.conquistandoavaga.winner.repositories.CategoriaRepository;
import com.conquistandoavaga.winner.repositories.CidadeRepository;
import com.conquistandoavaga.winner.repositories.ClienteRepository;
import com.conquistandoavaga.winner.repositories.EnderecoRepository;
import com.conquistandoavaga.winner.repositories.EstadoRepository;
import com.conquistandoavaga.winner.repositories.ItemPedidoRepository;
import com.conquistandoavaga.winner.repositories.PagamentoRepository;
import com.conquistandoavaga.winner.repositories.PedidoRepository;
import com.conquistandoavaga.winner.repositories.ProdutoRepository;

@SpringBootApplication
public class WinnerApplication implements CommandLineRunner{
	
	@Autowired
	 private CategoriaRepository categoriaRepository;
	
	@Autowired
	 private ProdutoRepository produtoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired 
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(WinnerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "materiais escolares");
		Categoria cat2 = new Categoria(null, "escritorio");
		
		Produto p1 = new Produto(null, "cp", 2000.00);
		Produto p2 = new Produto(null, "caderno", 15.25);
		Produto p3 = new Produto(null, "lapis", 56.56);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		Estado estado1 = new Estado(null, "minas gerais");
		Estado estado2 = new Estado (null, "sp");
		
		Cidade cidade1 = new Cidade(null, "uberlandia", estado1);
		Cidade cidade2 = new Cidade(null, "sao paulo", estado2);
		Cidade cidade3 = new Cidade(null, "campinas", estado2);
		
		estado1.getCidades().addAll(Arrays.asList(cidade1));
		estado2.getCidades().addAll(Arrays.asList(cidade2, cidade3));
		
		estadoRepository.saveAll(Arrays.asList(estado1, estado2));
		cidadeRepository.saveAll(Arrays.asList(cidade1, cidade2, cidade3));
		
		Cliente cli1 = new Cliente(null, "maria", "aosid@gmail", "61516156615665", TipoCliente.PessoaFisica);
		
		cli1.getTelefones().addAll(Arrays.asList("651656", "544545"));
		
		Endereco endereco1 = new Endereco(null, "rua flores", "12", "apto 23", "jardim", "31231", cidade1, cli1);
		Endereco endereco2 = new Endereco(null, "rua flores torrsad", "6511", "apto 45615", "mato", "6516", cidade3, cli1);
		
		cli1.getEnderecos().addAll(Arrays.asList(endereco1, endereco2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(endereco1, endereco2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		
		Pedido pedido1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, endereco1);
		Pedido pedido2 = new Pedido(null, sdf.parse("10/10/2017 10:32"), cli1, endereco2);
		
		Pagamento pgm1 = new PagamentoComCartao(null, EstadoPagamento.Quitado, pedido1, 6);
		Pagamento pgm2 = new PagamentoComBoleto(null, EstadoPagamento.Pendente, pedido2, sdf.parse("10/10/2017 10:32"),null);
		
		pedido1.setPagamento(pgm1);
		pedido2.setPagamento(pgm2);
		
		cli1.getPedidos().addAll(Arrays.asList(pedido1, pedido2));
		
		pedidoRepository.saveAll(Arrays.asList(pedido1, pedido2));
		pagamentoRepository.saveAll(Arrays.asList(pgm1, pgm2));
		
		ItemPedido itemPedido1 = new ItemPedido(pedido1, p1, 0.0, 1, 2000.00);
		ItemPedido itemPedido2 = new ItemPedido(pedido1, p3, 0.0, 2, 80.00);
		ItemPedido itemPedido3 = new ItemPedido(pedido2, p2, 100.00, 1, 800.00);
		
		pedido1.getItens().addAll(Arrays.asList(itemPedido1, itemPedido2));
		pedido2.getItens().addAll(Arrays.asList( itemPedido3));
		
		p1.getItens().addAll(Arrays.asList(itemPedido1));
		p2.getItens().addAll(Arrays.asList(itemPedido3));
		p3.getItens().addAll(Arrays.asList(itemPedido2));
		
		
		itemPedidoRepository.saveAll(Arrays.asList(itemPedido1, itemPedido2, itemPedido3));
		
		
	}

}
