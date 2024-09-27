package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class BookScraper {
    public static void main(String[] args) {
        String url = "https://books.toscrape.com/";

        try{
            Document document = Jsoup.connect(url).get();
            Elements books = document.select(".product_pod");
            System.out.println("=======================================");
            System.out.println("************ Web Scraper **************");
            System.out.println("=======================================");
            for(Element bk : books){
                String title = bk.select(" h3 > a").text();
                String price = bk.select(".price_color").text();
                // A whole list of book title and price
               // System.out.println(title + "-" + price);

                //Advanced Scarping
                // Get books with $20
                String actual_price = price.substring(1);
                if (Double.parseDouble(actual_price) < 20){
                    System.out.println(title + "-" + price);
                }
            }
            System.out.println("=======================================");
            System.out.println("************ End Scraper **************");
            System.out.println("=======================================");


        } catch (IOException e){
            e.printStackTrace();
        }


    }
}
