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
        if self.cardNo == "0":
            return ""
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
        self.size += 52
    def mergeNDecks(self, n):
        for decks in range(n):
            self.createDeck()

d1 = Deck()
def deal(player, dealer,deck):
    player.draw(deck)
    dealer.draw(deck)
    player.draw(deck)
    dealer.draw(deck)

def game(player, dealer, deck, hitRate):
    deck.createDeck()
    #print(deck.size)
    random.shuffle(deck.deckList)
    emptyCard = Card("spades",0)
    player.hand = []
    player.printHand()
    dealer.hand = []
    player.computeTotal()
    dealer.computeTotal()
    player.draw(deck)
    dealer.draw(deck)
    player.draw(deck)
    dealer.draw(deck)
    #print("Setup finished! \n")
    total_before = player.computeTotal()
    ##print(total_before)
    dealer_card = dealer.hand[0].value
    stand_hit = 0 #0 for stand 1 for hit
    win_lose = 0
    #hitRate = random.choice([0,1])
    if player.computeTotal() == 21:
        print("Black Jack!!")
        win_lose = 1
        return total_before, dealer_card, stand_hit, win_lose
    elif player.computeTotal() < 21 and hitRate == 1:
        player.draw(deck)
        stand_hit = 1
        if player.computeTotal() > 21:
            win_lose = 0
            return total_before, dealer_card, stand_hit, win_lose

    #print(deck.size)
    try:
        dealer.decision_maker(player, deck)
    except IndexError:
        print("Error detected on Iteration number: " ,i)
        print(len(deck.deckList))
        dealer.printHand()
    
    if dealer.checkGameOver() and (player.checkGameOver() == False):
        win_lose = 1
    elif dealer.checkGameOver() == False and player.checkGameOver() == False:
        if dealer.computeTotal() > player.computeTotal():
            win_lose = 0
        else: 
            win_lose = 1
    return total_before, dealer_card, stand_hit, win_lose
p1 = Player([], "Anon")
dealer = Dealer([],"Dealer")
results_table = list()
correctMove = list()
for i in range(500):
    print("Iteration Number: " ,i)
    result = list()
    total_before = 0
    dealer_card = 0
    stand_hit = 0
    win_lose = 0
    if i < 250:
        hitRate = 1
    else:
        hitRate = 0
    random.seed(i)
    total_before, dealer_card, stand_hit, win_lose = game(p1, dealer,d1,hitRate)
    correct_move = 0
    if(stand_hit == win_lose):
        correct_move = 1
    result = [total_before, dealer_card,stand_hit, correct_move,win_lose]
    correctMove.append(correct_move)
    results_table.append(result)
for i in range(len(results_table)):
    print(results_table[i],",")

# n_inputs = len(results_table[0]) - 1
# n_outputs = len(set([row[-1] for row in results_table]))
# random.seed(1)
# network = initialize_network(n_inputs, 3, n_outputs)
# train_network(network, results_table, 0.66, 90, n_outputs)
# for row in results_table:
# 	prediction = predict(network, row)
# 	print('Expected=%d, Got=%d' % (row[-1], prediction))
