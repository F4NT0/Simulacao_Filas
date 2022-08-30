#=============================
# RUNNER DO PROJETO PELO LINUX
#=============================

cd Filas/
javac Colors.java Random.java Evento.java Fila.java Escalonador.java Algoritmo.java Main.java
java Main
rm -rf *.class
cd ..
