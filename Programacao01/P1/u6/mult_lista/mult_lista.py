def multiplica_lista(n, lista):
    lista_ = []
    if n > 0:
        for i in range(n):
            for x in lista:
                lista_.append(x)
    return lista_
nomes = ['joao', 'pedro']
print(multiplica_lista(2, nomes))