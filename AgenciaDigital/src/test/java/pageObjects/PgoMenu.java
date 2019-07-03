package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PgoMenu extends GenericsPgo {

	/** Menu */
	@FindBy(xpath = "//*[@id='app']/div/div[2]/aside/section/ul/li[1]/a/span")
	public WebElement MENU_PAINEL_ATENDIMENTO;

	@FindBy(xpath = "//*[@id='app']/div/div[2]/aside/section/ul/li[2]/a/span")
	public WebElement MENU_MEU_PAINEL;

	@FindBy(xpath = "//*[@id='app']/div/div[2]/aside/section/ul/li[3]/a/span")
	public WebElement MENU_CLIENTES;

	@FindBy(xpath = "//*[@id='app']/div/div[2]/aside/section/ul/li[4]/a/span")
	public WebElement MENU_PESQUISAS;

	@FindBy(xpath = "//*[@id='app']/div/div[2]/aside/section/ul/li[5]/a/span")
	public WebElement MENU_GERENCIAR;

	@FindBy(xpath = "//*[@id='app']/div/div[2]/aside/section/ul/li[6]/a/span")
	public WebElement MENU_MANUAL_USUARIO;

	/** SubMenu */
	@FindBy(xpath = "//*[@id='app']/div/div[2]/aside/section/ul/li[4]/ul/li[1]/a")
	public WebElement SUBMENU_PESQUISAS_PROTOCOLO_ATENDIMENTO;

	@FindBy(xpath = "//*[@id='app']/div/div[2]/aside/section/ul/li[4]/ul/li[2]/a")
	public WebElement SUBMENU_PESQUISAS_NOTAS_NEGOCIACAO;

	@FindBy(xpath = "//*[@id='app']/div/div[2]/aside/section/ul/li[4]/ul/li[3]/a")
	public WebElement SUBMENU_PESQUISAS_ERROS_CHAT;

	@FindBy(xpath = "//*[@id='app']/div/div[2]/aside/section/ul/li[4]/ul/li[4]/a")
	public WebElement SUBMENU_PESQUISAS_PEDIDOS_ADESAO;

	@FindBy(xpath = "//*[@id='app']/div/div[2]/aside/section/ul/li[4]/ul/li[5]/a")
	public WebElement SUBMENU_PESQUISAS_ESTATISTICAS_CHAT;

	@FindBy(xpath = "//*[@id='app']/div/div[2]/aside/section/ul/li[5]/ul/li[1]/a")
	public WebElement SUBMENU_GERENCIAR_UNIDADES_ATENDIMENTO;

	@FindBy(xpath = "//*[@id='app']/div/div[2]/aside/section/ul/li[5]/ul/li[2]/a")
	public WebElement SUBMENU_GERENCIAR_EQUIPES;

	@FindBy(xpath = "//*[@id='app']/div/div[2]/aside/section/ul/li[5]/ul/li[3]/a")
	public WebElement SUBMENU_GERENCIAR_MODELO_NOTA;

	@FindBy(xpath = "//*[@id='app']/div/div[2]/aside/section/ul/li[5]/ul/li[4]/a")
	public WebElement SUBMENU_GERENCIAR_ACOES_PRODUTO;

	@FindBy(xpath = "//*[@id='app']/div/div[2]/aside/section/ul/li[5]/ul/li[5]/a")
	public WebElement SUBMENU_GERENCIAR_CAMPOS_MODELO;

	@FindBy(xpath = "//*[@id='app']/div/div[2]/aside/section/ul/li[5]/ul/li[6]/a")
	public WebElement SUBMENU_GERENCIAR_ITENS_FLUXO;

	@FindBy(xpath = "//*[@id='app']/div/div[2]/aside/section/ul/li[5]/ul/li[7]/a")
	public WebElement SUBMENU_GERENCIAR_TIPOS_PENDENCIA_NOTA;

	@FindBy(xpath = "//*[@id='app']/div/div[2]/aside/section/ul/li[5]/ul/li[8]/a")
	public WebElement SUBMENU_GERENCIAR_MENSAGEM_NOTIFICACAO;

}
