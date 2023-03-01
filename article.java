
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


public class article{
    String path = "C:\\Users\\Bora\\OneDrive\\Masaüstü\\article1.txt";
    ArrayList<Object> articleList = new ArrayList<Object>();
    BufferedReader in = null;
    String paperId;
    String articleName;
    String publisherName;
    String publishYear;



    public article(String paperid,String nameee,String publishername, String publishyear) throws FileNotFoundException, IOException {
        paperId= paperid;
        articleName = nameee;
        publisherName=publishername;
        publishYear=publishyear;

    }

    public String toString(){
        return "ARTICLE"+"      "+paperId+"     "+articleName+"     "+publisherName+"       "+publishYear;
    }

    public ArrayList getArray(){
        return articleList;
    }
    public String getPaperId(){
        return paperId;
    }
    public String getArticleName(){
        return articleName;}
    public String getPublisherName(){
        return publisherName;
    }
    public String getPublishYear(){
        return publishYear;
    }



}

