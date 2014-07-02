package controller;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDTrueTypeFont;

import java.io.IOException;

/**
 * Created by Gergo on 2014.07.01..
 */
public class PdfCreator {

    public PdfCreator() {
    }

    public void createPDF() throws IOException {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        PDFont font = PDTrueTypeFont.loadTTF(document, "c:/windows/fonts/Roboto-Bold.ttf");

        try {
            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.beginText();
            contentStream.setFont(font, 16);
            contentStream.moveTextPositionByAmount(100, 700);
            contentStream.drawString("Hello Wurl");
            contentStream.endText();

            contentStream.close();

            document.save("Hello Worl.pdf");
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (COSVisitorException e) {
            e.printStackTrace();
        }
    }
}
