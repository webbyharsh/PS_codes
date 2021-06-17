package com.w2d3.journal.utilities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Storage {

    public static ArrayList<VitalPost> vitalStore = new ArrayList<VitalPost>();
    public static ArrayList<Article> articleStore = new ArrayList<Article>();
    //public static HashMap<String, ArrayList<VitalPost>> articleStoreAuthorWise = new HashMap<String, ArrayList<VitalPost>>();


    public Storage(){

    }

    public static boolean checkRecentVitalUpdate() throws Exception{

        VitalPost vp = vitalStore.get(vitalStore.size() - 1);
        String timeStamp = vp.timeStamp;
        Date currentDate = new Date();
        long currentTime = currentDate.getTime();
        Date recentDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(timeStamp);
        long recentDateTime = recentDate.getTime();

        if(Math.subtractExact(currentTime, recentDateTime) >= 7200000){
            return true;
        }

        return false;
    }
    public static ArrayList<Article> searchArticleByCategory(String category){
        ArrayList<Article> temp = new ArrayList<Article>();
        for(int i=0;i<articleStore.size();i++){
            if(articleStore.get(i).category.equals(category)){
                temp.add(articleStore.get(i));
            }
        }
        return temp;
    }
    public static ArrayList<Article> searchArticleByAuthor(String author){
        ArrayList<Article> temp = new ArrayList<Article>();
        for(int i=0;i<articleStore.size();i++){
            if(articleStore.get(i).author.equals(author)){
                temp.add(articleStore.get(i));
            }
        }
        return temp;
    }
    
}
