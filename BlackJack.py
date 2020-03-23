import random
import datetime
execfile('player.py')
# print('\u2660') #spades
# print('\u2665') #hearts
# print('\u2663') #clubs
# print('\u2666')
symbols = ['\u2660', '\u2665', '\u2663', '\u2666'] #spades, hearts, clubs, diamonds
#print('\u1f0a0')
class Card():
    def __init__ (self, suit, cardNo):
        self.suit = suit
        self.cardNo = cardNo
        if(cardNo == "A"):
            self.value = 1
        elif(cardNo == "J" or cardNo == "Q" or cardNo == "K"):
            self.value = 10
        else:
            self.value = int(cardNo)

        if suit == "spades":
            self.symbol = symbols[0]
        elif suit == "hearts":
            self.symbol = symbols[1]
        elif suit == "clubs":
            self.symbol = symbols[2]
        elif suit == "diamonds":
            self.symbol = symbols[3]
    def setCardNo(self, cardNo):
        self.cardNo = "" + cardNo
    def setValue(self, value):
        self.value = int(value)
    def setSuit(self, suit):
        self.suit = "" + suit
        if suit == "spades":
            self.symbol = symbols[0]
        elif suit == "hearts":
            self.symbol = symbols[1]
        elif suit == "clubs":
            self.symbol = symbols[2]
        elif suit == "diamonds":
            self.symbol = symbols[3]

    def __str__(self):
        return self.cardNo + self.symbol

    def __eq__(self, other):
        if other == None:
            return False
        return self.cardNo == other.cardNo
    
class Deck:
    def __init__(self):
        CardNumbers = ["A", "2", "3", "4", "5","6", "7", "8", "9", "10", "J", "Q", "K"]
        self.deckList = []
        for i in range(1,14):
            heartCard = Card("hearts", CardNumbers[i-1] )
            self.deckList.append(heartCard)
        for i in range(1,14):
            spadeCard = Card("spades", CardNumbers[i-1] )
            self.deckList.append(spadeCard)
        for i in range(1,14):
            clubCard = Card("clubs", CardNumbers[i-1] )
            self.deckList.append(clubCard)
        for i in range(1,14):
            diamondCard = Card("diamonds", CardNumbers[i-1] )
            self.deckList.append(diamondCard)
        self.size = 52
        random.shuffle(self.deckList)

    def draw(self):
        random.shuffle(self.deckList)
        currentDate = datetime.datetime.now()
        currentDate = str(currentDate)
        random.seed(currentDate, version=2)
        choice = random.choice(self.deckList)
        self.deckList.remove(choice)
        self.size -=1
        return choice
        
    def createDeck(self):
        CardNumbers = ["A", "2", "3", "4", "5",
                       "6", "7", "8", "9", "10", "J", "Q", "K"]
        for i in range(1, 14):
            heartCard = Card("hearts", CardNumbers[i-1])
            self.deckList.append(heartCard)
        for i in range(1, 14):
            spadeCard = Card("spades", CardNumbers[i-1])
            self.deckList.append(spadeCard)
        for i in range(1, 14):
            clubCard = Card("clubs", CardNumbers[i-1])
            self.deckList.append(clubCard)
        for i in range(1, 14):
            diamondCard = Card("diamonds", CardNumbers[i-1])
            self.deckList.append(diamondCard)

d1 = Deck()
p1 = Player([],"P1")
p1.draw(d1)
p1.draw(d1)
p1.printHand()