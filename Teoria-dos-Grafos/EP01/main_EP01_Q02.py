import networkx as nx
from util.networkx_util import draw_graph
from EP01.src.Q02 import is_candidate

# Importando o grafo, pesos são labels das arestas
G = nx.read_graphml('graphs\s-u-w-cy-sc-p-01.graphml')
for s, t in G.edges:
    G[s][t]['weight'] = int(G[s][t]['label'])
# Invocando a função
q_list = ['n7', 'n8', 'n9', 'n12']
q = 'n0'
print(is_candidate(G, q_list, q, 50000))
draw_graph(G, nx.kamada_kawai_layout(G),
           edge_labels=nx.get_edge_attributes(G, 'weight'),
           nset=[q_list, [q], [n for n in G.nodes if n not in q_list and n != q]],
           nsetcolor=["pink", "red", "grey"],
           nsetlabel=['q_list', 'q', 'others'])
