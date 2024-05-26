def remove_multiplos_do_menor(lista):
    minimo = lista[0]

    for x in range(len(lista)):
        if lista[x] < minimo:
            minimo = lista[x]
    for n in range(len(lista)-1, -1, -1):
        if lista[n] % minimo == 0:
            lista.pop(n)


l1 = [6, 9, 10, 3, 5]
l2 = [10, 20, 5, 24, 31]
assert remove_multiplos_do_menor(l1) == None
assert remove_multiplos_do_menor(l2) == None
