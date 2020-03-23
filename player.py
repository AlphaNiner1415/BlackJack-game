
class Player(object):
    def __init__(self,hand, name):
        self.hand = [None, None, None, None, None]
        self.name = str(name)
        self.total = 0
        for card in hand:
            self.hand.append(card)
    def computeTotal(self):
        total = 0
        flag = False

    def draw(self, deck):
        drawnCard = deck.draw()
        for card in range(len(self.hand)):
            if self.hand[card] is None:
                self.hand[card] = drawnCard
                print(self.hand[card])
                print(self.name + " drew a card!")
                self.computeTotal()
                break
        

    def getNonNullHandLength(self):
        count = 0
        for i in len(self.hand):
            if (self.hand[i] is not None):
                count+= 1
        return count
    
    def checkGameOver(self):
        if self.computeTotal() > 21: 
            return True
        else:
            return False
    
    def clearHand(self):
        for card in self.hand:
            card = None

    def printHand(self):
        s1 = ""
        for card in self.hand:
            if(card != None):
                s1 += str(card) + ", "
        print(s1)
            
        
        
