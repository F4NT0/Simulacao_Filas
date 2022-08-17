# 🧙‍♂️ SIMULADORES DE FILAS 🧙‍♂️

---

# Tópico 1) Obtenção de um número pseudo-aleatório

* Devemos pegar um número aleatório entre 0 e 1
* Sequeremos saber um número entre um número A e um B, utilizamos a seguinte fórmula

```
U(A,B) = (B - A) x U(0,1) + A
```

Se queremos saber um número pseudo-aleatório entre 2 e 3, devemos:

1. Escolher um número aleatório entre 0 e 1, escolhi **0,2**
2. Utilizar esse valor no lugar do U(0,1)

```
U(2,3) = (3 - 2) x 0,2 + 2
U(2,3) = 1 x 0,2 + 2
U(2,3) = 0,2 + 2
U(2,3) = 2,2
```

* O nosso número pseudo-aleatório entre 2 e 3 foi **2,2**


---

# Tópico 2) Notação de Kendall

---

# A/B/C/K/N/D

* **A** = Distribuição das [**chegadas**]() de clientes.
* **B** = Distribuição dos [**atendimentos**]() de clientes.
* **C** = Distribuição de [**servidores**]() da fila.
* **K** = [**Capacidade**]() da Fila (**tamanho máximo do vetor de situações da fila**).
* **N** = [**Tamanho**]() da população.
* **D** = [**Politica**]() de atendimento.


# A/B/C/K

Exemplo: [**G/G/1/3**]()

* Distribuição geométrica (G) nas chegadas(A), Distribuição geométrica (G) no atendimento (B).
* Fila com 1 servidor (C).
* Capacidade para 3 clientes na fila (K).

Exemplo 2: [**M/M/1**]()

* Distribuição Exponencial (M) nas chegadas (A), Distribuição Exponencial (M) no atendimento de clientes (B).
* Fila com 1 servidor (C).
* Como não tem um valor para K, significa que a fila tem capacidade infinita.

---

# Tópico 3) Simulação de uma fila simples

* Núcleo de Simulação:
    * Lista de eventos agendados (**Escalonador**).
    * Variável para o tamanho da fila.
    * Simulador (contadores de tempo dos estados).

* Tempo:
    * Tempo global de simulação.


### Classes necessárias

* Classe **Evento** = Onde vai ficar definido os métodos de chegada e saída.
* Classe **Fila** = quantas pessoas, tempo minimo/maximo de atendimento, tempo minimo/maximo de chegada na fila.
* Classe **Escalonador** = que é o Priority Queue do java, vai lidar com as chegadas e saídas dos clientes.
* Classe **Random** = onde ficam a geração dos valores aleatórios.

### Passos

1. Recebe como atributos a quantidade de pessoas possíveis na fila (K), para criar o vetor com todos os estados possíveis da fila.
    * Se o tamanho do K for 3, vai ter um vetor que vai de 0 á 3.
    * Posição 0 significa que teve n horas com 0 pessoas na fila.
    * Posição 1 significa que teve n horas com 1 pessoas na fila.
    * Posição 2 significa que teve n horas com 2 pessoas na fila.
    * Posição 3 significa que teve n horas com 3 pessoas na fila.

2. A fila é iniciada com **zero**, ou seja, ainda não tem ninguém na fila, isso vai servir na hora do escalonador trabalhar com as chegadas e saídas.
3. O tempo global é iniciado como **zero**, ele vai sendo incrementado a partir de um cálculo.
