# Simulação de uma Fila

---

### Obtenção de um número pseudo-aleatório

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

---

### Classes necessárias

* Classe Evento = vai definir o tipo de chegada ou saida
* Classe Fila = quantas pessoas, tempo minimo/maximo de atendimento, tempo minimo/maximo de chegada na fila,
* Classe Escalonador = que é o Priority Queue do java
* Classe Random = onde ficam a geração dos valores aleatórios
