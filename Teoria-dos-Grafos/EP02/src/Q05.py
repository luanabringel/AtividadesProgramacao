import networkx as nx


def change_costs_factor(ddc, c):
    # Verifica se o grafo é direcionado, se é None e se c não está no grafo
    if ddc == None or c == None or not isinstance(ddc, nx.DiGraph) or c not in ddc:
        return None

    # Inicializa o custo de manutenção das classes
    custo = 1

    # Verifica as dependências da classe
    dependentes = []
    fator_de_carga = 0
    for classe in ddc:
        if classe != c:
            dependentes = list(nx.neighbors(ddc, classe))
            for dependente in dependentes:
                if dependente == c:
                    fator_de_carga += 1
                    break
                vizinhos = list(nx.neighbors(ddc, dependente))
                for vizinho in vizinhos:
                    if vizinho not in dependentes and vizinho != dependente:
                        dependentes.append(vizinho)
                    
    custo += fator_de_carga
    
    # Verifica os ciclos de dependências minimas 
    ciclos = nx.simple_cycles(ddc)
    for ciclo in ciclos:
        if c in ciclo:
            custo += 10

    # Verifica a tangle do ddc
    tangle = max(nx.strongly_connected_components(ddc), key=len)
    if len(tangle) > 3 and c in tangle:
        custo += 50
    
    return custo
