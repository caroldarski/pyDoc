import java.util.List;
import java.util.ArrayList;
public class Classe{

  private int id;
  private String master;
  private String name;
  private String description;
  private String signature;
  private List<Funcao> funcaoList;

  public Classe(){
    this.funcaoList = new ArrayList<Funcao>();
  }

  public String getMaster(){
    return this.master;
  }

  public void setMaster(String master){
    this.master = master;
  }

  public List<Funcao> getFuncaoList(){
    return this.funcaoList;
  }

  public void setId(int id){
    this.id = id;
  }

  public int getId(){
    return this.id;
  }

  public void setName(String name){
    this.name = name;
  }

  public String getName(){
    return this.name;
  }

  public void setDescription(String description){
    this.description = description;
  }

  public String getDescription(){
    return this.description;
  }

  public void setSignature(String signature){
    this.signature = signature;
  }

  public String getSignature(){
    return this.signature;
  }

}
