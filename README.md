# 🧙‍♂️ SIMULADORES DE FILAS 🧙‍♂️

---

## Como rodar o projeto

### Alterando os valores para teste

* Os valores para serem alterados para teste se encontram no Arquivo **Filas/Main.java**
* Para alterar os valores necessários para o simulador, altere os seguintes dados (começando na linha **10**)

```java
int c = 1; // número de atendentes (C)
int k = 3; // capacidade de pessoas na fila (K)
int chMin = 1; // tempo de chegada mínima de um cliente
int chMax = 2; // tempo de chegada máximo de um cliente
int atendMin = 3; // tempo de atendimento mínimo do cliente
int atendMax = 6; // tempo de atendimento máximo do cliente
double tempoGlobalInicial = 2.0; //tempo global do primeiro cliente
```

* Como na primeira versão são testados com valores aleatórios pré-definidos, pode ser alterado os valores da lista **valoresAleatorios** a partir da linha **20**

```java
// Valores Aleatórios entre 0 e 1 colocados manualmente
ArrayList<Double> valoresAleatorios = new ArrayList<>();
valoresAleatorios.add(0.3276);
valoresAleatorios.add(0.8851);
valoresAleatorios.add(0.1643);
valoresAleatorios.add(0.5542);
valoresAleatorios.add(0.6813);
valoresAleatorios.add(0.7221);
valoresAleatorios.add(0.9881);
```

### Como rodar o projeto no Windows

* Utilize o arquivo **runner.ps1** para fazer a compilação do projeto e apresentar no console o resultado
* Para deixar o powershell compilar scripts para ele, deve ser colocado o seguinte comando como administrador:

```powershell

```