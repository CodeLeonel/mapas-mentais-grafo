package repositorio;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class LeitorPDF {

	public String lerArquivo() {
		
		PDDocument document = null;
		PDFTextStripper pdfStripper = null;
		String text = null;
		
		File file = new File("./editais/edital-cpnu-bloco-2-2024-01-26-retificado.pdf");
		
		try {
			document = PDDocument.load(file);
		
			pdfStripper = new PDFTextStripper();
		
			text = pdfStripper.getText(document);
	    
		    document.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return text;
	}
	
}
