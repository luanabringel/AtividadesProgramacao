import unittest
import sys

module = sys.argv[-1].split(".py")[0]

class PublicTests(unittest.TestCase):

    @classmethod
    def setUpClass(cls):
        global conta_diferentes
        undertest = __import__(module)
        conta_diferentes = getattr(undertest, 'conta_diferentes', None)

    def test_basico1(self):
       assert conta_diferentes('aaa', 'bbb') == 3

    def test_basico2(self):
       assert conta_diferentes('oi', 'ola') == 1

    def test_basico3(self):
       assert conta_diferentes('ola', 'oi') == 1

if __name__ == '__main__':
    loader = unittest.TestLoader()
    runner = unittest.TextTestRunner()
    runner.run(loader.loadTestsFromModule(sys.modules[__name__]))
