# mamifero.py
# Definição de diferentes tipos de mamíferos.
# @autor: Carolina Darski
# @date: 05/05/2016
# @version: 1.0
# Esta classe representa um mamífero.
class Mamifero:
    # Definição de um som para o mamífero genérico.
    def som(self,som):
        som = "emitir um som"

# Esta classe representa um homem que herda de um mamífero.
class Homem(Mamifero):
    # Definição de um som para o mamífero Homem.
    def som(self,som):
        som = "Oi!"

# Esta classe representa um cachorro que herda de um mamífero.
class Cachorro(Mamifero):
    # Definição de um som para o mamífero cachorro.
    def som(self,som):
        som = "Wufff! Wufff!"

# Esta classe representa um gato que herda de um mamífero.
class Gato(Mamifero):
    #Definição de um som para o mamífero gato.
    def som(self, som):
        som = "Meawwwww!"
