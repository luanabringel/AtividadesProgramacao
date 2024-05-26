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

def test_bash(texto):
    assert re.search(r"\bbash\b", texto, flags=re.IGNORECASE)

def test_python(texto):
    assert re.search(r"\bpython\b", texto, flags=re.IGNORECASE)

def test_mkdir(texto):
    assert re.search(r"\bmkdir\b", texto, flags=re.IGNORECASE)

def test_cd(texto):
    assert re.search(r"\bcd\b", texto, flags=re.IGNORECASE)

def test_ls(texto):
    assert re.search(r"\bls\b", texto, flags=re.IGNORECASE)
