from undertst import diff_simetricos

def test_exemplo_1():
    lista1 = [2, 5, 3, 9]
    assert diff_simetricos(lista1) == [-7, 2]
    assert lista1 == [2, 5, 3, 9]

def test_exemplo_2():
    lista2 = [2, 5, 3, 9, 4]
    assert diff_simetricos(lista2) == [-2, -4, 3]
    assert lista2 == [2, 5, 3, 9, 4]

def test_exemplo_3():
    lista3 = [2, 1]
    assert diff_simetricos(lista3) == [1]
    assert lista3 == [2, 1]

def test_exemplo4():
    lista4 = [5]
    assert diff_simetricos(lista4) == [5]
    assert lista4 == [5]

def test_exemplo5():
    lista5 = ['']
    assert diff_simetricos(lista5) == ['']
    assert lista5 == ['']
