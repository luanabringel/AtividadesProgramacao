import networkx as nx
from src.Q04 import mfs_greedy

    
def ordem_reversa(graph):
    reversed_order = list(nx.topological_sort(graph))
    reversed_order.reverse()
    return reversed_order


def class_order(ddc):
    if ddc is None:
        return None

    if not isinstance(ddc, nx.DiGraph):
        return None

    # Verificando se o grafo é acíclico
    if nx.is_directed_acyclic_graph(ddc) == True:
        return None
    
    # Obter o MFS utilizando a função mfs_greedy já implementada na questão quatro.
    mfs = mfs_greedy(ddc)

    # Criar um novo grafo removendo as dependências presentes no MFS
    grafo_aciclico = ddc.copy()
    for arc in mfs:
        grafo_aciclico.remove_edge(*arc)

    # Encontrar os componentes fortemente conectados
    componentes = list(nx.strongly_connected_components(grafo_aciclico))

    # Remover duplicatas nos grupos
    for grupo in componentes.values():
        grupo.sort()
        grupo[:] = sorted(set(grupo))

    # Obter a ordem topológica inversa no subgrafo acíclico
    ordem = ordem_reversa(grafo_aciclico)
    
    return []
