from undertst import adiciona_maior

def test_basico():
    l1 = [2, 6, 5, 4, 0, 1]
    assert adiciona_maior(l1) == None
    assert l1 == [6, 10, 9, 8, 4, 5]


