import networkx as nx
from util.networkx_util import draw_graph
from EP01.src.Q03 import graph_density


# Importando o grafo, pesos são labels das arestas
G = nx.read_graphml('graphs\s-d-cy-sc-p-02.graphml')
print(f"n: {G.number_of_nodes()}")
print(f"m: {G.number_of_edges()}")
# Invocando a função
d = graph_density(G)
draw_graph(G, pos=nx.circular_layout(G), title=f"Densidade: {d}")

