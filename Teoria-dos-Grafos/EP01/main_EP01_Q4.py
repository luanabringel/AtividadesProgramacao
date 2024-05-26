import networkx as nx
from EP01.src.Q04 import best_route
from util.networkx_util import draw_graph

F = nx.read_graphml("graphs/s-u-w-cy-sc-p-02.graphml")
depth_dict = {'n0': 0, 'n1': 26, 'n2': 52, 'n3': 59, 'n4': 95, 'n5': 68, 'n6': 79, 'n7': 26}
for v in F.nodes:
    F.nodes[v]['depth'] = depth_dict[v]
full_list = ['n5', 'n6']
for v in F.nodes:
    if v in full_list:
        F.nodes[v]['full'] = True
    else:
        F.nodes[v]['full'] = False
route = best_route(F, 'n0')
node_labels = {v: f"{v}({F.nodes[v]['depth']})" for v in F.nodes}

draw_graph(F, pos=nx.planar_layout(F),
           node_labels=node_labels,
           nset=[full_list, route, [v for v in F.nodes if v not in full_list and v not in route]],
           nsetlabel=["Full", "Best Route", "Others"], nsetcolor=["red", "cyan", "grey"])
