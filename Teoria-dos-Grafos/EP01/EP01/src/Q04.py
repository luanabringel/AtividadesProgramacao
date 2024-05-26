import networkx as nx


def best_route(G, i):

    # Verifica se o grafo é None
    if G is None:
        return None

    # Verifica se o nó possui o atributo depth
    profundidades = nx.get_node_attributes(G, 'depth')
    for node in G.nodes:
        if node not in profundidades:
            return None

    if G is None or i not in G.nodes or G.nodes[i]['depth'] != 0:
        return None

    percurso = []
    
    # Verifica se o nó é um nó final (compartimento de entrada)
    if G.nodes[i]['full']:
        return percurso

    visitou = set()
    percurso = [i]
    
    def get_depth(x):
        return x[1]

    while True:
        # Pega o último nó do percurso
        atual = percurso[-1]

        # Verifica se o nó é um nó final
        if G.nodes[atual]['full']:
            return percurso

        candidates = []

        # Verifica os vizinhos do nó atual
        for neighbor in G.neighbors(atual):
            # Verifica se o vizinho não foi visitado e se não é um nó final
            if not G.nodes[neighbor]['full']:
                if neighbor not in visitou:
                    if G.nodes[neighbor]['depth'] > G.nodes[atual]['depth']:
                        candidates.append((neighbor, G.nodes[neighbor]['depth']))

        # Verifica se não há candidatos
        if not candidates:
            return percurso
            
        # Verifica se há mais de um candidato
        else:
            next_compartment = min(candidates, key=get_depth)[0]
            visitou.add(next_compartment)
            percurso.append(next_compartment)