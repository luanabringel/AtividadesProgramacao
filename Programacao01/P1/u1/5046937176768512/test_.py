import re
from pathlib import Path

import pytest

ARQUIVO = "questoes.txt"

@pytest.fixture
def texto():
    try:
        return open(ARQUIVO).read()
    except:
        return ""

def test_ha_arquivo():
    assert Path(ARQUIVO).exists()

def test_q1(texto):
    assert re.search(r"\bpwd\b", texto)

def test_q2(texto):
    assert re.search(r"\bPATH\b", texto)

def test_q3(texto):
    assert re.search(r"\bPS1\b", texto)

def test_q4(texto):
    assert re.search(r"\bexit\b", texto)

def test_q5(texto):
    assert re.search(r"\bid\b", texto)

def test_q6(texto):
    assert re.search(r"\bps\b", texto)

def test_q7(texto):
    assert re.search(r"\becho\b", texto)

def test_q8(texto):
    assert re.search(r"/home/.*/p1", texto)

def test_q9(texto):
    assert re.search(r"\bpip\b", texto)

def test_q10(texto):
    assert re.search(r".local/bin", texto)
