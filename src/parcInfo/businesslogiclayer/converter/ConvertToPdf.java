package parcInfo.businesslogiclayer.converter;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.io.File;
import java.io.FileOutputStream;

import javax.swing.JTable;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;


public class ConvertToPdf {
	public void toPDF(JTable table, File file){
		Document document = new Document(); 
		try { 
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file)); 

		document.open(); 
		PdfContentByte cb = writer.getDirectContent(); 

		cb.saveState(); 
		Graphics2D g2 = cb.createGraphicsShapes(1200, 500); 

		Shape oldClip = g2.getClip(); 
		g2.clipRect(0, 0, 800, 1000); 

		table.print(g2); 
		g2.setClip(oldClip); 

		g2.dispose(); 
		cb.restoreState(); 
		} catch (Exception e) { 
		System.err.println(e.getMessage()); 
		} 
		document.close(); 
		
	}
}
