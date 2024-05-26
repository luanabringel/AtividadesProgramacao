import networkx as nx


# Função que retorna o número de arestas de entrada de um nó c
def fanIn(ddc, c):
    fan_in = 0
    for i in ddc:
        if c in ddc[i]:
            fan_in += 1

    return fan_in


# Função que verifica a validade do grafo e se o nó c existe no grafo
def is_None(ddc, c):
    if ddc is None:
        return True

    if c is None:
        return True

    if c not in ddc:
        return True

    return False


# Função que retorna o número de arestas de entrada e saída de um nó c
def class_metrics(ddc, c):

    # Verifica se o grafo é um DiGraph
    if not isinstance(ddc, nx.DiGraph):
        return None

    # Verifica se o nó c existe no grafo
    if is_None(ddc, c):
        return None

    # Número de arestas de saída
    fan_out = len(ddc[c])

    # Número de arestas de entrada
    fan_in = fanIn(ddc, c)

    # Retorna o número de arestas de entrada e saída
    return fan_out, fan_in # (fan_out, fan_in)
