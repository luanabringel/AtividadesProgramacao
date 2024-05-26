def remove_abaixo_media(l1):
    s = 0
    for n in range(len(l1)):
        s += l1[n]
    med = s/len(l1)
    for x in range(len(l1)-1, -1, -1):
        if l1[x] < med:
            l1.pop(x)
    return l1
