numero = input()
sequencia = input().split()
cont = 0

for n in sequencia:
    if n == numero:
        cont += 1

if cont > 0:
    print("sim")
else:
    print("não")
