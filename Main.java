import java.io.*;
import java.util.ArrayList;
import java.util.Collections;


public class Main {

    public static void main(String[] args) throws IOException {
        String pathCommand=args[1];
        BufferedReader in = null;
        ArrayList<String> comList = new ArrayList<String>();
        PrintWriter printWriter = new PrintWriter("output.txt");

        String pathauthor = args[0];
        ArrayList<author> authList = new ArrayList<author>();
        String id;
        String name;
        String uni;
        String department;
        String email;
        //article info
        ArrayList<article> articleList = new ArrayList<article>();
        String paperId;
        String articleName;
        String publisherName;
        String publishYear;

        try {
            in = new BufferedReader(new FileReader(pathauthor));
            String str;
            while ((str = in.readLine()) != null) {
                String[] vals = str.split(" ");


                switch (vals.length) {
                    case 2:
                        id = vals[1];
                        author author1 = new author(id);
                        authList.add(author1);
                        break;


                    case 3:
                        id = vals[1];
                        name = vals[2];
                        author author2 = new author(id, name);
                        authList.add(author2);
                        break;


                    case 4:
                        id = vals[1];
                        name = vals[2];
                        uni = vals[3];
                        author author3 = new author(id, name, uni);
                        authList.add(author3);
                        break;


                    case 5:
                        id = vals[1];
                        name = vals[2];
                        uni = vals[3];
                        department = vals[4];
                        author author4 = new author(id, name, uni, department);
                        authList.add(author4);
                        break;



                    default:

                        id = vals[1];
                        name = vals[2];
                        uni = vals[3];
                        department = vals[4];
                        email = vals[5];
                        String temp = "";
                        for (int i = 6; i < vals.length; i++) {

                            if (i == vals.length - 1) {
                                temp += vals[i];
                            } else {
                                temp += vals[i] + ",";
                            }
                        }
                        author author6 = new author(id, name, uni, department, email, temp);
                        authList.add(author6);
                        break;




                }

            }
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        } catch (
                IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                in.close();
            }
        }


//      COMMANDS
        try {
            in = new BufferedReader(new FileReader(pathCommand));
            String str;
            while ((str = in.readLine()) != null) {

                comList.add(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                in.close();
            }
        }

        for (String i:comList) {
            if (i.contains("read")) {

                String[] arr = i.split(" ");

                String pathArticle = arr[1];

                try {
                    in = new BufferedReader(new FileReader(pathArticle));
                    String str;
                    while ((str = in.readLine()) != null) {
                        String[] vals = str.split(" ");

                        paperId = vals[1];
                        articleName = vals[2];
                        publisherName = vals[3];
                        publishYear = vals[4];
                        article a = new article(paperId, articleName, publisherName, publishYear);
                        articleList.add(a);


                    }

                } catch (
                        FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (in != null) {
                        in.close();
                    }
                }


            }
            ArrayList<String> tempp= new ArrayList<String>();
            if (i.equalsIgnoreCase("completeall")) {

                for (author authorr :authList) {
                    for (article artic : articleList) {

                        if (authorr.getId().equals(artic.paperId.substring(0, 3))) {

                            tempp.add(artic.paperId);

                            if (authorr.articlesOfAuthor2.contains(artic.paperId)||authorr.articlesOfAuthor2.size()>=5){

                            }else{

                                authorr.articlesOfAuthor2.add(artic.paperId);

                            }

                        }


                    }

                }
                printWriter.println("*************************************CompleteAll Successful*************************************");


            }
            if(i.equalsIgnoreCase("sortedall")){
                for (author writer: authList) {
                    Collections.sort(writer.articlesOfAuthor2);


                }
                printWriter.println("*************************************SortedAll Successful*************************************");


            }if(i.contains("del")){
                String[] arr= i.split(" ");
                for (int z=0;z< authList.size();z++){
                    if (authList.get(z).getId().equals(arr[1])){
                        authList.remove(z);
                        printWriter.println("*************************************del Successful*************************************");

                    }
                }










            }
            if(i.equals("list")){
                printWriter.println("----------------------------------------------List---------------------------------------------");

                for (author writer : authList) {
                    printWriter.println(writer);
                    for (String text:writer.articlesOfAuthor2){
                        for (article art: articleList){
                            if(art.paperId.equals(text)){
                                printWriter.println("+"+art.toString());
                            }

                        }
                    }
                    printWriter.println("");


                }
                printWriter.println("----------------------------------------------End---------------------------------------------");

            }

        }
        printWriter.close();
    }





}