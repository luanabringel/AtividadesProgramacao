dados = input()

#primeiro = ()
#cont = 0
#for elemento in dados:
#    if elemento[0] == "a":
#        primeiro = elemento[0]
#    if elemento != "a":
#        cont += 1

inicio = final = None
ordem = ""
cont = 0
for i, caractere enumerate(dados):
    letra = c.isalpha()
    if inicio is None and letra:
        inicio = i
    elif incio is not None and final is None and not letra:
        final = i
        break
else:
     final = len(dados)

if inicio is not None and final is not None:
    palavra = dados[inicio:final]

for x in palavra:
    if palavra[i] == "a":
        ordem = palavra
        print("em ordem")
    else:
        cont += 1
        print(f"fora de ordem: {cont}")

