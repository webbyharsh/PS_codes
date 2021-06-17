package com.w2d3.journal;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.w2d3.journal.utilities.Article;
import com.w2d3.journal.utilities.Storage;
import com.w2d3.journal.utilities.VitalPost;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        // Storage storage = new Storage();
        addArticle("Harsh", "Covid Symptoms", "Demo post showing covid symptoms...", "information");
        addArticle("Abhishek", "Covid treatment", "Demo post showing covid symptoms...post 2", "information");
        addArticle("Rahul", "How to take care", "Demo post showing covid symptoms...post 3", "self-care");
        addArticle("Harsh", "What to eat", "Demo post showing covid symptoms...post 4", "self-care");
        addArticle("Deepak", "Post covid activities", "Demo post showing covid symptoms...post 5", "information");
        addArticle("Shrishti", "Observing vitals", "Demo post showing covid symptoms...", "random");
        addArticle("Harsh", "Observing vitals", "Demo post showing covid symptoms...", "random");


        printArticles(Storage.searchArticleByCategory("self-care"));
       // printArticles(Storage.searchArticleByAuthor("Harsh"));
        
        

        try {
            addVital(85, 98, 98.2);
            addVital(84, 99, 98.2);
            addVital(83, 99, 98.2);
            addVital(85, 99, 98.2);
            addVital(90, 98, 98.2);
            addVital(82, 99, 98.2);
            addVital(85, 99, 98.2);
            addVital(85, 98, 98.2);

            System.out.println(Storage.checkRecentVitalUpdate());
        } catch (Exception e) {
            System.out.println("Something went wrong while adding vitals " + e.toString());
        }
        printVitals();
    }

    public static void addVital(int heartRate, int spo2, double temperature) throws Exception {
        try {
            Date currentDate = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            String dateNow = sdf.format(currentDate);
            // Date dateCustomObj = sdf.parse("16-06-2021 00:00:00");
            // String dateCustomString = sdf.format(dateCustomObj);
            VitalPost vitalPost = new VitalPost(heartRate, spo2, temperature, dateNow);
            Storage.vitalStore.add(vitalPost);
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }

    }

    public static void addArticle(String author, String postTitle, String postBody, String category) {
        Date currentDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String timeStamp = sdf.format(currentDate);
        Article article = new Article();
        article.setAuthor(author);
        article.setCategory(category);
        article.setPostBody(postBody);
        article.setPostTitle(postTitle);
        article.setTimeStamp(timeStamp);
        Storage.articleStore.add(article);
    }

    public static void printArticles(ArrayList<Article> article) {
        for (int i = 0; i < article.size(); i++) {
            System.out.println(article.get(i).postTitle);
            System.out.println(article.get(i).author);
            System.out.println(article.get(i).postBody);
            System.out.println(article.get(i).timeStamp);
            System.out.println("Catgory "+ article.get(i).category);
            System.out.println("===================================");
        }
    }
    
    public static void printVitals() {
        for (int i = 0; i < Storage.vitalStore.size(); i++) {
            System.out.println("Heart Rate " + Storage.vitalStore.get(i).heartRate);
            System.out.println("Spo2 level " + Storage.vitalStore.get(i).spo2);
            System.out.println("Temperature " + Storage.vitalStore.get(i).temperature);
            System.out.println(Storage.vitalStore.get(i).timeStamp);
            System.out.println("===================================");
        }
    }
}
