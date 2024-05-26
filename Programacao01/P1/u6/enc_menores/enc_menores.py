def encontra_menores(num, lista):
    menor = []

    for i in lista:
        if i < num:
            menor.append(i)
            break
    if menor != []:
        return menor[0]
    else:
        return -1
        
lista1 = [100,200,300,400]
lista2 = [15, 12, 4, 9, 10]
print(encontra_menores(100, lista1))
print(encontra_menores(10, lista2))
