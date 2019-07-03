package test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import helper.HlpLogin;
import suporte.CrossBrowser;
import suporte.Log;

public class Login extends CrossBrowser {

	/*
	 * Regras de Negocio
	 * 
	 * 
	 */

	private HlpLogin login;

	@BeforeMethod
	public void init() {
		defineBrowser("Chrome");
		login = new HlpLogin(driver.get());
	}

	@Test
	public void CEN01_RealizaLoginAVLATD() throws Exception {
		login.realizaLoginAtendimento("ATENDIMENTO");
		login.clicaBotaoEntrar();
		login.acessaMenu("Manual do Usuário");
	}

	/*
	 * 
	 * 
	@Test
	public void CEN02_RealizaLoginAVLAUD() throws Exception {
		login.realizaLoginAtendimento("AUDITORIA");
		login.clicaBotaoEntrar();
	}

	@Test
	public void CEN03_RealizaLoginAVLCGE() throws Exception {
		login.realizaLoginAtendimento("CONSULTA GESTOR");
		login.clicaBotaoEntrar();
	}

	@Test
	public void CEN04_RealizaLoginAVLCNF() throws Exception {
		login.realizaLoginAtendimento("CONFORMIDADE");
		login.clicaBotaoEntrar();
	}

	@Test
	public void CEN05_RealizaLoginAVLEAT() throws Exception {
		login.realizaLoginAtendimento("Exclusivo Assistente de Atendimento");
		login.clicaBotaoEntrar();
	}

	@Test
	public void CEN06_RealizaLoginAVLEGC() throws Exception {
		login.realizaLoginAtendimento("Exclusivo GCN");
		login.clicaBotaoEntrar();
	}

	@Test
	public void CEN07_RealizaLoginAVLESE() throws Exception {
		login.realizaLoginAtendimento("Exclusivo Superintendente");
		login.clicaBotaoEntrar();
	}

	@Test
	public void CEN08_RealizaLoginAVLGAT() throws Exception {
		login.realizaLoginAtendimento("GERENTE DE ATENDIMENTO");
		login.clicaBotaoEntrar();
	}

	@Test
	public void CEN09_RealizaLoginAVLGRE() throws Exception {
		login.realizaLoginAtendimento("GERENTE");
		login.clicaBotaoEntrar();
	}

	@Test
	public void CEN10_RealizaLoginAVLGUN() throws Exception {
		login.realizaLoginAtendimento("GERENTE UNIDADE");
		login.clicaBotaoEntrar();
	}

	@Test
	public void CEN11_RealizaLoginAVLMTZ() throws Exception {
		login.realizaLoginAtendimento("GESTOR MATRIZ");
		login.clicaBotaoEntrar();
	}

	@Test
	public void CEN12_RealizaLoginAVLRNP() throws Exception {
		login.realizaLoginAtendimento("RETAGUARDA");
		login.clicaBotaoEntrar();
	}

	@Test
	public void CEN13_RealizaLoginAVLSRV() throws Exception {
		login.realizaLoginAtendimento("SERVIÇO APP MOVEL");
		login.clicaBotaoEntrar();
	}

	@Test
	public void CEN14_NaoInformarDadosObrigatorios() throws Exception {
		login.clicaBotaoEntrar();
		login.capturaTelas("Realiza Login");
	}

	@Test
	public void CEN15_InformaUsuario() throws Exception {
		login.informaUsuario();
		login.clicaBotaoEntrar();
		login.capturaTelas("Realiza Login");
	}

	@Test
	public void CEN16_InformaSenha() throws Exception {
		login.informaSenha();
		login.clicaBotaoEntrar();
		login.capturaTelas("Realiza Login");
	}

	@Test
	public void CEN17_UsuarioInvalido() throws Exception {
		login.usuarioInvalida();
		login.informaSenha();
		login.clicaBotaoEntrar();
		login.validaMensagemError();
		login.capturaTelas("Realiza Login");
	}

	@Test
	public void CEN18_SenhaInvalida() throws Exception {
		login.informaUsuario();
		login.senhaInvalida();
		login.clicaBotaoEntrar();
		login.validaMensagemError();
		login.capturaTelas("Realiza Login");
	}
	
	*/

}
