package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pageObjects.PgoLogin;
import suporte.AgenciaDigital;

public class HlpLogin extends AgenciaDigital {

	String senha = "Senha01";
	PgoLogin pg;

	public HlpLogin(WebDriver driver) {
		super(driver);
		pg = PageFactory.initElements(driver, PgoLogin.class);
	}

	public void realizaLoginAtendimento(String perfilAcesso) throws Exception {
		if (perfilAcesso.equalsIgnoreCase("ATENDIMENTO")) {
			preencheCampo(pg.CMP_LOGIN, "c891887");
			preencheCampo(pg.CMP_SENHA, senha);
			capturaTelas("Realiza Login");
		} else if (perfilAcesso.equalsIgnoreCase("AUDITORIA")) {
			preencheCampo(pg.CMP_LOGIN, "c891889");
			preencheCampo(pg.CMP_SENHA, senha);
			capturaTelas("Realiza Login");

		} else if (perfilAcesso.equalsIgnoreCase("CONSULTA GESTOR")) {
			preencheCampo(pg.CMP_LOGIN, "c891892");
			preencheCampo(pg.CMP_SENHA, senha);
			capturaTelas("Realiza Login");

		} else if (perfilAcesso.equalsIgnoreCase("CONFORMIDADE")) {
			preencheCampo(pg.CMP_LOGIN, "c891890");
			preencheCampo(pg.CMP_SENHA, senha);
			capturaTelas("Realiza Login");

		} else if (perfilAcesso.equalsIgnoreCase("Exclusivo Assistente de Atendimento")) {
			preencheCampo(pg.CMP_LOGIN, "c891888");
			preencheCampo(pg.CMP_SENHA, senha);
			capturaTelas("Realiza Login");

		} else if (perfilAcesso.equalsIgnoreCase("Exclusivo GCN")) {
			preencheCampo(pg.CMP_LOGIN, "c891891");
			preencheCampo(pg.CMP_SENHA, senha);
			capturaTelas("Realiza Login");

		} else if (perfilAcesso.equalsIgnoreCase("Exclusivo Superintendente")) {
			preencheCampo(pg.CMP_LOGIN, "c891893");
			preencheCampo(pg.CMP_SENHA, senha);
			capturaTelas("Realiza Login");

		} else if (perfilAcesso.equalsIgnoreCase("GERENTE DE ATENDIMENTO")) {
			preencheCampo(pg.CMP_LOGIN, "c891894");
			preencheCampo(pg.CMP_SENHA, senha);
			capturaTelas("Realiza Login");

		} else if (perfilAcesso.equalsIgnoreCase("GERENTE")) {
			preencheCampo(pg.CMP_LOGIN, "c891925");
			preencheCampo(pg.CMP_SENHA, senha);
			capturaTelas("Realiza Login");

		} else if (perfilAcesso.equalsIgnoreCase("GERENTE UNIDADE")) {
			preencheCampo(pg.CMP_LOGIN, "c891924");
			preencheCampo(pg.CMP_SENHA, senha);
			capturaTelas("Realiza Login");

		} else if (perfilAcesso.equalsIgnoreCase("GESTOR MATRIZ")) {
			preencheCampo(pg.CMP_LOGIN, "c891933");
			preencheCampo(pg.CMP_SENHA, senha);
			capturaTelas("Realiza Login");

		} else if (perfilAcesso.equalsIgnoreCase("RETAGUARDA")) {
			preencheCampo(pg.CMP_LOGIN, "c891923");
			preencheCampo(pg.CMP_SENHA, senha);
			capturaTelas("Realiza Login");

		} else if (perfilAcesso.equalsIgnoreCase("SERVIÇO APP MOVEL")) {
			preencheCampo(pg.CMP_LOGIN, "c891886");
			preencheCampo(pg.CMP_SENHA, senha);
			capturaTelas("Realiza Login");

		} else {
			System.out.println("Login informado invalido");
			capturaTelas("Realiza Login");
		}

	}

	public void clicaBotaoEntrar() {
		click(pg.BTN_ENTRAR);
	}

	public void informaUsuario() {
		preencheCampo(pg.CMP_LOGIN, "c891887");
	}

	public void informaSenha() {
		preencheCampo(pg.CMP_SENHA, senha);
	}

	public void usuarioInvalida() {
		preencheCampo(pg.CMP_LOGIN, "c99999");
	}

	public void senhaInvalida() {
		preencheCampo(pg.CMP_SENHA, "automacao");
	}

	public void validaMensagemError() {
		pontoVerificacao(pg.MSG_ERRO, "innerText", "Nome de usuário ou senha inválida.");
	}

}
