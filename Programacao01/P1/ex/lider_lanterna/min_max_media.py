num_dados = int(input())

def mymin(list):
    _max = 0
    _index = 0
    for i in range(len(list)):
        if _max < list[i]:
            _max = list[i]

    _min = _max
    for i in range(len(list)):
        if _min > list[i]:
            _min = list[i]
            _index = i

    return _index

def mymax(list):
    _max = 0
    _index = 0
    for i in range(len(list)):
        if _max < list[i]:
            _max = list[i]
            _index = i

    return _index

lista=[]
for i in range(num_dados):
    dados = input()
    lista.append(dados)

for e in range(len(dados)):
    dados[e] = int(dados[e])

soma = 0
media = 0
qnt = 0
minimo = 0
maximo = 0
for v in lista:
    qnt += 1
    soma += lista[v]
    media += soma / qnt
    minimo = mymin(dados)
    maximo = mymax(dados)
    print(f"{dados[v]} {minimo} {media:.2f} {maximo}")



