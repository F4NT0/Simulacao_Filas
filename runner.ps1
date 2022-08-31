$PSDefaultParameterValues['Out-File:Encoding'] = 'utf8'
cd Apresentacao
javac -d ..\Filas\ *.java
cd ..
cd Filas
javac *.java
java Main
rmdir *.class
cd ..
