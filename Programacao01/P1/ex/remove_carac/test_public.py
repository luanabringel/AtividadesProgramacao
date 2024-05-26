from undertst import remove_caracteres

def test_exemplo():
    frase = "Apalavrados"
    assert remove_caracteres(frase, "sodA") == "palavra"
