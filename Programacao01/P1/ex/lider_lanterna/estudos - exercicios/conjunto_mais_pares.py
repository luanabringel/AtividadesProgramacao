# Conjunto com mais pares

lista_pares = []
pares = 0
while True:
    n = input()
    if n == '---':
        lista_pares.append(pares)
        pares = 0
        continue
    if n == 'fim':
        break
    if int(n) % 2 == 0:
        pares += 1

maior = lista_pares[0]
posicao = 1
for i in range(len(lista_pares)):
    if lista_pares[i] > maior:
        maior = lista_pares[i]
        posicao += i

if lista_pares != [] and maior != 0:
    print(f"Conjunto {posicao}: {maior} par(es)")