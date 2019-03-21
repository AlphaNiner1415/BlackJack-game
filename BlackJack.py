
print('\u2660') #spades
print('\u2661') #hearts
print('\u2663') #clubs
print('\u2666')

#print('\u1f0a0')
class Card:
    def __init__ (self, number, suit, symbol):
      self.number = number
      self.suit = suit
      self.symbol = symbol
class HeartCard(Card):
    def __init__(self, number, suit,symbol):
        self.symbol = '\u2661'
        self.number = number
        self.suit = "Hearts"
aceHearts = HeartCard("A")
