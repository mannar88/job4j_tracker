package ru.job4j.inheritance;

public class ReportUsage {

    public static void main(String[] args) {
        JSONReport report = new JSONReport();
                String text = report.generate("name", "body");
        System.out.println(text);
        HtmlReport reportHTML = new HtmlReport();
        text = reportHTML.generate("Report's name", "Report's body");
        System.out.println(text);
    }
}
