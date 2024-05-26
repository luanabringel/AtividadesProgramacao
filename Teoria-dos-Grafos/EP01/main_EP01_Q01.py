import networkx as nx
from EP01.src.Q01 import associate_astronauts
from util.networkx_util import draw_graph

a_list = [
    ('Kurtis', 'Shepstone', 'Italy'),
    ('Rafferty', 'Stoak', 'Canada'),
    ('Libbey', 'Anselm', 'Canada'),
    ('Odelinda', 'Thireau', 'Italy'),
    ('Eleanore', 'Pollett', 'USA'),
    ('Town', 'Duddell', 'Canada')
]
# Invocando a função
G = associate_astronauts(a_list)  
print(G.nodes(data=True))
# Saída esperada: (não necessariamente na mesma ordem)
# [(0, {'first_name': 'Kurtis', 'last_name': 'Shepstone', 'country': 'Italy'}), 
# (1, {'first_name': 'Rafferty', 'last_name': 'Stoak', 'country': 'Canada'}), 
# (2, {'first_name': 'Libbey', 'last_name': 'Anselm', 'country': 'Canada'}), 
# (3, {'first_name': 'Odelinda', 'last_name': 'Thireau', 'country': 'Italy'}), 
# (4, {'first_name': 'Eleanore', 'last_name': 'Pollett', 'country': 'USA'}), (5, {'first_name': 'Town', 'last_name': 'Duddell', 'country': 'Canada'})]
print(G.edges)
# Saída esperada: (não necessariamente na mesma ordem)
# [(0, 1), (0, 2), (0, 4), (0, 5), (1, 3), (1, 4), (2, 3), (2, 4), (3, 4), (3, 5), (4, 5)]
draw_graph(G, nx.circular_layout(G), node_labels=nx.get_node_attributes(G, 'last_name'))
