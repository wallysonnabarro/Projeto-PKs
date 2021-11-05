package br.sasclient.service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import br.sasclient.entity.Colaborador;
import br.sasclient.entity.Controles;
import br.sasclient.entity.DescricaoEnty;
import br.sasclient.entity.Descricoes;
import br.sasclient.entity.ListaReposicoes;
import br.sasclient.entity.Ocorrencia;
import br.sasclient.entity.OcorrenciaEnty;
import br.sasclient.entity.Ocorrencias;
import br.sasclient.entity.OcorrenciasAtivas;
import br.sasclient.entity.Pessoa;
import br.sasclient.entity.Pessoas;
import br.sasclient.entity.Prefixo;
import br.sasclient.entity.Prefixos;
import br.sasclient.entity.Relatorio;
import br.sasclient.entity.RelatorioEnty;
import br.sasclient.entity.Reposicoes;
import br.sasclient.entity.Tela;
import br.sasclient.entity.Telas;
import br.sasclient.entity.Titularizacoes;
import br.sasclient.entity.Usuario;
import br.sasclient.entity.Usuarios;

public class ServiceClient {

	/**
	 * GERENCIA A INFRAESTRUTURA DE COMUNIÇÃO DO LADO CLIENTE PARA EXECUTAR AS
	 * SOLICITAÇÕES REALIZADAS
	 */
	private Client client;

	/**
	 * ACESSA UM RECURSO IDENTIFICADO PELO URI(Uniform Resource
	 * Identifier/Identificador Uniforme de Recursos)
	 */
	private WebTarget webTarget;

	/** URL DO SERVIÇO REST QUE VAMOS ACESSAR */
	private final String URL_SERVICE = "http://localhost:7201/web-rest-sas/sas/login/";
	private final String URL_SERVICE_PDF = "http://localhost:7201/web-rest-sas/sas/geraPdf/";

	/** CONSTRUTOR DA NOSSA CLASSE */
	public ServiceClient() {
		this.client = ClientBuilder.newClient();
	}

	/** CADASTRA UMA NOVA PESSOA ATRAVÉS DA OPERAÇÃO cadastrar(MÉTODO HTTP: POST) */
	public String CadastrarPessoa(Usuario usuario) {

		this.webTarget = this.client.target(URL_SERVICE).path("cadastrar");

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");

		Response response = invocationBuilder.post(Entity.entity(usuario, "application/json;charset=UTF-8"));

		return response.readEntity(String.class);

	}

	/** CADASTRA UMA NOVA PESSOA ATRAVÉS DA OPERAÇÃO cadastrar(MÉTODO HTTP: POST) */
	public String CadastrarColaborador(Pessoa pessoa) {

		this.webTarget = this.client.target(URL_SERVICE).path("cadastrarPessoa");

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");

		Response response = invocationBuilder.post(Entity.entity(pessoa, "application/json;charset=UTF-8"));

		return response.readEntity(String.class);

	}

	/** CADASTRA UMA NOVA PESSOA ATRAVÉS DA OPERAÇÃO cadastrar(MÉTODO HTTP: POST) */
	public String CadastrarPrefixo(Prefixo prefixo) {

		this.webTarget = this.client.target(URL_SERVICE).path("cadastrarPrefixo");

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");

		Response response = invocationBuilder.post(Entity.entity(prefixo, "application/json;charset=UTF-8"));

		return response.readEntity(String.class);

	}

	/** CADASTRA UMA NOVA PESSOA ATRAVÉS DA OPERAÇÃO cadastrar(MÉTODO HTTP: POST) */
	public void RegistrarDescricao(DescricaoEnty enty) {

		this.webTarget = this.client.target(URL_SERVICE).path("registrarDescricao");

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");

		invocationBuilder.post(Entity.entity(enty, "application/json;charset=UTF-8"));

	}

	/** CADASTRA UMA NOVA PESSOA ATRAVÉS DA OPERAÇÃO cadastrar(MÉTODO HTTP: POST) */
	public String CadastrarOcorrencia(Ocorrencia ocorrencia) {

		this.webTarget = this.client.target(URL_SERVICE).path("cadastrarOcorrencia");

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");

		Response response = invocationBuilder.post(Entity.entity(ocorrencia, "application/json;charset=UTF-8"));

		return response.readEntity(String.class);

	}

