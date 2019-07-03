package suporte;


import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;

public class Datapool {
	private String workbookName = null;

	public Datapool(String pathDaPlanilha) {
		this.workbookName = pathDaPlanilha;
	}

	public String[][] retornaDadosPlanilha(){
		Workbook workbook = null;
		try {

			WorkbookSettings ws = new WorkbookSettings();
			ws.setEncoding("ISO-8859-1");

			workbook = Workbook.getWorkbook(new File(workbookName), ws);

		} catch (BiffException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Sheet sheet = workbook.getSheet(0);
		int linhas = sheet.getRows();
		int colunas = sheet.getColumns();
		String[][] dpt = new String[linhas][colunas];
		try {
			for(int i = 0; i < linhas; i++){
				for (int j = 0; j < colunas; j++) {
					dpt[i][j] = sheet.getCell(j, i).getContents();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return dpt;
	}

	public static void main(String[] args) {
		String[] tmp = {"BuscaAppNome.xls",
				};

		int total = 0;
		String[][] datapool = null;
		for (String strings : tmp) {
			datapool = new Datapool("/home/andre/Developer/work/AgenciaDigital/src/test/java/datapools/" + strings).retornaDadosPlanilha();
			//	System.out.println(strings + " QTD: " + String.valueOf(datapool.length-1));
			//	total += datapool.length-1;

			System.out.println("COOPERATIVA: " + datapool[1][0] + " | " + datapool[1][1]);
		}	
		System.out.println(total);
	}
}
