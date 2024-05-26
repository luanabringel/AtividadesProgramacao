def indice_mais_cedo(horas):
    indice_menor = 0
    for i in range(len(horas)):
        if horas[i] < horas[indice_menor]:
            indice_menor = i

    return indice_menor

funcionarios = input().split()
nome = []
horario = []
for i in range(0, len(funcionarios), 4):
    nome.append(funcionarios[i])
    horario.append(f"{funcionarios[i + 1]}:{funcionarios[i + 2]}:{funcionarios[i + 3]}")

indice_vencedor = indice_mais_cedo(horario)
vencedor = nome[indice_vencedor]

print(vencedor)