import networkx as nx
from src.Q01 import class_metrics


def silent_villains(ddc, threshold):
    global_breakable = []
    global_butterfly = []
    hub = []

    if ddc is None:
        return None
    elif threshold is None:
        return None
    elif threshold < 0:
        return None
    elif not isinstance(ddc, nx.DiGraph):
        return None


    for a in ddc.nodes:
        if ddc.out_degree(a) > threshold:
            global_breakable.append(a)
        if ddc.in_degree(a) > threshold:
            global_butterfly.append(a)
        if ddc.in_degree(a) > threshold and ddc.out_degree(a) > threshold:
            hub.append(a)

    return global_breakable, global_butterfly, hub
