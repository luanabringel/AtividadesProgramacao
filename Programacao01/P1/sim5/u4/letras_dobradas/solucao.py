# Programação | 2021.2
# Solução do "letras dobradas" https://p1ufcg.github.io/#/as/5734235593768960
# luana.leite@ccc.ufcg.edu.br

def acharduplicados(list):
    for i in range(len(list)):
        if (list[i] == list[i-1]):
            return True
    return False

def printlist(list):
    for i in range(len(list)):
        print(list[i])

num_palavras = int(input())
duplicadas = []
nao_duplicadas = []
for i in range(num_palavras):
    palavras = input()
    if acharduplicados(palavras):
        duplicadas.append(palavras)
    else:
        nao_duplicadas.append(palavras)

print(f"{len(duplicadas)} palavra(s) com letras dobradas:")
printlist(duplicadas)
print("---")
print(f"{len(nao_duplicadas)} palavra(s) sem letras dobradas:")
printlist(nao_duplicadas)
