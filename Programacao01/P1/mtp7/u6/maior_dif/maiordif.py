def adiciona_maior(lista):
    dif = 0
    for x in range(len(lista)-1):
        if abs(lista[x] - lista[x + 1]) > dif:
            dif = abs(lista[x] - lista[x + 1])
    for n in range(len(lista)):
        lista[n] += dif
