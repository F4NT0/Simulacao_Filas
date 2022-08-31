#=============================
# RUNNER DO PROJETO PELO LINUX
#=============================

cd Apresentacao
javac -d ..\Filas\ *.java
cd ..
cd Filas
javac *.java
java Main
ls -la
cd ..
