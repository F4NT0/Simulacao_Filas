$PSDefaultParameterValues['Out-File:Encoding'] = 'utf8'
cd .\Filas
javac Random.java Evento.java Fila.java Escalonador.java Algoritmo.java Main.java
java Main
cd ..