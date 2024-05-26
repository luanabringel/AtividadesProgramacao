def soma_intervalo(a, b):
    lista = []
    soma = 0
    for i in range(a, b+1):
        lista.append(i)
    for e in lista:
        soma += e
    return soma

assert soma_intervalo(5, 15) == 110
assert soma_intervalo(10, 10) == 10
