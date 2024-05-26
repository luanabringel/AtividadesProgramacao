valor_k = int(input())
pecas = input().split()

cont = 0
lista = []
for p in pecas:
    lista.append(int(p))

diferenca = 0
x1 = 0
x2 = 0
for v in range(0,len(lista)-1,1):
    diferenca = lista[v] - lista[v + 1]
    if [v] < [v + 1]:
        diferenca = [v + 1] - [v]


if diferenca > valor_k:
    cont += 1
    
print(cont)