from undertst import quantos_comeram

def test_ex1():
    assert quantos_comeram(10, [10, 10]) == 10

def test_ex2():
    assert quantos_comeram(12, [10, 10]) == 10

def test_ex3():
    assert quantos_comeram(2, [10, 10]) == 0

def test_ex4():
    assert quantos_comeram(5, [2, 3, 5]) == 5

def test_ex5():
    assert quantos_comeram(10, [0, 10]) == 10

def test_ex6():
    assert quantos_comeram(2, [1, 3, 2, 5, 6, 4]) == 1
