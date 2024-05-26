from undertst import multiplica_lista

def test_exemplo():
    nomes = ['joao', 'pedro']
    assert multiplica_lista(2, nomes) == ['joao', 'pedro', 'joao', 'pedro']

def test_exemplo():
    nomes = [2]
    assert multiplica_lista(1, nomes) == [2]
