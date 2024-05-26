import networkx as nx


def dependencies(ddc, c):
    # Verifica se os dados passados são None, se não é um grafo digrafo e se c não está no grafo, retorna None se satisfazer
    if ddc == None or c == None or not isinstance(ddc, nx.DiGraph) or c not in ddc:
        return None
    
    # Lista das denpedências diretas
    diretas = list(nx.neighbors(ddc, c))
    diretas.sort()

    # Lista com todas as denpedências
    dependentes = list(nx.neighbors(ddc, c))
    dependentes.sort()

    # Lista das denpedências indiretas
    indiretas = []

    for i in dependentes:
        vizinhos = list(nx.neighbors(ddc, i))
        for v in vizinhos:
            if v not in dependentes and v != c:
                indiretas.append(v)
                dependentes.append(v)

    return diretas, indiretas
