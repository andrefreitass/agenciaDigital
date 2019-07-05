package suporte;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import pageObjects.PgoMenu;

public class Menu {
	public PgoMenu menu;

	public Menu() {
		menu = PageFactory.initElements(CrossBrowser.driver.get(), PgoMenu.class);
	}

	public ArrayList<WebElement> getHierarquiaMenus(String opcao) {
		ArrayList<WebElement> listMenu = new ArrayList<WebElement>();
		switch (opcao) {
		case "Painel de Atendimento":
			listMenu.add(menu.MENU_PAINEL_ATENDIMENTO);
			break;

		case "Meu Painel":
			listMenu.add(menu.MENU_MEU_PAINEL);
			break;

		case "Clientes":
			listMenu.add(menu.MENU_CLIENTES);
			break;

		case "Pesquisas":
			listMenu.add(menu.MENU_PESQUISAS);
			break;

		case "Gerenciar":
			listMenu.add(menu.MENU_GERENCIAR);
			break;

		case "Manual do Usuário":
			listMenu.add(menu.MENU_MANUAL_USUARIO);
			break;

		default:
			System.out.println("Informe um MENU válido");
			break;
		}
		return listMenu;

	}

	public ArrayList<WebElement> getHierarquiaSubMenus(String opcao) {
		ArrayList<WebElement> subMenu = new ArrayList<WebElement>();
		switch (opcao) {
		case "Protocolo de Atendimento":
			subMenu.add(menu.SUBMENU_PESQUISAS_PROTOCOLO_ATENDIMENTO);
			break;

		case "Notas de Negociação":
			subMenu.add(menu.SUBMENU_PESQUISAS_NOTAS_NEGOCIACAO);
			break;

		case "Erros do chat":
			subMenu.add(menu.SUBMENU_PESQUISAS_ERROS_CHAT);
			break;

		case "Pedidos de Adesão":
			subMenu.add(menu.SUBMENU_PESQUISAS_PEDIDOS_ADESAO);
			break;
		case "Estatisticas de chat":
			subMenu.add(menu.SUBMENU_PESQUISAS_ESTATISTICAS_CHAT);
			break;

		case "Unidades Atendimento":
			subMenu.add(menu.SUBMENU_GERENCIAR_UNIDADES_ATENDIMENTO);
			break;

		case "Equipes":
			subMenu.add(menu.SUBMENU_GERENCIAR_EQUIPES);
			break;

		case "Modelos de Nota":
			subMenu.add(menu.SUBMENU_GERENCIAR_MODELO_NOTA);
			break;

		case "Ações do Produto":
			subMenu.add(menu.SUBMENU_GERENCIAR_ACOES_PRODUTO);
			break;

		case "Campos do Modelo":
			subMenu.add(menu.SUBMENU_GERENCIAR_CAMPOS_MODELO);
			break;

		case "Itens de Fluxo":
			subMenu.add(menu.SUBMENU_GERENCIAR_ITENS_FLUXO);
			break;

		case "Tipos de Pendencia da Nota":
			subMenu.add(menu.SUBMENU_GERENCIAR_TIPOS_PENDENCIA_NOTA);
			break;

		case "Mensagem de Notificação":
			subMenu.add(menu.SUBMENU_GERENCIAR_MENSAGEM_NOTIFICACAO);
			break;

		default:
			System.out.println("Informe um MENU ou SUBMENU válido");
			break;
		}
		return subMenu;

	}

}
