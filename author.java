import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class author {
    private String id;
    private String name;
    private String uni;
    private String department;
    private String email;
    private int check;




    private ArrayList<String> theList = new ArrayList<String>();

    private List<List<String>> authorLinked = new LinkedList<>();

    public ArrayList<String> articlesOfAuthor =new ArrayList<String>();
    public ArrayList<String> articlesOfAuthor2 =new ArrayList<String>();
    public author(String id){ this.id=id;
        check=1;
    }
    public author(String id,String name){this.id=id; this.name=name;
        check=2;
    }
    public author(String id, String name, String uni){this.id=id; this.name=name; this.uni=uni;
        check=3;
    }
    public author(String id, String name, String uni,String department){this.id=id;this.uni=uni; this.department=department; this.name=name;
        check=4;

    }
    public author(String id, String name, String uni,String department,String email,String... article) {
        this.id = id;
        this.uni = uni;
        this.department = department;
        this.email = email;
        this.name = name;
        for(int i=0;i<article.length;i++)
        {
            articlesOfAuthor.add(article[i]);
        }
        String[] tempke=articlesOfAuthor.get(0).split(",");
        for (String element: tempke){
            articlesOfAuthor2.add(element);
        }

        check = 5;
    }
    public String getId(){return id;
    }
    public String toString(){
        switch (check){
            case 1:return  "AUTHOR      "+id;
            case 2: return "AUTHOR      "+id+"      "+name;
            case 3: return "AUTHOR      "+id+"      "+name+"        "+uni;
            case 4: return "AUTHOR      "+id+"       "+name+"      "+uni+"      "+department;

            default:
                String temp=" ";
                for (String element:articlesOfAuthor){
                    temp+=element;

                }




                return "AUTHOR      "+id+"      "+name+"       "+uni+"     "+department+"     "+email;



        }

    }

}


