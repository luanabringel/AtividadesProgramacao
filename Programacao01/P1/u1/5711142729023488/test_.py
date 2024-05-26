import re
from pathlib import Path

import pytest

ARQUIVO = "questoes.txt"
RESPOSTAS = ["str", "float", "1.5", "int", "1", "str", "2.02.0", "float", "4.0"]

@pytest.fixture
def texto():
    try:
        return open(ARQUIVO).read()
    except:
        return ""

@pytest.fixture
def tem_token(texto):
    def tem_token(token):
        return re.search(r"\b" + token + r"\b", texto)
    return tem_token

@pytest.mark.parametrize("token", RESPOSTAS)
def test_q1(token, tem_token):
    assert tem_token(token)

def test_tem_10_mais_10(texto):
    return "10 + 10" in texto
