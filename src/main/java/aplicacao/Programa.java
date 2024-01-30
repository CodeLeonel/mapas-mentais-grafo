package aplicacao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class Programa {

	public static void main(String[] args) {
		
		PDDocument document = null;
		String pathTextFile = null;
		PDFTextStripper pdfStripper = null;
		String text;
		
		File file = new File("./editais/edital-cpnu-bloco-2-2024-01-26-retificado.pdf");
		
		try {
			document = PDDocument.load(file);
		
			pdfStripper = new PDFTextStripper();
		
			text = pdfStripper.getText(document);
	    
		    document.close();
			
		    pathTextFile = "./textos/"+file.getName() + ".txt";
		    
		    FileWriter fw = new FileWriter(pathTextFile);
		    
		    fw.write(text);
		      
		    fw.close();
	    
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		try(BufferedReader br = new BufferedReader(new FileReader(pathTextFile))) {
			
			List<Sessao> sessaoList = new ArrayList<>();
			Sessao sessao = null;
			String linha = br.readLine();
			Boolean anexo = false;
			
			while(linha != null) {
				
				if(linha.contains("ANEXO IV - CONTEÚDOS PROGRAMÁTICOS")) {
					anexo = true;
				}
				
				if(anexo && linha.contains("CONHECIMENTOS GERAIS") || linha.contains("EIXO TEMÁTICO")) {
					
					sessao = new Sessao(linha.trim());
					
					
					
				}
				
				linha = br.readLine();
			}
			
		} catch(IOException e) {
			
		}

	}

}
