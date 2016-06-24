
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

public class CreateDocPython {
		static List<Arquivo> arquivosList = new ArrayList<Arquivo>();
		public static void listMethodNames(ANTLRInputStream source, String inputFile) throws Exception{
				Python3Parser parser = new Builder.Parser(source).build();
				CreateDocPythonListener listener = new CreateDocPythonListener();
				ParseTreeWalker.DEFAULT.walk(listener, parser.file_input());
				ArrayList<Classe> cl = listener.getClasseList();

				Arquivo arq = new Arquivo();
				arq.setName(inputFile);
				arq.getClassesList().addAll(cl);
				arq.setAuthor(listener.getAuthorComment());
				arq.setDate(listener.getDateComment());
				arq.setVersion(listener.getVersionComment());
				arquivosList.add(arq);
		}

		private static void createDoc(List<Arquivo> arquivos) throws Exception{
			PrintWriter buffWrite = new PrintWriter(new FileWriter("pyDoc.html"));
			buffWrite.println("<html>");
			buffWrite.println("<head> <meta charset=\"UTF-8\">");
			buffWrite.println("<title>pyHTMLDoc - Calculadora.py</title>");
			buffWrite.println("</head>");
			buffWrite.println("<body>");

			for (int x=0; x < arquivos.size(); x++){
				for (int i=0; i<arquivos.get(x).getClassesList().size(); i++){
					int indiceI = i + 1;
					buffWrite.println("<a href=\"#CL"+ arquivos.get(x).getClassesList().get(i).getName() +"\" style=\"font-family: Arial, Verdana, sans-serif; font-size: 12px; font-style: italic;\">" + indiceI + "." + arquivos.get(x).getClassesList().get(i).getName() + "</a></br>");
					for (int j=0; j< arquivos.get(x).getClassesList().get(i).getFuncaoList().size(); j++){
						int indiceJ = j + 1;
						buffWrite.println("&nbsp;&nbsp;&nbsp;<a href=\"#FUNC"+ arquivos.get(x).getClassesList().get(i).getFuncaoList().get(j).getId() +"\" style=\"font-family: Arial, Verdana, sans-serif; font-size: 12px; font-style: italic;\">" + indiceI + "." + indiceJ + "." + arquivos.get(x).getClassesList().get(i).getFuncaoList().get(j).getName() + "</a></br>");
					}
				}
			}

			for (int x=0; x < arquivos.size(); x++){

				buffWrite.println("<h2 style=\"color: rgb(34, 34, 34); font-family: Arial, Verdana, sans-serif;\">" + arquivos.get(x).getName() + "</h2></br>");
				buffWrite.println("<h4 style=\"color: rgb(34, 34, 34); font-family: Arial, Verdana, sans-serif; font-size: 12px;\"> Autor: " + arquivos.get(x).getAuthor() + "</h4></br>");
				buffWrite.println("<h4 style=\"color: rgb(34, 34, 34); font-family: Arial, Verdana, sans-serif; font-size: 12px;\"> Data: " + arquivos.get(x).getDate() + "</h4></br>");
				buffWrite.println("<h4 style=\"color: rgb(34, 34, 34); font-family: Arial, Verdana, sans-serif; font-size: 12px;\"> Versão: " + arquivos.get(x).getVersion() + "</h4></br>");

				for (int i=0; i<arquivos.get(x).getClassesList().size(); i++){
					buffWrite.println("<div id=\"CL"+ arquivos.get(x).getClassesList().get(i).getName() +"\"> <h3 style=\"color: rgb(34, 34, 34); font-family: Arial, Verdana, sans-serif;\">" + arquivos.get(x).getClassesList().get(i).getName());
					buffWrite.println("(<a href=\"#CL" + arquivos.get(x).getClassesList().get(i).getMaster() + "\">"+ arquivos.get(x).getClassesList().get(i).getMaster() + "</a>)</h3></br>");

					buffWrite.println("<spam style=\"color: rgb(34, 34, 34); font-family: Arial, Verdana, sans-serif; font-size: 12px;\">" + arquivos.get(x).getClassesList().get(i).getDescription() + "</spam></div></br>");
					buffWrite.println("<h3 style=\"color: rgb(34, 34, 34); font-family: Arial, Verdana, sans-serif;\">M&eacute;todos:</h3>");
					for (int j=0; j< arquivos.get(x).getClassesList().get(i).getFuncaoList().size(); j++){
						buffWrite.println("<h2 style=\"color: rgb(34, 34, 34); font-family: Arial, Verdana, sans-serif;\">" + arquivos.get(x).getClassesList().get(i).getFuncaoList().get(j).getName() + arquivos.get(x).getClassesList().get(i).getFuncaoList().get(j).getParameters() + "</h2>" );
						buffWrite.println("<div id=\"FUNC"+ arquivos.get(x).getClassesList().get(i).getFuncaoList().get(j).getId() +"\" style=\"font-family: Arial, Verdana, sans-serif; font-size: 12px; font-style: italic;\">"  + "</br>" + arquivos.get(x).getClassesList().get(i).getFuncaoList().get(j).getDescription() + "</div></br>");
					}
				}


			}
			buffWrite.println("</body>");

			buffWrite.close();

		}
    public static void main(String[] args) throws Exception {
      String inputFile = null;
			for (int i=0; i < args.length; i++){
				inputFile = args[i];

				InputStream file = new FileInputStream(inputFile);

				ANTLRInputStream source = new ANTLRInputStream(file);
				System.out.println(source.toString());
				listMethodNames(source, inputFile);
			}
			createDoc(arquivosList);

		}
}
