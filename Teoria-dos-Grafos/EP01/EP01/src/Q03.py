import networkx as nx


def graph_density(g):
    
    if g is None:
        return None
    
    # Verificando se o grafo é um multigrafo ou um pseudografo
    has_multiple_edges = lambda g: (any(g.number_of_edges(e[0], e[1]) > 1 for e in g.edges))
    is_pseudograph = lambda g: nx.number_of_selfloops(g) > 0
    is_multigraph = lambda g: not is_pseudograph(g) and has_multiple_edges(g)

    if is_pseudograph(g) or is_multigraph(g):
        return None
    
    # Calculando a densidade, tanto do grafo direcionado ou não-direcionado, usando a função density
    densidade = round(nx.density(g), 2)

    return densidade
