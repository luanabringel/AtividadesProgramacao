numero = int(input())
divisores = 1

while divisores < numero:
    resto = numero % divisores
    if resto == 0:
        print(divisores)
    divisores = divisores + 1

