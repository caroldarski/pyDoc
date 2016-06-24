
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.*;
import java.util.ArrayList;
public class CreateDocPythonListener extends Python3BaseListener{
    String lastComment = "";
    String parametersDef = "";
    String argsListClass = "";

    ArrayList<Funcao> funcaoList = new ArrayList<>();
    ArrayList<Classe> classeList = new ArrayList<>();
    int contClass = 0;
    int contFunc = 0;
    public ArrayList<Classe> getClasseList(){
      return this.classeList;
    }

    public ArrayList<Funcao> getFuncaoList(){
      return this.funcaoList;
    }

    @Override
    public void enterFuncdef(@NotNull Python3Parser.FuncdefContext ctx) {
      Funcao f = new Funcao();
      f.setName(ctx.NAME().getText());
      f.setClasse(classeList.get(contClass -1));
      f.setId(contFunc);
      f.setDescription(lastComment);
      funcaoList.add(f);
      classeList.get(contClass -1).getFuncaoList().add(f);

      contFunc++;
      // System.out.println("Parameters def" + f.getParameters());
      // System.out.println("FuncDef:" + f.getName() );
      // System.out.println("Descrição: " + f.getDescription());
      // System.out.println("Classe pai: " + f.getClasse().getName());
      lastComment="";
    }

    @Override
    public void enterClassdef(@NotNull Python3Parser.ClassdefContext ctx) {
      Classe c = new Classe();
      c.setName(ctx.NAME().getText());
      c.setDescription(lastComment);
      c.setId(contClass);
      classeList.add(c);
      contClass++;
      // System.out.println("Class:" + c.getName());
      // System.out.println("Comentario:" + c.getDescription());
      lastComment="";
    }

    @Override
    public void enterArglist(@NotNull Python3Parser.ArglistContext ctx){
      argsListClass = ctx.getText();
      if (classeList != null){
        classeList.get(contClass -1).setMaster(argsListClass);
      }
    }

    @Override
    public void enterParameters(Python3Parser.ParametersContext ctx){
      parametersDef = ctx.getText();
      if (funcaoList != null){
        funcaoList.get(contFunc -1).setParameters(parametersDef);
      }
    }

    @Override
    public void enterCommentdef(@NotNull Python3Parser.CommentdefContext ctx) {
      String content = ctx.COMMENT().getText();
      String contentWithoutComm = content.replace("#", "");
      lastComment += contentWithoutComm + " ";
    }

    @Override
    public void enterSimple_stmt(@NotNull Python3Parser.Simple_stmtContext ctx){
      lastComment = "";
    }

    @Override
    public void enterIf_stmt(@NotNull Python3Parser.If_stmtContext ctx){
      lastComment = "";
    }

    @Override
    public void enterWhile_stmt(@NotNull Python3Parser.While_stmtContext ctx){
      lastComment = "";
    }

    @Override
    public void enterFor_stmt(@NotNull Python3Parser.For_stmtContext ctx){
      lastComment = "";
    }

    @Override
    public void enterTry_stmt(@NotNull Python3Parser.Try_stmtContext ctx){
      lastComment = "";
    }

    @Override
    public void enterWith_stmt(@NotNull Python3Parser.With_stmtContext ctx){
      lastComment = "";
    }
}
