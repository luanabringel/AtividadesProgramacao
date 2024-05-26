import networkx as nx
from util.networkx_util import draw_graph
from EP01.src.Q05 import valid_word

W = nx.MultiDiGraph()
W.add_nodes_from([0, 1, 2, 3])
W.add_edge(0, 1, 'e1', label='a')
W.add_edge(0, 1, 'e2', label='b')
W.add_edge(1, 1, 'e3', label='a')
W.add_edge(1, 2, 'e4', label='b')
W.add_edge(2, 2, 'e5', label='b')
W.add_edge(2, 3, 'e6', label='c')

draw_graph(W, pos=nx.random_layout(W))

print(valid_word(W, 0, 3, 'aabbc')) #Saída esperada: True
print(valid_word(W, 0, 3, "aaa")) #Saída esperada: False
print(valid_word(W, 0, 3, "abc")) #Saída esperada: True
print(valid_word(W, 0, 3, "abcc")) #Saída esperada: False
print(valid_word(W, 0, 3, "bbbbc")) #Saída esperada: True



