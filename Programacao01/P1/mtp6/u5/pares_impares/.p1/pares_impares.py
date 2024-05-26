pares = 0
impares = 0
while True:
    numeros = input()
    if numeros == "fim":
        break
    if numeros == "":
        print()
        break
    if int(numeros) % 2 == 0:
        pares += 1
    elif int(numeros) % 2 == 1:
        impares += 1
if pares > 0:
    print(f"pares = {pares}")
if impares > 0:
    print(f"ímpares = {impares}")