	/** CADASTRA UMA NOVA PESSOA ATRAVÉS DA OPERAÇÃO cadastrar(MÉTODO HTTP: POST) */
	public String CadastrarOcorrenciaAtiva(OcorrenciaEnty enty) {

		this.webTarget = this.client.target(URL_SERVICE).path("cadastrarOcorrenciaAtiva");

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");

		Response response = invocationBuilder.post(Entity.entity(enty, "application/json;charset=UTF-8"));

		return response.readEntity(String.class);

	}

	/** CADASTRA UMA NOVA PESSOA ATRAVÉS DA OPERAÇÃO cadastrar(MÉTODO HTTP: POST) */
	public void FinalizarOcorrenciaAtiva(OcorrenciaEnty enty) {

		this.webTarget = this.client.target(URL_SERVICE).path("FinalizarOcorrenciaAtiva");

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");

		invocationBuilder.post(Entity.entity(enty, "application/json;charset=UTF-8"));
	}

	/** CADASTRA UMA NOVA PESSOA ATRAVÉS DA OPERAÇÃO cadastrar(MÉTODO HTTP: POST) */
	public String CadastrarControleFaltasAtrasosViglante(Colaborador colaborador) {

		this.webTarget = this.client.target(URL_SERVICE).path("cadastrarFaltasAtrasos");

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");

		Response response = invocationBuilder.post(Entity.entity(colaborador, "application/json;charset=UTF-8"));

		return response.readEntity(String.class);

	}

	/** CADASTRA UMA NOVA REPOSIÇÃO DE FALTA E ATRASO(MÉTODO HTTP: POST) */
	public String CadastrarControleReposicoes(Reposicoes reposicoes) {

		this.webTarget = this.client.target(URL_SERVICE).path("cadastrarReposicoes");

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");

		Response response = invocationBuilder.post(Entity.entity(reposicoes, "application/json;charset=UTF-8"));

		return response.readEntity(String.class);

	}

	/**
	 * ALTERA UM REGISTRO JÁ CADASTRADO ATRAVÉS DA OPERAÇÃO alterar(MÉTODO HTTP:PUT)
	 */
	public String AlterarPessoa(Pessoa pessoa) {

		this.webTarget = this.client.target(URL_SERVICE).path("alterar");

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");

		Response response = invocationBuilder.put(Entity.entity(pessoa, "application/json;charset=UTF-8"));

		return response.readEntity(String.class);

	}

	/**
	 * ALTERA UM REGISTRO JÁ CADASTRADO ATRAVÉS DA OPERAÇÃO alterar(MÉTODO HTTP:PUT)
	 */
	public String AlterarOcorrencia(Ocorrencia ocorrencia) {

		this.webTarget = this.client.target(URL_SERVICE).path("alterarOcorrencia");

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");

		Response response = invocationBuilder.put(Entity.entity(ocorrencia, "application/json;charset=UTF-8"));

		return response.readEntity(String.class);

	}

	/** VALIDA O USUARIO SENHA AO LOGAR(MÉTODO HTTP:POST) */
	public Usuario IsLogar(Usuario usuario) {

		this.webTarget = this.client.target(URL_SERVICE).path("IsLogar");

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");

		Response response = invocationBuilder.post(Entity.entity(usuario, "application/json;charset=UTF-8"));

		return response.readEntity(Usuario.class);

	}

	/** verifica se existe o colaborador com o cpf(MÉTODO HTTP:POST) */
	public Pessoa consultarPessoa(Pessoa pessoa) {

		this.webTarget = this.client.target(URL_SERVICE).path("consultarPessoa");

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");

		Response response = invocationBuilder.post(Entity.entity(pessoa, "application/json;charset=UTF-8"));

		return response.readEntity(Pessoa.class);

	}

	/** verifica se existe o ocorrencia id:(MÉTODO HTTP:POST) */
	public Ocorrencia consultarIdOcorrencia(int i) {

		Ocorrencia ocorrencia = new Ocorrencia();
		ocorrencia.setId(i);

		this.webTarget = this.client.target(URL_SERVICE).path("consultarIdOcorrencia");

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");

		Response response = invocationBuilder.post(Entity.entity(ocorrencia, "application/json;charset=UTF-8"));

		return response.readEntity(Ocorrencia.class);

	}

	/** verifica se existe o ocorrencia id:(MÉTODO HTTP:POST) */
	public Descricoes pegarDescricaoDaOcorrenciaID(OcorrenciaEnty enty) {
		
		this.webTarget = this.client.target(URL_SERVICE).path("pegarDescricaoDaOcorrenciaID");

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");

		Response response = invocationBuilder.post(Entity.entity(enty, "application/json;charset=UTF-8"));

		return response.readEntity(Descricoes.class);

	}

