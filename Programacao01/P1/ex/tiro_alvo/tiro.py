soma = 0
chances = 0
while True:
    alvo = input().split()
    distancia = ((float(alvo[0]))**2 + (float(alvo[1]))**2) **(1/2)
    if distancia > 200.0:
        break
    soma += distancia
    chances += 1
    print(f"{distancia:.2f}cm")

print("--")
print(f"num disparos: {chances}")

media = soma/chances
print(f"distancia media: {media:.2f}cm")
