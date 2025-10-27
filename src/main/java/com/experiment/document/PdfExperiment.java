package com.experiment.document;

import com.experiment.model.Person;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.AreaBreak;

public class PdfExperiment {

    public static void main(String[] args) {
        try {
            // PDF file path
            String dest = "BankStatement.pdf";
            PdfWriter writer = new PdfWriter(dest);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            // Example person
            Person person = new Person("Advik", 123456789); // assuming 123456789 is account number

            // Add content for 3 pages
            for (int page = 1; page <= 3; page++) {
                document.add(new Paragraph("The Bank Statement").setBold().setFontSize(18));
                document.add(new Paragraph("Name: " + person.getName()));
                document.add(new Paragraph("Account Number: " + person.getAge())); // rename getter if needed
                document.add(new Paragraph("Page " + page + " of 3"));

                // Table with 4 columns (auto-sized)
                Table table = new Table(4);
                table.addHeaderCell("Date");
                table.addHeaderCell("Description");
                table.addHeaderCell("Credit");
                table.addHeaderCell("Debit");

                // Sample transactions
                table.addCell("01-Oct-2025");
                table.addCell("Salary");
                table.addCell("$2000");
                table.addCell("$0");

                table.addCell("05-Oct-2025");
                table.addCell("ATM Withdrawal");
                table.addCell("$0");
                table.addCell("$500");

                table.addCell("Total");
                table.addCell("");
                table.addCell("$2000");
                table.addCell("$500");

                document.add(table);

                if (page != 3) {
                    document.add(new AreaBreak());
                }
            }

            document.close();
            System.out.println("PDF generated at: " + dest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
