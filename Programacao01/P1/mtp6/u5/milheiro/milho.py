qnt = 0
s = 0
fornadas = []
while True:
    qnt += 1
    tijolos = int(input())
    fornadas.append(tijolos)
    s += tijolos
    if s >= 1000:
        break
print(s)

media = s / qnt
print(f"{media:.2f}")

media_superior = 0
for t in fornadas:
    if t > media:
        media_superior += 1
print(media_superior)
