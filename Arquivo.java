import java.util.List;
import java.util.ArrayList;
public class Arquivo{

  private String author;
  private String date;
  private String version;
  private String name;
  private List<Classe> classesList;

  public Arquivo(){
    this.classesList = new ArrayList<Classe>();
  }
  public void setAuthor(String author){
    this.author = author;
  }

  public String getAuthor(){
    return this.author;
  }

  public void setDate(String date){
    this.date = date;
  }

  public String getDate(){
    return this.date;
  }

  public void setVersion(String version){
    this.version = version;
  }

  public String getVersion(){
    return this.version;
  }

  public void setName(String name){
    this.name = name;
  }

  public String getName(){
    return this.name;
  }

  public List<Classe> getClassesList(){
    return this.classesList;
  }


}
