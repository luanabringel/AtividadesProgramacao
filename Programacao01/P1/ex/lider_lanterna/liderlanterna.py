times = input().split()
pontuacao = input().split()
rodadas = int(input())

def index(list, element):
    for i in range(len(list)+1):
        if list[i] == element:
            return i 

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

lista = []
for x in range(rodadas):
    jogos = input().split()
    lista.append(jogos)

for e in range(len(pontuacao)):
    pontuacao[e] = int(pontuacao[e])

for v in lista:
    gols = v[1].split("x")
    gols1 = int(gols[0])
    gols2 = int(gols[1])
    index1 = index(times,v[0])
    index2 = index(times,v[2])

    if gols1 > gols2:
        pontuacao[index1] += 3
    elif gols2 > gols1:
        pontuacao[index2] += 3
    elif gols1 == gols2:
        pontuacao[index1] += 1
        pontuacao[index2] += 1

minimo = mymin(pontuacao)
maximo = mymax(pontuacao)

print(f"Líder: {times[maximo]}")
print(f"Lanterna: {times[minimo]}")