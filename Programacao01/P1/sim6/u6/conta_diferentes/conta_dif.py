def conta_diferentes(s1, s2):
    cont = 0
    for i in range(len(s1)):
        for j in range(len(s2)):
            if s1[i] != s2[j]:
                cont += 1
    return cont

print(conta_diferentes('aaa', 'bbb'))
print(conta_diferentes('oi', 'ola'))
print(conta_diferentes('ola', 'oi'))
