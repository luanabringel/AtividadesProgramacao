palavras = input().split()

def infunc(list, element):
    isin = False
    for i in range(len(list)):
        if list[i] == element:
            isin = True
            break
    return isin

cont = 0
for p in palavras:
    for letra in p:
        if palavras[letra] == "a" or palavras[letra] or "e" or palavras[letra] == "i" or palavras[letra] or "o" or palavras[letra] == "u":
            cont += 1

print(f"Quantidade de pentavogalicas: {cont}") 