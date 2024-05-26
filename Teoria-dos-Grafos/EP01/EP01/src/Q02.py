import networkx as nx


def is_candidate(g, q_list, q, t):
    # Verifica se parâmetros é nulo
    if g == None or q_list == None or q == None or t == None:
        return None

    # Verifica se o grafo é vazio
    if g.number_of_nodes() == 0:
        return None

    # Verifica se q já faz parte do distrito
    if q in q_list:
        return None

    # verifica se q está inserido no grafo
    if q not in g:
        return None

    # verifica se o limite é maior ou igual a zero
    if t < 0:
        return None

    # Verifica se os vértices de q_list está contido em g
    for i in q_list:
        if i not in g:
            return None

    # Verifica se q é alcançável a partir das vizinhanças dos vértices de q_list
    for u in q_list:
        if not nx.has_path(g, u, q):
            return False
        if nx.has_path(g, u, q):
            path = nx.shortest_path(g, u, q)
            if not set(path[1:-1]).issubset(q_list):
                return False

    # Verifica se a distância entre q e os vértices de q_list é menor ou igual a d
    for u in q_list:
        dist = nx.shortest_path_length(g, u, q, weight='weight')
        if dist > t:
            return False

    return True
