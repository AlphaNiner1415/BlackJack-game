import random
import datetime
from player import Player,Dealer
from BackPropTest import *
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
        self.deckList = list()
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
        deckList2 = self.deckList.copy()
        random.shuffle(deckList2)
        self.deckList = deckList2

    def draw(self):
        random.shuffle(self.deckList)
        currentDate = datetime.datetime.now()
        currentDate = str(currentDate)
        random.seed(currentDate, version=2)
        choice = random.choice(self.deckList)
        self.deckList.remove(choice)
        self.size -=1
        return choice
    def clear(self):
        self.deckList = []
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
    def mergeNDecks(self, n):
        for decks in range(n):
            self.createDeck()

d1 = Deck()
def deal(player, dealer,deck):
    player.draw(deck)
    dealer.draw(deck)
    player.draw(deck)
    dealer.draw(deck)

def game(player, dealer, deck):
    deck.clear()
    deck.mergeNDecks(5)
    if(len(deck.deckList) <= 10):
        deck.clear()
        deck.mergeNDecks(5)
    deal(player,dealer,deck)
    total_before = player.computeTotal()
    dealer_card = dealer.hand[0].value
    stand_hit = 0 #0 for stand 1 for hit
    win_lose = 0
    hitRate = random.choice([0,1])
    if player.computeTotal() == 21:
        win_lose = 1
        return total_before, dealer_card, stand_hit, win_lose
    elif player.computeTotal() < 21 and hitRate == 1:
        player.draw()
        stand_hit = 1
        if player.computeTotal() > 21:
            return total_before, dealer_card, stand_hit, win_lose
    
    dealer.decisionMaker(player)
    if dealer.checkGameOver():

        
        
        
p1 = Player([], "Anon")
dealer = Dealer([],"Dealer")
game(p1,dealer,d1)
