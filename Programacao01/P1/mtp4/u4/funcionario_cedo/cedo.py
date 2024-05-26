funcionarios = input().split()

for nome in range(len(funcionarios)):
    funcionarios[nome] = funcionarios[0:len(funcionarios):4]
    funcionarios[nome].append(funcionarios)

maior = 0
for i in range(len(funcionarios)):
    if funcionarios[i] > list[maior]:
        maior = i
        print(maior)




