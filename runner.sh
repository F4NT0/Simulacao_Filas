#=============================
# RUNNER DO PROJETO PELO LINUX
#=============================

cd Apresentacao
javac -d ..\Filas\ *.java
cd ..
cd Filas
javac *.java
java Main
rm -rf Apresentacao/
rm -rf *.class
cd ..
