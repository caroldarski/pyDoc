
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

		public static void listMethodNames(ANTLRInputStream source, Arquivo arq) throws Exception{
				Python3Parser parser = new Builder.Parser(source).build();
				CreateDocPythonListener listener = new CreateDocPythonListener();
				PrintWriter buffWrite = new PrintWriter(new FileWriter("pyDoc.html"));
				ParseTreeWalker.DEFAULT.walk(listener, parser.file_input());

				buffWrite.println("<html>");
				buffWrite.println("<head>");
				buffWrite.println("<title>pyHTMLDoc - Calculadora.py</title>");
				buffWrite.println("</head>");
				buffWrite.println("<body>");

				ArrayList<Funcao> af = listener.getFuncaoList();
				ArrayList<Classe> cl = listener.getClasseList();


				for (int i=0; i<cl.size(); i++){
					int indiceI = i + 1;
					buffWrite.println("<a href=\"#CL"+ cl.get(i).getName() +"\" style=\"font-family: Arial, Verdana, sans-serif; font-size: 12px; font-style: italic;\">" + indiceI + "." + cl.get(i).getName() + "</a></br>");
					for (int j=0; j< cl.get(i).getFuncaoList().size(); j++){
						int indiceJ = j + 1;
						buffWrite.println("&nbsp;&nbsp;&nbsp;<a href=\"#FUNC"+ cl.get(i).getFuncaoList().get(j).getId() +"\" style=\"font-family: Arial, Verdana, sans-serif; font-size: 12px; font-style: italic;\">" + indiceI + "." + indiceJ + "." + cl.get(i).getFuncaoList().get(j).getName() + "</a></br>");
					}
				}

				buffWrite.println("<h2 style=\"color: rgb(34, 34, 34); font-family: Arial, Verdana, sans-serif;\">" + arq.getName() + "</h2>");

				for (int i=0; i<cl.size(); i++){
					buffWrite.println("<div id=\"CL"+ cl.get(i).getName() +"\"> <h3 style=\"color: rgb(34, 34, 34); font-family: Arial, Verdana, sans-serif;\">" + cl.get(i).getName());
					buffWrite.println("(<a href=\"#CL" + cl.get(i).getMaster() + "\">"+ cl.get(i).getMaster() + "</a>)</h3></br>");

					buffWrite.println("<spam style=\"color: rgb(34, 34, 34); font-family: Arial, Verdana, sans-serif; font-size: 12px;\">" + cl.get(i).getDescription() + "</spam></div></br>");
					buffWrite.println("<h3 style=\"color: rgb(34, 34, 34); font-family: Arial, Verdana, sans-serif;\">M&eacute;todos:</h3>");
					for (int j=0; j< cl.get(i).getFuncaoList().size(); j++){
						buffWrite.println("<h2 style=\"color: rgb(34, 34, 34); font-family: Arial, Verdana, sans-serif;\">" + cl.get(i).getFuncaoList().get(j).getName() + cl.get(i).getFuncaoList().get(j).getParameters() + "</h2>" );
						buffWrite.println("<div id=\"FUNC"+ cl.get(i).getFuncaoList().get(j).getId() +"\" style=\"font-family: Arial, Verdana, sans-serif; font-size: 12px; font-style: italic;\">"  + "</br>" + cl.get(i).getFuncaoList().get(j).getDescription() + "</div></br>");
					}
				}

				buffWrite.println("</body>");
				buffWrite.close();

    }

    public static void main(String[] args) throws Exception {
      String inputFile = null;
			for (int i=0; i < args.length; i++){
				inputFile = args[i];
				Arquivo arq = new Arquivo();
				arq.setName(inputFile);

				InputStream file = new FileInputStream(inputFile);

				ANTLRInputStream source = new ANTLRInputStream(file);
				System.out.println(source.toString());
				listMethodNames(source, arq);
			}

		}
}
