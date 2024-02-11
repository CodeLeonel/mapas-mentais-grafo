package aplicacao;

import application.JaGraph;

public class TestarLib {

	public static void main(String[] args) {
		
		String dotCommands = "digraph G {\r\n"
				+ "a -> b;\r\n"
				+ "c [shape=box];\r\n"
				+ "a -> c [weight=29,label=\"lib lib lib\"];\r\n"
				+ "subgraph anything {\r\n"
				+ "/* the following affects only x,y,z */\r\n"
				+ "node [shape=circle];\r\n"
				+ "a; x; y -> z; y -> z; /* multiple edges */\r\n"
				+ "}\r\n"
				+ "}";
		

		
		JaGraph.renderPDFile(dotCommands, "neato", "pastateste/TesteLib");

	}

}
