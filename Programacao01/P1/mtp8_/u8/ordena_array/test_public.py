from undertst import ordena_tipos

def test_basico():
    a = ['1a', '2', 'e', '4', '4.4', 'e6', '8']
    assert ordena_tipos(a) == None
    assert a == ['2', '4', '8', 'e', '1a', '4.4', 'e6']
