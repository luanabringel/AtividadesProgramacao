import networkx as nx
from src.Q01 import class_metrics


def find_minimum_dependency_cycles(ddc):
    # Obtém todos os ciclos no grafo
    cycles = nx.simple_cycles(ddc)

    # Converte os ciclos em pares de nós
    cycle_pairs = []
    for cycle in cycles:
        cycle_length = len(cycle)
        cycle_pairs.append([(cycle[i], cycle[(i + 1) % cycle_length]) for i in range(cycle_length)])

    return cycle_pairs


def find_max_occurring_arc(cycles, ddc):
    # Dicionário para contar as ocorrências de cada arco
    arc_occurrences = {} 

    for cycle in cycles:
        for arc in cycle:
            if arc in arc_occurrences:
                arc_occurrences[arc] += 1
            else:
                arc_occurrences[arc] = 1

    max_occurrences = max(arc_occurrences.values())  # Maior quantidade de ocorrências

    max_arcs = [arc for arc, occurrences in arc_occurrences.items() if occurrences == max_occurrences]

    # No caso de empate, escolhe o arco cujo vértice de origem tem maior fan_out
    if len(max_arcs) > 1:
        max_fan_out = 0
        max_arcs_with_fan_out = []

        for arc in max_arcs:
            fan_out = class_metrics(ddc, arc[0])[0]
            if fan_out > max_fan_out:
                max_arcs_with_fan_out = [arc]
                max_fan_out = fan_out
            elif fan_out == max_fan_out:
                max_arcs_with_fan_out.append(arc)
                

        max_arcs = max_arcs_with_fan_out

    # No caso de empate, escolhe o arco cujo vértice destino tem maior fan_in
    if len(max_arcs) > 1:
        max_fan_in = 0
        max_arcs_with_fan_in = []

        for arc in max_arcs:
            fan_in = class_metrics(ddc, arc[1])[1]
            if fan_in > max_fan_in:
                max_arcs_with_fan_in = [arc]
                max_fan_in = fan_in
            elif fan_in == max_fan_in:
                max_arcs_with_fan_in.append(arc)

        max_arcs = max_arcs_with_fan_in

    # No caso de empate, considera a ordenação lexicográfica das tuplas
    if max_occurrences > 1 and len(max_arcs) > 1:
        max_arcs.sort()

    return list(reversed(max_arcs))


def mfs_greedy(ddc):
    # Verifica se o grafo é um DiGraph
    if not isinstance(ddc, nx.DiGraph):
        return None

    mfs = []
    md_cycles = find_minimum_dependency_cycles(ddc)  # Função para encontrar os ciclos de dependência mínimos
    if md_cycles is None:
        return []

    while len(md_cycles) > 0:
        max_arcs = find_max_occurring_arc(md_cycles, ddc)
        
        if len(max_arcs) > 0:
            max_arc = max_arcs[0]  # Seleciona o primeiro arco com a maior quantidade de ocorrências
        else:
            max_arc = None

        mfs.append(max_arc)
        md_cycles = [cycle for cycle in md_cycles if max_arc not in cycle]

    return mfs
