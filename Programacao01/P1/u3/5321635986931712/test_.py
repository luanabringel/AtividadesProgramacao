from undertst import hello


def test_retorna_str():
    assert type(hello()) is str


def test_tem_hello():
    assert "hello" in hello().lower()
