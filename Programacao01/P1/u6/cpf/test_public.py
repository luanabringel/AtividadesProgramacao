from undertst import calcula_digitos_verificacao

def test_basico():
    assert calcula_digitos_verificacao('153245875') == '40'
