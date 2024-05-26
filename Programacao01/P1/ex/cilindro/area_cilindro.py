import math

print("Cálculo da Superfície de um Cilindro")

print("---")
diametro = float(input("Medida do diâmetro? "))
altura = float(input("Medida da altura? "))
print("---")

pi = math.pi
raio = diametro/2
area_lateral = 2 * pi * raio * altura
area_base = pi * (raio **2)
area_total = area_lateral + (2 * area_base)

print(f"Área calculada: {area_total:.2f}")

