import networkx as nx

G = nx.read_graphml('./graphs/s-u-w-cy-sc-p-01.graphml')
out = nx.generate_edgelist(G,data=["label"])
olist=[]
for line in out:
    olist.append(line)
print(olist)


