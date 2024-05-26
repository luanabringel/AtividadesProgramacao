from undertst import split_simplificado

def test_simples():
    assert split_simplificado('um exemplo') == ['um','exemplo']
    
def test_exemplo():
    assert split_simplificado('um exemplo maior') == ['um','exemplo','maior']

def test_exemplo():
    assert split_simplificado('duaspalavras') == ['duaspalavras']
