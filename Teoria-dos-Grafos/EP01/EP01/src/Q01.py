import networkx as nx


def associate_astronauts(list_a):

    G = nx.Graph()
    
    # Contadores que identificam os vértices para comparação
    node = 0
    nextNode = 0

    # Verifica se a lista é de tamanho zero, ou seja, vazia.
    if list_a is not None and len(list_a) == 0:
        return G
    
    # Verifica se a lista é None.
    if list_a is None:
        return None

    # Verifica se o tipo dos elementos contidos na lista são tuplas de Strings.
    if type(list_a[0]) != tuple or type(list_a[0][0]) != str:
        return None

    # Identifica e compara todos vértices pelo atributo "country"
    for i in list_a:
        G.add_node(node, first_name = i[0], last_name = i[1], country = i[2])
        for j in list_a:
            if i[2] != j[2]:
                G.add_edge(node, nextNode)
            nextNode += 1
        nextNode = 0
        node += 1

    return G
