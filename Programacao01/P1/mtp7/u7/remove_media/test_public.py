from undertst import remove_abaixo_media

def test_exemplo1():
    l1 = [1, 1, 1, 1]
    remove_abaixo_media(l1)
    assert l1 == [1, 1, 1, 1]

def test_exemplo2():
    l1 = [1, 1, 1, -1, 1]
    remove_abaixo_media(l1)
    assert l1 == [1, 1, 1, 1]

