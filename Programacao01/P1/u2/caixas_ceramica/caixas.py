import math

revestimento = float(input("Capacidade de revestimento? "))
print()
print("== Dados do vão a revestir ==")
c = float(input("Comprimento? "))
l = float(input("Largura? "))
a = float(input("Altura? "))

area = (l*c) + (2*a*c) + (2*a*l)
ncaixas = area/revestimento
print()

print("== Resultados ==")
print(f"Área total a revestir: {area} m2")
print(f"Número de caixas: {math.ceil(ncaixas)}")
