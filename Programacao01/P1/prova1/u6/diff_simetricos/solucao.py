# Programação | 2021.2
# Solução do "altera senha" https://p1ufcg.github.io/#/as/4990024128921600
# luana.leite@ccc.ufcg.edu.br

def diff_simetricos(valores):
    lista_de_valores = []
    for valor in range(len(valores) // 2):
        lista_de_valores.append(valores[valor] - valores[-1 - valor])

    if len(valores % 2) != 0:
        lista_de_valores.append(valores[len(valores) // 2])
    return lista_de_valores
