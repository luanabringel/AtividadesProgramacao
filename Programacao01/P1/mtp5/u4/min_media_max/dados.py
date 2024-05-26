num_dados = int(input())

dados = int(input())

lista = []
lista.append(dados)

maximo = dados
minimo = dados
soma = dados

media = soma/len(lista)

print(f"{dados} {minimo} {media:.2f} {maximo}")

for x in range(num_dados - 1):
    a = int(input())
    lista.append(a)
    soma += a
    if a<minimo:
        minimo = a
    if a>maximo:
        maximo = a
    media = soma/len(lista)
    print(f"{a} {minimo} {media:.2f} {maximo}")

