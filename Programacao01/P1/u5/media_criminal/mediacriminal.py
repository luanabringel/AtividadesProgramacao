media_ssp = float(input())

while True:
    valores = input()
    lista_valores = valores.split()

    if lista_valores[0] == "fim":
        break

    soma = 0
    quant = 0
    for x in lista_valores:
        soma += int(x)
        quant += 1

    media = soma/quant
    if media > media_ssp:
        print(valores)
    elif media <= (media_ssp / 2):
        break