	/**
	 * CONSULTA TODAS AS PESSOAS CADASTRADAS NO SERVIÇO ATRAVÉS DA OPERAÇÃO
	 * todasPessoas(MÉTODO HTTP:GET)
	 */
	public Usuarios ConsultarTodasUsuarios() {

		this.webTarget = this.client.target(URL_SERVICE).path("todosUsuarios");

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");

		Response response = invocationBuilder.get();

		return response.readEntity(Usuarios.class);

	}

	/**
	 * CONSULTA TODAS AS PESSOAS CADASTRADAS NO SERVIÇO ATRAVÉS DA OPERAÇÃO
	 * todasPessoas(MÉTODO HTTP:GET)
	 */
	public Telas ConsultarPrefixosTela() {

		this.webTarget = this.client.target(URL_SERVICE).path("tela");

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");

		Response response = invocationBuilder.get();

		return response.readEntity(Telas.class);

	}

	/**
	 * CONSULTA TODAS AS PESSOAS CADASTRADAS NO SERVIÇO ATRAVÉS DA OPERAÇÃO
	 * todasPessoas(MÉTODO HTTP:GET)
	 */
	public String ConsultarOcorrenciaTempo(int codigo, int index) {

		OcorrenciaEnty enty = new OcorrenciaEnty();
		enty.setCodigo(index);
		enty.setGrupo(codigo);

		this.webTarget = this.client.target(URL_SERVICE).path("tempo");

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");

		Response response = invocationBuilder.post(Entity.entity(enty, "application/json;charset=UTF-8"));

		return response.readEntity(String.class);

	}

	/**
	 * CONSULTA TODAS AS PESSOAS CADASTRADAS NO SERVIÇO ATRAVÉS DA OPERAÇÃO
	 * todasPessoas(MÉTODO HTTP:GET)
	 */
	public String ConsultarOcorrenciaTempoAtraso(int index) {

		OcorrenciaEnty enty = new OcorrenciaEnty();
		enty.setCodigo(index);

		this.webTarget = this.client.target(URL_SERVICE).path("tempoAtraso");

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");

		Response response = invocationBuilder.post(Entity.entity(enty, "application/json;charset=UTF-8"));

		return response.readEntity(String.class);

	}

	/**
	 * CONSULTA TODAS AS PESSOAS CADASTRADAS NO SERVIÇO ATRAVÉS DA OPERAÇÃO
	 * todasPessoas(MÉTODO HTTP:GET)
	 */
	public ListaReposicoes ConsultarTodasReposicoes() {

		this.webTarget = this.client.target(URL_SERVICE).path("todasReposicoes");

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");

		Response response = invocationBuilder.get();

		return response.readEntity(ListaReposicoes.class);

	}

	/**
	 * CONSULTA TODAS AS PESSOAS CADASTRADAS NO SERVIÇO ATRAVÉS DA OPERAÇÃO
	 * todasPessoas(MÉTODO HTTP:GET)
	 */
	public Pessoas ConsultarTodasPessoas() {

		this.webTarget = this.client.target(URL_SERVICE).path("todosPessoas");

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");

		Response response = invocationBuilder.get();

		return response.readEntity(Pessoas.class);

	}

	/**
	 * CONSULTA TODAS AS PESSOAS CADASTRADAS NO SERVIÇO ATRAVÉS DA OPERAÇÃO
	 * todasPessoas(MÉTODO HTTP:GET)
	 */
	public Ocorrencias ConsultarTodasOcorrencias() {

		this.webTarget = this.client.target(URL_SERVICE).path("todasOcorrencias");

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");

		Response response = invocationBuilder.get();

		return response.readEntity(Ocorrencias.class);

	}

	/**
	 * CONSULTA TODAS AS PESSOAS CADASTRADAS NO SERVIÇO ATRAVÉS DA OPERAÇÃO
	 * todasPessoas(MÉTODO HTTP:GET)
	 */
	public OcorrenciasAtivas ConsultarTodasOcorrenciasAtivas() {

		this.webTarget = this.client.target(URL_SERVICE).path("todasOcorrenciasAtivas");

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");

		Response response = invocationBuilder.get();

		return response.readEntity(OcorrenciasAtivas.class);

	}

	/**
	 * CONSULTA UMA PESSOA PELO CÓDIGO ATRAVÉS DA OPERAÇÃO getPessoa(MÉTODO HTTP:
	 * GET)
	 */
	public Pessoa ConsultarPessoaPorCodigo(int codigo) {

		this.webTarget = this.client.target(URL_SERVICE).path("getPessoa").path(String.valueOf(codigo));

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");

		Response response = invocationBuilder.get();

		return response.readEntity(Pessoa.class);

	}

