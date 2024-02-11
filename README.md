# Gerador de mapas mentais automatizado para o CPNU 2024

* Linguagem: JAVA
* Bibliotecas: PDFBox, GraphViz.

* Definição: Ferramenta de auxilio para estudos,
organiza temas em formato de grafo.
Inicialmente projetado para auxílio ao CNU de 2024.

* Contexto:

A motivação inicialmente veio de necessidade organizativa individual,
mas escalonou em nível significativo, no intuito de não somente organizar
o criador desta ferramenta para atender a outros concurseiros.
Na premissa de que o esforço (seja individual e coletivo)
é o principal determinante para o sucesso do concurso,
a facilitação é apenas um meio.
Também tem base científica na construção de mapas conceituais de Novak,
que possuem objetivos a melhorar a ensino-aprendizagem.

A tecnologia usada para este projeto é o uso da Linguagem de Programação JAVA.
Além de utilizar a biblioteca PDFBox e GraphViz.

Neste projeto o fluxo se inicia com a aquisição de dados dos editais
por meio do PDFBox e então estes dados são padronizados e categorizados,
formando uma árvore que se ramificará mecanicamente a partir de padrões
encontrados nos editais para reduzir o tamanho do conteúdo de cada nó.
Isso facilita a geração e visualização de grafos em PDF, 
que usa a biblioteca GraphViz
a partir do "plugin JNI" J2GV (que o programador que vos fala criou).

Link para avaliação deste projeto: https://forms.gle/W3mrQFwyU42LQTMGA

Para contato:
Email: hugoleonel.net64@gmail.com
LinkedIn: https://www.linkedin.com/in/hugo-leonel/
