# Conjunto com maior palavra

palavras = []  # formada pelas palavras de cada conjunto
maiores_palavras = []  # Será formada pelas maiores palavras de cada conjunto
while True:
    entrada = input()
    if entrada != '---' and entrada != 'fim':
        palavras.append(entrada)
    if entrada == '---' and len(palavras) > 0:  # essa condição não será executada se o conjunto for vazio
                                                # o len de um conjunto vazio é zero
        maior = palavras[0]  # encontrando a maior palavra do conjunto atual
        for i in range(len(palavras)):
            if len(palavras[i]) > len(maior):
                maior = palavras[i]

        maiores_palavras.append(maior)  # a lista está recebendo a maior palavra do conjunto
        palavras = []
        continue

    if entrada == 'fim':
        break

maior = maiores_palavras[0]  # encontrando a maior palavra, na lista das maiores palavras
posicao = 1
for i in range(len(maiores_palavras)):
    if len(maiores_palavras[i]) > len(maior):
        maior = maiores_palavras[i]
        posicao += i

print(f'Conjunto {posicao}: {maior} ({len(maior)} letras)')

#OUTRO CODIGO
conjunto = []
while True:
    elemento = input()
    if elemento == 'fim': break
    conjunto.append(elemento)
nome = None
maior = 0
for i in range(len(conjunto)):
    cont = 0
    for v in range(len(conjunto[i])):
        if conjunto[i] != '---':
            cont += 1
        if cont > maior:
            maior = cont
            nome = conjunto[i]

separador = 1
for i in range(0, len(conjunto)):
    if conjunto[i] == '---':
        separador += 1
    if conjunto[i] == nome: break

if nome == None:
    parada = True
else:
    print(f'Conjunto {separador}: {nome} ({maior} letras)')