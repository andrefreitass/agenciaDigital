package suporte;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AgenciaDigital {

	public static String diretorioDatapool = "/home/andre/Developer/work/AgenciaDigital/src/test/java/datapools/";
	public static String diretorioUpload = "";
	static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	static WebDriverWait wait;
	public Menu mn = new Menu();

	/**
	 * Construtor
	 * 
	 * @param driver
	 */
	public AgenciaDigital(WebDriver drv) {
		wait = new WebDriverWait(drv, 30);
		driver.set(drv);
	}

	public void capturaTelas(String casoTeste) throws Exception {

		File scrFile = ((TakesScreenshot) driver.get()).getScreenshotAs(OutputType.FILE);

		File filetemp = new File("target/screenshot/" + casoTeste + ".jpeg");
		if (!filetemp.exists()) {
			File file = new File("target/screenshot/" + casoTeste + "1.jpeg");
			for (int i = 2; i < 50; i++) {
				if (file.exists()) {
					file = new File("target/screenshot/" + casoTeste + i + ".jpeg");
				} else {
					FileUtils.copyFile(scrFile, file);
					break;
				}
			}
		} else {
			FileUtils.copyFile(scrFile, filetemp);
		}
	}

	/**
	 * Aguardo o Elemento HTML ser carregado na tela
	 * 
	 * @param by
	 */
	public void aguardaElemento(WebElement object) {
		try {
			Log.info("Aguardando Elemento Ser Carregado em Tela");
			anexaDescricao("Aguardando elemento: "
					+ getLocatorElement(wait.until(ExpectedConditions.elementToBeClickable(object))));
		} catch (NoSuchElementException e) {
			anexaDescricao("ERRO - Elemento não encontrado: " + getLocatorElement(object));
		} catch (Exception e) {
			anexaDescricao("ERRO - Falha ao tentar localizar o elemento: " + getLocatorElement(object));
		}
	}

	/**
	 * Aguarda Elemento com base no atributo declarado, deve ser usado
	 * 
	 * @param object
	 * @param atributo
	 * @param valor
	 */
	public void aguardaElemento(WebElement object, String atributo, String valor) {
		try {
			anexaDescricao("Aguardando elemento por combinação de Atributos ");
			wait.until(ExpectedConditions.attributeToBe(object, atributo, valor));
		} catch (Exception e) {
			e.printStackTrace();
			anexaDescricao("ERRO - Elemento não encontrado: " + getLocatorElement(object));
		}
	}

	/**
	 * Seleciona um item da Combo pelo Value
	 * 
	 * @param object
	 * @param value
	 */
	public void selecionaComboBox(WebElement object, String value) {
		try {
			anexaDescricao("Selecionando comboBox por Value: " + value + " Objeto: "
					+ getLocatorElement(wait.until(ExpectedConditions.elementToBeClickable(object))));
			new Select(object).selectByVisibleText(value);
			Thread.sleep(300);
		} catch (Exception e) {
			anexaDescricao("ERRO - Elemento não encontrado: " + getLocatorElement(object));
		}
	}

	/**
	 * Seleciona um item da Combo pelo Index
	 * 
	 * @param object
	 * @param index
	 */
	public void selecionaComboBox(WebElement object, int index) {
		try {
			anexaDescricao(" Selecionando comboBox por index: " + index + " Object: "
					+ getLocatorElement(wait.until(ExpectedConditions.elementToBeClickable(object))));
			new Select(object).selectByIndex(index);
			Thread.sleep(300);
		} catch (Exception e) {
			anexaDescricao("ERRO - Elemento não encontrado: " + getLocatorElement(object));
		}
	}

	/**
	 * Aciona o checkBox
	 * 
	 * @param object
	 * @param check
	 */
	public void selecionaCheckBox(WebElement object, boolean check) {
		try {
			if (check) {
				anexaDescricao("Marcando checkBox: "
						+ getLocatorElement(wait.until(ExpectedConditions.elementToBeClickable(object))));
				if (!object.isSelected()) {
					object.click();
				}
			} else {
				anexaDescricao("Desmarcando checkBox: "
						+ getLocatorElement(wait.until(ExpectedConditions.elementToBeClickable(object))));
				if (object.isSelected()) {
					object.click();
				}
			}
		} catch (NoSuchElementException e) {
			anexaDescricao(" ERRO - Elemento não encontrado: " + getLocatorElement(object));
		}
	}

	/**
	 * Limpa o campo recebido
	 * 
	 * @param object
	 */
	public void limpaCampo(WebElement object) {
		try {
			anexaDescricao("Limpando campo: "
					+ getLocatorElement(wait.until(ExpectedConditions.elementToBeClickable(object))));
			object.clear();
		} catch (NoSuchElementException e) {
			anexaDescricao("ERRO - Elemento não encontrato: " + getLocatorElement(object));
		} catch (Exception e) {
			anexaDescricao("ERRO - Erro ao limpar o campo:" + getLocatorElement(object));
		}
	}

	/**
	 * Digita o <code>texto</code> no elemento
	 * 
	 * @param id
	 * @param texto
	 */
	public void preencheCampo(WebElement object, String texto) {
		limpaCampo(object);
		try {
			Log.info("Preenche Campo");
			anexaDescricao("Preenchendo campo: "
					+ getLocatorElement(wait.until(ExpectedConditions.elementToBeClickable(object))) + " Valor: "
					+ texto);
			object.sendKeys(texto);
			object.sendKeys(Keys.TAB);
		} catch (InvalidElementStateException e) {
			anexaDescricao("ERRO - Elemento não esta habilitado no HTML: " + getLocatorElement(object));
		} catch (StaleElementReferenceException e) {
			anexaDescricao("ERRO - Elemento não encontrado no HTML: " + getLocatorElement(object));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void preencheCampoJS(WebElement object, String texto) {
		try {
			anexaDescricao("Preenchendo campo: "
					+ getLocatorElement(wait.until(ExpectedConditions.elementToBeClickable(object))) + " Valor: "
					+ texto);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].value='" + texto + "';", object);
			object.sendKeys(Keys.TAB);
			// click(object);
		} catch (Exception e) {
			anexaDescricao("ERRO - Elemento não encontrado no HTML: " + getLocatorElement(object));
		}
	}

	public void escape() {
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ESCAPE);
			r.keyRelease(KeyEvent.VK_ESCAPE);
			r.keyPress(KeyEvent.VK_ESCAPE);
			r.keyRelease(KeyEvent.VK_ESCAPE);
		} catch (AWTException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * clica no elemento
	 * 
	 * @param id
	 */
	public void click(WebElement object) {
		try {
			anexaDescricao("Clicando no objeto: "
					+ getLocatorElement(wait.until(ExpectedConditions.elementToBeClickable(object))));
			object.click();
		} catch (NoSuchElementException e) {
			anexaDescricao("ERRO - Elemento não encontrado no HTML: " + getLocatorElement(object));
		}
	}

	public void scrooll(WebElement object) {
		JavascriptExecutor js = (JavascriptExecutor) driver.get();
		js.executeScript("arguments [0] .scrollIntoView ();", object);

	}

	/**
	 * Scroll até o elemento declarado
	 * 
	 * @param element
	 */
	public void scroll(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			int x = element.getLocation().getX();
			int y = element.getLocation().getY();
			js.executeScript("window.scrollBy(" + x + "," + y + ")", "");
		} catch (Exception e) {
			try {
				js.executeScript("arguments[0].scrollIntoView(true);", element);
			} catch (Exception f) {
			}
		}
	}

	/**
	 * Método que Marca em vermelho o elemento HTML da tela para auxiliar em Prints
	 * e aguarda o TEMPO_DE_ESPERA definido.
	 * 
	 * @param driver
	 * @param element
	 * @throws InterruptedException
	 */
	public void destaque(WebElement... element) {
		for (WebElement webElement : element) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			try {
				js.executeScript("arguments[0].setAttribute('style', arguments[1]);", webElement,
						"border: 3px solid red;");
			} catch (Exception e) {
				anexaDescricao("ERRO - Destacar o elemento..."
						+ getLocatorElement(wait.until(ExpectedConditions.elementToBeClickable(webElement))));
			}
		}
	}

	/**
	 * Localiza arquivo para upload
	 * 
	 * @param botaoUpload
	 * @param arquivo
	 */
	public void uploadArquivo(WebElement botaoUpload, String arquivo) {
		try {
			anexaDescricao("Realizando upload de arquivo no campo: "
					+ getLocatorElement(wait.until(ExpectedConditions.elementToBeClickable(botaoUpload))));
			botaoUpload.sendKeys(new File(diretorioUpload + arquivo).getAbsolutePath());
		} catch (Exception e) {
			anexaDescricao("ERRO - Elemento não encontrado no HTML: " + getLocatorElement(botaoUpload));
		}

	}

	/**
	 * Realiza o print da tela e anexa no relatorio Allure
	 * 
	 * @param casoTeste
	 */

	public void anexaEvidencia(String casoTeste) {
		// Allure.addAttachment(casoTeste, new ByteArrayInputStream(((TakesScreenshot)
		// driver.get()).getScreenshotAs(OutputType.BYTES)));
	}

	/**
	 * Anexa Descrição no relatório
	 * 
	 * @param desc
	 */
	public void anexaDescricao(String desc) {
		// ReportListener.setSteps(desc);
		// Log.fatal(desc);
	}

	/**
	 * Acessa a funcionalidade conforme mapeado na classe {@link PgoMenu}
	 * 
	 * @param funcionalidade
	 */
	public void acessaMenu(String funcionalidade) {
		ArrayList<WebElement> menus = mn.getHierarquiaMenus(funcionalidade);
		aguardaElemento(menus.get(0));
		for (int i = 0; i < menus.size(); i++) {
			try {
				menus.get(menus.size() - 1).isDisplayed();
				anexaDescricao("Acessando menu: " + getLocatorElement(
						wait.until(ExpectedConditions.elementToBeClickable(menus.get(menus.size() - 1)))));
				click(menus.get(menus.size() - 1));
				break;
			} catch (Exception e) {
				click(menus.get(i));
				if (!menus.get(i + 1).isDisplayed()) {
					click(menus.get(i));
				}
			}
		}
		try {
			Thread.sleep(8);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Seleciona senha no componente
	 * 
	 * @param btn   (Lista de botões)
	 * @param senha
	 */
	public void cliqueBotoesSenha(List<WebElement> btn, String senha) {
		aguardaElemento(btn.get(0));
		char[] pass = senha.toCharArray();
		for (int i = 0; i < pass.length; i++) {
			for (WebElement button : btn) {
				if (button.getText().equals(String.valueOf(pass[i]))) {
					click(button);
					break;
				}
			}
		}
	}

	/**
	 * Aguarda carga da página
	 */
	public void aguardaLoader() {
		// aguardaElemento(new Menu().getLoader(), "style", "display: none;");
		// Log.fatal("Aguardando Loader");
		//wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(mn.getLoader())));
	}

	/**
	 * Método para validação de campos e resultado esperado USAR SOMENTE COMO
	 * REFERÊNCIA DOS MÉTODOS COM TRY/CATCH OU VALIDACAÇÃO DE BANCO DE DADOS
	 * 
	 * @param validacao
	 * @param check
	 */
	public void pontoVerificacao(boolean validacao, String check) {
		// CrossBrowser.soft.get().assertTrue(validacao,check);
		// Log.fatal("Status: " + validacao + " - Ponto de verificação: " + check);
	}

	/**
	 * Metodo para validação dinâmica de objetos
	 * 
	 * @param object     - elemento alvo da validação
	 * @param atributo   - propriedade do objeto para validação
	 * @param valorCheck - valor a ser validado
	 */
	public void pontoVerificacao(WebElement object, String atributo, String valorCheck) {
		try {
			if (atributo.equals("newText")) {
				pontoVerificacao(object.getText().contains(valorCheck),
						"Validação do texto do campo: " + getLocatorElement(object) + "</br><b>Valor atual:</b> "
								+ object.getText() + "</br><b>Valor esperado:</b> " + valorCheck);
			} else {
				pontoVerificacao(object.getAttribute(atributo).contains(valorCheck),
						"Validação do campo: " + getLocatorElement(object) + "</br><b>Valor atual:</b> "
								+ object.getAttribute(atributo) + "</br><b>Valor esperado:</b> " + valorCheck);
			}
		} catch (NoSuchElementException fail) {
			pontoVerificacao(false, "Objeto não localizado - " + getLocatorElement(object));
		} catch (Exception e) {
			pontoVerificacao(false, "Erro ao tentar localizar objeto - " + getLocatorElement(object));
		}
	}

	/**
	 * Metodo para validação textual
	 * 
	 * @param object     - elemento alvo da validação
	 * @param valorCheck - valor a ser validado
	 */
	public void pontoVerificacao(WebElement object, String valorCheck) {
		try {
			pontoVerificacao(object.getText().contains(valorCheck),
					"Validação do texto do campo: " + getLocatorElement(object) + "</br><b>Valor atual:</b> "
							+ object.getText() + "</br><b>Valor esperado:</b> " + valorCheck);
		} catch (NoSuchElementException fail) {
			pontoVerificacao(false, "Objeto não localizado - " + getLocatorElement(object));
		} catch (Exception e) {
			pontoVerificacao(false, "Erro ao tentar localizar objeto - " + getLocatorElement(object));
		}
	}

	/**
	 * Metodo para validação de padrões por Expressões Regulares
	 * 
	 * @param padrao   - padrão a ser validado
	 * @param object   - elemento alvo da validação
	 * @param atributo - propriedade do objeto para validação
	 */
	public void pontoVerificacao(Pattern padrao, WebElement object, String atributo) {
		try {
			pontoVerificacao(
					padrao.matcher(wait.until(ExpectedConditions.visibilityOf(object)).getAttribute(atributo)
							.replace("	", "")).find(),
					"Validação do campo: " + getLocatorElement(object) + "</br><b>Padrão:</b> " + padrao
							+ "</br><b>Valor atual:</b> " + object.getAttribute(atributo));
		} catch (NoSuchElementException fail) {
			pontoVerificacao(false, "Objeto não localizado - " + getLocatorElement(object));
		} catch (Exception e) {
			pontoVerificacao(false, "Erro ao tentar localizar objeto - " + getLocatorElement(object));
		}
	}

	/**
	 * Metodo para validação da quantidade de caracteres suportados pelo campo
	 * 
	 * @param object   - elemento alvo da validação
	 * @param atributo - propriedade do objeto para validação
	 * @param qtChar   - Limite de caracteres a ser checado
	 */
	public void pontoVerificacao(WebElement object, String atributo, int qtChar) {
		try {
			if (object.getAttribute("type").equals("hidden")) {
				pontoVerificacao(object.getAttribute(atributo).split(";").length == qtChar,
						"Validação do limite de caracteres do campo: " + getLocatorElement(object)
								+ "</br><b>Quantidade atual:</b> " + object.getAttribute(atributo).split(";").length
								+ "</br><b>Quantidade esperada:</b> " + qtChar);
			} else {
				pontoVerificacao(
						wait.until(ExpectedConditions.visibilityOf(object)).getAttribute(atributo).length() == qtChar,
						"Validação do limite de caracteres do campo: " + getLocatorElement(object)
								+ "</br><b>Quantidade atual:</b> " + object.getAttribute(atributo).length()
								+ "</br><b>Quantidade esperada:</b> " + qtChar);
			}
		} catch (NoSuchElementException fail) {
			pontoVerificacao(false, "Objeto não localizado - " + getLocatorElement(object));
		} catch (Exception e) {
			pontoVerificacao(false, "Erro ao tentar localizar objeto - " + getLocatorElement(object));
		}
	}

	/**
	 * Localiza células em uma tabela baseando-se em um texto. O método percorre
	 * todas as linhas da tabela. Exemplo: findElementOnTable("form:table",
	 * "2ChevroletCorvette", "rf-dt-c", 6);
	 * 
	 * @param ID_Table         - ID da tabela referenciada
	 * @param textFind         - Texto a ser localizado
	 * @param tdClass          - A classe CSS da linha (td)
	 * @param indexColunReturn - Número da coluna que deve retornar
	 */
	public ArrayList<WebElement> findElementOnTable(WebElement businessTable, String textFind, String tdClass,
			int indexColunReturn) {
		ArrayList<WebElement> list = new ArrayList<WebElement>();

		for (int i = 1; true; i++) {
			List<WebElement> tableRows = businessTable
					.findElements(By.xpath(".//tr[" + i + "]/td[@class = '" + tdClass + "']"));
			String txt = "";
			if (!tableRows.isEmpty()) {
				for (int j = 0; j < tableRows.size(); j++) {
					txt += tableRows.get(j).getText();
				}
				if (txt.contains(textFind)) {
					list.add(tableRows.get(indexColunReturn));
				}
			} else {
				break;
			}
		}
		return list;
	}

	/**
	 * Localiza icones em uma tabela baseando-se em um texto. O método percorre
	 * todas as linhas da tabela. Exemplo: findElementOnTable("form:table",
	 * "2ChevroletCorvette", "rf-dt-c", "delete", 6);
	 * 
	 * @param ID_Table         - ID da tabela referenciada
	 * @param textFind         - Texto a ser localizado
	 * @param tdClass          - A classe CSS da linha (td)
	 * @param icone            - Referência textual do ícone ou img
	 * @param indexColunReturn - Número da coluna que deve retornar
	 */
	public WebElement findElementOnTable(WebElement Table, String textFind, String tdClass, String icone,
			int indexColunReturn) {
		ArrayList<WebElement> list = findElementOnTable(Table, textFind, tdClass, indexColunReturn);
		WebElement icon = null;
		if (!list.isEmpty()) {
			for (int i = 0; i < list.size(); i++) {
				List<WebElement> tableRows = list.get(i).findElements(By.xpath(".//a/img"));
				if (!tableRows.isEmpty()) {
					for (int j = 0; j < tableRows.size(); j++) {
						if (tableRows.get(j).getAttribute("src").contains(icone)) {
							icon = tableRows.get(j);
							break;
						}
					}
				} else {
					System.out.println("Icone NÃO Localizado!");
				}
			}
		} else {
			System.out.println("Celulas NÃO Localizadas!");
		}
		return icon;
	}

	private String getLocatorElement(WebElement element) {
		return element.toString().replaceAll("\\S+: \\S+ on \\S+ (\\S+) -> ", "[");
	}

	public String[][] getDataPool(String dpt) {
		return new Datapool(diretorioDatapool + dpt).retornaDadosPlanilha();
	}

}