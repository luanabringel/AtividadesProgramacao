# Programação | 2021.2
# Solução do "quantos comeram?" https://p1ufcg.github.io/#/as/5734235593768960
# luana.leite@ccc.ufcg.edu.br

def quantos_comeram(n, fila_pedidos):
    cont_pedidos = 0
    num_feijoadas = n
    for pedido in fila_pedidos:
        num_feijoadas -= pedido
        if num_feijoadas >= 0:
            cont_pedidos += pedido
    return cont_pedidos
