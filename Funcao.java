public class Funcao{

  private int id;
  private Classe classe;
  private Classe masterClasse;
  private String name;
  private String description;
  private String parameters;
  private String signature;

  public void setId(int id){
    this.id = id;
  }

  public int getId(){
    return this.id;
  }
  
  public void setClasse(Classe classe){
    this.classe = classe;
  }

  public Classe getClasse(){
    return this.classe;
  }

  public void setMasterClasse(Classe masterClasse){
    this.masterClasse = masterClasse;
  }

  public Classe getMasterClasse(){
    return this.masterClasse;
  }

  public void setDescription(String description){
    this.description = description;
  }

  public String getDescription(){
    return this.description;
  }

  public void setParameters(String parameters){
    this.parameters = parameters;
  }

  public String getParameters(){
    return this.parameters;
  }

  public void setSignature(String signature){
    this.signature = signature;
  }

  public String getSignature(){
    return this.signature;
  }

  public void setName(String name){
    this.name = name;
  }

  public String getName(){
    return this.name;
  }
}
