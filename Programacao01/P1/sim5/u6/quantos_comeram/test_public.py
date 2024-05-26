from undertst import quantos_comeram

def test_exemplo_1():
    assert quantos_comeram(10, [10, 10]) == 10

def test_exemplo_2():
    assert quantos_comeram(12, [10, 10]) == 10

def test_exemplo_3():
    assert quantos_comeram(2, [10, 10]) == 0

def test_exemplo_4():
    assert quantos_comeram(5, [2, 3, 5]) == 5