	/**
	 * EXCLUI UM REGISTRO CADASTRADO PELO CÓDIGO ATRAVÉS DA OPERAÇÃO excluir(MÉTODO
	 * HTTP:delete)
	 */
	public String ExcluirUsuarioPorCodigo(int codigo) {

		Usuario usuario = new Usuario();
		usuario.setCodigo(codigo);

		this.webTarget = this.client.target(URL_SERVICE).path("excluir");

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");

		Response response = invocationBuilder.post(Entity.entity(usuario, "application/json;charset=UTF-8"));

		return response.readEntity(String.class);

	}

	/**
	 * EXCLUI UM REGISTRO CADASTRADO PELO CÓDIGO ATRAVÉS DA OPERAÇÃO excluir(MÉTODO
	 * HTTP:delete)
	 */
	public String ExcluirTelaPorCodigo(int codigo_colaborador) {
		Tela tela = new Tela();
		tela.setCodigo_colaborador(codigo_colaborador);

		this.webTarget = this.client.target(URL_SERVICE).path("excluirTela");

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");

		Response response = invocationBuilder.post(Entity.entity(tela, "application/json;charset=UTF-8"));

		return response.readEntity(String.class);

	}

	public Controles getPlanilha(int i) {
		Colaborador c = new Colaborador();
		c.setCodigo(i);

		this.webTarget = this.client.target(URL_SERVICE).path("planilha");

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");

		Response response = invocationBuilder.post(Entity.entity(c, "application/json;charset=UTF-8"));

		return response.readEntity(Controles.class);
	}

	public Controles getPlanilha2(int i) {
		Colaborador c = new Colaborador();
		c.setCodigo(i);

		this.webTarget = this.client.target(URL_SERVICE).path("planilha2");

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");

		Response response = invocationBuilder.post(Entity.entity(c, "application/json;charset=UTF-8"));

		return response.readEntity(Controles.class);
	}

	public String CadastrarTela(Tela t) {

		this.webTarget = this.client.target(URL_SERVICE).path("cadastrarTelas");

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");

		Response response = invocationBuilder.post(Entity.entity(t, "application/json;charset=UTF-8"));

		return response.readEntity(String.class);
	}

	public Prefixos ConsultarTodosPrefixos() {

		this.webTarget = this.client.target(URL_SERVICE).path("todosPrefixos");

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");

		Response response = invocationBuilder.get();

		return response.readEntity(Prefixos.class);

	}
	
	public Pessoas ConsultarPessoasOcorrencias() {
		
		this.webTarget = this.client.target(URL_SERVICE).path("todosPessoasOcorrencias");
		
		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");
		
		Response response = invocationBuilder.get();
		
		return response.readEntity(Pessoas.class);
		
	}

	public Titularizacoes ConsultarTodosTitularizacao() {

		this.webTarget = this.client.target(URL_SERVICE).path("todasTitularizacao");

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");

		Response response = invocationBuilder.get();

		return response.readEntity(Titularizacoes.class);

	}	

	/** CADASTRA UMA NOVA PESSOA ATRAVÉS DA OPERAÇÃO cadastrar(MÉTODO HTTP: POST) */
	public byte[] GerarRelatorioPorData(Relatorio enty) {

		this.webTarget = this.client.target(URL_SERVICE_PDF).path("pdf");

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");

		Response response = invocationBuilder.post(Entity.entity(enty, "application/json;charset=UTF-8"));

		return response.readEntity(byte[].class);

	}

	/** CADASTRA UMA NOVA PESSOA ATRAVÉS DA OPERAÇÃO cadastrar(MÉTODO HTTP: POST) */
	public byte[] GerarRelatorioBoletins(Relatorio enty) {

		this.webTarget = this.client.target(URL_SERVICE_PDF).path("pdfBoletins");

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");

		Response response = invocationBuilder.post(Entity.entity(enty, "application/json;charset=UTF-8"));

		return response.readEntity(byte[].class);

	}

	/** CADASTRA UMA NOVA PESSOA ATRAVÉS DA OPERAÇÃO cadastrar(MÉTODO HTTP: POST) */
	public byte[] GerarRelatorioPorNome(RelatorioEnty enty) {

		this.webTarget = this.client.target(URL_SERVICE_PDF).path("pdfPorNome");

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");

		Response response = invocationBuilder.post(Entity.entity(enty, "application/json;charset=UTF-8"));

		return response.readEntity(byte[].class);

	}

}
