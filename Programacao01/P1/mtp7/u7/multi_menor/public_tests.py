import unittest
import sys

module = sys.argv[-1].split(".py")[0]

class PublicTests(unittest.TestCase):

    @classmethod
    def setUpClass(cls):
        global remove_multiplos_do_menor
        undertest = __import__(module)
        remove_multiplos_do_menor = getattr(undertest, 'remove_multiplos_do_menor', None)

    def test_exemplo(self):
        l1 = [6, 9, 10, 3, 5]
        assert  remove_multiplos_do_menor(l1) == None
        assert l1 == [10, 5]

    def test_exemplo2(self):
        l2 = [10, 20, 5, 24, 31]
        assert remove_multiplos_do_menor(l2) == None
        assert l2 == [24, 31]

if __name__ == '__main__':
    loader = unittest.TestLoader()
    runner = unittest.TextTestRunner()
    runner.run(loader.loadTestsFromModule(sys.modules[__name__]))
