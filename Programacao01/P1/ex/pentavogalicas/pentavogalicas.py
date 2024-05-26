palavras = input().split()

cont = 0
for i in range(len(palavras)):
    lista = [False, False, False, False, False]
    for v in range(len(palavras[i][v])):
        if palavras[i][v] == "a":
            lista[0] = True
        elif palavras[i][v] == "e":
            lista[1] = True
        elif palavras[i][v] == "i":
            lista[2] = True
        elif palavras[i][v] == "o":
            lista[3] = True
        elif palavras[i][v] == "u":
            lista[4] = True

    if lista[0] and lista[1] and lista[2] and lista[3] and lista[4]:
        cont += 1

print(f"Quantidade de pentavogais: {cont}")
