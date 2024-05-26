import unittest
import sys

module = sys.argv[-1].split(".py")[0]

class PublicTests(unittest.TestCase):

    @classmethod
    def setUpClass(cls):
        global quase_fonemas
        undertest = __import__(module)
        quase_fonemas = getattr(undertest, 'quase_fonemas', None)

    def test_exemplo(self):
        assert quase_fonemas("computador") == ['co', 'pu', 'ta', 'do']
        assert quase_fonemas("exemplo") == ['xe', 'lo']
        assert quase_fonemas("arara") == ['ra', 'ra']

if __name__ == '__main__':
    loader = unittest.TestLoader()
    runner = unittest.TextTestRunner()
    runner.run(loader.loadTestsFromModule(sys.modules[__name__]))
