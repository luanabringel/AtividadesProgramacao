from undertst import soma_intervalo

def test_basico_1():
    assert soma_intervalo(10, 10) == 10

def test_basico_2():
    assert soma_intervalo(5, 15) == 110
