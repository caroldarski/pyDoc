# calculadora.py
# @autor: Carolina Darski
# @date: 05/05/2016
# @version: 1.0
# Esta classe representa uma calculadora.
class Calculadora(object):
    def __init__(self, a, b):
        self.a = a
        self.b = b

    # Realiza operação de soma através do método.
    def soma(self):
        return self.a + self.b

    # Realiza operação de subtração através do método.
    def subtrai(self):
        return self.a - self.b

    # Realiza operação de multiplicação através do método.
    def multiplica(self):
        return self.a * self.b

    # Realiza operação de divisão através do método
    def divide(self):
        return self.a / self.b
