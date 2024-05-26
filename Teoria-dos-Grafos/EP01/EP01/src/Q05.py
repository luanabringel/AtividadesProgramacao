import networkx as nx


def valid_word(g, s, t, w):

    # Verifica se a entrada não vai andar
    if(s == t and len(w) == 0):
        return True

    # Verifica se parâmetros é nulo
    if g is None or s is None or t is None or w is None:
        return None

    # Verifica se os parâmetros não estão no grafo
    if (s not in g.nodes) or (t not in g.nodes):
        return None

    # Acha o proximo vertice que vai andar
    def acharProximo(g, c, l):
        for i in g.successors(c):
            for value in g[c][i].values():
                if not "label" in value:
                    return None

                if(l in value['label']):
                    return i

        return -1

    # Defini o primeiro vertice a andar
    proximo = acharProximo(g, s, w[0])

    # Verifica se não tem label
    if(proximo == None):
        return None

    # Verifica se não tem caminho
    if(proximo < 0):
        return False

    # Verifica se está no final certo, com uma palavra de tamanho 1
    elif(len(w)== 1) or (proximo == t):
        return True

    # Verifica os proximos caminhos de cada letra fora a primeira.
    else:
        for k in range(1, len(w)):
            proximo = acharProximo(g, proximo, w[k])

            if(proximo < 0):
                return False

        if(proximo == t):
            return True

        else:
            return False
        