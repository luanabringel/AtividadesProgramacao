from undertst import pivot

def test_exemplo_1():
    numeros = [6, 4, 8, 1, 7, 3]
    pivot(numeros)
    assert numeros == [4, 1, 3, 6, 8, 7], numeros
