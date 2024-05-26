from undertst import hello_arg

def test_1():
    msg_lower = hello_arg("prog1").lower()
    assert "hello" in msg_lower
    assert "prog1" in msg_lower

def test_2():
    msg_lower = hello_arg("Maria").lower()
    assert "hello" in msg_lower
    assert "maria" in msg_lower
